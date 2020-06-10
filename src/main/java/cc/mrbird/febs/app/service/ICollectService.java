package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Collect;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-26 09:53:12
 */
public interface ICollectService extends IService<Collect> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param collect collect
     * @return IPage<Collect>
     */
    IPage<Collect> findCollects(QueryRequest request, Collect collect);

    /**
     * 查询（所有）
     *
     * @param collect collect
     * @return List<Collect>
     */
    List<Collect> findCollects(Collect collect);

    /**
     * 新增
     *
     * @param collect collect
     */
    void createCollect(Collect collect);

    /**
     * 修改
     *
     * @param collect collect
     */
    void updateCollect(Collect collect);

    /**
     * 删除
     *
     * @param collect collect
     */
    void deleteCollect(Collect collect);

    /**
     * @Description: 查找我收藏的
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/26 10:29
     */
    Body selectCollect();

    /**
     * @Description: 添加收藏
     * @Param: [collect]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/26 10:31
     */
    Body insertCollect(Integer collectUser, Integer collectOfficeBuildingId, String type);

    /**
     * @Description: 取消收藏
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/26 10:31
     */
    Body deleteCollect(Integer id);
}
