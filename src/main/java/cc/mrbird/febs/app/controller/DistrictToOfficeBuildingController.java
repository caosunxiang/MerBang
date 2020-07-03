package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.DistrictToOfficeBuilding;
import cc.mrbird.febs.app.service.IDistrictToOfficeBuildingService;
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
 * @date 2020-05-06 09:17:36
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class DistrictToOfficeBuildingController extends BaseController {

    private final IDistrictToOfficeBuildingService districtToOfficeBuildingService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "districtToOfficeBuilding")
    public String districtToOfficeBuildingIndex() {
        return FebsUtil.view("districtToOfficeBuilding/districtToOfficeBuilding");
    }

    @GetMapping("districtToOfficeBuilding")
    @ResponseBody
    @RequiresPermissions("districtToOfficeBuilding:list")
    public FebsResponse getAllDistrictToOfficeBuildings(DistrictToOfficeBuilding districtToOfficeBuilding) {
        return new FebsResponse().success().data(districtToOfficeBuildingService.findDistrictToOfficeBuildings(districtToOfficeBuilding));
    }

    @GetMapping("districtToOfficeBuilding/list")
    @ResponseBody
    @RequiresPermissions("districtToOfficeBuilding:list")
    public FebsResponse districtToOfficeBuildingList(QueryRequest request,
                                                     DistrictToOfficeBuilding districtToOfficeBuilding) {
        Map<String, Object> dataTable =
                getDataTable(this.districtToOfficeBuildingService.findDistrictToOfficeBuildings(request,
                        districtToOfficeBuilding));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增DistrictToOfficeBuilding", exceptionMessage = "新增DistrictToOfficeBuilding失败")
    @PostMapping("districtToOfficeBuilding")
    @ResponseBody
    @RequiresPermissions("districtToOfficeBuilding:add")
    public FebsResponse addDistrictToOfficeBuilding(@Valid DistrictToOfficeBuilding districtToOfficeBuilding) {
        this.districtToOfficeBuildingService.createDistrictToOfficeBuilding(districtToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除DistrictToOfficeBuilding", exceptionMessage = "删除DistrictToOfficeBuilding失败")
    @GetMapping("districtToOfficeBuilding/delete")
    @ResponseBody
    @RequiresPermissions("districtToOfficeBuilding:delete")
    public FebsResponse deleteDistrictToOfficeBuilding(DistrictToOfficeBuilding districtToOfficeBuilding) {
        this.districtToOfficeBuildingService.deleteDistrictToOfficeBuilding(districtToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改DistrictToOfficeBuilding", exceptionMessage = "修改DistrictToOfficeBuilding失败")
    @PostMapping("districtToOfficeBuilding/update")
    @ResponseBody
    @RequiresPermissions("districtToOfficeBuilding:update")
    public FebsResponse updateDistrictToOfficeBuilding(DistrictToOfficeBuilding districtToOfficeBuilding) {
        this.districtToOfficeBuildingService.updateDistrictToOfficeBuilding(districtToOfficeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改DistrictToOfficeBuilding", exceptionMessage = "导出Excel失败")
    @PostMapping("districtToOfficeBuilding/excel")
    @ResponseBody
    @RequiresPermissions("districtToOfficeBuilding:export")
    public void export(QueryRequest queryRequest, DistrictToOfficeBuilding districtToOfficeBuilding,
                       HttpServletResponse response) {
        List<DistrictToOfficeBuilding> districtToOfficeBuildings =
                this.districtToOfficeBuildingService.findDistrictToOfficeBuildings(queryRequest,
                        districtToOfficeBuilding).getRecords();
        ExcelKit.$Export(DistrictToOfficeBuilding.class, response).downXlsx(districtToOfficeBuildings, false);
    }
}
