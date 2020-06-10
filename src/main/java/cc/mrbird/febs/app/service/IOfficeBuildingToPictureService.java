package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.OfficeBuildingToPicture;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:56
 */
public interface IOfficeBuildingToPictureService extends IService<OfficeBuildingToPicture> {
    /**
     * 查询（分页）
     *
     * @param request                 QueryRequest
     * @param officeBuildingToPicture officeBuildingToPicture
     * @return IPage<OfficeBuildingToPicture>
     */
    IPage<OfficeBuildingToPicture> findOfficeBuildingToPictures(QueryRequest request,
                                                                OfficeBuildingToPicture officeBuildingToPicture);

    /**
     * 查询（所有）
     *
     * @param officeBuildingToPicture officeBuildingToPicture
     * @return List<OfficeBuildingToPicture>
     */
    List<OfficeBuildingToPicture> findOfficeBuildingToPictures(OfficeBuildingToPicture officeBuildingToPicture);

    /**
     * 新增
     *
     * @param officeBuildingToPicture officeBuildingToPicture
     */
    void createOfficeBuildingToPicture(OfficeBuildingToPicture officeBuildingToPicture);

    /**
     * 修改
     *
     * @param officeBuildingToPicture officeBuildingToPicture
     */
    void updateOfficeBuildingToPicture(OfficeBuildingToPicture officeBuildingToPicture);

    /**
     * 删除
     *
     * @param officeBuildingToPicture officeBuildingToPicture
     */
    void deleteOfficeBuildingToPicture(OfficeBuildingToPicture officeBuildingToPicture);

    /**
     * @Description: 上传写字楼的具体照片
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 11:18
     */
    Body uploadIntroduce(String picture, Integer userId, Integer officeBuilding, String introduce);

    /**
     * @Description: 查看指定写字楼下的照片
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 13:21
     */
    Body selectByofficeBuildingId(Integer id);

    /**
     * @Description: 删除办公室图片
     * @Param: [Id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/6/1 9:43
     */
    Body deleteOfficeBuildingPicture(Integer Id);
}
