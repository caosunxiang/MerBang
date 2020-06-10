package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.MetroToOfficeBuilding;
import cc.mrbird.febs.app.mapper.MetroToOfficeBuildingMapper;
import cc.mrbird.febs.app.service.IMetroToOfficeBuildingService;
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
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:18
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MetroToOfficeBuildingServiceImpl extends ServiceImpl<MetroToOfficeBuildingMapper, MetroToOfficeBuilding> implements IMetroToOfficeBuildingService {

    private final MetroToOfficeBuildingMapper metroToOfficeBuildingMapper;

    @Override
    public IPage<MetroToOfficeBuilding> findMetroToOfficeBuildings(QueryRequest request, MetroToOfficeBuilding metroToOfficeBuilding) {
        LambdaQueryWrapper<MetroToOfficeBuilding> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<MetroToOfficeBuilding> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<MetroToOfficeBuilding> findMetroToOfficeBuildings(MetroToOfficeBuilding metroToOfficeBuilding) {
	    LambdaQueryWrapper<MetroToOfficeBuilding> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createMetroToOfficeBuilding(MetroToOfficeBuilding metroToOfficeBuilding) {
        this.save(metroToOfficeBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMetroToOfficeBuilding(MetroToOfficeBuilding metroToOfficeBuilding) {
        this.saveOrUpdate(metroToOfficeBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMetroToOfficeBuilding(MetroToOfficeBuilding metroToOfficeBuilding) {
        LambdaQueryWrapper<MetroToOfficeBuilding> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
