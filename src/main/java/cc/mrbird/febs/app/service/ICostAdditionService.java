package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.CostAddition;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 16:18:18
 */
public interface ICostAdditionService extends IService<CostAddition> {
    /**
     * 查询（分页）
     *
     * @param request      QueryRequest
     * @param costAddition costAddition
     * @return IPage<CostAddition>
     */
    IPage<CostAddition> findCostAdditions(QueryRequest request, CostAddition costAddition);

    /**
     * 查询（所有）
     *
     * @param costAddition costAddition
     * @return List<CostAddition>
     */
    List<CostAddition> findCostAdditions(CostAddition costAddition);

    /**
     * 新增
     *
     * @param costAddition costAddition
     */
    void createCostAddition(CostAddition costAddition);

    /**
     * 修改
     *
     * @param costAddition costAddition
     */
    void updateCostAddition(CostAddition costAddition);

    /**
     * 删除
     *
     * @param costAddition costAddition
     */
    void deleteCostAddition(CostAddition costAddition);


    Body insertCostAddition(CostAddition costAddition, Integer userid);

    /**
     * @Description: 查找所有分类
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 16:33
     */
    Body selectCostAdditionaAll();

    /**
     * @Description: 查询子类
     * @Param: [pid]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 16:33
     */
    Body selectCostAdditionaByPid(Integer pid);

    /**
     * @Description: 修改分类名字
     * @Param: [costAddition]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/29 10:47
     */
    Body updateCostAdditionaName(CostAddition costAddition);

    Body deleteCost(Integer id);
}
