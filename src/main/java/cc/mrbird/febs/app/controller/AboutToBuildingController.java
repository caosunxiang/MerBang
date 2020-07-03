package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.AboutToBuilding;
import cc.mrbird.febs.app.service.IAboutToBuildingService;
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
 * @date 2020-05-12 13:47:16
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class AboutToBuildingController extends BaseController {

    private final IAboutToBuildingService aboutToBuildingService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "aboutToBuilding")
    public String aboutToBuildingIndex() {
        return FebsUtil.view("aboutToBuilding/aboutToBuilding");
    }

    @GetMapping("aboutToBuilding")
    @ResponseBody
    @RequiresPermissions("aboutToBuilding:list")
    public FebsResponse getAllAboutToBuildings(AboutToBuilding aboutToBuilding) {
        return new FebsResponse().success().data(aboutToBuildingService.findAboutToBuildings(aboutToBuilding));
    }

    @GetMapping("aboutToBuilding/list")
    @ResponseBody
    @RequiresPermissions("aboutToBuilding:list")
    public FebsResponse aboutToBuildingList(QueryRequest request, AboutToBuilding aboutToBuilding) {
        Map<String, Object> dataTable = getDataTable(this.aboutToBuildingService.findAboutToBuildings(request,
                aboutToBuilding));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增AboutToBuilding", exceptionMessage = "新增AboutToBuilding失败")
    @PostMapping("aboutToBuilding")
    @ResponseBody
    @RequiresPermissions("aboutToBuilding:add")
    public FebsResponse addAboutToBuilding(@Valid AboutToBuilding aboutToBuilding) {
        this.aboutToBuildingService.createAboutToBuilding(aboutToBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除AboutToBuilding", exceptionMessage = "删除AboutToBuilding失败")
    @GetMapping("aboutToBuilding/delete")
    @ResponseBody
    @RequiresPermissions("aboutToBuilding:delete")
    public FebsResponse deleteAboutToBuilding(AboutToBuilding aboutToBuilding) {
        this.aboutToBuildingService.deleteAboutToBuilding(aboutToBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改AboutToBuilding", exceptionMessage = "修改AboutToBuilding失败")
    @PostMapping("aboutToBuilding/update")
    @ResponseBody
    @RequiresPermissions("aboutToBuilding:update")
    public FebsResponse updateAboutToBuilding(AboutToBuilding aboutToBuilding) {
        this.aboutToBuildingService.updateAboutToBuilding(aboutToBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改AboutToBuilding", exceptionMessage = "导出Excel失败")
    @PostMapping("aboutToBuilding/excel")
    @ResponseBody
    @RequiresPermissions("aboutToBuilding:export")
    public void export(QueryRequest queryRequest, AboutToBuilding aboutToBuilding, HttpServletResponse response) {
        List<AboutToBuilding> aboutToBuildings = this.aboutToBuildingService.findAboutToBuildings(queryRequest,
                aboutToBuilding).getRecords();
        ExcelKit.$Export(AboutToBuilding.class, response).downXlsx(aboutToBuildings, false);
    }

    @ControllerEndpoint(operation = "添加写字楼详情", exceptionMessage = "添加写字楼详情失败")
    @PostMapping("insertAbout")
    @ResponseBody
    public Body insertAbout(AboutToBuilding aboutToBuilding, Integer userId) {
        return this.aboutToBuildingService.insertAbout(aboutToBuilding, userId);
    }

    @ControllerEndpoint(operation = "查看写字楼详情", exceptionMessage = "查看写字楼详情失败")
    @GetMapping("selectAboutToBuilding")
    @ResponseBody
    public Body selectAboutToBuilding(Integer id) {
        return this.aboutToBuildingService.selectAboutToBuilding(id);
    }

    @ControllerEndpoint(operation = "修改写字楼详情", exceptionMessage = "修改写字楼详情失败")
    @PostMapping("updateBuildingDetails")
    @ResponseBody
    public Body updateDetails(AboutToBuilding aboutToBuilding, Integer userid) {
        return this.aboutToBuildingService.updateDetails(aboutToBuilding, userid);
    }


}
