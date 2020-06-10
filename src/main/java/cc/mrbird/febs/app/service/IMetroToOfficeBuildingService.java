package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.MetroToOfficeBuilding;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:18
 */
public interface IMetroToOfficeBuildingService extends IService<MetroToOfficeBuilding> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param metroToOfficeBuilding metroToOfficeBuilding
     * @return IPage<MetroToOfficeBuilding>
     */
    IPage<MetroToOfficeBuilding> findMetroToOfficeBuildings(QueryRequest request,
                                                            MetroToOfficeBuilding metroToOfficeBuilding);

    /**
     * 查询（所有）
     *
     * @param metroToOfficeBuilding metroToOfficeBuilding
     * @return List<MetroToOfficeBuilding>
     */
    List<MetroToOfficeBuilding> findMetroToOfficeBuildings(MetroToOfficeBuilding metroToOfficeBuilding);

    /**
     * 新增
     *
     * @param metroToOfficeBuilding metroToOfficeBuilding
     */
    void createMetroToOfficeBuilding(MetroToOfficeBuilding metroToOfficeBuilding);

    /**
     * 修改
     *
     * @param metroToOfficeBuilding metroToOfficeBuilding
     */
    void updateMetroToOfficeBuilding(MetroToOfficeBuilding metroToOfficeBuilding);

    /**
     * 删除
     *
     * @param metroToOfficeBuilding metroToOfficeBuilding
     */
    void deleteMetroToOfficeBuilding(MetroToOfficeBuilding metroToOfficeBuilding);
}
