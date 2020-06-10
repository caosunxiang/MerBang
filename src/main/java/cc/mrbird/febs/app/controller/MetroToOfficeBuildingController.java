package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.MetroToOfficeBuilding;
import cc.mrbird.febs.app.service.IMetroToOfficeBuildingService;
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
 * @date 2020-05-06 09:18:18
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class MetroToOfficeBuildingController extends BaseController {

    private final IMetroToOfficeBuildingService metroToOfficeBuildingService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "metroToOfficeBuilding")
    public String metroToOfficeBuildingIndex(){
        return FebsUtil.view("metroToOfficeBuilding/metroToOfficeBuilding");
    }

    @GetMapping("metroToOfficeBuilding")
    @ResponseBody
    @RequiresPermissions("metroToOfficeBuilding:list")
    public FebsResponse getAllMetroToOfficeBuildings(MetroToOfficeBuilding metroToOfficeBuilding) {
        return new FebsResponse().success().data(metroToOfficeBuildingService.findMetroToOfficeBuildings(metroToOfficeBuilding));
    }

    @GetMapping("metroToOfficeBuilding/list")
    @ResponseBody
    @RequiresPermissions("metroToOfficeBuilding:list")
    public FebsResponse metroToOfficeBuildingList(QueryRequest request, MetroToOfficeBuilding metroToOfficeBuilding) {
        Map<String, Object> dataTable = getDataTable(this.metroToOfficeBuildingService.findMetroToOfficeBuildings(request, metroToOfficeBuilding));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增MetroToOfficeBuilding", exceptionMessage = "新增MetroToOfficeBuilding失败")
    @PostMapping("metroToOfficeBuilding")
    @ResponseBody
    @RequiresPermissions("metroToOfficeBuilding:add")
    public FebsResponse addMetroToOfficeBuilding(@Valid MetroToOfficeBuilding metroToOfficeBuilding) {
        this.metroToOfficeBuildingService.createMetroToOfficeBuilding(metroToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除MetroToOfficeBuilding", exceptionMessage = "删除MetroToOfficeBuilding失败")
    @GetMapping("metroToOfficeBuilding/delete")
    @ResponseBody
    @RequiresPermissions("metroToOfficeBuilding:delete")
    public FebsResponse deleteMetroToOfficeBuilding(MetroToOfficeBuilding metroToOfficeBuilding) {
        this.metroToOfficeBuildingService.deleteMetroToOfficeBuilding(metroToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改MetroToOfficeBuilding", exceptionMessage = "修改MetroToOfficeBuilding失败")
    @PostMapping("metroToOfficeBuilding/update")
    @ResponseBody
    @RequiresPermissions("metroToOfficeBuilding:update")
    public FebsResponse updateMetroToOfficeBuilding(MetroToOfficeBuilding metroToOfficeBuilding) {
        this.metroToOfficeBuildingService.updateMetroToOfficeBuilding(metroToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改MetroToOfficeBuilding", exceptionMessage = "导出Excel失败")
    @PostMapping("metroToOfficeBuilding/excel")
    @ResponseBody
    @RequiresPermissions("metroToOfficeBuilding:export")
    public void export(QueryRequest queryRequest, MetroToOfficeBuilding metroToOfficeBuilding, HttpServletResponse response) {
        List<MetroToOfficeBuilding> metroToOfficeBuildings = this.metroToOfficeBuildingService.findMetroToOfficeBuildings(queryRequest, metroToOfficeBuilding).getRecords();
        ExcelKit.$Export(MetroToOfficeBuilding.class, response).downXlsx(metroToOfficeBuildings, false);
    }
}
