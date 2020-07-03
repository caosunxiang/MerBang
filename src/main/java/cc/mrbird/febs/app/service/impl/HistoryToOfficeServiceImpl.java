package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.HistoryToOffice;
import cc.mrbird.febs.app.mapper.HistoryToOfficeMapper;
import cc.mrbird.febs.app.service.IHistoryToOfficeService;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:02
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HistoryToOfficeServiceImpl extends ServiceImpl<HistoryToOfficeMapper, HistoryToOffice> implements IHistoryToOfficeService {

    private final HistoryToOfficeMapper historyToOfficeMapper;

    @Override
    public IPage<HistoryToOffice> findHistoryToOffices(QueryRequest request, HistoryToOffice historyToOffice) {
        LambdaQueryWrapper<HistoryToOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<HistoryToOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<HistoryToOffice> findHistoryToOffices(HistoryToOffice historyToOffice) {
        LambdaQueryWrapper<HistoryToOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createHistoryToOffice(HistoryToOffice historyToOffice) {
        this.save(historyToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateHistoryToOffice(HistoryToOffice historyToOffice) {
        this.saveOrUpdate(historyToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteHistoryToOffice(HistoryToOffice historyToOffice) {
        LambdaQueryWrapper<HistoryToOffice> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }
}
