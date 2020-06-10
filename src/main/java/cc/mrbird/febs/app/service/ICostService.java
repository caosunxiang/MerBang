package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Cost;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 16:18:21
 */
public interface ICostService extends IService<Cost> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param cost    cost
     * @return IPage<Cost>
     */
    IPage<Cost> findCosts(QueryRequest request, Cost cost);

    /**
     * 查询（所有）
     *
     * @param cost cost
     * @return List<Cost>
     */
    List<Cost> findCosts(Cost cost);

    /**
     * 新增
     *
     * @param cost cost
     */
    void createCost(Cost cost);

    /**
     * 修改
     *
     * @param cost cost
     */
    void updateCost(Cost cost);

    /**
     * 删除
     *
     * @param cost cost
     */
    void deleteCost(Cost cost);

    /**
     * @Description: 添加物业费
     * @Param: [cost]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/20 10:14
     */
    Body InsertCost(Cost cost);

    /**
     * @Description: 查找指定物业费订单
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/20 10:23
     */
    Body selectCostByCostId(Integer id );

    /** 
    * @Description: 费用统计
    * @Param: []
    * @return: cc.mrbird.febs.common.utils.json.Body
    * @Author: 冷酷的苹果
    * @Date: 2020/5/20 10:54
    */
    Body costStatistics(Integer costId);

    /** 
    * @Description: 查询所有物业费账单
    * @Param: []
    * @return: cc.mrbird.febs.common.utils.json.Body
    * @Author: 冷酷的苹果
    * @Date: 2020/5/20 13:17
    */
    Body selectCost(String condition,Integer id,String door);
}
