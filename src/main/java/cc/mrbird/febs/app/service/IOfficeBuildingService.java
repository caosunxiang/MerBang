package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.OfficeBuilding;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-04-30 17:22:24
 */
public interface IOfficeBuildingService extends IService<OfficeBuilding> {
    /**
     * 查询（分页）
     *
     * @param request        QueryRequest
     * @param officeBuilding officeBuilding
     * @return IPage<OfficeBuilding>
     */
    IPage<OfficeBuilding> findOfficeBuildings(QueryRequest request, OfficeBuilding officeBuilding);

    /**
     * 查询（所有）
     *
     * @param officeBuilding officeBuilding
     * @return List<OfficeBuilding>
     */
    List<OfficeBuilding> findOfficeBuildings(OfficeBuilding officeBuilding);

    /**
     * 新增
     *
     * @param officeBuilding officeBuilding
     */
    void createOfficeBuilding(OfficeBuilding officeBuilding);

    /**
     * 修改
     *
     * @param officeBuilding officeBuilding
     */
    void updateOfficeBuilding(OfficeBuilding officeBuilding);

    /**
     * 删除
     *
     * @param officeBuilding officeBuilding
     */
    void deleteOfficeBuilding(OfficeBuilding officeBuilding);

    /**
     * @Description: 写字楼查询
     * @Param: [condition]
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/4/30 17:56
     */
    Body selectOfficeBuilding(String condition, Integer areaLow, Integer areaHigh, String priceLow,
                              String priceHigh, String fitment, String name, String position,
                              String userId, String myId, String address, String order, Integer index, Integer size);

    /**
     * @Description: 写字楼唯一查询
     * @Param: [id]
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/6 8:58
     */
    Body selectOfficeBuildingById(Integer id);

    /**
     * @Description: 添加写字楼
     * @Param: [name, address, log, lat, area, price, user]
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/11 9:51
     */
    Body insertOfficeBuilding(String name, String address, String log, String lat, String area, String price,
                              Integer user);

    /**
     * @Description: 上传写字楼照片
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/12 11:05
     */
    Body uploadOfficeBuilding(MultipartFile file);

    /**
     * @Description: 上传写字楼首页图片
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 8:58
     */
    Body uploadOfficeHomePage(Integer officeBuildingId, String picture, Integer userId);

    /**
     * @Description: 修改写字楼详情
     * @Param: [officeBuilding]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/14 14:42
     */
    Body updateOfficeBuildingDetails(OfficeBuilding officeBuilding);

}
