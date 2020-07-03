package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:21
 */
public interface IAppLogService extends IService<AppLog> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param appLog  appLog
     * @return IPage<AppLog>
     */
    IPage<AppLog> findAppLogs(QueryRequest request, AppLog appLog);

    /**
     * 查询（所有）
     *
     * @param appLog appLog
     * @return List<AppLog>
     */
    List<AppLog> findAppLogs(AppLog appLog);

    /**
     * 新增
     *
     * @param appLog appLog
     */
    void createAppLog(AppLog appLog);

    /**
     * 修改
     *
     * @param appLog appLog
     */
    void updateAppLog(AppLog appLog);

    /**
     * 删除
     *
     * @param appLog appLog
     */
    void deleteAppLog(AppLog appLog);

    /**
     * @Description: 查找个人操作记录
     * @Param: [userId]
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/6 11:06
     */
    Body appLogByUserId(Integer userId, String type, Integer house);
}
