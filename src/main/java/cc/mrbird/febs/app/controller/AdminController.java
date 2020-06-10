package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.Admin;
import cc.mrbird.febs.app.service.IAdminService;
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
 *  Controller
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:33
 */
@Slf4j
@Validated
@CrossOrigin
@Controller
@RequiredArgsConstructor
@RequestMapping("app")
public class AdminController extends BaseController {

    private final IAdminService adminService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "admin")
    public String adminIndex(){
        return FebsUtil.view("admin/admin");
    }

    @GetMapping("admin")
    @ResponseBody
    @RequiresPermissions("admin:list")
    public FebsResponse getAllAdmins(Admin admin) {
        return new FebsResponse().success().data(adminService.findAdmins(admin));
    }

    @GetMapping("admin/list")
    @ResponseBody
    @RequiresPermissions("admin:list")
    public FebsResponse adminList(QueryRequest request, Admin admin) {
        Map<String, Object> dataTable = getDataTable(this.adminService.findAdmins(request, admin));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Admin", exceptionMessage = "新增Admin失败")
    @PostMapping("admin")
    @ResponseBody
    @RequiresPermissions("admin:add")
    public FebsResponse addAdmin(@Valid Admin admin) {
        this.adminService.createAdmin(admin);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Admin", exceptionMessage = "删除Admin失败")
    @GetMapping("admin/delete")
    @ResponseBody
    @RequiresPermissions("admin:delete")
    public FebsResponse deleteAdmin(Admin admin) {
        this.adminService.deleteAdmin(admin);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Admin", exceptionMessage = "修改Admin失败")
    @PostMapping("admin/update")
    @ResponseBody
    @RequiresPermissions("admin:update")
    public FebsResponse updateAdmin(Admin admin) {
        this.adminService.updateAdmin(admin);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Admin", exceptionMessage = "导出Excel失败")
    @PostMapping("admin/excel")
    @ResponseBody
    @RequiresPermissions("admin:export")
    public void export(QueryRequest queryRequest, Admin admin, HttpServletResponse response) {
        List<Admin> admins = this.adminService.findAdmins(queryRequest, admin).getRecords();
        ExcelKit.$Export(Admin.class, response).downXlsx(admins, false);
    }

    @ControllerEndpoint(operation = "查看系统详情", exceptionMessage = "查看系统详情失败")
    @GetMapping("adminParticulars")
    @ResponseBody
    public Body adminParticulars(){
        return this.adminService.adminParticulars();
    }
}
