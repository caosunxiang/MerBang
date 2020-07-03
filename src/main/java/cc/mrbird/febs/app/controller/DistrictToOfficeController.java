package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.DistrictToOffice;
import cc.mrbird.febs.app.service.IDistrictToOfficeService;
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
 * @date 2020-05-07 16:30:33
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class DistrictToOfficeController extends BaseController {

    private final IDistrictToOfficeService districtToOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "districtToOffice")
    public String districtToOfficeIndex() {
        return FebsUtil.view("districtToOffice/districtToOffice");
    }

    @GetMapping("districtToOffice")
    @ResponseBody
    @RequiresPermissions("districtToOffice:list")
    public FebsResponse getAllDistrictToOffices(DistrictToOffice districtToOffice) {
        return new FebsResponse().success().data(districtToOfficeService.findDistrictToOffices(districtToOffice));
    }

    @GetMapping("districtToOffice/list")
    @ResponseBody
    @RequiresPermissions("districtToOffice:list")
    public FebsResponse districtToOfficeList(QueryRequest request, DistrictToOffice districtToOffice) {
        Map<String, Object> dataTable = getDataTable(this.districtToOfficeService.findDistrictToOffices(request,
                districtToOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增DistrictToOffice", exceptionMessage = "新增DistrictToOffice失败")
    @PostMapping("districtToOffice")
    @ResponseBody
    @RequiresPermissions("districtToOffice:add")
    public FebsResponse addDistrictToOffice(@Valid DistrictToOffice districtToOffice) {
        this.districtToOfficeService.createDistrictToOffice(districtToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除DistrictToOffice", exceptionMessage = "删除DistrictToOffice失败")
    @GetMapping("districtToOffice/delete")
    @ResponseBody
    @RequiresPermissions("districtToOffice:delete")
    public FebsResponse deleteDistrictToOffice(DistrictToOffice districtToOffice) {
        this.districtToOfficeService.deleteDistrictToOffice(districtToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改DistrictToOffice", exceptionMessage = "修改DistrictToOffice失败")
    @PostMapping("districtToOffice/update")
    @ResponseBody
    @RequiresPermissions("districtToOffice:update")
    public FebsResponse updateDistrictToOffice(DistrictToOffice districtToOffice) {
        this.districtToOfficeService.updateDistrictToOffice(districtToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改DistrictToOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("districtToOffice/excel")
    @ResponseBody
    @RequiresPermissions("districtToOffice:export")
    public void export(QueryRequest queryRequest, DistrictToOffice districtToOffice, HttpServletResponse response) {
        List<DistrictToOffice> districtToOffices = this.districtToOfficeService.findDistrictToOffices(queryRequest,
                districtToOffice).getRecords();
        ExcelKit.$Export(DistrictToOffice.class, response).downXlsx(districtToOffices, false);
    }
}
