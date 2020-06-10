package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.OfficeBuilding;
import cc.mrbird.febs.app.service.IOfficeBuildingService;
import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.utils.json.Body;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author 冷酷的苹果
 * @date 2020-04-30 17:22:24
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("app")
public class OfficeBuildingController extends BaseController {

    private final IOfficeBuildingService officeBuildingService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "officeBuilding")
    public String officeBuildingIndex() {
        return FebsUtil.view("officeBuilding/officeBuilding");
    }

    @GetMapping("officeBuilding")
    @ResponseBody
    @RequiresPermissions("officeBuilding:list")
    public FebsResponse getAllOfficeBuildings(OfficeBuilding officeBuilding) {
        return new FebsResponse().success().data(officeBuildingService.findOfficeBuildings(officeBuilding));
    }

    @GetMapping("officeBuilding/list")
    @ResponseBody
    @RequiresPermissions("officeBuilding:list")
    public FebsResponse officeBuildingList(QueryRequest request, OfficeBuilding officeBuilding) {
        Map<String, Object> dataTable = getDataTable(this.officeBuildingService.findOfficeBuildings(request,
                officeBuilding));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增OfficeBuilding", exceptionMessage = "新增OfficeBuilding失败")
    @PostMapping("officeBuilding")
    @ResponseBody
    @RequiresPermissions("officeBuilding:add")
    public FebsResponse addOfficeBuilding(@Valid OfficeBuilding officeBuilding) {
        this.officeBuildingService.createOfficeBuilding(officeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OfficeBuilding", exceptionMessage = "删除OfficeBuilding失败")
    @GetMapping("officeBuilding/delete")
    @ResponseBody
    @RequiresPermissions("officeBuilding:delete")
    public FebsResponse deleteOfficeBuilding(OfficeBuilding officeBuilding) {
        this.officeBuildingService.deleteOfficeBuilding(officeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeBuilding", exceptionMessage = "修改OfficeBuilding失败")
    @PostMapping("officeBuilding/update")
    @ResponseBody
    @RequiresPermissions("officeBuilding:update")
    public FebsResponse updateOfficeBuilding(OfficeBuilding officeBuilding) {
        this.officeBuildingService.updateOfficeBuilding(officeBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeBuilding", exceptionMessage = "导出Excel失败")
    @PostMapping("officeBuilding/excel")
    @ResponseBody
    @RequiresPermissions("officeBuilding:export")
    public void export(QueryRequest queryRequest, OfficeBuilding officeBuilding, HttpServletResponse response) {
        List<OfficeBuilding> officeBuildings = this.officeBuildingService.findOfficeBuildings(queryRequest,
                officeBuilding).getRecords();
        ExcelKit.$Export(OfficeBuilding.class, response).downXlsx(officeBuildings, false);
    }


    @ControllerEndpoint(operation = "查询所有的写字楼消息", exceptionMessage = "查询所有的写字楼消息失败")
    @GetMapping("selectOfficeBuilding")
    @ResponseBody
    public Body selectOfficeBuilding(String condition, Integer areaLow, Integer areaHigh, String priceLow,
                                     String priceHigh, String fitment, String name, String position,
                                     String userId, String myId, String address,String order, Integer index, Integer size) {
        return this.officeBuildingService.selectOfficeBuilding(condition, areaLow, areaHigh,
                priceLow, priceHigh, fitment, name, position, userId, myId, address,order, index, size);
    }

    @ControllerEndpoint(operation = "查询指定写字楼消息", exceptionMessage = "查询指定写字楼消息失败")
    @GetMapping("selectOfficeBuildingById")
    @ResponseBody
    public Body selectOfficeBuildingById(Integer id) {
        return this.officeBuildingService.selectOfficeBuildingById(id);
    }

    @ControllerEndpoint(operation = "添加写字楼基本信息", exceptionMessage = "添加写字楼基本信息消息失败")
    @PostMapping("insertOfficeBuilding")
    @ResponseBody
    public Body insertOfficeBuilding(String name, String address, String log, String lat, String area,
                                     String price, Integer user) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(address) || StringUtils.isEmpty(log) ||
                StringUtils.isEmpty(lat) || StringUtils.isEmpty(area) || StringUtils.isEmpty(price)||user==null) {
            return Body.BODY_451;
        }
        return this.officeBuildingService.insertOfficeBuilding(name, address, log, lat, area, price, user);
    }

    @ControllerEndpoint(operation = "上传图片", exceptionMessage = "上传图片失败")
    @PostMapping("upload")
    @ResponseBody
    public Body uploadOfficeBuilding(MultipartFile file) {
        return this.officeBuildingService.uploadOfficeBuilding(file);
    }

    @ControllerEndpoint(operation = "上传写字楼首页图片", exceptionMessage = "上传写字楼首页图片失败")
    @PostMapping("uploadOfficeBuildingHomePage")
    @ResponseBody
    public Body uploadOfficeHomePage(Integer officeBuildingId,String picture,Integer userId) {
        return this.officeBuildingService.uploadOfficeHomePage(officeBuildingId,picture,userId);
    }

    @ControllerEndpoint(operation = "修改写字楼详情", exceptionMessage = "修改写字楼详情失败")
    @PostMapping("updateOfficeBuildingDetails")
    @ResponseBody
    public Body updateOfficeBuildingDetails(OfficeBuilding officeBuilding) {
return this.officeBuildingService.updateOfficeBuildingDetails(officeBuilding);
    }
}
