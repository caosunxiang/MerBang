package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.DistrictToOffice;
import cc.mrbird.febs.app.mapper.DistrictToOfficeMapper;
import cc.mrbird.febs.app.service.IDistrictToOfficeService;
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
 * @date 2020-05-07 16:30:33
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DistrictToOfficeServiceImpl extends ServiceImpl<DistrictToOfficeMapper, DistrictToOffice> implements IDistrictToOfficeService {

    private final DistrictToOfficeMapper districtToOfficeMapper;

    @Override
    public IPage<DistrictToOffice> findDistrictToOffices(QueryRequest request, DistrictToOffice districtToOffice) {
        LambdaQueryWrapper<DistrictToOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<DistrictToOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<DistrictToOffice> findDistrictToOffices(DistrictToOffice districtToOffice) {
	    LambdaQueryWrapper<DistrictToOffice> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createDistrictToOffice(DistrictToOffice districtToOffice) {
        this.save(districtToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateDistrictToOffice(DistrictToOffice districtToOffice) {
        this.saveOrUpdate(districtToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDistrictToOffice(DistrictToOffice districtToOffice) {
        LambdaQueryWrapper<DistrictToOffice> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
