package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.MetroToOffice;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-07 16:30:38
 */
public interface IMetroToOfficeService extends IService<MetroToOffice> {
    /**
     * 查询（分页）
     *
     * @param request       QueryRequest
     * @param metroToOffice metroToOffice
     * @return IPage<MetroToOffice>
     */
    IPage<MetroToOffice> findMetroToOffices(QueryRequest request, MetroToOffice metroToOffice);

    /**
     * 查询（所有）
     *
     * @param metroToOffice metroToOffice
     * @return List<MetroToOffice>
     */
    List<MetroToOffice> findMetroToOffices(MetroToOffice metroToOffice);

    /**
     * 新增
     *
     * @param metroToOffice metroToOffice
     */
    void createMetroToOffice(MetroToOffice metroToOffice);

    /**
     * 修改
     *
     * @param metroToOffice metroToOffice
     */
    void updateMetroToOffice(MetroToOffice metroToOffice);

    /**
     * 删除
     *
     * @param metroToOffice metroToOffice
     */
    void deleteMetroToOffice(MetroToOffice metroToOffice);
}
