package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.HistoryToOffice;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:02
 */
public interface IHistoryToOfficeService extends IService<HistoryToOffice> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param historyToOffice historyToOffice
     * @return IPage<HistoryToOffice>
     */
    IPage<HistoryToOffice> findHistoryToOffices(QueryRequest request, HistoryToOffice historyToOffice);

    /**
     * 查询（所有）
     *
     * @param historyToOffice historyToOffice
     * @return List<HistoryToOffice>
     */
    List<HistoryToOffice> findHistoryToOffices(HistoryToOffice historyToOffice);

    /**
     * 新增
     *
     * @param historyToOffice historyToOffice
     */
    void createHistoryToOffice(HistoryToOffice historyToOffice);

    /**
     * 修改
     *
     * @param historyToOffice historyToOffice
     */
    void updateHistoryToOffice(HistoryToOffice historyToOffice);

    /**
     * 删除
     *
     * @param historyToOffice historyToOffice
     */
    void deleteHistoryToOffice(HistoryToOffice historyToOffice);
}
