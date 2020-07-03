package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.HistoryToOfficeBuilding;
import cc.mrbird.febs.app.service.IHistoryToOfficeBuildingService;
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
 * @date 2020-05-06 09:18:07
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class HistoryToOfficeBuildingController extends BaseController {

    private final IHistoryToOfficeBuildingService historyToOfficeBuildingService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "historyToOfficeBuilding")
    public String historyToOfficeBuildingIndex() {
        return FebsUtil.view("historyToOfficeBuilding/historyToOfficeBuilding");
    }

    @GetMapping("historyToOfficeBuilding")
    @ResponseBody
    @RequiresPermissions("historyToOfficeBuilding:list")
    public FebsResponse getAllHistoryToOfficeBuildings(HistoryToOfficeBuilding historyToOfficeBuilding) {
        return new FebsResponse().success().data(historyToOfficeBuildingService.findHistoryToOfficeBuildings(historyToOfficeBuilding));
    }

    @GetMapping("historyToOfficeBuilding/list")
    @ResponseBody
    @RequiresPermissions("historyToOfficeBuilding:list")
    public FebsResponse historyToOfficeBuildingList(QueryRequest request,
                                                    HistoryToOfficeBuilding historyToOfficeBuilding) {
        Map<String, Object> dataTable =
                getDataTable(this.historyToOfficeBuildingService.findHistoryToOfficeBuildings(request,
                        historyToOfficeBuilding));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增HistoryToOfficeBuilding", exceptionMessage = "新增HistoryToOfficeBuilding失败")
    @PostMapping("historyToOfficeBuilding")
    @ResponseBody
    @RequiresPermissions("historyToOfficeBuilding:add")
    public FebsResponse addHistoryToOfficeBuilding(@Valid HistoryToOfficeBuilding historyToOfficeBuilding) {
        this.historyToOfficeBuildingService.createHistoryToOfficeBuilding(historyToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除HistoryToOfficeBuilding", exceptionMessage = "删除HistoryToOfficeBuilding失败")
    @GetMapping("historyToOfficeBuilding/delete")
    @ResponseBody
    @RequiresPermissions("historyToOfficeBuilding:delete")
    public FebsResponse deleteHistoryToOfficeBuilding(HistoryToOfficeBuilding historyToOfficeBuilding) {
        this.historyToOfficeBuildingService.deleteHistoryToOfficeBuilding(historyToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改HistoryToOfficeBuilding", exceptionMessage = "修改HistoryToOfficeBuilding失败")
    @PostMapping("historyToOfficeBuilding/update")
    @ResponseBody
    @RequiresPermissions("historyToOfficeBuilding:update")
    public FebsResponse updateHistoryToOfficeBuilding(HistoryToOfficeBuilding historyToOfficeBuilding) {
        this.historyToOfficeBuildingService.updateHistoryToOfficeBuilding(historyToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改HistoryToOfficeBuilding", exceptionMessage = "导出Excel失败")
    @PostMapping("historyToOfficeBuilding/excel")
    @ResponseBody
    @RequiresPermissions("historyToOfficeBuilding:export")
    public void export(QueryRequest queryRequest, HistoryToOfficeBuilding historyToOfficeBuilding,
                       HttpServletResponse response) {
        List<HistoryToOfficeBuilding> historyToOfficeBuildings =
                this.historyToOfficeBuildingService.findHistoryToOfficeBuildings(queryRequest,
                        historyToOfficeBuilding).getRecords();
        ExcelKit.$Export(HistoryToOfficeBuilding.class, response).downXlsx(historyToOfficeBuildings, false);
    }
}
