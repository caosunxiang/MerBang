package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.entity.LabelToSharedOffice;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.app.mapper.LabelToSharedOfficeMapper;
import cc.mrbird.febs.app.service.ILabelToSharedOfficeService;
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

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:50
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LabelToSharedOfficeServiceImpl extends ServiceImpl<LabelToSharedOfficeMapper, LabelToSharedOffice> implements ILabelToSharedOfficeService {

    private final LabelToSharedOfficeMapper labelToSharedOfficeMapper;

    private final AppLogMapper appLogMapper;

    @Override
    public IPage<LabelToSharedOffice> findLabelToSharedOffices(QueryRequest request, LabelToSharedOffice labelToSharedOffice) {
        LambdaQueryWrapper<LabelToSharedOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<LabelToSharedOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<LabelToSharedOffice> findLabelToSharedOffices(LabelToSharedOffice labelToSharedOffice) {
	    LambdaQueryWrapper<LabelToSharedOffice> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createLabelToSharedOffice(LabelToSharedOffice labelToSharedOffice) {
        this.save(labelToSharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLabelToSharedOffice(LabelToSharedOffice labelToSharedOffice) {
        this.saveOrUpdate(labelToSharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLabelToSharedOffice(LabelToSharedOffice labelToSharedOffice) {
        LambdaQueryWrapper<LabelToSharedOffice> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public Body insertLabelAndSharedOffice(Integer SharedOfficeId, String labelId, Integer id) {
        String[] ids = labelId.split(StringPool.COMMA);
        for (String s : ids) {
            LabelToSharedOffice labelToSharedOffice=new LabelToSharedOffice();
            labelToSharedOffice.setSharedOfficeId(SharedOfficeId);
            labelToSharedOffice.setSharedOfficeLabelId(Integer.parseInt(s));
            this.labelToSharedOfficeMapper.insert(labelToSharedOffice);
        }
            AppLog appLog=new AppLog();
            appLog.setCreateUser(id);
            appLog.setContent("添加标签属性");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(),DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark("B");
            appLog.setHouse⁯(SharedOfficeId);
            this.appLogMapper.insert(appLog);
            return Body.BODY_200;
    }

    @Override
    public Body selectLabelBySharedOfficeId(Integer SharedOfficeId) {
        List<Map<String,Object>>list=this.labelToSharedOfficeMapper.selectSharedLabel(SharedOfficeId);
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
