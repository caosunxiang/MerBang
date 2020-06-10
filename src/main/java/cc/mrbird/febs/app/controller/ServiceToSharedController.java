package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.ServiceToShared;
import cc.mrbird.febs.app.service.IServiceToSharedService;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author 冷酷的苹果
 * @date 2020-05-15 15:54:00
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class ServiceToSharedController extends BaseController {

    private final IServiceToSharedService serviceToSharedService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "serviceToShared")
    public String serviceToSharedIndex(){
        return FebsUtil.view("serviceToShared/serviceToShared");
    }

    @GetMapping("serviceToShared")
    @ResponseBody
    @RequiresPermissions("serviceToShared:list")
    public FebsResponse getAllServiceToShareds(ServiceToShared serviceToShared) {
        return new FebsResponse().success().data(serviceToSharedService.findServiceToShareds(serviceToShared));
    }

    @GetMapping("serviceToShared/list")
    @ResponseBody
    @RequiresPermissions("serviceToShared:list")
    public FebsResponse serviceToSharedList(QueryRequest request, ServiceToShared serviceToShared) {
        Map<String, Object> dataTable = getDataTable(this.serviceToSharedService.findServiceToShareds(request, serviceToShared));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增ServiceToShared", exceptionMessage = "新增ServiceToShared失败")
    @PostMapping("serviceToShared")
    @ResponseBody
    @RequiresPermissions("serviceToShared:add")
    public FebsResponse addServiceToShared(@Valid ServiceToShared serviceToShared) {
        this.serviceToSharedService.createServiceToShared(serviceToShared);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除ServiceToShared", exceptionMessage = "删除ServiceToShared失败")
    @GetMapping("serviceToShared/delete")
    @ResponseBody
    @RequiresPermissions("serviceToShared:delete")
    public FebsResponse deleteServiceToShared(ServiceToShared serviceToShared) {
        this.serviceToSharedService.deleteServiceToShared(serviceToShared);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改ServiceToShared", exceptionMessage = "修改ServiceToShared失败")
    @PostMapping("serviceToShared/update")
    @ResponseBody
    @RequiresPermissions("serviceToShared:update")
    public FebsResponse updateServiceToShared(ServiceToShared serviceToShared) {
        this.serviceToSharedService.updateServiceToShared(serviceToShared);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改ServiceToShared", exceptionMessage = "导出Excel失败")
    @PostMapping("serviceToShared/excel")
    @ResponseBody
    @RequiresPermissions("serviceToShared:export")
    public void export(QueryRequest queryRequest, ServiceToShared serviceToShared, HttpServletResponse response) {
        List<ServiceToShared> serviceToShareds = this.serviceToSharedService.findServiceToShareds(queryRequest, serviceToShared).getRecords();
        ExcelKit.$Export(ServiceToShared.class, response).downXlsx(serviceToShareds, false);
    }

    @ControllerEndpoint(operation = "绑定共享办公服务", exceptionMessage = "绑定共享办公服务失败")
    @PostMapping("insertServiceToShared")
    @ResponseBody
    public Body insertServiceToShared(String serviceId, Integer sharedId, Integer userid) {
        List<String> list = Arrays.asList(serviceId);
        return this.serviceToSharedService.insertServiceToShared(list,sharedId,userid);
    }
}
