package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.entity.Attention;
import cc.mrbird.febs.app.entity.Office;
import cc.mrbird.febs.app.entity.OfficeBuilding;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.app.mapper.AttentionMapper;
import cc.mrbird.febs.app.mapper.OfficeBuildingMapper;
import cc.mrbird.febs.app.mapper.OfficeMapper;
import cc.mrbird.febs.app.service.IOfficeBuildingService;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.DataHandleUtil;
import cc.mrbird.febs.common.utils.DateUtil;
import cc.mrbird.febs.common.utils.FileUploadUtils;
import cc.mrbird.febs.common.utils.GPSUtil;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-04-30 17:22:24
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OfficeBuildingServiceImpl extends ServiceImpl<OfficeBuildingMapper, OfficeBuilding> implements IOfficeBuildingService {

    private final OfficeBuildingMapper officeBuildingMapper;

    private final OfficeMapper officeMapper;

    private final AppLogMapper appLogMapper;

    private final AttentionMapper attentionMapper;

    @Override
    public IPage<OfficeBuilding> findOfficeBuildings(QueryRequest request, OfficeBuilding officeBuilding) {
        LambdaQueryWrapper<OfficeBuilding> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OfficeBuilding> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OfficeBuilding> findOfficeBuildings(OfficeBuilding officeBuilding) {
        LambdaQueryWrapper<OfficeBuilding> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOfficeBuilding(OfficeBuilding officeBuilding) {
        this.save(officeBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOfficeBuilding(OfficeBuilding officeBuilding) {
        this.saveOrUpdate(officeBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOfficeBuilding(OfficeBuilding officeBuilding) {
        LambdaQueryWrapper<OfficeBuilding> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectOfficeBuilding(String condition, Integer areaLow, Integer areaHigh, String priceLow,
                                     String priceHigh, String fitment, String name, String position,
                                     String userId, String myId, String address, String order, Integer index,
                                     Integer size) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (StringUtils.isEmpty(userId) && StringUtils.isEmpty(myId)) {
            list = this.officeBuildingMapper.selectOfficeBuilding(condition, areaLow, areaHigh,
                    priceLow, priceHigh, fitment, name, position, address, order);
        } else if (!StringUtils.isEmpty(userId) && StringUtils.isEmpty(myId)) {
            list = this.officeBuildingMapper.selectOfficeBuildingUserId(condition, areaLow, areaHigh,
                    priceLow, priceHigh, fitment, name, position, userId, address, order);
        } else {
            list = this.officeBuildingMapper.selectOfficeBuildingMyId(condition, areaLow, areaHigh,
                    priceLow, priceHigh, fitment, name, position, myId, address, order);
        }

        Page<Map<String, Object>> page = new Page<>(index, size, list.size());
        if (list.size() > 0) {
            for (Map<String, Object> stringObjectMap : list) {
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
                Double distance = GPSUtil.GetDistance(log, lat, log1, lat1);
                stringObjectMap.put("distance", distance);
                int title = officeMapper.selectCountByBuildingId((Integer) stringObjectMap.get("id"));
                stringObjectMap.put("title", title);
                int count = officeMapper.selectCountByBuildingForA((Integer) stringObjectMap.get("id"));
                stringObjectMap.put("count", count);
                String ratio = DataHandleUtil.division(count, title);
                stringObjectMap.put("ratio", ratio);
            }
            page.setRecords(list);
            return Body.newInstance(page);
        } else {
            return Body.newInstance(201, "没有记录");
        }
    }

    @Override
    public Body selectOfficeBuildingById(Integer id) {
        OfficeBuilding officeBuilding = this.officeBuildingMapper.selectById(id);
        if (officeBuilding != null) {
            return Body.newInstance(officeBuilding);
        }
        return Body.newInstance(201, "查询失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertOfficeBuilding(String name, String address, String log, String lat, String area,
                                     String price, Integer user) {
        LambdaQueryWrapper<OfficeBuilding> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(OfficeBuilding::getName,name);
        if (this.officeBuildingMapper.selectList(wrapper).size()>0){
            return Body.newInstance(201,"不能添加重复姓名");
        }
        OfficeBuilding officeBuilding = new OfficeBuilding();
        officeBuilding.setName(name);
        officeBuilding.setAddress(address);
        officeBuilding.setLat(lat);
        officeBuilding.setLog(log);
        officeBuilding.setArea(area);
        officeBuilding.setPrice(price);
        officeBuilding.setCreationTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        officeBuilding.setCreateUser(user);
        Integer count = this.officeBuildingMapper.insert(officeBuilding);
        if (count == 1) {
            Attention attention = new Attention();
            attention.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            attention.setAttentionUser(user);
            attention.setAttentionLabel(officeBuilding.getId());
            attention.setAttentionType("A");
            this.attentionMapper.insert(attention);
            AppLog appLog = new AppLog();
            appLog.setCreateUser(user);
            appLog.setContent("添加写字楼");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark(attention.getAttentionType());
            appLog.setHouse⁯(attention.getAttentionLabel());
            this.appLogMapper.insert(appLog);
            return Body.newInstance(officeBuilding);
        }
        return Body.newInstance(201, "新增写字楼房源失败");
    }

    @Override
    public Body uploadOfficeBuilding(MultipartFile file) {
        String picture = FileUploadUtils.fileUpload(file, "officeBuilding");
        System.out.println(picture);
        return Body.newInstance(picture);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body uploadOfficeHomePage(Integer officeBuildingId, String picture, Integer userId) {
        OfficeBuilding officeBuilding = new OfficeBuilding();
        officeBuilding.setPicture(picture);
        officeBuilding.setId(officeBuildingId);
        officeBuilding.setUpdateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        Integer count = this.officeBuildingMapper.updateById(officeBuilding);
        if (count == 1) {
            AppLog appLog = new AppLog();
            appLog.setCreateUser(userId);
            appLog.setContent("更改首页图片");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("A");
            appLog.setHouse⁯(officeBuildingId);
            this.appLogMapper.insert(appLog);
            return Body.BODY_200;
        } else {
            return Body.newInstance(201, "修改失败");
        }
    }

    @Override
    public Body updateOfficeBuildingDetails(OfficeBuilding officeBuilding) {
        officeBuilding.setUpdateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        Integer count=this.officeBuildingMapper.updateById(officeBuilding);
        if (count==1){
            AppLog appLog = new AppLog();
            appLog.setCreateUser(officeBuilding.getCreateUser());
            appLog.setContent("修改写字楼信息");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("A");
            appLog.setHouse⁯(officeBuilding.getId());
            this.appLogMapper.insert(appLog);
            return Body.BODY_200;
        }
        return Body.newInstance(201,"修改失败");
    }
}
