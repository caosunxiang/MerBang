package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.HistoryToOffice;
import cc.mrbird.febs.app.service.IHistoryToOfficeService;
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
 * @date 2020-05-06 09:18:02
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class HistoryToOfficeController extends BaseController {

    private final IHistoryToOfficeService historyToOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "historyToOffice")
    public String historyToOfficeIndex() {
        return FebsUtil.view("historyToOffice/historyToOffice");
    }

    @GetMapping("historyToOffice")
    @ResponseBody
    @RequiresPermissions("historyToOffice:list")
    public FebsResponse getAllHistoryToOffices(HistoryToOffice historyToOffice) {
        return new FebsResponse().success().data(historyToOfficeService.findHistoryToOffices(historyToOffice));
    }

    @GetMapping("historyToOffice/list")
    @ResponseBody
    @RequiresPermissions("historyToOffice:list")
    public FebsResponse historyToOfficeList(QueryRequest request, HistoryToOffice historyToOffice) {
        Map<String, Object> dataTable = getDataTable(this.historyToOfficeService.findHistoryToOffices(request,
                historyToOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增HistoryToOffice", exceptionMessage = "新增HistoryToOffice失败")
    @PostMapping("historyToOffice")
    @ResponseBody
    @RequiresPermissions("historyToOffice:add")
    public FebsResponse addHistoryToOffice(@Valid HistoryToOffice historyToOffice) {
        this.historyToOfficeService.createHistoryToOffice(historyToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除HistoryToOffice", exceptionMessage = "删除HistoryToOffice失败")
    @GetMapping("historyToOffice/delete")
    @ResponseBody
    @RequiresPermissions("historyToOffice:delete")
    public FebsResponse deleteHistoryToOffice(HistoryToOffice historyToOffice) {
        this.historyToOfficeService.deleteHistoryToOffice(historyToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改HistoryToOffice", exceptionMessage = "修改HistoryToOffice失败")
    @PostMapping("historyToOffice/update")
    @ResponseBody
    @RequiresPermissions("historyToOffice:update")
    public FebsResponse updateHistoryToOffice(HistoryToOffice historyToOffice) {
        this.historyToOfficeService.updateHistoryToOffice(historyToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改HistoryToOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("historyToOffice/excel")
    @ResponseBody
    @RequiresPermissions("historyToOffice:export")
    public void export(QueryRequest queryRequest, HistoryToOffice historyToOffice, HttpServletResponse response) {
        List<HistoryToOffice> historyToOffices = this.historyToOfficeService.findHistoryToOffices(queryRequest,
                historyToOffice).getRecords();
        ExcelKit.$Export(HistoryToOffice.class, response).downXlsx(historyToOffices, false);
    }
}
