package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.HistoryToOfficeBuilding;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:07
 */
public interface IHistoryToOfficeBuildingService extends IService<HistoryToOfficeBuilding> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param historyToOfficeBuilding historyToOfficeBuilding
     * @return IPage<HistoryToOfficeBuilding>
     */
    IPage<HistoryToOfficeBuilding> findHistoryToOfficeBuildings(QueryRequest request,
                                                                HistoryToOfficeBuilding historyToOfficeBuilding);

    /**
     * 查询（所有）
     *
     * @param historyToOfficeBuilding historyToOfficeBuilding
     * @return List<HistoryToOfficeBuilding>
     */
    List<HistoryToOfficeBuilding> findHistoryToOfficeBuildings(HistoryToOfficeBuilding historyToOfficeBuilding);

    /**
     * 新增
     *
     * @param historyToOfficeBuilding historyToOfficeBuilding
     */
    void createHistoryToOfficeBuilding(HistoryToOfficeBuilding historyToOfficeBuilding);

    /**
     * 修改
     *
     * @param historyToOfficeBuilding historyToOfficeBuilding
     */
    void updateHistoryToOfficeBuilding(HistoryToOfficeBuilding historyToOfficeBuilding);

    /**
     * 删除
     *
     * @param historyToOfficeBuilding historyToOfficeBuilding
     */
    void deleteHistoryToOfficeBuilding(HistoryToOfficeBuilding historyToOfficeBuilding);
}
