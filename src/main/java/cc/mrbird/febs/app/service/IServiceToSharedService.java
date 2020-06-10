package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.ServiceToShared;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-15 15:54:00
 */
public interface IServiceToSharedService extends IService<ServiceToShared> {
    /**
     * 查询（分页）
     *
     * @param request         QueryRequest
     * @param serviceToShared serviceToShared
     * @return IPage<ServiceToShared>
     */
    IPage<ServiceToShared> findServiceToShareds(QueryRequest request, ServiceToShared serviceToShared);

    /**
     * 查询（所有）
     *
     * @param serviceToShared serviceToShared
     * @return List<ServiceToShared>
     */
    List<ServiceToShared> findServiceToShareds(ServiceToShared serviceToShared);

    /**
     * 新增
     *
     * @param serviceToShared serviceToShared
     */
    void createServiceToShared(ServiceToShared serviceToShared);

    /**
     * 修改
     *
     * @param serviceToShared serviceToShared
     */
    void updateServiceToShared(ServiceToShared serviceToShared);

    /**
     * 删除
     *
     * @param serviceToShared serviceToShared
     */
    void deleteServiceToShared(ServiceToShared serviceToShared);

    /*** 
     * @Description: 关联共享服务
     * @Param: [serviceId, sharedId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/15 16:14
     */
    Body insertServiceToShared(List<String> String, Integer sharedId,Integer userid);
}
