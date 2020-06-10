package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.LabelToSharedOffice;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:50
 */
public interface ILabelToSharedOfficeService extends IService<LabelToSharedOffice> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param labelToSharedOffice labelToSharedOffice
     * @return IPage<LabelToSharedOffice>
     */
    IPage<LabelToSharedOffice> findLabelToSharedOffices(QueryRequest request, LabelToSharedOffice labelToSharedOffice);

    /**
     * 查询（所有）
     *
     * @param labelToSharedOffice labelToSharedOffice
     * @return List<LabelToSharedOffice>
     */
    List<LabelToSharedOffice> findLabelToSharedOffices(LabelToSharedOffice labelToSharedOffice);

    /**
     * 新增
     *
     * @param labelToSharedOffice labelToSharedOffice
     */
    void createLabelToSharedOffice(LabelToSharedOffice labelToSharedOffice);

    /**
     * 修改
     *
     * @param labelToSharedOffice labelToSharedOffice
     */
    void updateLabelToSharedOffice(LabelToSharedOffice labelToSharedOffice);

    /**
     * 删除
     *
     * @param labelToSharedOffice labelToSharedOffice
     */
    void deleteLabelToSharedOffice(LabelToSharedOffice labelToSharedOffice);

    /**
     * @Description:关联共享办公和标签
     * @Param: [officeBuildingId, labelId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 13:51
     */
    Body insertLabelAndSharedOffice(Integer SharedOfficeId, String labelId, Integer id);


    /**
     * @Description:  查询已经选择的标签
     * @Param: [officeBuildingId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/21 15:48
     */
    Body selectLabelBySharedOfficeId(Integer SharedOfficeId);
}
