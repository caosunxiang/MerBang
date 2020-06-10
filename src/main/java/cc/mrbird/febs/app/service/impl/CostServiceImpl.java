package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Cost;
import cc.mrbird.febs.app.mapper.CostMapper;
import cc.mrbird.febs.app.service.ICostService;
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
import java.util.Map;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 16:18:21
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CostServiceImpl extends ServiceImpl<CostMapper, Cost> implements ICostService {

    private final CostMapper costMapper;

    @Override
    public IPage<Cost> findCosts(QueryRequest request, Cost cost) {
        LambdaQueryWrapper<Cost> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Cost> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Cost> findCosts(Cost cost) {
        LambdaQueryWrapper<Cost> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCost(Cost cost) {
        this.save(cost);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCost(Cost cost) {
        this.saveOrUpdate(cost);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCost(Cost cost) {
        LambdaQueryWrapper<Cost> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body InsertCost(Cost cost) {
        cost.setTotalPrices(cost.getPrice());
       cost.setType(1);
        int count = this.costMapper.insert(cost);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "创建失败");
    }

    @Override
    public Body selectCostByCostId(Integer id) {
        Cost cost = this.costMapper.selectById(id);
        if (cost!=null){
            return Body.newInstance(cost);
        } else {
            return Body.newInstance(201,"查找失败");
        }
    }

    @Override
    public Body costStatistics(Integer costId) {
        List<Map<String,Object>>list=this.costMapper.costStatistics(costId);
        if (list.size()>0){
            return Body.newInstance(list);
        }
        return Body.newInstance(201,"没有附加款项");
    }

    @Override
    public Body selectCost(String condition,Integer id,String door) {
        List<Map<String,Object>> list=this.costMapper.selectCost(condition,id,door);
        if (list.size()>0){
            return Body.newInstance(list);
        }
        return Body.newInstance(201,"查找失败");
    }
}
