package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.Cost;
import cc.mrbird.febs.app.entity.Lessee;
import cc.mrbird.febs.app.mapper.CostMapper;
import cc.mrbird.febs.app.mapper.LesseeMapper;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.CostOrder;
import cc.mrbird.febs.app.mapper.CostOrderMapper;
import cc.mrbird.febs.app.service.ICostOrderService;
import cc.mrbird.febs.common.utils.json.Body;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 16:18:25
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CostOrderServiceImpl extends ServiceImpl<CostOrderMapper, CostOrder> implements ICostOrderService {

    private final CostOrderMapper costOrderMapper;

    private final LesseeMapper lesseeMapper;

    private final CostMapper costMapper;

    @Override
    public IPage<CostOrder> findCostOrders(QueryRequest request, CostOrder costOrder) {
        LambdaQueryWrapper<CostOrder> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<CostOrder> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<CostOrder> findCostOrders(CostOrder costOrder) {
        LambdaQueryWrapper<CostOrder> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCostOrder(CostOrder costOrder) {
        this.save(costOrder);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCostOrder(CostOrder costOrder) {
        this.saveOrUpdate(costOrder);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCostOrder(CostOrder costOrder) {
        LambdaQueryWrapper<CostOrder> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertCostOrder(CostOrder costOrder, Integer id) {
        int count = this.costOrderMapper.insert(costOrder);
        Cost cost = this.costMapper.selectById(costOrder.getCost());
        BigDecimal price = new BigDecimal(0);
        if (cost.getTotalPrices().compareTo(costOrder.getPrice()) >= 0) {
            price = price.add(costOrder.getPrice());
            cost.setSurplus(cost.getSurplus().add(price));
        }
        if (count == 1) {
            Lessee lessee = this.lesseeMapper.selectById(id);
            lessee.setAccepting(lessee.getAccepting().add(price));
            lesseeMapper.insert(lessee);
            costMapper.updateById(cost);
            return Body.BODY_200;
        }
        return Body.newInstance(201, "添加失败");
    }

    @Override
    public Body selectCostOrderByCostId(Integer id) {
        List<Map<String, Object>> list = this.costOrderMapper.selectCostOrderByCostId(id);
        if (list.size() > 0) {
            return Body.newInstance(list);
        }
        return Body.newInstance(201, "查找失败");
    }
}
