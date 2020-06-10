package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.MetroToSharedOffice;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-07 16:30:14
 */
public interface IMetroToSharedOfficeService extends IService<MetroToSharedOffice> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param metroToSharedOffice metroToSharedOffice
     * @return IPage<MetroToSharedOffice>
     */
    IPage<MetroToSharedOffice> findMetroToSharedOffices(QueryRequest request, MetroToSharedOffice metroToSharedOffice);

    /**
     * 查询（所有）
     *
     * @param metroToSharedOffice metroToSharedOffice
     * @return List<MetroToSharedOffice>
     */
    List<MetroToSharedOffice> findMetroToSharedOffices(MetroToSharedOffice metroToSharedOffice);

    /**
     * 新增
     *
     * @param metroToSharedOffice metroToSharedOffice
     */
    void createMetroToSharedOffice(MetroToSharedOffice metroToSharedOffice);

    /**
     * 修改
     *
     * @param metroToSharedOffice metroToSharedOffice
     */
    void updateMetroToSharedOffice(MetroToSharedOffice metroToSharedOffice);

    /**
     * 删除
     *
     * @param metroToSharedOffice metroToSharedOffice
     */
    void deleteMetroToSharedOffice(MetroToSharedOffice metroToSharedOffice);
}
