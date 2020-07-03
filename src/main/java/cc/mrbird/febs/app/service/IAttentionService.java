package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Attention;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-07 16:30:04
 */
public interface IAttentionService extends IService<Attention> {
    /**
     * 查询（分页）
     *
     * @param request   QueryRequest
     * @param attention attention
     * @return IPage<Attention>
     */
    IPage<Attention> findAttentions(QueryRequest request, Attention attention);

    /**
     * 查询（所有）
     *
     * @param attention attention
     * @return List<Attention>
     */
    List<Attention> findAttentions(Attention attention);

    /**
     * 新增
     *
     * @param attention attention
     */
    void createAttention(Attention attention);

    /**
     * 修改
     *
     * @param attention attention
     */
    void updateAttention(Attention attention);

    /**
     * 删除
     *
     * @param attention attention
     */
    void deleteAttention(Attention attention);

    /**
     * @Description: 查询关注了写字楼的人
     * @Param: [OfficeBuildingid]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 14:27
     */
    Body selectByOfficeBuilding(String phone, Integer id);

    /**
     * @Description: 租户页面查找写字楼消息
     * @Param: [name]
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/8 10:33
     */
    Body selectBuildingInLessee(String name, Integer id);

    /**
     * @Description: 查找指定房源的绑定人
     * @Param: [type, id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/15 16:39
     */
    Body selectUserByType(String type, Integer id);

    /**
     * @Description: 删除已有管理员
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/15 16:51
     */
    Body delectUser(Integer userid, Integer id);

    /**
     * @Description: 添加管理员
     * @Param: [attention, id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/15 16:55
     */
    Body insertAttention(Attention attention, Integer id);

    /**
     * @Description: 查询用户下管理的房源
     * @Param: [userid]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/16 13:37
     */
    Body selectAttentionByUserid(Integer userid);

    /**
     * @Description: 查询旗下的房源
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/22 16:35
     */
    Body selectHouseInSet(Integer id);

}
