package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.SharedOffice;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:09
 */
public interface ISharedOfficeService extends IService<SharedOffice> {
    /**
     * 查询（分页）
     *
     * @param request      QueryRequest
     * @param sharedOffice sharedOffice
     * @return IPage<SharedOffice>
     */
    IPage<SharedOffice> findSharedOffices(QueryRequest request, SharedOffice sharedOffice);

    /**
     * 查询（所有）
     *
     * @param sharedOffice sharedOffice
     * @return List<SharedOffice>
     */
    List<SharedOffice> findSharedOffices(SharedOffice sharedOffice);

    /**
     * 新增
     *
     * @param sharedOffice sharedOffice
     */
    void createSharedOffice(SharedOffice sharedOffice);

    /**
     * 修改
     *
     * @param sharedOffice sharedOffice
     */
    void updateSharedOffice(SharedOffice sharedOffice);

    /**
     * 删除
     *
     * @param sharedOffice sharedOffice
     */
    void deleteSharedOffice(SharedOffice sharedOffice);

    /**
     * @Description: 高级查询共享办公
     * @Param: [condition, areaLow, areaHigh, priceLow, priceHigh, fitment, name, position, userId, myId]
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @Author: 冷酷的苹果
     * @Date: 2020/5/7 17:15
     */
    public Body selectSharedOffice(String condition, Integer id, Integer areaLow, Integer areaHigh, Integer priceLow,
                                   Integer priceHigh, String type, String name, String position,
                                   String userId, String myId, String address, String order, Integer index,
                                   Integer size);

    /**
     * @Description: 上传共享办公首页图片
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 8:58
     */
    Body uploadOfficeHomePage(Integer officeBuildingId, String picture, Integer userId);

    /**
     * @Description: 添加共享办公
     * @Param: [sharedOffice]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/15 13:58
     */
    Body insertSharedOffice(SharedOffice sharedOffice);

    /**
     * @Description: 修改共享办公
     * @Param: [sharedOffice]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/15 14:13
     */
    Body updateSharedOfficeDetails(SharedOffice sharedOffice, Integer userid);

    /**
     * @Description: 查询共享办公基本信息
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/25 17:27
     */
    Body selectSharedOfficeById(Integer id);
}
