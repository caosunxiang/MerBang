package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.UserRecord;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:27
 */
public interface IUserRecordService extends IService<UserRecord> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param userRecord userRecord
     * @return IPage<UserRecord>
     */
    IPage<UserRecord> findUserRecords(QueryRequest request, UserRecord userRecord);

    /**
     * 查询（所有）
     *
     * @param userRecord userRecord
     * @return List<UserRecord>
     */
    List<UserRecord> findUserRecords(UserRecord userRecord);

    /**
     * 新增
     *
     * @param userRecord userRecord
     */
    void createUserRecord(UserRecord userRecord);

    /**
     * 修改
     *
     * @param userRecord userRecord
     */
    void updateUserRecord(UserRecord userRecord);

    /**
     * 删除
     *
     * @param userRecord userRecord
     */
    void deleteUserRecord(UserRecord userRecord);
}
