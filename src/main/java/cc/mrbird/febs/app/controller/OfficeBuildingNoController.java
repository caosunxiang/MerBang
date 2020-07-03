package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.OfficeBuilding;
import cc.mrbird.febs.app.entity.OfficeBuildingNo;
import cc.mrbird.febs.app.service.IOfficeBuildingNoService;
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
 * @date 2020-05-06 09:18:10
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class OfficeBuildingNoController extends BaseController {

    private final IOfficeBuildingNoService officeBuildingNoService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "officeBuildingNo")
    public String officeBuildingNoIndex() {
        return FebsUtil.view("officeBuildingNo/officeBuildingNo");
    }

    @GetMapping("officeBuildingNo")
    @ResponseBody
    @RequiresPermissions("officeBuildingNo:list")
    public FebsResponse getAllOfficeBuildingNos(OfficeBuildingNo officeBuildingNo) {
        return new FebsResponse().success().data(officeBuildingNoService.findOfficeBuildingNos(officeBuildingNo));
    }

    @GetMapping("officeBuildingNo/list")
    @ResponseBody
    @RequiresPermissions("officeBuildingNo:list")
    public FebsResponse officeBuildingNoList(QueryRequest request, OfficeBuildingNo officeBuildingNo) {
        Map<String, Object> dataTable = getDataTable(this.officeBuildingNoService.findOfficeBuildingNos(request,
                officeBuildingNo));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增OfficeBuildingNo", exceptionMessage = "新增OfficeBuildingNo失败")
    @PostMapping("officeBuildingNo")
    @ResponseBody
    @RequiresPermissions("officeBuildingNo:add")
    public FebsResponse addOfficeBuildingNo(@Valid OfficeBuildingNo officeBuildingNo) {
        this.officeBuildingNoService.createOfficeBuildingNo(officeBuildingNo);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OfficeBuildingNo", exceptionMessage = "删除OfficeBuildingNo失败")
    @GetMapping("officeBuildingNo/delete")
    @ResponseBody
    @RequiresPermissions("officeBuildingNo:delete")
    public FebsResponse deleteOfficeBuildingNo(OfficeBuildingNo officeBuildingNo) {
        this.officeBuildingNoService.deleteOfficeBuildingNo(officeBuildingNo);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeBuildingNo", exceptionMessage = "修改OfficeBuildingNo失败")
    @PostMapping("officeBuildingNo/update")
    @ResponseBody
    @RequiresPermissions("officeBuildingNo:update")
    public FebsResponse updateOfficeBuildingNo(OfficeBuildingNo officeBuildingNo) {
        this.officeBuildingNoService.updateOfficeBuildingNo(officeBuildingNo);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeBuildingNo", exceptionMessage = "导出Excel失败")
    @PostMapping("officeBuildingNo/excel")
    @ResponseBody
    @RequiresPermissions("officeBuildingNo:export")
    public void export(QueryRequest queryRequest, OfficeBuildingNo officeBuildingNo, HttpServletResponse response) {
        List<OfficeBuildingNo> officeBuildingNos = this.officeBuildingNoService.findOfficeBuildingNos(queryRequest,
                officeBuildingNo).getRecords();
        ExcelKit.$Export(OfficeBuildingNo.class, response).downXlsx(officeBuildingNos, false);
    }

    @ControllerEndpoint(operation = "查询写字楼楼栋", exceptionMessage = "查询写字楼楼栋失败")
    @GetMapping("selectOfficeBuildingNo")
    @ResponseBody
    public Body selectOfficeBuildingNo(Integer officeBuildingId) {
        return this.officeBuildingNoService.selectOfficeBuildingNo(officeBuildingId);
    }
}
