package cc.mrbird.febs.app.service;


import cc.mrbird.febs.app.entity.BusinessDistrict;
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
 * @date 2020-05-06 11:24:48
 */
public interface IBusinessDistrictService extends IService<BusinessDistrict> {
    /**
     * 查询（分页）
     *
     * @param request          QueryRequest
     * @param businessDistrict businessDistrict
     * @return IPage<BusinessDistrict>
     */
    IPage<BusinessDistrict> findBusinessDistricts(QueryRequest request, BusinessDistrict businessDistrict);

    /**
     * 查询（所有）
     *
     * @param businessDistrict businessDistrict
     * @return List<BusinessDistrict>
     */
    List<BusinessDistrict> findBusinessDistricts(BusinessDistrict businessDistrict);

    /**
     * 新增
     *
     * @param businessDistrict businessDistrict
     */
    void createBusinessDistrict(BusinessDistrict businessDistrict);

    /**
     * 修改
     *
     * @param businessDistrict businessDistrict
     */
    void updateBusinessDistrict(BusinessDistrict businessDistrict);

    /**
     * 删除
     *
     * @param businessDistrict businessDistrict
     */
    void deleteBusinessDistrict(BusinessDistrict businessDistrict);

    /**
     * @Description: 查找商圈信息
     * @Param: []
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/6 11:28
     */
    Body selectBusinessDistrict(String city);

    /**
     * @Description:
     * @Param: [businessDistrict]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/6/10 8:56
     */
    Body insertBusinessDistrict(BusinessDistrict businessDistrict);
}
