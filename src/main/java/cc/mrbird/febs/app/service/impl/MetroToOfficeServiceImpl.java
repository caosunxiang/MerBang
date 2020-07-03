package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.MetroToOffice;
import cc.mrbird.febs.app.mapper.MetroToOfficeMapper;
import cc.mrbird.febs.app.service.IMetroToOfficeService;
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
 * @date 2020-05-07 16:30:38
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MetroToOfficeServiceImpl extends ServiceImpl<MetroToOfficeMapper, MetroToOffice> implements IMetroToOfficeService {

    private final MetroToOfficeMapper metroToOfficeMapper;

    @Override
    public IPage<MetroToOffice> findMetroToOffices(QueryRequest request, MetroToOffice metroToOffice) {
        LambdaQueryWrapper<MetroToOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<MetroToOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<MetroToOffice> findMetroToOffices(MetroToOffice metroToOffice) {
        LambdaQueryWrapper<MetroToOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createMetroToOffice(MetroToOffice metroToOffice) {
        this.save(metroToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMetroToOffice(MetroToOffice metroToOffice) {
        this.saveOrUpdate(metroToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMetroToOffice(MetroToOffice metroToOffice) {
        LambdaQueryWrapper<MetroToOffice> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }
}
