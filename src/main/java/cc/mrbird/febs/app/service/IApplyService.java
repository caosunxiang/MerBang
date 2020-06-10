package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Apply;

import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 16:04:13
 */
public interface IApplyService extends IService<Apply> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param apply   apply
     * @return IPage<Apply>
     */
    IPage<Apply> findApplys(QueryRequest request, Apply apply);

    /**
     * 查询（所有）
     *
     * @param apply apply
     * @return List<Apply>
     */
    List<Apply> findApplys(Apply apply);

    /**
     * 新增
     *
     * @param apply apply
     */
    void createApply(Apply apply);

    /**
     * 修改
     *
     * @param apply apply
     */
    void updateApply(Apply apply);

    /**
     * 删除
     *
     * @param apply apply
     */
    void deleteApply(Apply apply);

    /**
     * @Description: 办公室请求
     * @Param: [id]
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/8 16:31
     */
    Body selectApplyCount(Integer id);

    /** 
    * @Description: 查询指定办公室的请求
    * @Param: [id]
    * @return: cc.mrbird.febs.common.entity.FebsResponse
    * @Author: 冷酷的苹果
    * @Date: 2020/5/8 16:43
    */
    Body selectApplyByOffice(Integer id);

}
