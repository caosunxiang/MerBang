package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.SharedOfficeToPicture;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:58
 */
public interface ISharedOfficeToPictureService extends IService<SharedOfficeToPicture> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param sharedOfficeToPicture sharedOfficeToPicture
     * @return IPage<SharedOfficeToPicture>
     */
    IPage<SharedOfficeToPicture> findSharedOfficeToPictures(QueryRequest request,
                                                            SharedOfficeToPicture sharedOfficeToPicture);

    /**
     * 查询（所有）
     *
     * @param sharedOfficeToPicture sharedOfficeToPicture
     * @return List<SharedOfficeToPicture>
     */
    List<SharedOfficeToPicture> findSharedOfficeToPictures(SharedOfficeToPicture sharedOfficeToPicture);

    /**
     * 新增
     *
     * @param sharedOfficeToPicture sharedOfficeToPicture
     */
    void createSharedOfficeToPicture(SharedOfficeToPicture sharedOfficeToPicture);

    /**
     * 修改
     *
     * @param sharedOfficeToPicture sharedOfficeToPicture
     */
    void updateSharedOfficeToPicture(SharedOfficeToPicture sharedOfficeToPicture);

    /**
     * 删除
     *
     * @param sharedOfficeToPicture sharedOfficeToPicture
     */
    void deleteSharedOfficeToPicture(SharedOfficeToPicture sharedOfficeToPicture);

    /**
     * @Description: 上传共享办公的具体照片
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 11:18
     */
    Body uploadIntroduce(String picture, Integer userId, Integer sharedOffice, String introduce);

    /**
     * @Description: 查看指定共享办公下的照片
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/13 13:21
     */
    Body selectByofficeBuildingId(Integer id);

    Body deleteSharedOfficePicture(Integer Id);
}
