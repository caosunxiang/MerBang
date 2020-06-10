package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.FloorToOffice;
import cc.mrbird.febs.app.service.IFloorToOfficeService;
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
 * Controller
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 13:40:47
 */
@Slf4j
@Validated
@Controller
@CrossOrigin
@RequestMapping("app")
@RequiredArgsConstructor
public class FloorToOfficeController extends BaseController {

    private final IFloorToOfficeService floorToOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "floorToOffice")
    public String floorToOfficeIndex() {
        return FebsUtil.view("floorToOffice/floorToOffice");
    }

    @GetMapping("floorToOffice")
    @ResponseBody
    @RequiresPermissions("floorToOffice:list")
    public FebsResponse getAllFloorToOffices(FloorToOffice floorToOffice) {
        return new FebsResponse().success().data(floorToOfficeService.findFloorToOffices(floorToOffice));
    }

    @GetMapping("floorToOffice/list")
    @ResponseBody
    @RequiresPermissions("floorToOffice:list")
    public FebsResponse floorToOfficeList(QueryRequest request, FloorToOffice floorToOffice) {
        Map<String, Object> dataTable = getDataTable(this.floorToOfficeService.findFloorToOffices(request,
                floorToOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增FloorToOffice", exceptionMessage = "新增FloorToOffice失败")
    @PostMapping("floorToOffice")
    @ResponseBody
    @RequiresPermissions("floorToOffice:add")
    public FebsResponse addFloorToOffice(@Valid FloorToOffice floorToOffice) {
        this.floorToOfficeService.createFloorToOffice(floorToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除FloorToOffice", exceptionMessage = "删除FloorToOffice失败")
    @GetMapping("floorToOffice/delete")
    @ResponseBody
    @RequiresPermissions("floorToOffice:delete")
    public FebsResponse deleteFloorToOffice(FloorToOffice floorToOffice) {
        this.floorToOfficeService.deleteFloorToOffice(floorToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改FloorToOffice", exceptionMessage = "修改FloorToOffice失败")
    @PostMapping("floorToOffice/update")
    @ResponseBody
    @RequiresPermissions("floorToOffice:update")
    public FebsResponse updateFloorToOffice(FloorToOffice floorToOffice) {
        this.floorToOfficeService.updateFloorToOffice(floorToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改FloorToOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("floorToOffice/excel")
    @ResponseBody
    @RequiresPermissions("floorToOffice:export")
    public void export(QueryRequest queryRequest, FloorToOffice floorToOffice, HttpServletResponse response) {
        List<FloorToOffice> floorToOffices = this.floorToOfficeService.findFloorToOffices(queryRequest,
                floorToOffice).getRecords();
        ExcelKit.$Export(FloorToOffice.class, response).downXlsx(floorToOffices, false);
    }

    //    @ControllerEndpoint(operation = "根据楼层查找办公室", exceptionMessage = "根据楼层查找办公室失败")
//    @GetMapping("selectOfficeByfloor")
//    @ResponseBody
//    public Body selectOfficeByfloor(Integer id) {
//        return this.floorToOfficeService.selectOfficeByfloor(id);
//    }
    @ControllerEndpoint(operation = "根据楼层查找办公室", exceptionMessage = "根据楼层查找办公室失败")
    @GetMapping("selectOfficeFloor")
    @ResponseBody
    public Body selectOfficeFloor(Integer pid, Integer id) {
        return this.floorToOfficeService.selectOfficeFloor(pid,id);
    }
}
