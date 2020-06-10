package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.Office;
import cc.mrbird.febs.app.service.IOfficeService;
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
 * Controller
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:16:31
 */
@Slf4j
@Validated
@Controller
@CrossOrigin
@RequestMapping("app")
@RequiredArgsConstructor
public class OfficeController extends BaseController {

    private final IOfficeService officeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "office")
    public String officeIndex() {
        return FebsUtil.view("office/office");
    }

    @GetMapping("office")
    @ResponseBody
    @RequiresPermissions("office:list")
    public FebsResponse getAllOffices(Office office) {
        return new FebsResponse().success().data(officeService.findOffices(office));
    }

    @GetMapping("office/list")
    @ResponseBody
    @RequiresPermissions("office:list")
    public FebsResponse officeList(QueryRequest request, Office office) {
        Map<String, Object> dataTable = getDataTable(this.officeService.findOffices(request, office));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Office", exceptionMessage = "新增Office失败")
    @PostMapping("office")
    @ResponseBody
    @RequiresPermissions("office:add")
    public FebsResponse addOffice(@Valid Office office) {
        this.officeService.createOffice(office);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Office", exceptionMessage = "删除Office失败")
    @GetMapping("office/delete")
    @ResponseBody
    @RequiresPermissions("office:delete")
    public FebsResponse deleteOffice(Office office) {
        this.officeService.deleteOffice(office);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Office", exceptionMessage = "修改Office失败")
    @PostMapping("office/update")
    @ResponseBody
    @RequiresPermissions("office:update")
    public FebsResponse updateOffice(Office office) {
        this.officeService.updateOffice(office);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Office", exceptionMessage = "导出Excel失败")
    @PostMapping("office/excel")
    @ResponseBody
    @RequiresPermissions("office:export")
    public void export(QueryRequest queryRequest, Office office, HttpServletResponse response) {
        List<Office> offices = this.officeService.findOffices(queryRequest, office).getRecords();
        ExcelKit.$Export(Office.class, response).downXlsx(offices, false);
    }

    @ControllerEndpoint(operation = "高级搜索办公室", exceptionMessage = "高级搜索办公室失败")
    @GetMapping("selectOffice")
    @ResponseBody
    public Body selectOffice(String condition, Integer areaLow, Integer areaHigh, String priceLow,Integer id,
                             String priceHigh, String fitment, String name, String position, String address,
                             String userId, String myId, String order, Integer index, Integer size) {
        return this.officeService.selectOffice(condition, areaLow, areaHigh,
                priceLow, id,priceHigh, fitment, name, position, address, userId, myId, order, index, size);
    }

    @ControllerEndpoint(operation = "上传办公室首页图片", exceptionMessage = "上传办公室首页图片失败")
    @PostMapping("uploadOfficeHomePage")
    @ResponseBody
    public Body uploadOfficeHomePage(Integer officeId, String picture, Integer userId) {
        return this.officeService.uploadOfficeHomePage(officeId, picture, userId);
    }

    @ControllerEndpoint(operation = "添加办公室", exceptionMessage = "添加办公室失败")
    @PostMapping("insertOffice")
    @ResponseBody
    public Body insertOffice(String data, Integer id) {
        return this.officeService.insertOffice(data, id);
    }

    @ControllerEndpoint(operation = "添加办公室上级查找", exceptionMessage = "添加办公室上级查找失败")
    @GetMapping("selectPidType")
    @ResponseBody
    public Body selectPidType(Integer id) {
        return this.officeService.selectPidType(id);
    }

    @ControllerEndpoint(operation = "查询办公室详情", exceptionMessage = "查询办公室详情失败")
    @GetMapping("selectOfficeDetails")
    @ResponseBody
    public Body selectOfficeDetails(Integer id) {
        return this.officeService.selectOfficeDetails(id);
    }

    @ControllerEndpoint(operation = "查询办公室", exceptionMessage = "查询办公室失败")
    @GetMapping("selectOfficeByOfficeId")
    @ResponseBody
    public Body selectOfficeById(Integer id) {
        return this.officeService.selectOfficeById(id);
    }

    @ControllerEndpoint(operation = "修改办公室信息/个人详情", exceptionMessage = "修改办公室信息/个人详情失败")
    @PostMapping("updateOfficeDetails")
    @ResponseBody
    public Body updateOfficeDetails(Office office, Integer userid) {
        return this.officeService.updateOfficeDetails(office, userid);
    }

    @ControllerEndpoint(operation = "租金页面查询办公室", exceptionMessage = "租金页面查询办公室失败")
    @GetMapping("selectOfficeInPrice")
    @ResponseBody
    public Body selectOfficeInPrice(Integer pid, String door, Integer id) {
        return this.officeService.selectOfficeInPrice(pid, door, id);
    }

    @ControllerEndpoint(operation = "物业页面查询办公室", exceptionMessage = "物业页面查询办公室失败")
    @GetMapping("selectOfficeInCost")
    @ResponseBody
    public Body selectOfficeInCost(Integer id, Integer uid,String type) {
        return this.officeService.selectOfficeInCost(id, uid,type);
    }

    @ControllerEndpoint(operation = "删除办公室", exceptionMessage = "物业页面查询办公室失败")
    @PostMapping("deleteOffice")
    @ResponseBody
    public Body deleteOffice(Integer officeId) {
        return this.officeService.deleteOffice(officeId);
    }
}
