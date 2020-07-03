package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.entity.OfficeBuildingToPicture;
import cc.mrbird.febs.app.entity.SharedOffice;
import cc.mrbird.febs.app.entity.SharedOfficeToPicture;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.app.mapper.SharedOfficeToPictureMapper;
import cc.mrbird.febs.app.service.ISharedOfficeToPictureService;
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
 * @date 2020-05-06 09:17:58
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SharedOfficeToPictureServiceImpl extends ServiceImpl<SharedOfficeToPictureMapper, SharedOfficeToPicture> implements ISharedOfficeToPictureService {

    private final SharedOfficeToPictureMapper sharedOfficeToPictureMapper;

    private final AppLogMapper appLogMapper;

    @Override
    public IPage<SharedOfficeToPicture> findSharedOfficeToPictures(QueryRequest request,
                                                                   SharedOfficeToPicture sharedOfficeToPicture) {
        LambdaQueryWrapper<SharedOfficeToPicture> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<SharedOfficeToPicture> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<SharedOfficeToPicture> findSharedOfficeToPictures(SharedOfficeToPicture sharedOfficeToPicture) {
        LambdaQueryWrapper<SharedOfficeToPicture> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createSharedOfficeToPicture(SharedOfficeToPicture sharedOfficeToPicture) {
        this.save(sharedOfficeToPicture);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSharedOfficeToPicture(SharedOfficeToPicture sharedOfficeToPicture) {
        this.saveOrUpdate(sharedOfficeToPicture);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSharedOfficeToPicture(SharedOfficeToPicture sharedOfficeToPicture) {
        LambdaQueryWrapper<SharedOfficeToPicture> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body uploadIntroduce(String picture, Integer userId, Integer sharedOffice, String introduce) {
        SharedOfficeToPicture toPicture = new SharedOfficeToPicture();
        toPicture.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        toPicture.setCreateUser(userId);
        toPicture.setSharedOfficeId(sharedOffice);
        toPicture.setIntroduce(introduce);
        toPicture.setPicture(picture);
        Integer count = sharedOfficeToPictureMapper.insert(toPicture);
        if (count == 1) {
            AppLog appLog = new AppLog();
            appLog.setCreateUser(userId);
            appLog.setContent("更改" + introduce + "图片");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("B");
            appLog.setHouse⁯(sharedOffice);
            this.appLogMapper.insert(appLog);
            return Body.BODY_200;
        } else {
            return Body.newInstance(201, "修改失败");
        }
    }

    @Override
    public Body selectByofficeBuildingId(Integer id) {
        LambdaQueryWrapper<SharedOfficeToPicture> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SharedOfficeToPicture::getSharedOfficeId, id);
        List<SharedOfficeToPicture> list = this.sharedOfficeToPictureMapper.selectList(wrapper);
        if (list.size() > 0) {
            return Body.newInstance(list);
        }
        return Body.newInstance(201, "没有查到相应消息");
    }

    @Override
    public Body deleteSharedOfficePicture(Integer Id) {
        Integer count = this.sharedOfficeToPictureMapper.deleteById(Id);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "删除失败");
    }
}
