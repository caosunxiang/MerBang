package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.LabelToOfficeBuilding;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:39
 */
public interface ILabelToOfficeBuildingService extends IService<LabelToOfficeBuilding> {
    /**
     * 查询（分页）
     *
     * @param request               QueryRequest
     * @param labelToOfficeBuilding labelToOfficeBuilding
     * @return IPage<LabelToOfficeBuilding>
     */
    IPage<LabelToOfficeBuilding> findLabelToOfficeBuildings(QueryRequest request,
                                                            LabelToOfficeBuilding labelToOfficeBuilding);

    /**
     * 查询（所有）
     *
     * @param labelToOfficeBuilding labelToOfficeBuilding
     * @return List<LabelToOfficeBuilding>
     */
    List<LabelToOfficeBuilding> findLabelToOfficeBuildings(LabelToOfficeBuilding labelToOfficeBuilding);

    /**
     * 新增
     *
     * @param labelToOfficeBuilding labelToOfficeBuilding
     */
    void createLabelToOfficeBuilding(LabelToOfficeBuilding labelToOfficeBuilding);

    /**
     * 修改
     *
     * @param labelToOfficeBuilding labelToOfficeBuilding
     */
    void updateLabelToOfficeBuilding(LabelToOfficeBuilding labelToOfficeBuilding);

    /**
     * 删除
     *
     * @param labelToOfficeBuilding labelToOfficeBuilding
     */
    void deleteLabelToOfficeBuilding(LabelToOfficeBuilding labelToOfficeBuilding);

    /**
     * @Description:关联写字楼和标签
     * @Param: [officeBuildingId, labelId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 13:51
     */
    Body insertLabelAndOfficeBuilding(Integer officeBuildingId, String labelId, Integer id);

    /**
     * @Description:  查询已经选择的标签
     * @Param: [officeBuildingId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/21 15:48
     */
    Body selectLabelByBuildingId(Integer officeBuildingId);
}
