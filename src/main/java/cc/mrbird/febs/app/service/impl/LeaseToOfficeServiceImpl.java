package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AboutToBuilding;
import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.LeaseToOffice;
import cc.mrbird.febs.app.mapper.LeaseToOfficeMapper;
import cc.mrbird.febs.app.service.ILeaseToOfficeService;
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
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-14 15:23:01
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LeaseToOfficeServiceImpl extends ServiceImpl<LeaseToOfficeMapper, LeaseToOffice> implements ILeaseToOfficeService {

    private final LeaseToOfficeMapper leaseToOfficeMapper;

    private final AppLogMapper appLogMapper;
    @Override
    public IPage<LeaseToOffice> findLeaseToOffices(QueryRequest request, LeaseToOffice leaseToOffice) {
        LambdaQueryWrapper<LeaseToOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<LeaseToOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<LeaseToOffice> findLeaseToOffices(LeaseToOffice leaseToOffice) {
	    LambdaQueryWrapper<LeaseToOffice> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createLeaseToOffice(LeaseToOffice leaseToOffice) {
        this.save(leaseToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLeaseToOffice(LeaseToOffice leaseToOffice) {
        this.saveOrUpdate(leaseToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLeaseToOffice(LeaseToOffice leaseToOffice) {
        LambdaQueryWrapper<LeaseToOffice> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertLease(LeaseToOffice leaseToOffice, Integer userid) {
        LambdaQueryWrapper<LeaseToOffice> wrapper=new LambdaQueryWrapper();
        LeaseToOffice lease=this.leaseToOfficeMapper.selectOne(wrapper);
        if (lease!=null){
            return Body.newInstance(201,"消息已存在，请选择更改");
        }
        Integer count=this.leaseToOfficeMapper.insert(leaseToOffice);
        if (count==1){
            AppLog appLog = new AppLog();
            appLog.setCreateUser(userid);
            appLog.setContent("修改办公室信息");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("C");
            appLog.setHouse⁯(leaseToOffice.getOfficeId());
            this.appLogMapper.insert(appLog);
            return  Body.BODY_200;
        }
        return Body.newInstance(201,"添加失败");
    }

    @Override
    public Body selectLeaseToOffice(Integer id) {
        LambdaQueryWrapper<LeaseToOffice> wrapper=new LambdaQueryWrapper();
        wrapper.eq(LeaseToOffice::getOfficeId,id);
        LeaseToOffice lease=this.leaseToOfficeMapper.selectOne(wrapper);
        return Body.newInstance(lease);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body updateDetails(LeaseToOffice leaseToOffice, Integer userid) {
        Integer count=this.leaseToOfficeMapper.updateById(leaseToOffice);
        if (count==1){
            AppLog appLog = new AppLog();
            appLog.setCreateUser(userid);
            appLog.setContent("修改办公室信息");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("A");
            appLog.setHouse⁯(leaseToOffice.getOfficeId());
            this.appLogMapper.insert(appLog);
            return  Body.BODY_200;
        }
        return Body.newInstance(201,"添加失败");
    }
}
