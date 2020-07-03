package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.ServiceToShared;
import cc.mrbird.febs.app.mapper.ServiceToSharedMapper;
import cc.mrbird.febs.app.service.IServiceToSharedService;
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
 * @date 2020-05-15 15:54:00
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ServiceToSharedServiceImpl extends ServiceImpl<ServiceToSharedMapper, ServiceToShared> implements IServiceToSharedService {

    private final ServiceToSharedMapper serviceToSharedMapper;

    private final AppLogMapper appLogMapper;

    @Override
    public IPage<ServiceToShared> findServiceToShareds(QueryRequest request, ServiceToShared serviceToShared) {
        LambdaQueryWrapper<ServiceToShared> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<ServiceToShared> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ServiceToShared> findServiceToShareds(ServiceToShared serviceToShared) {
        LambdaQueryWrapper<ServiceToShared> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createServiceToShared(ServiceToShared serviceToShared) {
        this.save(serviceToShared);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateServiceToShared(ServiceToShared serviceToShared) {
        this.saveOrUpdate(serviceToShared);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteServiceToShared(ServiceToShared serviceToShared) {
        LambdaQueryWrapper<ServiceToShared> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body insertServiceToShared(List<String> serviceId, Integer sharedId, Integer userid) {
        for (String i : serviceId) {
            ServiceToShared serviceToShared = new ServiceToShared();
            serviceToShared.setServiceId(Integer.parseInt(i));
            serviceToShared.setSharedId(sharedId);
            this.serviceToSharedMapper.insert(serviceToShared);
        }
        AppLog appLog = new AppLog();
        appLog.setCreateUser(userid);
        appLog.setContent("添加共享办公服务信息");
        appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        appLog.setRemark("B");
        appLog.setHouse⁯(sharedId);
        this.appLogMapper.insert(appLog);
        return Body.BODY_200;
    }
}
