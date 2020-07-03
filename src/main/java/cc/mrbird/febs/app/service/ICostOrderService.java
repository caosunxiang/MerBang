package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.CostOrder;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 16:18:25
 */
public interface ICostOrderService extends IService<CostOrder> {
    /**
     * 查询（分页）
     *
     * @param request   QueryRequest
     * @param costOrder costOrder
     * @return IPage<CostOrder>
     */
    IPage<CostOrder> findCostOrders(QueryRequest request, CostOrder costOrder);

    /**
     * 查询（所有）
     *
     * @param costOrder costOrder
     * @return List<CostOrder>
     */
    List<CostOrder> findCostOrders(CostOrder costOrder);

    /**
     * 新增
     *
     * @param costOrder costOrder
     */
    void createCostOrder(CostOrder costOrder);

    /**
     * 修改
     *
     * @param costOrder costOrder
     */
    void updateCostOrder(CostOrder costOrder);

    /**
     * 删除
     *
     * @param costOrder costOrder
     */
    void deleteCostOrder(CostOrder costOrder);

    /**
     * @Description: 添加物业费收费账单
     * @Param: [costOrder]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/20 16:02
     */
    Body insertCostOrder(CostOrder costOrder, Integer id);

    /**
     * @Description: 查询物业账单下的收费账单
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/20 16:03
     */
    Body selectCostOrderByCostId(Integer id);
}
