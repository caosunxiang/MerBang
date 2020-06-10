package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Floor;

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
 * @date 2020-05-08 13:40:43
 */
public interface IFloorService extends IService<Floor> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param floor   floor
     * @return IPage<Floor>
     */
    IPage<Floor> findFloors(QueryRequest request, Floor floor);

    /**
     * 查询（所有）
     *
     * @param floor floor
     * @return List<Floor>
     */
    List<Floor> findFloors(Floor floor);

    /**
     * 新增
     *
     * @param floor floor
     */
    void createFloor(Floor floor);

    /**
     * 修改
     *
     * @param floor floor
     */
    void updateFloor(Floor floor);

    /**
     * 删除
     *
     * @param floor floor
     */
    void deleteFloor(Floor floor);

    /**
     * @Description: 查找写字楼下的楼层
     * @Param: [buildingId]
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/8 13:46
     */
    Body selectFloorById(Integer buildingId);

    /**
     * @Description: 添加写字楼下的楼层
     * @Param: [floor]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/12 9:31
     */
    Body insertFloor(Floor floor);

    /** 
    * @Description: 根据类型和上级id查询其下楼栋
    * @Param: []
    * @return: cc.mrbird.febs.common.utils.json.Body
    * @Author: 冷酷的苹果
    * @Date: 2020/5/14 10:27
    */
    Body selectFloorToId(Integer pid,String state);
}
