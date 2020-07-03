package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.BusinessDistrict;
import cc.mrbird.febs.app.mapper.BusinessDistrictMapper;
import cc.mrbird.febs.app.service.IBusinessDistrictService;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.DateUtil;
import cc.mrbird.febs.common.utils.json.Body;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 11:24:48
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BusinessDistrictServiceImpl extends ServiceImpl<BusinessDistrictMapper, BusinessDistrict> implements IBusinessDistrictService {

    private final BusinessDistrictMapper businessDistrictMapper;

    @Override
    public IPage<BusinessDistrict> findBusinessDistricts(QueryRequest request, BusinessDistrict businessDistrict) {
        LambdaQueryWrapper<BusinessDistrict> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<BusinessDistrict> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BusinessDistrict> findBusinessDistricts(BusinessDistrict businessDistrict) {
        LambdaQueryWrapper<BusinessDistrict> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createBusinessDistrict(BusinessDistrict businessDistrict) {
        this.save(businessDistrict);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBusinessDistrict(BusinessDistrict businessDistrict) {
        this.saveOrUpdate(businessDistrict);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBusinessDistrict(BusinessDistrict businessDistrict) {
        LambdaQueryWrapper<BusinessDistrict> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectBusinessDistrict(String city) {
        LambdaQueryWrapper<BusinessDistrict> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(BusinessDistrict::getCity, city);
        List<BusinessDistrict> list = this.businessDistrictMapper.selectList(wrapper);
        if (list.size() > 0) {
            return Body.newInstance(list);
        } else {
            return Body.newInstance(201, "没有查询到商圈信息");
        }
    }

    @Override
    public Body insertBusinessDistrict(BusinessDistrict businessDistrict) {
        businessDistrict.setCreationTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        businessDistrict.setState("A");
        int count = this.businessDistrictMapper.insert(businessDistrict);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "添加失败");
    }
}
