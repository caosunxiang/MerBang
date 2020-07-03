package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.Cost;
import cc.mrbird.febs.app.mapper.CostMapper;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Addition;
import cc.mrbird.febs.app.mapper.AdditionMapper;
import cc.mrbird.febs.app.service.IAdditionService;
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
 * @date 2020-05-19 16:18:23
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdditionServiceImpl extends ServiceImpl<AdditionMapper, Addition> implements IAdditionService {

    private final AdditionMapper additionMapper;

    private final CostMapper costMapper;

    @Override
    public IPage<Addition> findAdditions(QueryRequest request, Addition addition) {
        LambdaQueryWrapper<Addition> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Addition> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Addition> findAdditions(Addition addition) {
        LambdaQueryWrapper<Addition> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAddition(Addition addition) {
        this.save(addition);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAddition(Addition addition) {
        this.saveOrUpdate(addition);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAddition(Addition addition) {
        LambdaQueryWrapper<Addition> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertAddition(Addition addition) {
        int count = this.additionMapper.insert(addition);
        Cost cost = this.costMapper.selectById(addition.getCost());
        BigDecimal price = cost.getTotalPrices();
        price = price.add(addition.getPrice());
        cost.setTotalPrices(price);
        costMapper.updateById(cost);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "添加失败");
    }

    @Override
    public Body delectAddition(Integer id) {
        int count = this.additionMapper.deleteById(id);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "删除失败");
    }

    @Override
    public Body selectAdditionByCostId(Integer costId) {
        List<Map<String, Object>> list = this.additionMapper.selectAdditionByCostId(costId);
        if (list.size() > 0) {
            return Body.newInstance(list);
        }
        return Body.newInstance(201, "没有附加项");
    }
}
