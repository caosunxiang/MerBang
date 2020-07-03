package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.MetroToOffice;
import cc.mrbird.febs.app.service.IMetroToOfficeService;
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
 * @date 2020-05-07 16:30:38
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class MetroToOfficeController extends BaseController {

    private final IMetroToOfficeService metroToOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "metroToOffice")
    public String metroToOfficeIndex() {
        return FebsUtil.view("metroToOffice/metroToOffice");
    }

    @GetMapping("metroToOffice")
    @ResponseBody
    @RequiresPermissions("metroToOffice:list")
    public FebsResponse getAllMetroToOffices(MetroToOffice metroToOffice) {
        return new FebsResponse().success().data(metroToOfficeService.findMetroToOffices(metroToOffice));
    }

    @GetMapping("metroToOffice/list")
    @ResponseBody
    @RequiresPermissions("metroToOffice:list")
    public FebsResponse metroToOfficeList(QueryRequest request, MetroToOffice metroToOffice) {
        Map<String, Object> dataTable = getDataTable(this.metroToOfficeService.findMetroToOffices(request,
                metroToOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增MetroToOffice", exceptionMessage = "新增MetroToOffice失败")
    @PostMapping("metroToOffice")
    @ResponseBody
    @RequiresPermissions("metroToOffice:add")
    public FebsResponse addMetroToOffice(@Valid MetroToOffice metroToOffice) {
        this.metroToOfficeService.createMetroToOffice(metroToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除MetroToOffice", exceptionMessage = "删除MetroToOffice失败")
    @GetMapping("metroToOffice/delete")
    @ResponseBody
    @RequiresPermissions("metroToOffice:delete")
    public FebsResponse deleteMetroToOffice(MetroToOffice metroToOffice) {
        this.metroToOfficeService.deleteMetroToOffice(metroToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改MetroToOffice", exceptionMessage = "修改MetroToOffice失败")
    @PostMapping("metroToOffice/update")
    @ResponseBody
    @RequiresPermissions("metroToOffice:update")
    public FebsResponse updateMetroToOffice(MetroToOffice metroToOffice) {
        this.metroToOfficeService.updateMetroToOffice(metroToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改MetroToOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("metroToOffice/excel")
    @ResponseBody
    @RequiresPermissions("metroToOffice:export")
    public void export(QueryRequest queryRequest, MetroToOffice metroToOffice, HttpServletResponse response) {
        List<MetroToOffice> metroToOffices = this.metroToOfficeService.findMetroToOffices(queryRequest,
                metroToOffice).getRecords();
        ExcelKit.$Export(MetroToOffice.class, response).downXlsx(metroToOffices, false);
    }
}
