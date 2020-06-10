package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.SharedService;
import cc.mrbird.febs.app.service.ISharedServiceService;
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
 * @date 2020-05-15 15:53:58
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class SharedServiceController extends BaseController {

    private final ISharedServiceService sharedServiceService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "sharedService")
    public String sharedServiceIndex(){
        return FebsUtil.view("sharedService/sharedService");
    }

    @GetMapping("sharedService")
    @ResponseBody
    @RequiresPermissions("sharedService:list")
    public FebsResponse getAllSharedServices(SharedService sharedService) {
        return new FebsResponse().success().data(sharedServiceService.findSharedServices(sharedService));
    }

    @GetMapping("sharedService/list")
    @ResponseBody
    @RequiresPermissions("sharedService:list")
    public FebsResponse sharedServiceList(QueryRequest request, SharedService sharedService) {
        Map<String, Object> dataTable = getDataTable(this.sharedServiceService.findSharedServices(request, sharedService));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增SharedService", exceptionMessage = "新增SharedService失败")
    @PostMapping("sharedService")
    @ResponseBody
    @RequiresPermissions("sharedService:add")
    public FebsResponse addSharedService(@Valid SharedService sharedService) {
        this.sharedServiceService.createSharedService(sharedService);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除SharedService", exceptionMessage = "删除SharedService失败")
    @GetMapping("sharedService/delete")
    @ResponseBody
    @RequiresPermissions("sharedService:delete")
    public FebsResponse deleteSharedService(SharedService sharedService) {
        this.sharedServiceService.deleteSharedService(sharedService);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改SharedService", exceptionMessage = "修改SharedService失败")
    @PostMapping("sharedService/update")
    @ResponseBody
    @RequiresPermissions("sharedService:update")
    public FebsResponse updateSharedService(SharedService sharedService) {
        this.sharedServiceService.updateSharedService(sharedService);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改SharedService", exceptionMessage = "导出Excel失败")
    @PostMapping("sharedService/excel")
    @ResponseBody
    @RequiresPermissions("sharedService:export")
    public void export(QueryRequest queryRequest, SharedService sharedService, HttpServletResponse response) {
        List<SharedService> sharedServices = this.sharedServiceService.findSharedServices(queryRequest, sharedService).getRecords();
        ExcelKit.$Export(SharedService.class, response).downXlsx(sharedServices, false);
    }

    @ControllerEndpoint(operation = "查找共享办公", exceptionMessage = "查找共享办公失败")
    @GetMapping("selectSharedService")
    @ResponseBody
    public Body selectSharedService() {
        return this.sharedServiceService.selectSharedService();
    }
}
