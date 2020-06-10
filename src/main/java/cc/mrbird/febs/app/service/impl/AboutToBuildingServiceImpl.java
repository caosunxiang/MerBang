package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.AboutToBuilding;
import cc.mrbird.febs.app.mapper.AboutToBuildingMapper;
import cc.mrbird.febs.app.service.IAboutToBuildingService;
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
 * @date 2020-05-12 13:47:16
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AboutToBuildingServiceImpl extends ServiceImpl<AboutToBuildingMapper, AboutToBuilding> implements IAboutToBuildingService {

    private final AboutToBuildingMapper aboutToBuildingMapper;

    private final AppLogMapper appLogMapper;

    @Override
    public IPage<AboutToBuilding> findAboutToBuildings(QueryRequest request, AboutToBuilding aboutToBuilding) {
        LambdaQueryWrapper<AboutToBuilding> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<AboutToBuilding> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<AboutToBuilding> findAboutToBuildings(AboutToBuilding aboutToBuilding) {
	    LambdaQueryWrapper<AboutToBuilding> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAboutToBuilding(AboutToBuilding aboutToBuilding) {
        this.save(aboutToBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAboutToBuilding(AboutToBuilding aboutToBuilding) {
        this.saveOrUpdate(aboutToBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAboutToBuilding(AboutToBuilding aboutToBuilding) {
        LambdaQueryWrapper<AboutToBuilding> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertAbout(AboutToBuilding aboutToBuilding,Integer userid) {
        LambdaQueryWrapper<AboutToBuilding> wrapper=new LambdaQueryWrapper();
        wrapper.eq(AboutToBuilding::getOfficeBuildingId,aboutToBuilding.getOfficeBuildingId());
        AboutToBuilding about=this.aboutToBuildingMapper.selectOne(wrapper);
        if (about!=null){
            this.aboutToBuildingMapper.updateById(aboutToBuilding);
                AppLog appLog = new AppLog();
                appLog.setCreateUser(userid);
                appLog.setContent("修改写字楼信息");
                appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
                appLog.setRemark("A");
                appLog.setHouse⁯(aboutToBuilding.getOfficeBuildingId());
                this.appLogMapper.insert(appLog);
                return  Body.BODY_200;
        }
        Integer count=this.aboutToBuildingMapper.insert(aboutToBuilding);
        if (count==1){
            AppLog appLog = new AppLog();
            appLog.setCreateUser(userid);
            appLog.setContent("修改写字楼信息");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("A");
            appLog.setHouse⁯(aboutToBuilding.getOfficeBuildingId());
            this.appLogMapper.insert(appLog);
            return  Body.BODY_200;
        }
        return Body.newInstance(201,"添加失败");
    }

    @Override
    public Body selectAboutToBuilding(Integer id) {
        LambdaQueryWrapper<AboutToBuilding> wrapper=new LambdaQueryWrapper();
        wrapper.eq(AboutToBuilding::getOfficeBuildingId,id);
        AboutToBuilding aboutToBuilding=this.aboutToBuildingMapper.selectOne(wrapper);
        if (aboutToBuilding==null){
            return Body.newInstance(201,"尚未创建");
        }
        return Body.newInstance(aboutToBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body updateDetails(AboutToBuilding aboutToBuilding,Integer userid) {
        Integer count=this.aboutToBuildingMapper.updateById(aboutToBuilding);
        if (count==1){
            AppLog appLog = new AppLog();
            appLog.setCreateUser(userid);
            appLog.setContent("修改写字楼信息");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("A");
            appLog.setHouse⁯(aboutToBuilding.getOfficeBuildingId());
            this.appLogMapper.insert(appLog);
            return  Body.BODY_200;
        }
        return Body.newInstance(201,"添加失败");
    }
}
