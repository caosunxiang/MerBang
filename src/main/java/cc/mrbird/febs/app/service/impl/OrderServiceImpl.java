package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.Contract;
import cc.mrbird.febs.app.mapper.ContractMapper;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Order;
import cc.mrbird.febs.app.mapper.OrderMapper;
import cc.mrbird.febs.app.service.IOrderService;
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
 * @date 2020-05-19 13:56:57
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    private final OrderMapper orderMapper;

    private final ContractMapper contractMapper;

    @Override
    public IPage<Order> findOrders(QueryRequest request, Order order) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Order> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Order> findOrders(Order order) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrder(Order order) {
        this.save(order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(Order order) {
        this.saveOrUpdate(order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOrder(Order order) {
        LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertOrderDetails(String payer, String date, BigDecimal peice, String picture, String remark,
                                   Integer id,Integer contractId) {
        Order order = new Order();
        order.setContractId(id);
        order.setInvoice(picture);
        order.setPaidInDate(date);
        order.setPaidInPrice(peice);
        order.setPayer(payer);
        order.setContractId(contractId);
        order.setRemark(remark);
        int count = this.orderMapper.insert(order);
        if (count == 1) {
            Contract contract = new Contract();
            contract.setState("B");
            contract.setContractId(id);
            this.contractMapper.updateById(contract);
            return Body.newInstance(order);
        }
        return Body.newInstance(201, "缴费失败");
    }

    @Override
    public Body selectByContractId(Integer id) {
        LambdaQueryWrapper<Order> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Order::getContractId,id);
        List<Order> orders=this.orderMapper.selectList(wrapper);
        if (orders.size()>0){
            return Body.newInstance(orders);
        }
        return Body.newInstance(201,"查询失败");
    }

    @Override
    public Body selectByOrderId(Integer id) {
        Order order=this.orderMapper.selectById(id);
        if (order!=null){
            return Body.newInstance(order);
        }
        return Body.newInstance(201,"查找成功");
    }

    @Override
    public Body selectLineChart(Integer id) {
        List<Map<String,Object>>list=this.orderMapper.selectLineChart(id);
        return Body.newInstance(list);
    }


}
