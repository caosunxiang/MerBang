package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.UserToBuilding;

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
 * @date 2020-05-08 10:16:51
 */
public interface IUserToBuildingService extends IService<UserToBuilding> {
    /**
     * 查询（分页）
     *
     * @param request        QueryRequest
     * @param userToBuilding userToBuilding
     * @return IPage<UserToBuilding>
     */
    IPage<UserToBuilding> findUserToBuildings(QueryRequest request, UserToBuilding userToBuilding);

    /**
     * 查询（所有）
     *
     * @param userToBuilding userToBuilding
     * @return List<UserToBuilding>
     */
    List<UserToBuilding> findUserToBuildings(UserToBuilding userToBuilding);

    /**
     * 新增
     *
     * @param userToBuilding userToBuilding
     */
    void createUserToBuilding(UserToBuilding userToBuilding);

    /**
     * 修改
     *
     * @param userToBuilding userToBuilding
     */
    void updateUserToBuilding(UserToBuilding userToBuilding);

    /**
     * 删除
     *
     * @param userToBuilding userToBuilding
     */
    void deleteUserToBuilding(UserToBuilding userToBuilding);

    /**
     * @Description: 租户页面查找写字楼消息
     * @Param: [name]
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/8 10:33
     */
    Body selectBuildingInLessee(String name);
}
