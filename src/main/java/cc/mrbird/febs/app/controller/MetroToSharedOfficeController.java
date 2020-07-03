package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.MetroToSharedOffice;
import cc.mrbird.febs.app.service.IMetroToSharedOfficeService;
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
 * @date 2020-05-07 16:30:14
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class MetroToSharedOfficeController extends BaseController {

    private final IMetroToSharedOfficeService metroToSharedOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "metroToSharedOffice")
    public String metroToSharedOfficeIndex() {
        return FebsUtil.view("metroToSharedOffice/metroToSharedOffice");
    }

    @GetMapping("metroToSharedOffice")
    @ResponseBody
    @RequiresPermissions("metroToSharedOffice:list")
    public FebsResponse getAllMetroToSharedOffices(MetroToSharedOffice metroToSharedOffice) {
        return new FebsResponse().success().data(metroToSharedOfficeService.findMetroToSharedOffices(metroToSharedOffice));
    }

    @GetMapping("metroToSharedOffice/list")
    @ResponseBody
    @RequiresPermissions("metroToSharedOffice:list")
    public FebsResponse metroToSharedOfficeList(QueryRequest request, MetroToSharedOffice metroToSharedOffice) {
        Map<String, Object> dataTable = getDataTable(this.metroToSharedOfficeService.findMetroToSharedOffices(request
                , metroToSharedOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增MetroToSharedOffice", exceptionMessage = "新增MetroToSharedOffice失败")
    @PostMapping("metroToSharedOffice")
    @ResponseBody
    @RequiresPermissions("metroToSharedOffice:add")
    public FebsResponse addMetroToSharedOffice(@Valid MetroToSharedOffice metroToSharedOffice) {
        this.metroToSharedOfficeService.createMetroToSharedOffice(metroToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除MetroToSharedOffice", exceptionMessage = "删除MetroToSharedOffice失败")
    @GetMapping("metroToSharedOffice/delete")
    @ResponseBody
    @RequiresPermissions("metroToSharedOffice:delete")
    public FebsResponse deleteMetroToSharedOffice(MetroToSharedOffice metroToSharedOffice) {
        this.metroToSharedOfficeService.deleteMetroToSharedOffice(metroToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改MetroToSharedOffice", exceptionMessage = "修改MetroToSharedOffice失败")
    @PostMapping("metroToSharedOffice/update")
    @ResponseBody
    @RequiresPermissions("metroToSharedOffice:update")
    public FebsResponse updateMetroToSharedOffice(MetroToSharedOffice metroToSharedOffice) {
        this.metroToSharedOfficeService.updateMetroToSharedOffice(metroToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改MetroToSharedOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("metroToSharedOffice/excel")
    @ResponseBody
    @RequiresPermissions("metroToSharedOffice:export")
    public void export(QueryRequest queryRequest, MetroToSharedOffice metroToSharedOffice,
                       HttpServletResponse response) {
        List<MetroToSharedOffice> metroToSharedOffices =
                this.metroToSharedOfficeService.findMetroToSharedOffices(queryRequest, metroToSharedOffice).getRecords();
        ExcelKit.$Export(MetroToSharedOffice.class, response).downXlsx(metroToSharedOffices, false);
    }
}
