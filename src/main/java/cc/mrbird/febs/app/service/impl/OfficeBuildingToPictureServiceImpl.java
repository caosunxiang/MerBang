package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.entity.OfficeBuildingToPicture;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.app.mapper.OfficeBuildingToPictureMapper;
import cc.mrbird.febs.app.service.IOfficeBuildingToPictureService;
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
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:56
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OfficeBuildingToPictureServiceImpl extends ServiceImpl<OfficeBuildingToPictureMapper, OfficeBuildingToPicture> implements IOfficeBuildingToPictureService {

    private final OfficeBuildingToPictureMapper officeBuildingToPictureMapper;

    private final AppLogMapper appLogMapper;

    @Override
    public IPage<OfficeBuildingToPicture> findOfficeBuildingToPictures(QueryRequest request, OfficeBuildingToPicture officeBuildingToPicture) {
        LambdaQueryWrapper<OfficeBuildingToPicture> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OfficeBuildingToPicture> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OfficeBuildingToPicture> findOfficeBuildingToPictures(OfficeBuildingToPicture officeBuildingToPicture) {
	    LambdaQueryWrapper<OfficeBuildingToPicture> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOfficeBuildingToPicture(OfficeBuildingToPicture officeBuildingToPicture) {
        this.save(officeBuildingToPicture);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOfficeBuildingToPicture(OfficeBuildingToPicture officeBuildingToPicture) {
        this.saveOrUpdate(officeBuildingToPicture);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOfficeBuildingToPicture(OfficeBuildingToPicture officeBuildingToPicture) {
        LambdaQueryWrapper<OfficeBuildingToPicture> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body uploadIntroduce(String picture, Integer userId, Integer officeBuilding, String introduce) {
        OfficeBuildingToPicture toPicture=new OfficeBuildingToPicture();
        toPicture.setCreateTime(DateUtil.getDateFormat(new Date(),DateUtil.FULL_TIME_SPLIT_PATTERN));
        toPicture.setCreateUser(userId);
        toPicture.setOfficeBuildingId(officeBuilding);
        toPicture.setIntroduce(introduce);
        toPicture.setPicture(picture);
        Integer count=officeBuildingToPictureMapper.insert(toPicture);
        if (count==1){
            AppLog appLog=new AppLog();
            appLog.setCreateUser(userId);
            appLog.setContent("更改"+introduce+"图片");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(),DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("A");
            appLog.setHouse⁯(officeBuilding);
            this.appLogMapper.insert(appLog);
            return Body.BODY_200;
        }else {
            return Body.newInstance(201,"修改失败");
        }
    }

    @Override
    public Body selectByofficeBuildingId(Integer id) {
        LambdaQueryWrapper<OfficeBuildingToPicture> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(OfficeBuildingToPicture::getOfficeBuildingId,id);
        List<OfficeBuildingToPicture>list=this.officeBuildingToPictureMapper.selectList(wrapper);
        if (list.size()>0){
            return Body.newInstance(list);
        }
        return Body.newInstance(201,"没有查到相应消息");
    }

    @Override
    public Body deleteOfficeBuildingPicture(Integer Id) {
        Integer count=this.officeBuildingToPictureMapper.deleteById(Id);
        if (count==1){
            return Body.BODY_200;
        }
        return Body.newInstance(201,"删除失败");
    }
}
