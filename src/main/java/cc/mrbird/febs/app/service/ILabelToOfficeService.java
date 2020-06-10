package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.LabelToOffice;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:12
 */
public interface ILabelToOfficeService extends IService<LabelToOffice> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param labelToOffice labelToOffice
     * @return IPage<LabelToOffice>
     */
    IPage<LabelToOffice> findLabelToOffices(QueryRequest request, LabelToOffice labelToOffice);

    /**
     * 查询（所有）
     *
     * @param labelToOffice labelToOffice
     * @return List<LabelToOffice>
     */
    List<LabelToOffice> findLabelToOffices(LabelToOffice labelToOffice);

    /**
     * 新增
     *
     * @param labelToOffice labelToOffice
     */
    void createLabelToOffice(LabelToOffice labelToOffice);

    /**
     * 修改
     *
     * @param labelToOffice labelToOffice
     */
    void updateLabelToOffice(LabelToOffice labelToOffice);

    /**
     * 删除
     *
     * @param labelToOffice labelToOffice
     */
    void deleteLabelToOffice(LabelToOffice labelToOffice);

    /**
     * @Description:  查询已经选择的标签
     * @Param: [officeBuildingId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/21 15:48
     */
    Body selectLabelByOfficeId(Integer officeId);
}
