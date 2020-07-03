package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.DistrictToSharedOffice;
import cc.mrbird.febs.app.service.IDistrictToSharedOfficeService;
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
 * @date 2020-05-07 16:30:08
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class DistrictToSharedOfficeController extends BaseController {

    private final IDistrictToSharedOfficeService districtToSharedOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "districtToSharedOffice")
    public String districtToSharedOfficeIndex() {
        return FebsUtil.view("districtToSharedOffice/districtToSharedOffice");
    }

    @GetMapping("districtToSharedOffice")
    @ResponseBody
    @RequiresPermissions("districtToSharedOffice:list")
    public FebsResponse getAllDistrictToSharedOffices(DistrictToSharedOffice districtToSharedOffice) {
        return new FebsResponse().success().data(districtToSharedOfficeService.findDistrictToSharedOffices(districtToSharedOffice));
    }

    @GetMapping("districtToSharedOffice/list")
    @ResponseBody
    @RequiresPermissions("districtToSharedOffice:list")
    public FebsResponse districtToSharedOfficeList(QueryRequest request,
                                                   DistrictToSharedOffice districtToSharedOffice) {
        Map<String, Object> dataTable =
                getDataTable(this.districtToSharedOfficeService.findDistrictToSharedOffices(request,
                        districtToSharedOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增DistrictToSharedOffice", exceptionMessage = "新增DistrictToSharedOffice失败")
    @PostMapping("districtToSharedOffice")
    @ResponseBody
    @RequiresPermissions("districtToSharedOffice:add")
    public FebsResponse addDistrictToSharedOffice(@Valid DistrictToSharedOffice districtToSharedOffice) {
        this.districtToSharedOfficeService.createDistrictToSharedOffice(districtToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除DistrictToSharedOffice", exceptionMessage = "删除DistrictToSharedOffice失败")
    @GetMapping("districtToSharedOffice/delete")
    @ResponseBody
    @RequiresPermissions("districtToSharedOffice:delete")
    public FebsResponse deleteDistrictToSharedOffice(DistrictToSharedOffice districtToSharedOffice) {
        this.districtToSharedOfficeService.deleteDistrictToSharedOffice(districtToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改DistrictToSharedOffice", exceptionMessage = "修改DistrictToSharedOffice失败")
    @PostMapping("districtToSharedOffice/update")
    @ResponseBody
    @RequiresPermissions("districtToSharedOffice:update")
    public FebsResponse updateDistrictToSharedOffice(DistrictToSharedOffice districtToSharedOffice) {
        this.districtToSharedOfficeService.updateDistrictToSharedOffice(districtToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改DistrictToSharedOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("districtToSharedOffice/excel")
    @ResponseBody
    @RequiresPermissions("districtToSharedOffice:export")
    public void export(QueryRequest queryRequest, DistrictToSharedOffice districtToSharedOffice,
                       HttpServletResponse response) {
        List<DistrictToSharedOffice> districtToSharedOffices =
                this.districtToSharedOfficeService.findDistrictToSharedOffices(queryRequest, districtToSharedOffice).getRecords();
        ExcelKit.$Export(DistrictToSharedOffice.class, response).downXlsx(districtToSharedOffices, false);
    }
}
