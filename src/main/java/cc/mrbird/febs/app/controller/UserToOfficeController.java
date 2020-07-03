package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.UserToOffice;
import cc.mrbird.febs.app.service.IUserToOfficeService;
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
 * @date 2020-05-08 10:08:20
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class UserToOfficeController extends BaseController {

    private final IUserToOfficeService userToOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "userToOffice")
    public String userToOfficeIndex() {
        return FebsUtil.view("userToOffice/userToOffice");
    }

    @GetMapping("userToOffice")
    @ResponseBody
    @RequiresPermissions("userToOffice:list")
    public FebsResponse getAllUserToOffices(UserToOffice userToOffice) {
        return new FebsResponse().success().data(userToOfficeService.findUserToOffices(userToOffice));
    }

    @GetMapping("userToOffice/list")
    @ResponseBody
    @RequiresPermissions("userToOffice:list")
    public FebsResponse userToOfficeList(QueryRequest request, UserToOffice userToOffice) {
        Map<String, Object> dataTable = getDataTable(this.userToOfficeService.findUserToOffices(request, userToOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增UserToOffice", exceptionMessage = "新增UserToOffice失败")
    @PostMapping("userToOffice")
    @ResponseBody
    @RequiresPermissions("userToOffice:add")
    public FebsResponse addUserToOffice(@Valid UserToOffice userToOffice) {
        this.userToOfficeService.createUserToOffice(userToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除UserToOffice", exceptionMessage = "删除UserToOffice失败")
    @GetMapping("userToOffice/delete")
    @ResponseBody
    @RequiresPermissions("userToOffice:delete")
    public FebsResponse deleteUserToOffice(UserToOffice userToOffice) {
        this.userToOfficeService.deleteUserToOffice(userToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改UserToOffice", exceptionMessage = "修改UserToOffice失败")
    @PostMapping("userToOffice/update")
    @ResponseBody
    @RequiresPermissions("userToOffice:update")
    public FebsResponse updateUserToOffice(UserToOffice userToOffice) {
        this.userToOfficeService.updateUserToOffice(userToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改UserToOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("userToOffice/excel")
    @ResponseBody
    @RequiresPermissions("userToOffice:export")
    public void export(QueryRequest queryRequest, UserToOffice userToOffice, HttpServletResponse response) {
        List<UserToOffice> userToOffices =
                this.userToOfficeService.findUserToOffices(queryRequest, userToOffice).getRecords();
        ExcelKit.$Export(UserToOffice.class, response).downXlsx(userToOffices, false);
    }
}
