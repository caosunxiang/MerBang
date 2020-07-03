package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.HistoryToSharedOffice;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:05
 */
public interface IHistoryToSharedOfficeService extends IService<HistoryToSharedOffice> {
    /**
     * 查询（分页）
     *
     * @param request               QueryRequest
     * @param historyToSharedOffice historyToSharedOffice
     * @return IPage<HistoryToSharedOffice>
     */
    IPage<HistoryToSharedOffice> findHistoryToSharedOffices(QueryRequest request,
                                                            HistoryToSharedOffice historyToSharedOffice);

    /**
     * 查询（所有）
     *
     * @param historyToSharedOffice historyToSharedOffice
     * @return List<HistoryToSharedOffice>
     */
    List<HistoryToSharedOffice> findHistoryToSharedOffices(HistoryToSharedOffice historyToSharedOffice);

    /**
     * 新增
     *
     * @param historyToSharedOffice historyToSharedOffice
     */
    void createHistoryToSharedOffice(HistoryToSharedOffice historyToSharedOffice);

    /**
     * 修改
     *
     * @param historyToSharedOffice historyToSharedOffice
     */
    void updateHistoryToSharedOffice(HistoryToSharedOffice historyToSharedOffice);

    /**
     * 删除
     *
     * @param historyToSharedOffice historyToSharedOffice
     */
    void deleteHistoryToSharedOffice(HistoryToSharedOffice historyToSharedOffice);
}
