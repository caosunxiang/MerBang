package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.SharedOffice;
import cc.mrbird.febs.app.service.ISharedOfficeService;
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
 * @date 2020-05-06 09:17:09
 */
@Slf4j
@Validated
@Controller
@CrossOrigin
@RequestMapping("app")
@RequiredArgsConstructor
public class SharedOfficeController extends BaseController {

    private final ISharedOfficeService sharedOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "sharedOffice")
    public String sharedOfficeIndex() {
        return FebsUtil.view("sharedOffice/sharedOffice");
    }

    @GetMapping("sharedOffice")
    @ResponseBody
    @RequiresPermissions("sharedOffice:list")
    public FebsResponse getAllSharedOffices(SharedOffice sharedOffice) {
        return new FebsResponse().success().data(sharedOfficeService.findSharedOffices(sharedOffice));
    }

    @GetMapping("sharedOffice/list")
    @ResponseBody
    @RequiresPermissions("sharedOffice:list")
    public FebsResponse sharedOfficeList(QueryRequest request, SharedOffice sharedOffice) {
        Map<String, Object> dataTable = getDataTable(this.sharedOfficeService.findSharedOffices(request, sharedOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增SharedOffice", exceptionMessage = "新增SharedOffice失败")
    @PostMapping("sharedOffice")
    @ResponseBody
    @RequiresPermissions("sharedOffice:add")
    public FebsResponse addSharedOffice(@Valid SharedOffice sharedOffice) {
        this.sharedOfficeService.createSharedOffice(sharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除SharedOffice", exceptionMessage = "删除SharedOffice失败")
    @GetMapping("sharedOffice/delete")
    @ResponseBody
    @RequiresPermissions("sharedOffice:delete")
    public FebsResponse deleteSharedOffice(SharedOffice sharedOffice) {
        this.sharedOfficeService.deleteSharedOffice(sharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改SharedOffice", exceptionMessage = "修改SharedOffice失败")
    @PostMapping("sharedOffice/update")
    @ResponseBody
    @RequiresPermissions("sharedOffice:update")
    public FebsResponse updateSharedOffice(SharedOffice sharedOffice) {
        this.sharedOfficeService.updateSharedOffice(sharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改SharedOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("sharedOffice/excel")
    @ResponseBody
    @RequiresPermissions("sharedOffice:export")
    public void export(QueryRequest queryRequest, SharedOffice sharedOffice, HttpServletResponse response) {
        List<SharedOffice> sharedOffices =
                this.sharedOfficeService.findSharedOffices(queryRequest, sharedOffice).getRecords();
        ExcelKit.$Export(SharedOffice.class, response).downXlsx(sharedOffices, false);
    }

//    @ControllerEndpoint(operation = "高级查找共享办公", exceptionMessage = "高级查找共享办公失败")
    @GetMapping("selectSharedOffice")
    @ResponseBody
    public Body selectSharedOffice(String condition,Integer id, Integer areaLow, Integer areaHigh, Integer priceLow,
                                   Integer priceHigh, String type, String name, String position, String userId
            , String myId, String address,String order, Integer index, Integer size) {
        return this.sharedOfficeService.selectSharedOffice(condition, id, areaLow, areaHigh, priceLow, priceHigh, type,
                name, position, userId, myId, address,order, index, size);
    }

    @ControllerEndpoint(operation = "上传共享办公首页图片", exceptionMessage = "上传共享办公首页图片失败")
    @PostMapping("uploadSharedOfficeHomePage")
    @ResponseBody
    public Body uploadSharedOfficeHomePage(Integer SharedOfficeId,String picture,Integer userId) {
        return this.sharedOfficeService.uploadOfficeHomePage(SharedOfficeId,picture,userId);
    }

    @ControllerEndpoint(operation = "添加共享办公", exceptionMessage = "添加共享办公失败")
    @PostMapping("insertSharedOffice")
    @ResponseBody
    public Body insertSharedOffice(SharedOffice sharedOffice) {
        return this.sharedOfficeService.insertSharedOffice(sharedOffice);
    }

    @ControllerEndpoint(operation = "修改共享办公", exceptionMessage = "修改共享办公失败")
    @PostMapping("updateSharedOfficeDetails")
    @ResponseBody
    public Body updateSharedOfficeDetails(SharedOffice sharedOffice,Integer userid) {
        return this.sharedOfficeService.updateSharedOfficeDetails(sharedOffice,userid);
    }

    @ControllerEndpoint(operation = "查询指定共享办公消息", exceptionMessage = "查询指定共享办公消息失败")
    @GetMapping("selectSharedOfficeById")
    @ResponseBody
    public Body selectSharedOfficeById(Integer id) {
        return this.sharedOfficeService.selectSharedOfficeById(id);
    }
}
