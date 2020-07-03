package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.SharedOfficeLabel;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-15 14:45:20
 */
public interface ISharedOfficeLabelService extends IService<SharedOfficeLabel> {
    /**
     * 查询（分页）
     *
     * @param request           QueryRequest
     * @param sharedOfficeLabel sharedOfficeLabel
     * @return IPage<SharedOfficeLabel>
     */
    IPage<SharedOfficeLabel> findSharedOfficeLabels(QueryRequest request, SharedOfficeLabel sharedOfficeLabel);

    /**
     * 查询（所有）
     *
     * @param sharedOfficeLabel sharedOfficeLabel
     * @return List<SharedOfficeLabel>
     */
    List<SharedOfficeLabel> findSharedOfficeLabels(SharedOfficeLabel sharedOfficeLabel);

    /**
     * 新增
     *
     * @param sharedOfficeLabel sharedOfficeLabel
     */
    void createSharedOfficeLabel(SharedOfficeLabel sharedOfficeLabel);

    /**
     * 修改
     *
     * @param sharedOfficeLabel sharedOfficeLabel
     */
    void updateSharedOfficeLabel(SharedOfficeLabel sharedOfficeLabel);

    /**
     * 删除
     *
     * @param sharedOfficeLabel sharedOfficeLabel
     */
    void deleteSharedOfficeLabel(SharedOfficeLabel sharedOfficeLabel);

    /**
     * @Description: 查询共享办公标签
     * @Param: []
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/6 13:14
     */
    Body selectSharedOfficeLabel();

    /**
     * @Description: 添加共享办公标签
     * @Param: [name]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 13:29
     */
    Body insertSharedOfficeLabel(String name, Integer userId);
}
