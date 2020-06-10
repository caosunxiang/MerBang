package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.app.service.IAppLogService;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
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

import java.util.List;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:21
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AppLogServiceImpl extends ServiceImpl<AppLogMapper, AppLog> implements IAppLogService {

    private final AppLogMapper appLogMapper;

    @Override
    public IPage<AppLog> findAppLogs(QueryRequest request, AppLog appLog) {
        LambdaQueryWrapper<AppLog> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<AppLog> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<AppLog> findAppLogs(AppLog appLog) {
        LambdaQueryWrapper<AppLog> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAppLog(AppLog appLog) {
        this.save(appLog);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAppLog(AppLog appLog) {
        this.saveOrUpdate(appLog);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAppLog(AppLog appLog) {
        LambdaQueryWrapper<AppLog> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body appLogByUserId(Integer userId, String type, Integer house) {
        LambdaQueryWrapper<AppLog> wrapper = new LambdaQueryWrapper<>();
        if (userId != null) {
            wrapper.eq(AppLog::getCreateUser, userId);
        }
        if (!StringUtils.isEmpty(type)) {
            wrapper.eq(AppLog::getRemark, type);
        }
        if (house != null) {
            wrapper.eq(AppLog::getHouse⁯, house);
        }
        List<AppLog> list = this.appLogMapper.selectList(wrapper);
        if (list.size() > 0) {
            Page<AppLog> page = new Page<>();
            page.setRecords(list);
            return Body.newInstance(page);
        } else {
            return Body.newInstance(201, "没有操作记录");
        }
    }
}
