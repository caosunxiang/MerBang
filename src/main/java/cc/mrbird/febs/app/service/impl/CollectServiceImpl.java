package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.CollectSharedOffice;
import cc.mrbird.febs.app.mapper.CollectSharedOfficeMapper;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Collect;
import cc.mrbird.febs.app.mapper.CollectMapper;
import cc.mrbird.febs.app.service.ICollectService;
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
 * @date 2020-05-26 09:53:12
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService {

    private final CollectMapper collectMapper;

    private final CollectSharedOfficeMapper collectSharedOfficeMapper;

    @Override
    public IPage<Collect> findCollects(QueryRequest request, Collect collect) {
        LambdaQueryWrapper<Collect> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Collect> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Collect> findCollects(Collect collect) {
        LambdaQueryWrapper<Collect> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCollect(Collect collect) {
        this.save(collect);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCollect(Collect collect) {
        this.saveOrUpdate(collect);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCollect(Collect collect) {
        LambdaQueryWrapper<Collect> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectCollect() {
        List<Map<String, Object>> list = this.collectMapper.selectCollect();
        if (list.size() > 0) {
            return Body.newInstance(list);
        }
        return Body.newInstance(201, "没有相关信息");
    }

    @Override
    public Body insertCollect(Integer collectUser, Integer collectOfficeBuildingId, String type) {
        int count = 0;
        if (type.equals("A")) {
            Collect collect = new Collect();
            collect.setCollectOfficeBuildingId(collectOfficeBuildingId);
            collect.setCollectUser(collectUser);
            collect.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            count = this.collectMapper.insert(collect);
        } else {
            CollectSharedOffice collect = new CollectSharedOffice();
            collect.setCollectSharedOfficeId(collectOfficeBuildingId);
            collect.setCollectUser(collectUser);
            collect.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            count = this.collectSharedOfficeMapper.insert(collect);
        }
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "添加失败");
    }

    @Override
    public Body deleteCollect(Integer id) {
        int count = this.collectMapper.deleteById(id);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "取消失败");
    }
}
