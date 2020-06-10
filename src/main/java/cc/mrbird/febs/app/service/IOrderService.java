package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Order;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 13:56:57
 */
public interface IOrderService extends IService<Order> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param order   order
     * @return IPage<Order>
     */
    IPage<Order> findOrders(QueryRequest request, Order order);

    /**
     * 查询（所有）
     *
     * @param order order
     * @return List<Order>
     */
    List<Order> findOrders(Order order);

    /**
     * 新增
     *
     * @param order order
     */
    void createOrder(Order order);

    /**
     * 修改
     *
     * @param order order
     */
    void updateOrder(Order order);

    /**
     * 删除
     *
     * @param order order
     */
    void deleteOrder(Order order);

    /**
     * @Description: 录入支付凭证
     * @Param: [payer, date, peice, picture, remark]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 13:24
     */
    Body insertOrderDetails(String payer, String date, BigDecimal peice, String picture, String remark, Integer id,Integer contractId);

    /**
     * @Description: 查找账单的支付记录
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 14:27
     */
    Body selectByContractId(Integer id);

    /**
     * @Description: 查询账单详情
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 14:34
     */
    Body selectByOrderId(Integer id);

    /**
     * @Description:  首页折线图
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/22 8:51
     */
    Body selectLineChart(Integer id);
}
