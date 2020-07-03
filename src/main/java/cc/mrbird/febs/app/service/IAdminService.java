package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Admin;
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
 * @date 2020-05-06 09:17:33
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param admin   admin
     * @return IPage<Admin>
     */
    IPage<Admin> findAdmins(QueryRequest request, Admin admin);

    /**
     * 查询（所有）
     *
     * @param admin admin
     * @return List<Admin>
     */
    List<Admin> findAdmins(Admin admin);

    /**
     * 新增
     *
     * @param admin admin
     */
    void createAdmin(Admin admin);

    /**
     * 修改
     *
     * @param admin admin
     */
    void updateAdmin(Admin admin);

    /**
     * 删除
     *
     * @param admin admin
     */
    void deleteAdmin(Admin admin);

    /**
     * @Description: 系统详情
     * @Param: []
     * @return: void
     * @Author: 冷酷的苹果
     * @Date: 2020/5/6 10:49
     */
    Body adminParticulars();
}
