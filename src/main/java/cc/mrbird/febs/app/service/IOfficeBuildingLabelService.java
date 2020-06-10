package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.OfficeBuildingLabel;
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
 * @date 2020-05-06 09:17:24
 */
public interface IOfficeBuildingLabelService extends IService<OfficeBuildingLabel> {
    /**
     * 查询（分页）
     *
     * @param request             QueryRequest
     * @param officeBuildingLabel officeBuildingLabel
     * @return IPage<OfficeBuildingLabel>
     */
    IPage<OfficeBuildingLabel> findOfficeBuildingLabels(QueryRequest request, OfficeBuildingLabel officeBuildingLabel);

    /**
     * 查询（所有）
     *
     * @param officeBuildingLabel officeBuildingLabel
     * @return List<OfficeBuildingLabel>
     */
    List<OfficeBuildingLabel> findOfficeBuildingLabels(OfficeBuildingLabel officeBuildingLabel);

    /**
     * 新增
     *
     * @param officeBuildingLabel officeBuildingLabel
     */
    void createOfficeBuildingLabel(OfficeBuildingLabel officeBuildingLabel);

    /**
     * 修改
     *
     * @param officeBuildingLabel officeBuildingLabel
     */
    void updateOfficeBuildingLabel(OfficeBuildingLabel officeBuildingLabel);

    /**
     * 删除
     *
     * @param officeBuildingLabel officeBuildingLabel
     */
    void deleteOfficeBuildingLabel(OfficeBuildingLabel officeBuildingLabel);

    /**
     * @Description: 查询写字楼标签
     * @Param: []
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/6 13:14
     */
    Body selectOfficeBuildingLabel();

    /**
     * @Description: 添加办公室标签
     * @Param: [name]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 13:29
     */
    Body insertOfficeBuildingLabel(String name,Integer userId);
}
