package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.OfficeLabel;
import cc.mrbird.febs.app.mapper.OfficeLabelMapper;
import cc.mrbird.febs.app.service.IOfficeLabelService;
import cc.mrbird.febs.common.entity.QueryRequest;
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
 * @date 2020-05-06 09:16:37
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OfficeLabelServiceImpl extends ServiceImpl<OfficeLabelMapper, OfficeLabel> implements IOfficeLabelService {

    private final OfficeLabelMapper officeLabelMapper;

    @Override
    public IPage<OfficeLabel> findOfficeLabels(QueryRequest request, OfficeLabel officeLabel) {
        LambdaQueryWrapper<OfficeLabel> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OfficeLabel> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OfficeLabel> findOfficeLabels(OfficeLabel officeLabel) {
        LambdaQueryWrapper<OfficeLabel> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOfficeLabel(OfficeLabel officeLabel) {
        this.save(officeLabel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOfficeLabel(OfficeLabel officeLabel) {
        this.saveOrUpdate(officeLabel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOfficeLabel(OfficeLabel officeLabel) {
        LambdaQueryWrapper<OfficeLabel> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }
}
