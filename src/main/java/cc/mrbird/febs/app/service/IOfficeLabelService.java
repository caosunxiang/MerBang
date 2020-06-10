package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.OfficeLabel;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:16:37
 */
public interface IOfficeLabelService extends IService<OfficeLabel> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param officeLabel officeLabel
     * @return IPage<OfficeLabel>
     */
    IPage<OfficeLabel> findOfficeLabels(QueryRequest request, OfficeLabel officeLabel);

    /**
     * 查询（所有）
     *
     * @param officeLabel officeLabel
     * @return List<OfficeLabel>
     */
    List<OfficeLabel> findOfficeLabels(OfficeLabel officeLabel);

    /**
     * 新增
     *
     * @param officeLabel officeLabel
     */
    void createOfficeLabel(OfficeLabel officeLabel);

    /**
     * 修改
     *
     * @param officeLabel officeLabel
     */
    void updateOfficeLabel(OfficeLabel officeLabel);

    /**
     * 删除
     *
     * @param officeLabel officeLabel
     */
    void deleteOfficeLabel(OfficeLabel officeLabel);
}
