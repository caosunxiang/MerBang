package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.DistrictToOfficeBuilding;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:36
 */
public interface IDistrictToOfficeBuildingService extends IService<DistrictToOfficeBuilding> {
    /**
     * 查询（分页）
     *
     * @param request                  QueryRequest
     * @param districtToOfficeBuilding districtToOfficeBuilding
     * @return IPage<DistrictToOfficeBuilding>
     */
    IPage<DistrictToOfficeBuilding> findDistrictToOfficeBuildings(QueryRequest request,
                                                                  DistrictToOfficeBuilding districtToOfficeBuilding);

    /**
     * 查询（所有）
     *
     * @param districtToOfficeBuilding districtToOfficeBuilding
     * @return List<DistrictToOfficeBuilding>
     */
    List<DistrictToOfficeBuilding> findDistrictToOfficeBuildings(DistrictToOfficeBuilding districtToOfficeBuilding);

    /**
     * 新增
     *
     * @param districtToOfficeBuilding districtToOfficeBuilding
     */
    void createDistrictToOfficeBuilding(DistrictToOfficeBuilding districtToOfficeBuilding);

    /**
     * 修改
     *
     * @param districtToOfficeBuilding districtToOfficeBuilding
     */
    void updateDistrictToOfficeBuilding(DistrictToOfficeBuilding districtToOfficeBuilding);

    /**
     * 删除
     *
     * @param districtToOfficeBuilding districtToOfficeBuilding
     */
    void deleteDistrictToOfficeBuilding(DistrictToOfficeBuilding districtToOfficeBuilding);
}
