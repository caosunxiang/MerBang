package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.DistrictToOffice;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-07 16:30:33
 */
public interface IDistrictToOfficeService extends IService<DistrictToOffice> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param districtToOffice districtToOffice
     * @return IPage<DistrictToOffice>
     */
    IPage<DistrictToOffice> findDistrictToOffices(QueryRequest request, DistrictToOffice districtToOffice);

    /**
     * 查询（所有）
     *
     * @param districtToOffice districtToOffice
     * @return List<DistrictToOffice>
     */
    List<DistrictToOffice> findDistrictToOffices(DistrictToOffice districtToOffice);

    /**
     * 新增
     *
     * @param districtToOffice districtToOffice
     */
    void createDistrictToOffice(DistrictToOffice districtToOffice);

    /**
     * 修改
     *
     * @param districtToOffice districtToOffice
     */
    void updateDistrictToOffice(DistrictToOffice districtToOffice);

    /**
     * 删除
     *
     * @param districtToOffice districtToOffice
     */
    void deleteDistrictToOffice(DistrictToOffice districtToOffice);
}
