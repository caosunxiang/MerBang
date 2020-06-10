package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.LabelToOfficeBuilding;
import cc.mrbird.febs.app.service.ILabelToOfficeBuildingService;
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
 * @date 2020-05-06 09:17:39
 */
@Slf4j
@Validated
@Controller
@CrossOrigin
@RequestMapping("app")
@RequiredArgsConstructor
public class LabelToOfficeBuildingController extends BaseController {

    private final ILabelToOfficeBuildingService labelToOfficeBuildingService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "labelToOfficeBuilding")
    public String labelToOfficeBuildingIndex(){
        return FebsUtil.view("labelToOfficeBuilding/labelToOfficeBuilding");
    }

    @GetMapping("labelToOfficeBuilding")
    @ResponseBody
    @RequiresPermissions("labelToOfficeBuilding:list")
    public FebsResponse getAllLabelToOfficeBuildings(LabelToOfficeBuilding labelToOfficeBuilding) {
        return new FebsResponse().success().data(labelToOfficeBuildingService.findLabelToOfficeBuildings(labelToOfficeBuilding));
    }

    @GetMapping("labelToOfficeBuilding/list")
    @ResponseBody
    @RequiresPermissions("labelToOfficeBuilding:list")
    public FebsResponse labelToOfficeBuildingList(QueryRequest request, LabelToOfficeBuilding labelToOfficeBuilding) {
        Map<String, Object> dataTable = getDataTable(this.labelToOfficeBuildingService.findLabelToOfficeBuildings(request, labelToOfficeBuilding));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增LabelToOfficeBuilding", exceptionMessage = "新增LabelToOfficeBuilding失败")
    @PostMapping("labelToOfficeBuilding")
    @ResponseBody
    @RequiresPermissions("labelToOfficeBuilding:add")
    public FebsResponse addLabelToOfficeBuilding(@Valid LabelToOfficeBuilding labelToOfficeBuilding) {
        this.labelToOfficeBuildingService.createLabelToOfficeBuilding(labelToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除LabelToOfficeBuilding", exceptionMessage = "删除LabelToOfficeBuilding失败")
    @GetMapping("labelToOfficeBuilding/delete")
    @ResponseBody
    @RequiresPermissions("labelToOfficeBuilding:delete")
    public FebsResponse deleteLabelToOfficeBuilding(LabelToOfficeBuilding labelToOfficeBuilding) {
        this.labelToOfficeBuildingService.deleteLabelToOfficeBuilding(labelToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改LabelToOfficeBuilding", exceptionMessage = "修改LabelToOfficeBuilding失败")
    @PostMapping("labelToOfficeBuilding/update")
    @ResponseBody
    @RequiresPermissions("labelToOfficeBuilding:update")
    public FebsResponse updateLabelToOfficeBuilding(LabelToOfficeBuilding labelToOfficeBuilding) {
        this.labelToOfficeBuildingService.updateLabelToOfficeBuilding(labelToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改LabelToOfficeBuilding", exceptionMessage = "导出Excel失败")
    @PostMapping("labelToOfficeBuilding/excel")
    @ResponseBody
    @RequiresPermissions("labelToOfficeBuilding:export")
    public void export(QueryRequest queryRequest, LabelToOfficeBuilding labelToOfficeBuilding, HttpServletResponse response) {
        List<LabelToOfficeBuilding> labelToOfficeBuildings = this.labelToOfficeBuildingService.findLabelToOfficeBuildings(queryRequest, labelToOfficeBuilding).getRecords();
        ExcelKit.$Export(LabelToOfficeBuilding.class, response).downXlsx(labelToOfficeBuildings, false);
    }

    @ControllerEndpoint(operation = "关联写字楼标签", exceptionMessage = "关联写字楼标签失败")
    @PostMapping("insertLabelAndOfficeBuilding")
    @ResponseBody
    public Body insertLabelAndSharedOffice(Integer officeBuildingId, String labelId, Integer id) {
        return this.labelToOfficeBuildingService.insertLabelAndOfficeBuilding(officeBuildingId,labelId,id);
    }

    @ControllerEndpoint(operation = "查找已经选择的标签", exceptionMessage = "查找已经选择的标签失败")
    @GetMapping("selectLabelByBuildingId")
    @ResponseBody
    public Body selectLabelByBuildingId(Integer officeBuildingId) {
        return this.labelToOfficeBuildingService.selectLabelByBuildingId(officeBuildingId);
    }
}
