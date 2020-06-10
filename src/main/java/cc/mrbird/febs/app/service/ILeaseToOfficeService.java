package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.AboutToBuilding;
import cc.mrbird.febs.app.entity.LeaseToOffice;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-14 15:23:01
 */
public interface ILeaseToOfficeService extends IService<LeaseToOffice> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param leaseToOffice leaseToOffice
     * @return IPage<LeaseToOffice>
     */
    IPage<LeaseToOffice> findLeaseToOffices(QueryRequest request, LeaseToOffice leaseToOffice);

    /**
     * 查询（所有）
     *
     * @param leaseToOffice leaseToOffice
     * @return List<LeaseToOffice>
     */
    List<LeaseToOffice> findLeaseToOffices(LeaseToOffice leaseToOffice);

    /**
     * 新增
     *
     * @param leaseToOffice leaseToOffice
     */
    void createLeaseToOffice(LeaseToOffice leaseToOffice);

    /**
     * 修改
     *
     * @param leaseToOffice leaseToOffice
     */
    void updateLeaseToOffice(LeaseToOffice leaseToOffice);

    /**
     * 删除
     *
     * @param leaseToOffice leaseToOffice
     */
    void deleteLeaseToOffice(LeaseToOffice leaseToOffice);



    /**
     * @Description: 添加办公室的详细情况
     * @Param: [leaseToOffice]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/12 13:55
     */
    Body insertLease(LeaseToOffice leaseToOffice, Integer userid);

    /**
     * @Description: 查询指定写字楼的详情
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/14 14:53
     */
    Body selectLeaseToOffice(Integer id);

    /**
     * @Description:   修改办公室
     * @Param: [leaseToOffice]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/14 14:54
     */
    Body updateDetails(LeaseToOffice leaseToOffice,Integer userid);
}
