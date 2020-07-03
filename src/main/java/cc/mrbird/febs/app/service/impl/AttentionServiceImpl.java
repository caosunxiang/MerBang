package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AUser;
import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.entity.Office;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.app.mapper.OfficeMapper;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Attention;
import cc.mrbird.febs.app.mapper.AttentionMapper;
import cc.mrbird.febs.app.service.IAttentionService;
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
import java.util.Map;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-07 16:30:04
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AttentionServiceImpl extends ServiceImpl<AttentionMapper, Attention> implements IAttentionService {

    private final AttentionMapper attentionMapper;

    private final OfficeMapper officeMapper;

    private final AppLogMapper appLogMapper;

    @Override
    public IPage<Attention> findAttentions(QueryRequest request, Attention attention) {
        LambdaQueryWrapper<Attention> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Attention> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Attention> findAttentions(Attention attention) {
        LambdaQueryWrapper<Attention> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAttention(Attention attention) {
        this.save(attention);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAttention(Attention attention) {
        this.saveOrUpdate(attention);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAttention(Attention attention) {
        LambdaQueryWrapper<Attention> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectByOfficeBuilding(String phone, Integer id) {
        List<AUser> list = this.attentionMapper.selectByOfficeBuilding(phone, id);
        if (list.size() > 0) {
            return Body.newInstance(list);
        }
        return Body.newInstance(201, "没有人关注");
    }

    @Override
    public Body selectBuildingInLessee(String name, Integer id) {
        List<Map<String, Object>> list = this.attentionMapper.selectBuildingInLessee(name, id);
        if (list.size() > 0) {
            for (Map<String, Object> stringObjectMap : list) {
                Integer buildId = Integer.parseInt((String) stringObjectMap.get("id"));
                Integer count = officeMapper.selectCountByBuildingId(buildId);
                stringObjectMap.put("count", count);
            }
            return Body.newInstance(list);
        } else {
            return Body.newInstance(201, "没有相关记录");
        }
    }

    @Override
    public Body selectUserByType(String type, Integer id) {
        List<Map<String, Object>> list = attentionMapper.selectUserByType(type, id);
        if (list.size() > 0) {
            return Body.newInstance(list);
        }
        return Body.newInstance(201, "没有管理员");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body delectUser(Integer userid, Integer id) {
        Attention attention = this.attentionMapper.selectById(id);
        this.attentionMapper.deleteById(id);
        AppLog appLog = new AppLog();
        appLog.setCreateUser(userid);
        appLog.setContent("删除管理员信息");
        appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        appLog.setRemark(attention.getAttentionType());
        appLog.setHouse⁯(attention.getAttentionLabel());
        this.appLogMapper.insert(appLog);
        return Body.newInstance(201, "操作成功");
    }

    @Override
    public Body insertAttention(Attention attention, Integer id) {
        attention.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        Integer count = this.attentionMapper.insert(attention);
        if (count == 1) {
            AppLog appLog = new AppLog();
            appLog.setCreateUser(id);
            appLog.setContent("添加管理员信息");
            appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            appLog.setRemark(attention.getAttentionType());
            appLog.setHouse⁯(attention.getAttentionLabel());
            this.appLogMapper.insert(appLog);
        }
        return Body.newInstance(201, "操作成功");
    }

    @Override
    public Body selectAttentionByUserid(Integer userid) {
        LambdaQueryWrapper<Attention> wrapper = new LambdaQueryWrapper<>();
        List<Attention> list = this.attentionMapper.selectList(wrapper);
        if (list.size() > 0) {
            return Body.newInstance(list);
        }
        return Body.newInstance(201, "没有查询到相关房源");
    }

    @Override
    public Body selectHouseInSet(Integer id) {
        List<Map<String, Object>> list = this.attentionMapper.selectHouseInSet(id);
        return Body.newInstance(list);
    }
}
