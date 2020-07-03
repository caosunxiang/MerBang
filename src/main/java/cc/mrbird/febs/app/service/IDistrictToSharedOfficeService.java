package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.DistrictToSharedOffice;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-07 16:30:08
 */
public interface IDistrictToSharedOfficeService extends IService<DistrictToSharedOffice> {
    /**
     * 查询（分页）
     *
     * @param request                QueryRequest
     * @param districtToSharedOffice districtToSharedOffice
     * @return IPage<DistrictToSharedOffice>
     */
    IPage<DistrictToSharedOffice> findDistrictToSharedOffices(QueryRequest request,
                                                              DistrictToSharedOffice districtToSharedOffice);

    /**
     * 查询（所有）
     *
     * @param districtToSharedOffice districtToSharedOffice
     * @return List<DistrictToSharedOffice>
     */
    List<DistrictToSharedOffice> findDistrictToSharedOffices(DistrictToSharedOffice districtToSharedOffice);

    /**
     * 新增
     *
     * @param districtToSharedOffice districtToSharedOffice
     */
    void createDistrictToSharedOffice(DistrictToSharedOffice districtToSharedOffice);

    /**
     * 修改
     *
     * @param districtToSharedOffice districtToSharedOffice
     */
    void updateDistrictToSharedOffice(DistrictToSharedOffice districtToSharedOffice);

    /**
     * 删除
     *
     * @param districtToSharedOffice districtToSharedOffice
     */
    void deleteDistrictToSharedOffice(DistrictToSharedOffice districtToSharedOffice);
}
