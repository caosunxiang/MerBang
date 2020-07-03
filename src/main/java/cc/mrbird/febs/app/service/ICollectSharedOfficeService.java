package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.CollectSharedOffice;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-26 09:53:33
 */
public interface ICollectSharedOfficeService extends IService<CollectSharedOffice> {
    /**
     * 查询（分页）
     *
     * @param request             QueryRequest
     * @param collectSharedOffice collectSharedOffice
     * @return IPage<CollectSharedOffice>
     */
    IPage<CollectSharedOffice> findCollectSharedOffices(QueryRequest request, CollectSharedOffice collectSharedOffice);

    /**
     * 查询（所有）
     *
     * @param collectSharedOffice collectSharedOffice
     * @return List<CollectSharedOffice>
     */
    List<CollectSharedOffice> findCollectSharedOffices(CollectSharedOffice collectSharedOffice);

    /**
     * 新增
     *
     * @param collectSharedOffice collectSharedOffice
     */
    void createCollectSharedOffice(CollectSharedOffice collectSharedOffice);

    /**
     * 修改
     *
     * @param collectSharedOffice collectSharedOffice
     */
    void updateCollectSharedOffice(CollectSharedOffice collectSharedOffice);

    /**
     * 删除
     *
     * @param collectSharedOffice collectSharedOffice
     */
    void deleteCollectSharedOffice(CollectSharedOffice collectSharedOffice);
}
