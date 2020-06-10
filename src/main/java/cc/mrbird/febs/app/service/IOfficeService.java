package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Office;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:16:31
 */
public interface IOfficeService extends IService<Office> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param office  office
     * @return IPage<Office>
     */
    IPage<Office> findOffices(QueryRequest request, Office office);

    /**
     * 查询（所有）
     *
     * @param office office
     * @return List<Office>
     */
    List<Office> findOffices(Office office);

    /**
     * 新增
     *
     * @param office office
     */
    void createOffice(Office office);

    /**
     * 修改
     *
     * @param office office
     */
    void updateOffice(Office office);

    /**
     * 删除
     *
     * @param office office
     */
    void deleteOffice(Office office);

    /**
     * @Description: 办公室高级搜索
     * @Param: [condition, areaLow, areaHigh, priceLow, priceHigh, fitment, name, position]
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @Author: 冷酷的苹果
     * @Date: 2020/5/7 13:16
     */
    Body selectOffice(String condition, Integer areaLow, Integer areaHigh, String priceLow,Integer id,
                      String priceHigh, String fitment, String name, String position, String address,
                      String userId, String myId, String order, Integer index,
                      Integer size);

    /**
     * @Description: 上传办公室首页图片
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 8:58
     */
    Body uploadOfficeHomePage(Integer officeBuildingId, String picture, Integer userId);

    /**
     * @Description: 批量添加办公室
     * @Param: [data]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/14 9:12
     */
    Body insertOffice(String data, Integer id);

    /**
     * @Description: 批量添加中的下拉框(上级)
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/14 9:51
     */
    Body selectPidType(Integer id);

    /**
     * @Description: 查找指定办公室详情
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/14 10:52
     */
    Body selectOfficeDetails(Integer id);

    /**
     * @Description: 修改办公室信息/个人详情
     * @Param: [office]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/14 14:23
     */
    Body updateOfficeDetails(Office office, Integer userid);

    /**
     * @Description: 办公室信息
     * @Param: [id]
     * @return:
     * @Author: 冷酷的苹果
     * @Date: 2020/5/26 16:29
     */
    Body selectOfficeById(Integer id);

    /**
     * @Description:
     * @Param: [pid, door, id]
     * @return:
     * @Author: 冷酷的苹果
     * @Date: 2020/5/28 19:13
     */
    Body selectOfficeInPrice(Integer pid, String door, Integer id);
/** 
* @Description: 物业费页面查找办公室
* @Param: [id]
* @return: cc.mrbird.febs.common.utils.json.Body
* @Author: 冷酷的苹果
* @Date: 2020/5/29 17:47
*/
    Body selectOfficeInCost(Integer id,Integer uid,String type);
/** 
* @Description: 删除办公室
* @Param: [officeId]
* @return: cc.mrbird.febs.common.utils.json.Body
* @Author: 冷酷的苹果
* @Date: 2020/6/1 11:13
*/
    Body deleteOffice(Integer officeId);
}
