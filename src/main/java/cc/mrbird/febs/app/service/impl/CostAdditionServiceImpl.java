package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.CostAddition;
import cc.mrbird.febs.app.mapper.CostAdditionMapper;
import cc.mrbird.febs.app.service.ICostAdditionService;
import cc.mrbird.febs.common.utils.json.Body;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 16:18:18
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CostAdditionServiceImpl extends ServiceImpl<CostAdditionMapper, CostAddition> implements ICostAdditionService {

    private final CostAdditionMapper costAdditionMapper;

    @Override
    public IPage<CostAddition> findCostAdditions(QueryRequest request, CostAddition costAddition) {
        LambdaQueryWrapper<CostAddition> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<CostAddition> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<CostAddition> findCostAdditions(CostAddition costAddition) {
        LambdaQueryWrapper<CostAddition> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCostAddition(CostAddition costAddition) {
        this.save(costAddition);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCostAddition(CostAddition costAddition) {
        this.saveOrUpdate(costAddition);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCostAddition(CostAddition costAddition) {
        LambdaQueryWrapper<CostAddition> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body insertCostAddition(CostAddition costAddition, Integer userid) {
        costAddition.setCreateUser(userid);
        int count = this.costAdditionMapper.insert(costAddition);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "查询错误");
    }


    @Override
    public Body selectCostAdditionaAll() {
        LambdaQueryWrapper<CostAddition> wrapper = new LambdaQueryWrapper<>();
        List<CostAddition> list = this.costAdditionMapper.selectList(wrapper);
        if (list.size() > 0) {
            return Body.newInstance(list);
        }
        return Body.newInstance(201, "没有设置");
    }

    @Override
    public Body selectCostAdditionaByPid(Integer pid) {
        LambdaQueryWrapper<CostAddition> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CostAddition::getPid, pid);
        List<CostAddition> list = this.costAdditionMapper.selectList(wrapper);
        if (list.size() > 0) {
            return Body.newInstance(list);
        }
        return Body.newInstance(201, "没有设置");
    }

    @Override
    public Body updateCostAdditionaName(CostAddition costAddition) {
        this.costAdditionMapper.updateById(costAddition);
        return Body.BODY_200;
    }

    @Override
    public Body deleteCost(Integer id) {
        this.costAdditionMapper.deleteById(id);
        return Body.BODY_200;
    }
}
