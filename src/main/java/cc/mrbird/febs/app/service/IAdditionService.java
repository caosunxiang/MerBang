package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Addition;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 16:18:23
 */
public interface IAdditionService extends IService<Addition> {
    /**
     * 查询（分页）
     *
     * @param request  QueryRequest
     * @param addition addition
     * @return IPage<Addition>
     */
    IPage<Addition> findAdditions(QueryRequest request, Addition addition);

    /**
     * 查询（所有）
     *
     * @param addition addition
     * @return List<Addition>
     */
    List<Addition> findAdditions(Addition addition);

    /**
     * 新增
     *
     * @param addition addition
     */
    void createAddition(Addition addition);

    /**
     * 修改
     *
     * @param addition addition
     */
    void updateAddition(Addition addition);

    /**
     * 删除
     *
     * @param addition addition
     */
    void deleteAddition(Addition addition);

    /**
     * @Description: 添加物业费收费款项
     * @Param: [addition]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 16:58
     */
    Body insertAddition(Addition addition);

    /**
     * @Description: 删除物业费收费款项
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 17:00
     */
    Body delectAddition(Integer id);

    /**
     * @Description: 查找物业费的收费款项
     * @Param: [costId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 17:05
     */
    Body selectAdditionByCostId(Integer costId);
}
