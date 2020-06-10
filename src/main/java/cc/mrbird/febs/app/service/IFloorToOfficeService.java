package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.FloorToOffice;

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
 * @date 2020-05-08 13:40:47
 */
public interface IFloorToOfficeService extends IService<FloorToOffice> {
    /**
     * 查询（分页）
     *
     * @param request       QueryRequest
     * @param floorToOffice floorToOffice
     * @return IPage<FloorToOffice>
     */
    IPage<FloorToOffice> findFloorToOffices(QueryRequest request, FloorToOffice floorToOffice);

    /**
     * 查询（所有）
     *
     * @param floorToOffice floorToOffice
     * @return List<FloorToOffice>
     */
    List<FloorToOffice> findFloorToOffices(FloorToOffice floorToOffice);

    /**
     * 新增
     *
     * @param floorToOffice floorToOffice
     */
    void createFloorToOffice(FloorToOffice floorToOffice);

    /**
     * 修改
     *
     * @param floorToOffice floorToOffice
     */
    void updateFloorToOffice(FloorToOffice floorToOffice);

    /**
     * 删除
     *
     * @param floorToOffice floorToOffice
     */
    void deleteFloorToOffice(FloorToOffice floorToOffice);

    /**
     * @Description: 根据楼层查询办公室
     * @Param: [id]
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/8 14:41
     */
//    Body selectOfficeByfloor(Integer id);

    Body selectOfficeFloor(Integer pid ,Integer id);
}
