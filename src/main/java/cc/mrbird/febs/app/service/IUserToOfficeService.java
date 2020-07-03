package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.UserToOffice;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 10:08:20
 */
public interface IUserToOfficeService extends IService<UserToOffice> {
    /**
     * 查询（分页）
     *
     * @param request      QueryRequest
     * @param userToOffice userToOffice
     * @return IPage<UserToOffice>
     */
    IPage<UserToOffice> findUserToOffices(QueryRequest request, UserToOffice userToOffice);

    /**
     * 查询（所有）
     *
     * @param userToOffice userToOffice
     * @return List<UserToOffice>
     */
    List<UserToOffice> findUserToOffices(UserToOffice userToOffice);

    /**
     * 新增
     *
     * @param userToOffice userToOffice
     */
    void createUserToOffice(UserToOffice userToOffice);

    /**
     * 修改
     *
     * @param userToOffice userToOffice
     */
    void updateUserToOffice(UserToOffice userToOffice);

    /**
     * 删除
     *
     * @param userToOffice userToOffice
     */
    void deleteUserToOffice(UserToOffice userToOffice);
}
