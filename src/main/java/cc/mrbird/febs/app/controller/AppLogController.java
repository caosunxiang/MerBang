package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.service.IAppLogService;
import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:21
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class AppLogController extends BaseController {

    private final IAppLogService appLogService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "appLog")
    public String appLogIndex() {
        return FebsUtil.view("appLog/appLog");
    }

    @GetMapping("appLog")
    @ResponseBody
    @RequiresPermissions("appLog:list")
    public FebsResponse getAllAppLogs(AppLog appLog) {
        return new FebsResponse().success().data(appLogService.findAppLogs(appLog));
    }

    @GetMapping("appLog/list")
    @ResponseBody
    @RequiresPermissions("appLog:list")
    public FebsResponse appLogList(QueryRequest request, AppLog appLog) {
        Map<String, Object> dataTable = getDataTable(this.appLogService.findAppLogs(request, appLog));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增AppLog", exceptionMessage = "新增AppLog失败")
    @PostMapping("appLog")
    @ResponseBody
    @RequiresPermissions("appLog:add")
    public FebsResponse addAppLog(@Valid AppLog appLog) {
        this.appLogService.createAppLog(appLog);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除AppLog", exceptionMessage = "删除AppLog失败")
    @GetMapping("appLog/delete")
    @ResponseBody
    @RequiresPermissions("appLog:delete")
    public FebsResponse deleteAppLog(AppLog appLog) {
        this.appLogService.deleteAppLog(appLog);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改AppLog", exceptionMessage = "修改AppLog失败")
    @PostMapping("appLog/update")
    @ResponseBody
    @RequiresPermissions("appLog:update")
    public FebsResponse updateAppLog(AppLog appLog) {
        this.appLogService.updateAppLog(appLog);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改AppLog", exceptionMessage = "导出Excel失败")
    @PostMapping("appLog/excel")
    @ResponseBody
    @RequiresPermissions("appLog:export")
    public void export(QueryRequest queryRequest, AppLog appLog, HttpServletResponse response) {
        List<AppLog> appLogs = this.appLogService.findAppLogs(queryRequest, appLog).getRecords();
        ExcelKit.$Export(AppLog.class, response).downXlsx(appLogs, false);
    }

    @ControllerEndpoint(operation = "查询用户的操作记录", exceptionMessage = "查询用户的操作记录失败")
    @GetMapping("appLogByUserId")
    @ResponseBody
    public Body appLogByUserId(Integer userId, String type, Integer house) {
        if (userId == null) {
            return Body.newInstance(201, "没有这个用户");
        }
        return this.appLogService.appLogByUserId(userId, type, house);
    }
}
