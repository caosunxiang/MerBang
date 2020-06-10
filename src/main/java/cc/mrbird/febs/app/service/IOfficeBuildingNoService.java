package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.OfficeBuildingNo;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:10
 */
public interface IOfficeBuildingNoService extends IService<OfficeBuildingNo> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param officeBuildingNo officeBuildingNo
     * @return IPage<OfficeBuildingNo>
     */
    IPage<OfficeBuildingNo> findOfficeBuildingNos(QueryRequest request, OfficeBuildingNo officeBuildingNo);

    /**
     * 查询（所有）
     *
     * @param officeBuildingNo officeBuildingNo
     * @return List<OfficeBuildingNo>
     */
    List<OfficeBuildingNo> findOfficeBuildingNos(OfficeBuildingNo officeBuildingNo);

    /**
     * 新增
     *
     * @param officeBuildingNo officeBuildingNo
     */
    void createOfficeBuildingNo(OfficeBuildingNo officeBuildingNo);

    /**
     * 修改
     *
     * @param officeBuildingNo officeBuildingNo
     */
    void updateOfficeBuildingNo(OfficeBuildingNo officeBuildingNo);

    /**
     * 删除
     *
     * @param officeBuildingNo officeBuildingNo
     */
    
    void deleteOfficeBuildingNo(OfficeBuildingNo officeBuildingNo);

    /** 
    * @Description: 查找办公室楼号
    * @Param: [officeBuildingId]
    * @return: cc.mrbird.febs.common.entity.FebsResponse
    * @Author: 冷酷的苹果
    * @Date: 2020/5/6 15:56
    */
    Body selectOfficeBuildingNo(Integer officeBuildingId);
}
