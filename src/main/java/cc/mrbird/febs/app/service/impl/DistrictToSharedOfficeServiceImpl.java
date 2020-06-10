package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.DistrictToSharedOffice;
import cc.mrbird.febs.app.mapper.DistrictToSharedOfficeMapper;
import cc.mrbird.febs.app.service.IDistrictToSharedOfficeService;
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
 * @date 2020-05-07 16:30:08
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DistrictToSharedOfficeServiceImpl extends ServiceImpl<DistrictToSharedOfficeMapper, DistrictToSharedOffice> implements IDistrictToSharedOfficeService {

    private final DistrictToSharedOfficeMapper districtToSharedOfficeMapper;

    @Override
    public IPage<DistrictToSharedOffice> findDistrictToSharedOffices(QueryRequest request, DistrictToSharedOffice districtToSharedOffice) {
        LambdaQueryWrapper<DistrictToSharedOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<DistrictToSharedOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<DistrictToSharedOffice> findDistrictToSharedOffices(DistrictToSharedOffice districtToSharedOffice) {
	    LambdaQueryWrapper<DistrictToSharedOffice> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createDistrictToSharedOffice(DistrictToSharedOffice districtToSharedOffice) {
        this.save(districtToSharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateDistrictToSharedOffice(DistrictToSharedOffice districtToSharedOffice) {
        this.saveOrUpdate(districtToSharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDistrictToSharedOffice(DistrictToSharedOffice districtToSharedOffice) {
        LambdaQueryWrapper<DistrictToSharedOffice> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
