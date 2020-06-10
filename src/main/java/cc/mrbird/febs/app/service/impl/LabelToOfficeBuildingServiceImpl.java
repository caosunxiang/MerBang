package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.entity.LabelToOfficeBuilding;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.app.mapper.LabelToOfficeBuildingMapper;
import cc.mrbird.febs.app.service.ILabelToOfficeBuildingService;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.DateUtil;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:39
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LabelToOfficeBuildingServiceImpl extends ServiceImpl<LabelToOfficeBuildingMapper, LabelToOfficeBuilding> implements ILabelToOfficeBuildingService {

    private final LabelToOfficeBuildingMapper labelToOfficeBuildingMapper;

    private final AppLogMapper appLogMapper;

    @Override
    public IPage<LabelToOfficeBuilding> findLabelToOfficeBuildings(QueryRequest request, LabelToOfficeBuilding labelToOfficeBuilding) {
        LambdaQueryWrapper<LabelToOfficeBuilding> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<LabelToOfficeBuilding> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<LabelToOfficeBuilding> findLabelToOfficeBuildings(LabelToOfficeBuilding labelToOfficeBuilding) {
	    LambdaQueryWrapper<LabelToOfficeBuilding> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createLabelToOfficeBuilding(LabelToOfficeBuilding labelToOfficeBuilding) {
        this.save(labelToOfficeBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLabelToOfficeBuilding(LabelToOfficeBuilding labelToOfficeBuilding) {
        this.saveOrUpdate(labelToOfficeBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLabelToOfficeBuilding(LabelToOfficeBuilding labelToOfficeBuilding) {
        LambdaQueryWrapper<LabelToOfficeBuilding> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertLabelAndOfficeBuilding(Integer officeBuildingId, String labelId,Integer id) {
        String[] ids = labelId.split(StringPool.COMMA);
        for (String s : ids) {
            LabelToOfficeBuilding labelToOfficeBuilding=new LabelToOfficeBuilding();
            labelToOfficeBuilding.setOfficeBuildingId(officeBuildingId);
            labelToOfficeBuilding.setOfficeBuildingLabelId(Integer.parseInt(s));
            this.labelToOfficeBuildingMapper.insert(labelToOfficeBuilding);
        }
            AppLog appLog=new AppLog();
            appLog.setCreateUser(id);
            appLog.setContent("添加标签属性");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(),DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("A");
            appLog.setHouse⁯(officeBuildingId);
            this.appLogMapper.insert(appLog);
            return Body.BODY_200;
    }

    @Override
    public Body selectLabelByBuildingId(Integer officeBuildingId) {
        List<Map<String,Object>>list=this.labelToOfficeBuildingMapper.selectBuildLabel(officeBuildingId);
        if (list.size()>0){
            for (Map<String, Object> stringObjectMap : list) {
                if (!StringUtils.isEmpty(stringObjectMap.get("oid"))){
                    stringObjectMap.put("oid","bopdd_opp");
                }
            }
            return  Body.newInstance(list);
        }
        return Body.newInstance(201,"尚未选择");
    }
}
