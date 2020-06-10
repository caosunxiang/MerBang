package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.*;
import cc.mrbird.febs.app.mapper.*;
import cc.mrbird.febs.app.service.IOfficeService;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.InsertOffice;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.DataHandleUtil;
import cc.mrbird.febs.common.utils.DateUtil;
import cc.mrbird.febs.common.utils.GPSUtil;
import cc.mrbird.febs.common.utils.json.Body;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:16:31
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OfficeServiceImpl extends ServiceImpl<OfficeMapper, Office> implements IOfficeService {

    private final OfficeMapper officeMapper;

    private final AttentionMapper attentionMapper;

    private final AppLogMapper appLogMapper;

    private final FloorToOfficeMapper floorToOfficeMapper;

    private final LesseeMapper lesseeMapper;

    private final OfficeBuildingMapper officeBuildingMapper;

    private final SharedOfficeMapper sharedOfficeMapper;

    private final LabelToOfficeBuildingMapper labelToOfficeBuildingMapper;

    private final LabelToSharedOfficeMapper labelToSharedOfficeMapper;
    @Override
    public IPage<Office> findOffices(QueryRequest request, Office office) {
        LambdaQueryWrapper<Office> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Office> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Office> findOffices(Office office) {
        LambdaQueryWrapper<Office> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOffice(Office office) {
        this.save(office);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOffice(Office office) {
        this.saveOrUpdate(office);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOffice(Office office) {
        LambdaQueryWrapper<Office> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectOffice(String condition, Integer areaLow, Integer areaHigh, String priceLow,Integer id,
                             String priceHigh, String fitment, String name, String position, String address,
                             String userId, String myId, String order, Integer index,
                             Integer size) {
        List<Map<String, Object>> list;
        if (StringUtils.isEmpty(userId) && StringUtils.isEmpty(myId)) {
            list = this.officeMapper.selectOffice(condition, id ,areaLow, areaHigh,
                    priceLow, priceHigh, fitment, name, position, address, order );
        } else if (!StringUtils.isEmpty(userId) && StringUtils.isEmpty(myId)) {
            list = this.officeMapper.selectOfficeUserId(condition,id, areaLow, areaHigh,
                    priceLow, priceHigh, fitment, name, position, address, userId, order);
        } else {
            list = this.officeMapper.selectOfficeMyId(condition, id,areaLow, areaHigh,
                    priceLow, priceHigh, fitment, name, position, address, myId, order);
        }
        Page<Map<String, Object>> page = new Page<>(index, size, list.size());
        if (list.size() > 0) {
            for (Map<String, Object> stringObjectMap : list) {
                Integer month = attentionMapper.selectCountByOffice((Integer) stringObjectMap.get("id"));
                if (StringUtils.isEmpty(stringObjectMap.get("name"))&&!StringUtils.isEmpty(stringObjectMap.get("officeBuilding"))){
                    OfficeBuilding officeBuilding=officeBuildingMapper.selectById((Integer)stringObjectMap.get("officeBuilding"));
                    List<Map<String,Object>>mapList=this.labelToOfficeBuildingMapper.selectBuildLabel((Integer) stringObjectMap.get("officeBuilding"));
                    stringObjectMap.put("label",mapList);
                    if (StringUtils.isEmpty(stringObjectMap.get("address"))){
                        stringObjectMap.put("address",officeBuilding.getAddress());
                    }
                    stringObjectMap.put("name",officeBuilding.getName());
                }else if (StringUtils.isEmpty(stringObjectMap.get("name"))&&!StringUtils.isEmpty(stringObjectMap.get("sharedOfficeId"))){
                    SharedOffice sharedOffice=sharedOfficeMapper.selectById((Integer)stringObjectMap.get("sharedOfficeId"));
                    List<Map<String,Object>>mapList=this.labelToSharedOfficeMapper.selectSharedLabel((Integer) stringObjectMap.get("sharedOfficeId"));
                    stringObjectMap.put("label",mapList);
                    if (StringUtils.isEmpty(stringObjectMap.get("address"))){
                        stringObjectMap.put("address",sharedOffice.getAddress());
                    }
                    stringObjectMap.put("name",sharedOffice.getName());
                }
                stringObjectMap.put("month", month);
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
        Office Office = new Office();
        Office.setPicture(picture);
        Office.setId(officeBuildingId);
        Office.setUpdateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        Integer count = this.officeMapper.updateById(Office);
        if (count == 1) {
            AppLog appLog = new AppLog();
            appLog.setCreateUser(userId);
            appLog.setContent("更改首页图片");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("C");
            appLog.setHouse⁯(officeBuildingId);
            this.appLogMapper.insert(appLog);
            return Body.BODY_200;
        } else {
            return Body.newInstance(201, "修改失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertOffice(String data,Integer id) {
        List<InsertOffice> list = JSONObject.parseArray(data,InsertOffice.class);
        Office office=new Office();
        for (InsertOffice insertOffice : list) {
            if (insertOffice.getPidType().equals("A")){
                office.setOfficeBuilding(insertOffice.getPid());
                office.setName(officeBuildingMapper.selectById(insertOffice.getPid()).getName());
            }else {
                office.setSharedOfficeId(insertOffice.getPid());
                office.setName(sharedOfficeMapper.selectById(insertOffice.getPid()).getName());
            }
            office.setCreateUser(id);
            office.setArea(insertOffice.getArea());
            office.setFloor(insertOffice.getFloor());
            office.setCreationTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            office.setDoor(insertOffice.getDoor());
            office.setState(insertOffice.getState());
            this.officeMapper.insert(office);
            Attention attention = new Attention();
            attention.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            attention.setAttentionUser(office.getCreateUser());
            attention.setAttentionLabel(office.getId());
            attention.setAttentionType("C");
            this.attentionMapper.insert(attention);
            if (insertOffice.getFloorid()!=null) {
                FloorToOffice floorToOffice=new FloorToOffice();
                floorToOffice.setOfficeId(office.getId());
                floorToOffice.setFloorId(insertOffice.getFloorid());
                this.floorToOfficeMapper.insert(floorToOffice);
            }
            AppLog appLog = new AppLog();
            appLog.setCreateUser(id);
            appLog.setContent("添加办公室信息");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("A");
            appLog.setHouse⁯(attention.getAttentionLabel());
            this.appLogMapper.insert(appLog);
        }
        return Body.newInstance(office);
    }

    @Override
    public Body selectPidType(Integer id) {
        List<Map<String ,Object>>list=this.officeMapper.officeDown(id);
        if (list.size()>0){
            return Body.newInstance(list);
        }
        return Body.newInstance(201,"尚未有你管理的房源");
    }

    @Override
    public Body selectOfficeDetails(Integer id) {
        List<Map<String ,Object>> list=this.officeMapper.selectOfficeDetails(id);
        if (list.size()>0){
            return  Body.newInstance(list);
        }
        return Body.newInstance(201,"查询失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body updateOfficeDetails(Office office,Integer userid) {
        office.setUpdateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        Integer count=this.officeMapper.updateById(office);
        if (count==1){
            if (office.getFid()!=null) {
                FloorToOffice floorToOffice=new FloorToOffice();
                floorToOffice.setFloorId(office.getFloorid());
                floorToOffice.setId(office.getFid());
                this.floorToOfficeMapper.updateById(floorToOffice);
            }
            AppLog appLog = new AppLog();
            appLog.setCreateUser(userid);
            appLog.setContent("修改办公室信息");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("A");
            appLog.setHouse⁯(office.getId());
            this.appLogMapper.insert(appLog);
            return Body.BODY_200;
        }
        return Body.newInstance(201,"修改失败");
    }

    @Override
    public Body selectOfficeById(Integer id) {
        Office office
                =this.officeMapper.selectById(id);
        if (office!=null){
            return Body.newInstance(office);
        }
        return Body.newInstance(201,"查询失败");
    }

    @Override
    public Body selectOfficeInPrice(Integer pid, String door, Integer id) {
        List<Map<String,Object>> list=this.officeMapper.selectOfficeInPrice(pid,door,id);
        return Body.newInstance(list);
    }

    @Override
    public Body selectOfficeInCost(Integer id,Integer uid,String type) {
        List<Map<String,Object>> list=this.officeMapper.selectOfficeInCost(id,uid,type);
        return Body.newInstance(list);
    }

    @Override
    public Body deleteOffice(Integer officeId) {
        Map<String,Object>map=lesseeMapper.selectVerifyOffice(officeId);
        if (map==null){
            return Body.newInstance(201,"尚未清除租户，无法删除");
        }
        this.officeMapper.deleteById(officeId);
        return Body.BODY_200;
    }
}
