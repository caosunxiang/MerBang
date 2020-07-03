package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.entity.OfficeBuildingLabel;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.app.mapper.OfficeBuildingLabelMapper;
import cc.mrbird.febs.app.service.IOfficeBuildingLabelService;
import cc.mrbird.febs.common.entity.FebsResponse;
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
 * @date 2020-05-06 09:17:24
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OfficeBuildingLabelServiceImpl extends ServiceImpl<OfficeBuildingLabelMapper, OfficeBuildingLabel> implements IOfficeBuildingLabelService {

    private final OfficeBuildingLabelMapper officeBuildingLabelMapper;

    private final AppLogMapper appLogMapper;

    @Override
    public IPage<OfficeBuildingLabel> findOfficeBuildingLabels(QueryRequest request,
                                                               OfficeBuildingLabel officeBuildingLabel) {
        LambdaQueryWrapper<OfficeBuildingLabel> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OfficeBuildingLabel> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OfficeBuildingLabel> findOfficeBuildingLabels(OfficeBuildingLabel officeBuildingLabel) {
        LambdaQueryWrapper<OfficeBuildingLabel> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOfficeBuildingLabel(OfficeBuildingLabel officeBuildingLabel) {
        this.save(officeBuildingLabel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOfficeBuildingLabel(OfficeBuildingLabel officeBuildingLabel) {
        this.saveOrUpdate(officeBuildingLabel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOfficeBuildingLabel(OfficeBuildingLabel officeBuildingLabel) {
        LambdaQueryWrapper<OfficeBuildingLabel> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectOfficeBuildingLabel() {
        LambdaQueryWrapper<OfficeBuildingLabel> wrapper = new LambdaQueryWrapper<>();
        List<OfficeBuildingLabel> list = this.officeBuildingLabelMapper.selectList(wrapper);
        if (list.size() > 0) {
            return Body.newInstance(list);
        } else {
            return Body.newInstance(201, "没有相关信息");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertOfficeBuildingLabel(String name, Integer userId) {
        OfficeBuildingLabel officeBuildingLabel = new OfficeBuildingLabel();
        officeBuildingLabel.setCreationTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        officeBuildingLabel.setName(name);
        Integer count = this.officeBuildingLabelMapper.insert(officeBuildingLabel);
        if (count == 1) {
            AppLog appLog = new AppLog();
            appLog.setCreateUser(userId);
            appLog.setContent("上传标签");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            this.appLogMapper.insert(appLog);
            return Body.BODY_200;
        }
        return Body.newInstance(201, "添加失败");
    }
}
