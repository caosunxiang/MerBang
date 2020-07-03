package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.BusinessDistrict;
import cc.mrbird.febs.app.service.IBusinessDistrictService;
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
 * @date 2020-05-06 11:24:48
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class BusinessDistrictController extends BaseController {

    private final IBusinessDistrictService businessDistrictService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "businessDistrict")
    public String businessDistrictIndex() {
        return FebsUtil.view("businessDistrict/businessDistrict");
    }

    @GetMapping("businessDistrict")
    @ResponseBody
    @RequiresPermissions("businessDistrict:list")
    public FebsResponse getAllBusinessDistricts(BusinessDistrict businessDistrict) {
        return new FebsResponse().success().data(businessDistrictService.findBusinessDistricts(businessDistrict));
    }

    @GetMapping("businessDistrict/list")
    @ResponseBody
    @RequiresPermissions("businessDistrict:list")
    public FebsResponse businessDistrictList(QueryRequest request, BusinessDistrict businessDistrict) {
        Map<String, Object> dataTable = getDataTable(this.businessDistrictService.findBusinessDistricts(request,
                businessDistrict));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增BusinessDistrict", exceptionMessage = "新增BusinessDistrict失败")
    @PostMapping("businessDistrict")
    @ResponseBody
    @RequiresPermissions("businessDistrict:add")
    public FebsResponse addBusinessDistrict(@Valid BusinessDistrict businessDistrict) {
        this.businessDistrictService.createBusinessDistrict(businessDistrict);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除BusinessDistrict", exceptionMessage = "删除BusinessDistrict失败")
    @GetMapping("businessDistrict/delete")
    @ResponseBody
    @RequiresPermissions("businessDistrict:delete")
    public FebsResponse deleteBusinessDistrict(BusinessDistrict businessDistrict) {
        this.businessDistrictService.deleteBusinessDistrict(businessDistrict);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改BusinessDistrict", exceptionMessage = "修改BusinessDistrict失败")
    @PostMapping("businessDistrict/update")
    @ResponseBody
    @RequiresPermissions("businessDistrict:update")
    public FebsResponse updateBusinessDistrict(BusinessDistrict businessDistrict) {
        this.businessDistrictService.updateBusinessDistrict(businessDistrict);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改BusinessDistrict", exceptionMessage = "导出Excel失败")
    @PostMapping("businessDistrict/excel")
    @ResponseBody
    @RequiresPermissions("businessDistrict:export")
    public void export(QueryRequest queryRequest, BusinessDistrict businessDistrict, HttpServletResponse response) {
        List<BusinessDistrict> businessDistricts = this.businessDistrictService.findBusinessDistricts(queryRequest,
                businessDistrict).getRecords();
        ExcelKit.$Export(BusinessDistrict.class, response).downXlsx(businessDistricts, false);
    }

    @ControllerEndpoint(operation = "查询商圈信息", exceptionMessage = "查询商圈信息失败")
    @GetMapping("selectBusinessDistrict")
    @ResponseBody
    public Body selectBusinessDistrict(String city) {
        return this.businessDistrictService.selectBusinessDistrict(city);
    }

    @ControllerEndpoint(operation = "添加商圈信息", exceptionMessage = "添加商圈信息失败")
    @PostMapping("insertBusinessDistrict")
    @ResponseBody
    public Body insertBusinessDistrict(BusinessDistrict businessDistrict) {
        return this.businessDistrictService.insertBusinessDistrict(businessDistrict);
    }
}
