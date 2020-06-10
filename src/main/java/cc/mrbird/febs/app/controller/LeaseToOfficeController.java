package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.AboutToBuilding;
import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.LeaseToOffice;
import cc.mrbird.febs.app.service.ILeaseToOfficeService;
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
 * @date 2020-05-14 15:23:01
 */
@Slf4j
@Validated
@CrossOrigin
@RequestMapping("app")
@Controller
@RequiredArgsConstructor
public class LeaseToOfficeController extends BaseController {

    private final ILeaseToOfficeService leaseToOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "leaseToOffice")
    public String leaseToOfficeIndex(){
        return FebsUtil.view("leaseToOffice/leaseToOffice");
    }

    @GetMapping("leaseToOffice")
    @ResponseBody
    @RequiresPermissions("leaseToOffice:list")
    public FebsResponse getAllLeaseToOffices(LeaseToOffice leaseToOffice) {
        return new FebsResponse().success().data(leaseToOfficeService.findLeaseToOffices(leaseToOffice));
    }

    @GetMapping("leaseToOffice/list")
    @ResponseBody
    @RequiresPermissions("leaseToOffice:list")
    public FebsResponse leaseToOfficeList(QueryRequest request, LeaseToOffice leaseToOffice) {
        Map<String, Object> dataTable = getDataTable(this.leaseToOfficeService.findLeaseToOffices(request, leaseToOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增LeaseToOffice", exceptionMessage = "新增LeaseToOffice失败")
    @PostMapping("leaseToOffice")
    @ResponseBody
    @RequiresPermissions("leaseToOffice:add")
    public FebsResponse addLeaseToOffice(@Valid LeaseToOffice leaseToOffice) {
        this.leaseToOfficeService.createLeaseToOffice(leaseToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除LeaseToOffice", exceptionMessage = "删除LeaseToOffice失败")
    @GetMapping("leaseToOffice/delete")
    @ResponseBody
    @RequiresPermissions("leaseToOffice:delete")
    public FebsResponse deleteLeaseToOffice(LeaseToOffice leaseToOffice) {
        this.leaseToOfficeService.deleteLeaseToOffice(leaseToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改LeaseToOffice", exceptionMessage = "修改LeaseToOffice失败")
    @PostMapping("leaseToOffice/update")
    @ResponseBody
    @RequiresPermissions("leaseToOffice:update")
    public FebsResponse updateLeaseToOffice(LeaseToOffice leaseToOffice) {
        this.leaseToOfficeService.updateLeaseToOffice(leaseToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改LeaseToOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("leaseToOffice/excel")
    @ResponseBody
    @RequiresPermissions("leaseToOffice:export")
    public void export(QueryRequest queryRequest, LeaseToOffice leaseToOffice, HttpServletResponse response) {
        List<LeaseToOffice> leaseToOffices = this.leaseToOfficeService.findLeaseToOffices(queryRequest, leaseToOffice).getRecords();
        ExcelKit.$Export(LeaseToOffice.class, response).downXlsx(leaseToOffices, false);
    }
    @ControllerEndpoint(operation = "添加办公室租约", exceptionMessage = "添加办公室租约失败")
    @PostMapping("insertLease")
    @ResponseBody
    public Body insertLease(LeaseToOffice LeaseToOffice, Integer userid) {
        return this.leaseToOfficeService.insertLease(LeaseToOffice,userid);
    }

    @ControllerEndpoint(operation = "查看办公室租约", exceptionMessage = "查看办公室租约失败")
    @GetMapping("selectLeaseToOffice")
    @ResponseBody
    public Body selectLeaseToOffice(Integer id) {
        return this.leaseToOfficeService.selectLeaseToOffice(id);
    }

    @ControllerEndpoint(operation = "修改办公室详情", exceptionMessage = "修改办公室详情失败")
    @PostMapping("updateLeaseToOffice")
    @ResponseBody
    public Body updateDetails(LeaseToOffice LeaseToOffice,Integer userid) {
        return this.leaseToOfficeService.updateDetails(LeaseToOffice,userid);
    }
}
