package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.AboutToBuilding;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-12 13:47:16
 */
public interface IAboutToBuildingService extends IService<AboutToBuilding> {
    /**
     * 查询（分页）
     *
     * @param request         QueryRequest
     * @param aboutToBuilding aboutToBuilding
     * @return IPage<AboutToBuilding>
     */
    IPage<AboutToBuilding> findAboutToBuildings(QueryRequest request, AboutToBuilding aboutToBuilding);

    /**
     * 查询（所有）
     *
     * @param aboutToBuilding aboutToBuilding
     * @return List<AboutToBuilding>
     */
    List<AboutToBuilding> findAboutToBuildings(AboutToBuilding aboutToBuilding);

    /**
     * 新增
     *
     * @param aboutToBuilding aboutToBuilding
     */
    void createAboutToBuilding(AboutToBuilding aboutToBuilding);

    /**
     * 修改
     *
     * @param aboutToBuilding aboutToBuilding
     */
    void updateAboutToBuilding(AboutToBuilding aboutToBuilding);

    /**
     * 删除
     *
     * @param aboutToBuilding aboutToBuilding
     */
    void deleteAboutToBuilding(AboutToBuilding aboutToBuilding);

    /**
     * @Description: 添加写字楼的详细情况
     * @Param: [aboutToBuilding]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/12 13:55
     */
    Body insertAbout(AboutToBuilding aboutToBuilding,Integer userid);

    /**
     * @Description: 查询指定写字楼的详情
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/14 14:53
     */
    Body selectAboutToBuilding(Integer id);

    /**
    * @Description:
    * @Param: [aboutToBuilding]
    * @return: cc.mrbird.febs.common.utils.json.Body
    * @Author: 冷酷的苹果
    * @Date: 2020/5/14 14:54
    */
    Body updateDetails(AboutToBuilding aboutToBuilding,Integer userid);
}
