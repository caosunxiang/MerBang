package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Floor;
import cc.mrbird.febs.app.service.IFloorService;
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
 * @date 2020-05-08 13:40:43
 */
@Slf4j
@Validated
@Controller
@CrossOrigin
@RequestMapping("app")
@RequiredArgsConstructor
public class FloorController extends BaseController {

    private final IFloorService floorService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "floor")
    public String floorIndex() {
        return FebsUtil.view("floor/floor");
    }

    @GetMapping("floor")
    @ResponseBody
    @RequiresPermissions("floor:list")
    public FebsResponse getAllFloors(Floor floor) {
        return new FebsResponse().success().data(floorService.findFloors(floor));
    }

    @GetMapping("floor/list")
    @ResponseBody
    @RequiresPermissions("floor:list")
    public FebsResponse floorList(QueryRequest request, Floor floor) {
        Map<String, Object> dataTable = getDataTable(this.floorService.findFloors(request, floor));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Floor", exceptionMessage = "新增Floor失败")
    @PostMapping("floor")
    @ResponseBody
    @RequiresPermissions("floor:add")
    public FebsResponse addFloor(@Valid Floor floor) {
        this.floorService.createFloor(floor);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Floor", exceptionMessage = "删除Floor失败")
    @GetMapping("floor/delete")
    @ResponseBody
    @RequiresPermissions("floor:delete")
    public FebsResponse deleteFloor(Floor floor) {
        this.floorService.deleteFloor(floor);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Floor", exceptionMessage = "修改Floor失败")
    @PostMapping("floor/update")
    @ResponseBody
    @RequiresPermissions("floor:update")
    public FebsResponse updateFloor(Floor floor) {
        this.floorService.updateFloor(floor);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Floor", exceptionMessage = "导出Excel失败")
    @PostMapping("floor/excel")
    @ResponseBody
    @RequiresPermissions("floor:export")
    public void export(QueryRequest queryRequest, Floor floor, HttpServletResponse response) {
        List<Floor> floors = this.floorService.findFloors(queryRequest, floor).getRecords();
        ExcelKit.$Export(Floor.class, response).downXlsx(floors, false);
    }

    @ControllerEndpoint(operation = "查询写字楼下的楼层", exceptionMessage = "查询写字楼下的楼层失败")
    @GetMapping("selectFloorById")
    @ResponseBody
    public Body selectFloorById(Integer buildingId) {
        return this.floorService.selectFloorById(buildingId);
    }


    @ControllerEndpoint(operation = "添加写字楼下的楼层", exceptionMessage = "添加写字楼下的楼层失败")
    @PostMapping("insertFloor")
    @ResponseBody
    public Body insertFloor(@Valid Floor floor) {
        return this.floorService.insertFloor(floor);
    }

    @ControllerEndpoint(operation = "查询楼层", exceptionMessage = "查询楼层失败")
    @GetMapping("selectFloorToId")
    @ResponseBody
    public Body selectFloorToId(Integer pid, String state) {
        return this.floorService.selectFloorToId(pid, state);
    }
}
