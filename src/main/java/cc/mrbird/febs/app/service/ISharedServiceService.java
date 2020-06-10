package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.SharedService;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-15 15:53:58
 */
public interface ISharedServiceService extends IService<SharedService> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param sharedService sharedService
     * @return IPage<SharedService>
     */
    IPage<SharedService> findSharedServices(QueryRequest request, SharedService sharedService);

    /**
     * 查询（所有）
     *
     * @param sharedService sharedService
     * @return List<SharedService>
     */
    List<SharedService> findSharedServices(SharedService sharedService);

    /**
     * 新增
     *
     * @param sharedService sharedService
     */
    void createSharedService(SharedService sharedService);

    /**
     * 修改
     *
     * @param sharedService sharedService
     */
    void updateSharedService(SharedService sharedService);

    /**
     * 删除
     *
     * @param sharedService sharedService
     */
    void deleteSharedService(SharedService sharedService);
/** 
* @Description: 查询共享办公服务
* @Param: []
* @return: cc.mrbird.febs.common.utils.json.Body
* @Author: 冷酷的苹果
* @Date: 2020/5/15 16:05
*/
    Body selectSharedService();
}
