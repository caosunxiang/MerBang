package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.HistoryToSharedOffice;
import cc.mrbird.febs.app.service.IHistoryToSharedOfficeService;
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
 *  Controller
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:05
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class HistoryToSharedOfficeController extends BaseController {

    private final IHistoryToSharedOfficeService historyToSharedOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "historyToSharedOffice")
    public String historyToSharedOfficeIndex(){
        return FebsUtil.view("historyToSharedOffice/historyToSharedOffice");
    }

    @GetMapping("historyToSharedOffice")
    @ResponseBody
    @RequiresPermissions("historyToSharedOffice:list")
    public FebsResponse getAllHistoryToSharedOffices(HistoryToSharedOffice historyToSharedOffice) {
        return new FebsResponse().success().data(historyToSharedOfficeService.findHistoryToSharedOffices(historyToSharedOffice));
    }

    @GetMapping("historyToSharedOffice/list")
    @ResponseBody
    @RequiresPermissions("historyToSharedOffice:list")
    public FebsResponse historyToSharedOfficeList(QueryRequest request, HistoryToSharedOffice historyToSharedOffice) {
        Map<String, Object> dataTable = getDataTable(this.historyToSharedOfficeService.findHistoryToSharedOffices(request, historyToSharedOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增HistoryToSharedOffice", exceptionMessage = "新增HistoryToSharedOffice失败")
    @PostMapping("historyToSharedOffice")
    @ResponseBody
    @RequiresPermissions("historyToSharedOffice:add")
    public FebsResponse addHistoryToSharedOffice(@Valid HistoryToSharedOffice historyToSharedOffice) {
        this.historyToSharedOfficeService.createHistoryToSharedOffice(historyToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除HistoryToSharedOffice", exceptionMessage = "删除HistoryToSharedOffice失败")
    @GetMapping("historyToSharedOffice/delete")
    @ResponseBody
    @RequiresPermissions("historyToSharedOffice:delete")
    public FebsResponse deleteHistoryToSharedOffice(HistoryToSharedOffice historyToSharedOffice) {
        this.historyToSharedOfficeService.deleteHistoryToSharedOffice(historyToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改HistoryToSharedOffice", exceptionMessage = "修改HistoryToSharedOffice失败")
    @PostMapping("historyToSharedOffice/update")
    @ResponseBody
    @RequiresPermissions("historyToSharedOffice:update")
    public FebsResponse updateHistoryToSharedOffice(HistoryToSharedOffice historyToSharedOffice) {
        this.historyToSharedOfficeService.updateHistoryToSharedOffice(historyToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改HistoryToSharedOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("historyToSharedOffice/excel")
    @ResponseBody
    @RequiresPermissions("historyToSharedOffice:export")
    public void export(QueryRequest queryRequest, HistoryToSharedOffice historyToSharedOffice, HttpServletResponse response) {
        List<HistoryToSharedOffice> historyToSharedOffices = this.historyToSharedOfficeService.findHistoryToSharedOffices(queryRequest, historyToSharedOffice).getRecords();
        ExcelKit.$Export(HistoryToSharedOffice.class, response).downXlsx(historyToSharedOffices, false);
    }
}
