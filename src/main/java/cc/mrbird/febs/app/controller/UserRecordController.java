package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.UserRecord;
import cc.mrbird.febs.app.service.IUserRecordService;
import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:27
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class UserRecordController extends BaseController {

    private final IUserRecordService userRecordService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "userRecord")
    public String userRecordIndex() {
        return FebsUtil.view("userRecord/userRecord");
    }

    @GetMapping("userRecord")
    @ResponseBody
    @RequiresPermissions("userRecord:list")
    public FebsResponse getAllUserRecords(UserRecord userRecord) {
        return new FebsResponse().success().data(userRecordService.findUserRecords(userRecord));
    }

    @GetMapping("userRecord/list")
    @ResponseBody
    @RequiresPermissions("userRecord:list")
    public FebsResponse userRecordList(QueryRequest request, UserRecord userRecord) {
        Map<String, Object> dataTable = getDataTable(this.userRecordService.findUserRecords(request, userRecord));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增UserRecord", exceptionMessage = "新增UserRecord失败")
    @PostMapping("userRecord")
    @ResponseBody
    @RequiresPermissions("userRecord:add")
    public FebsResponse addUserRecord(@Valid UserRecord userRecord) {
        this.userRecordService.createUserRecord(userRecord);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除UserRecord", exceptionMessage = "删除UserRecord失败")
    @GetMapping("userRecord/delete")
    @ResponseBody
    @RequiresPermissions("userRecord:delete")
    public FebsResponse deleteUserRecord(UserRecord userRecord) {
        this.userRecordService.deleteUserRecord(userRecord);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改UserRecord", exceptionMessage = "修改UserRecord失败")
    @PostMapping("userRecord/update")
    @ResponseBody
    @RequiresPermissions("userRecord:update")
    public FebsResponse updateUserRecord(UserRecord userRecord) {
        this.userRecordService.updateUserRecord(userRecord);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改UserRecord", exceptionMessage = "导出Excel失败")
    @PostMapping("userRecord/excel")
    @ResponseBody
    @RequiresPermissions("userRecord:export")
    public void export(QueryRequest queryRequest, UserRecord userRecord, HttpServletResponse response) {
        List<UserRecord> userRecords = this.userRecordService.findUserRecords(queryRequest, userRecord).getRecords();
        ExcelKit.$Export(UserRecord.class, response).downXlsx(userRecords, false);
    }
}
