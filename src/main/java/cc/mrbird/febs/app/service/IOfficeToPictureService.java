package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.OfficeToPicture;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:53
 */
public interface IOfficeToPictureService extends IService<OfficeToPicture> {
    /**
     * 查询（分页）
     *
     * @param request         QueryRequest
     * @param officeToPicture officeToPicture
     * @return IPage<OfficeToPicture>
     */
    IPage<OfficeToPicture> findOfficeToPictures(QueryRequest request, OfficeToPicture officeToPicture);

    /**
     * 查询（所有）
     *
     * @param officeToPicture officeToPicture
     * @return List<OfficeToPicture>
     */
    List<OfficeToPicture> findOfficeToPictures(OfficeToPicture officeToPicture);

    /**
     * 新增
     *
     * @param officeToPicture officeToPicture
     */
    void createOfficeToPicture(OfficeToPicture officeToPicture);

    /**
     * 修改
     *
     * @param officeToPicture officeToPicture
     */
    void updateOfficeToPicture(OfficeToPicture officeToPicture);

    /**
     * 删除
     *
     * @param officeToPicture officeToPicture
     */
    void deleteOfficeToPicture(OfficeToPicture officeToPicture);

    /**
     * @Description: 上传办公室的具体照片
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 11:18
     */
    Body uploadIntroduce(String picture, Integer userId, Integer office, String introduce);

    /**
     * @Description: 查看指定办公室下的照片
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 13:21
     */
    Body selectByofficeBuildingId(Integer id);


    Body deleteOfficePicture(Integer Id);
}
