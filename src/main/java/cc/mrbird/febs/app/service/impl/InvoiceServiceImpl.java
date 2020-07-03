package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Invoice;
import cc.mrbird.febs.app.mapper.InvoiceMapper;
import cc.mrbird.febs.app.service.IInvoiceService;
import cc.mrbird.febs.common.utils.json.Body;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-18 09:55:16
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements IInvoiceService {

    private final InvoiceMapper invoiceMapper;

    @Override
    public IPage<Invoice> findInvoices(QueryRequest request, Invoice invoice) {
        LambdaQueryWrapper<Invoice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Invoice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Invoice> findInvoices(Invoice invoice) {
        LambdaQueryWrapper<Invoice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createInvoice(Invoice invoice) {
        this.save(invoice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateInvoice(Invoice invoice) {
        this.saveOrUpdate(invoice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteInvoice(Invoice invoice) {
        LambdaQueryWrapper<Invoice> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectInvoice(Integer lesseeId) {
        LambdaQueryWrapper<Invoice> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Invoice::getLesseeId, lesseeId);
        Invoice invoice
                = this.invoiceMapper.selectOne(wrapper);
        if (invoice != null) {
            return Body.newInstance(invoice);
        }
        return Body.newInstance(201, "查找开票信息");
    }

    @Override
    public Body insertInvoice(Invoice invoice) {
        int count = this.invoiceMapper.insert(invoice);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "新增失败");
    }

    @Override
    public Body updateInvoiceDetails(Invoice invoice) {
        int count = this.invoiceMapper.updateById(invoice);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "修改失败");
    }
}
