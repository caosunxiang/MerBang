package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.MetroToSharedOffice;
import cc.mrbird.febs.app.mapper.MetroToSharedOfficeMapper;
import cc.mrbird.febs.app.service.IMetroToSharedOfficeService;
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
 * @date 2020-05-07 16:30:14
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MetroToSharedOfficeServiceImpl extends ServiceImpl<MetroToSharedOfficeMapper, MetroToSharedOffice> implements IMetroToSharedOfficeService {

    private final MetroToSharedOfficeMapper metroToSharedOfficeMapper;

    @Override
    public IPage<MetroToSharedOffice> findMetroToSharedOffices(QueryRequest request,
                                                               MetroToSharedOffice metroToSharedOffice) {
        LambdaQueryWrapper<MetroToSharedOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<MetroToSharedOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<MetroToSharedOffice> findMetroToSharedOffices(MetroToSharedOffice metroToSharedOffice) {
        LambdaQueryWrapper<MetroToSharedOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createMetroToSharedOffice(MetroToSharedOffice metroToSharedOffice) {
        this.save(metroToSharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMetroToSharedOffice(MetroToSharedOffice metroToSharedOffice) {
        this.saveOrUpdate(metroToSharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMetroToSharedOffice(MetroToSharedOffice metroToSharedOffice) {
        LambdaQueryWrapper<MetroToSharedOffice> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }
}
