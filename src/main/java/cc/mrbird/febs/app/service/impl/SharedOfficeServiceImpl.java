package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.*;
import cc.mrbird.febs.app.mapper.*;
import cc.mrbird.febs.app.service.ISharedOfficeService;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.DataHandleUtil;
import cc.mrbird.febs.common.utils.DateUtil;
import cc.mrbird.febs.common.utils.GPSUtil;
import cc.mrbird.febs.common.utils.json.Body;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:09
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SharedOfficeServiceImpl extends ServiceImpl<SharedOfficeMapper, SharedOffice> implements ISharedOfficeService {

    private final SharedOfficeMapper sharedOfficeMapper;

    private final OfficeMapper officeMapper;

    private final AppLogMapper appLogMapper;

    private final AttentionMapper attentionMapper;

    private final OfficeBuildingMapper officeBuildingMapper;

    @Override
    public IPage<SharedOffice> findSharedOffices(QueryRequest request, SharedOffice sharedOffice) {
        LambdaQueryWrapper<SharedOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<SharedOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<SharedOffice> findSharedOffices(SharedOffice sharedOffice) {
        LambdaQueryWrapper<SharedOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createSharedOffice(SharedOffice sharedOffice) {
        this.save(sharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSharedOffice(SharedOffice sharedOffice) {
        this.saveOrUpdate(sharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSharedOffice(SharedOffice sharedOffice) {
        LambdaQueryWrapper<SharedOffice> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectSharedOffice(String condition, Integer id, Integer areaLow, Integer areaHigh, Integer priceLow,
                                   Integer priceHigh, String type, String name, String position, String userId
            , String myId, String address, String order, Integer index, Integer size) {
        List<Map<String, Object>> list;
        if (StringUtils.isEmpty(userId) && StringUtils.isEmpty(myId)) {
            list = this.sharedOfficeMapper.selectSharedOffice(condition, id, areaLow, areaHigh,
                    priceLow, priceHigh, type, name, position, address, order);
        } else if (!StringUtils.isEmpty(userId) && StringUtils.isEmpty(myId)) {
            list = this.sharedOfficeMapper.selectSharedOfficeUserId(condition, id, areaLow, areaHigh,
                    priceLow, priceHigh, type, name, position, userId, address, order);
        } else {
            list = this.sharedOfficeMapper.selectSharedOfficeMyId(condition, id, areaLow, areaHigh,
                    priceLow, priceHigh, type, name, position, myId, address, order);
        }
        Page<Map<String, Object>> page = new Page<>(0, 10, list.size());
        if (list.size() > 0) {
            for (Map<String, Object> stringObjectMap : list) {
                if (!StringUtils.isEmpty(stringObjectMap.get("officeBuilding"))) {
                    OfficeBuilding officeBuilding = officeBuildingMapper.selectById((Integer) stringObjectMap.get(
                            "officeBuilding"));
                    if (StringUtils.isEmpty(stringObjectMap.get("name"))) {
                        stringObjectMap.put("name", officeBuilding.getName());
                    }
                    if (StringUtils.isEmpty(stringObjectMap.get("address"))) {
                        stringObjectMap.put("address", officeBuilding.getAddress());
                    }
                }
                double log = Double.parseDouble((String) stringObjectMap.get("log"));
                double lat = Double.parseDouble((String) stringObjectMap.get("lat"));
                double log1 = 0.00;
                double lat1 = 0.00;
                if (!StringUtils.isEmpty(stringObjectMap.get("mp_longitude"))) {
                    log1 = Double.parseDouble((String) stringObjectMap.get("mp_longitude"));
                }
                if (!StringUtils.isEmpty(stringObjectMap.get("mp_latitude"))) {
                    lat1 = Double.parseDouble((String) stringObjectMap.get("mp_latitude"));
                }
                Double distance = GPSUtil.GetDistance(log, lat, log1, lat1);                               //两点之间计算距离
                stringObjectMap.put("distance", distance);
                Integer title = officeMapper.selectCountBySharedId((Integer) stringObjectMap.get("id"));
                //查找当前共享办公下的办公室总数
                stringObjectMap.put("title", title);
                Integer count = officeMapper.selectCountBySharedForA((Integer) stringObjectMap.get("id"));
                //查询但钱共享办公下的办公室已租数
                stringObjectMap.put("count", count);
                String ratio = DataHandleUtil.division(count, title);                                     //计算已租百分比
                stringObjectMap.put("ratio", ratio);
            }
            page.setRecords(list);
            return Body.newInstance(page);
        } else {
            return Body.newInstance(201, "没有记录");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body uploadOfficeHomePage(Integer officeBuildingId, String picture, Integer userId) {
        SharedOffice sharedOffice = new SharedOffice();
        sharedOffice.setPicture(picture);
        sharedOffice.setId(officeBuildingId);
        sharedOffice.setUpdateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        Integer count = this.sharedOfficeMapper.updateById(sharedOffice);
        if (count == 1) {
            AppLog appLog = new AppLog();
            appLog.setCreateUser(userId);
            appLog.setContent("更改首页图片");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("B");
            appLog.setHouse⁯(officeBuildingId);
            this.appLogMapper.insert(appLog);
            return Body.BODY_200;
        } else {
            return Body.newInstance(201, "修改失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertSharedOffice(SharedOffice sharedOffice) {
        LambdaQueryWrapper<SharedOffice> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SharedOffice::getName, sharedOffice.getName());
        if (this.sharedOfficeMapper.selectList(wrapper).size() > 0) {
            return Body.newInstance(201, "不能添加重复名称");
        }
        sharedOffice.setCreationTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        Integer count = this.sharedOfficeMapper.insert(sharedOffice);
        if (count == 1) {
            Attention attention = new Attention();
            attention.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            attention.setAttentionUser(sharedOffice.getCreateUser());
            attention.setAttentionLabel(sharedOffice.getId());
            attention.setAttentionType("B");
            this.attentionMapper.insert(attention);
            AppLog appLog = new AppLog();
            appLog.setCreateUser(sharedOffice.getCreateUser());
            appLog.setContent("添加共享办公信息");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("B");
            appLog.setHouse⁯(sharedOffice.getId());
            this.appLogMapper.insert(appLog);
        }
        return Body.newInstance(sharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body updateSharedOfficeDetails(SharedOffice sharedOffice, Integer userid) {
        sharedOffice.setUpdateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        Integer count = this.sharedOfficeMapper.updateById(sharedOffice);
        if (count == 1) {
            AppLog appLog = new AppLog();
            appLog.setCreateUser(userid);
            appLog.setContent("修改共享办公信息");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("B");
            appLog.setHouse⁯(sharedOffice.getId());
            this.appLogMapper.insert(appLog);
        }
        return Body.newInstance(201, "操作成功");
    }

    @Override
    public Body selectSharedOfficeById(Integer id) {
        SharedOffice sharedOffice = this.sharedOfficeMapper.selectById(id);
        if (sharedOffice != null) {
            return Body.newInstance(sharedOffice);
        }
        return Body.newInstance(201, "查询失败");
    }
}
