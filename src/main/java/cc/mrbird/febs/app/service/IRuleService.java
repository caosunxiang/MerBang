package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Rule;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-18 09:55:18
 */
public interface IRuleService extends IService<Rule> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param rule rule
     * @return IPage<Rule>
     */
    IPage<Rule> findRules(QueryRequest request, Rule rule);

    /**
     * 查询（所有）
     *
     * @param rule rule
     * @return List<Rule>
     */
    List<Rule> findRules(Rule rule);

    /**
     * 新增
     *
     * @param rule rule
     */
    void createRule(Rule rule);

    /**
     * 修改
     *
     * @param rule rule
     */
    void updateRule(Rule rule);

    /**
     * 删除
     *
     * @param rule rule
     */
    void deleteRule(Rule rule);

/** 
* @Description: 查找租户租金规则
* @Param: [lesseeId]
* @return: cc.mrbird.febs.common.utils.json.Body
* @Author: 冷酷的苹果
* @Date: 2020/5/18 10:30
*/
    Body selectRule(Integer lesseeId);
/** 
* @Description: 新增租金规则
* @Param: [rule]
* @return: cc.mrbird.febs.common.utils.json.Body
* @Author: 冷酷的苹果
* @Date: 2020/5/18 10:31
*/
    Body insertRule(Rule rule,Integer userid,Integer house);
/** 
* @Description: 修改租金规则
* @Param: [rule]
* @return: cc.mrbird.febs.common.utils.json.Body
* @Author: 冷酷的苹果
* @Date: 2020/5/18 10:33
*/
    Body updateRuleDetails(Rule rule,Integer userid,Integer house);
}
