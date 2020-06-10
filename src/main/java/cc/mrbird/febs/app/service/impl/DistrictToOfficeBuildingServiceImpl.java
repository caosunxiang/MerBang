package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.DistrictToOfficeBuilding;
import cc.mrbird.febs.app.mapper.DistrictToOfficeBuildingMapper;
import cc.mrbird.febs.app.service.IDistrictToOfficeBuildingService;
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
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:36
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DistrictToOfficeBuildingServiceImpl extends ServiceImpl<DistrictToOfficeBuildingMapper, DistrictToOfficeBuilding> implements IDistrictToOfficeBuildingService {

    private final DistrictToOfficeBuildingMapper districtToOfficeBuildingMapper;

    @Override
    public IPage<DistrictToOfficeBuilding> findDistrictToOfficeBuildings(QueryRequest request, DistrictToOfficeBuilding districtToOfficeBuilding) {
        LambdaQueryWrapper<DistrictToOfficeBuilding> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<DistrictToOfficeBuilding> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<DistrictToOfficeBuilding> findDistrictToOfficeBuildings(DistrictToOfficeBuilding districtToOfficeBuilding) {
	    LambdaQueryWrapper<DistrictToOfficeBuilding> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createDistrictToOfficeBuilding(DistrictToOfficeBuilding districtToOfficeBuilding) {
        this.save(districtToOfficeBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateDistrictToOfficeBuilding(DistrictToOfficeBuilding districtToOfficeBuilding) {
        this.saveOrUpdate(districtToOfficeBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDistrictToOfficeBuilding(DistrictToOfficeBuilding districtToOfficeBuilding) {
        LambdaQueryWrapper<DistrictToOfficeBuilding> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
