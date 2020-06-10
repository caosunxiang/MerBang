package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.OfficeBuildingLabel;
import cc.mrbird.febs.app.service.IOfficeBuildingLabelService;
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
 * @date 2020-05-06 09:17:24
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class OfficeBuildingLabelController extends BaseController {

    private final IOfficeBuildingLabelService officeBuildingLabelService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "officeBuildingLabel")
    public String officeBuildingLabelIndex() {
        return FebsUtil.view("officeBuildingLabel/officeBuildingLabel");
    }

    @GetMapping("officeBuildingLabel")
    @ResponseBody
    @RequiresPermissions("officeBuildingLabel:list")
    public FebsResponse getAllOfficeBuildingLabels(OfficeBuildingLabel officeBuildingLabel) {
        return new FebsResponse().success().data(officeBuildingLabelService.findOfficeBuildingLabels(officeBuildingLabel));
    }

    @GetMapping("officeBuildingLabel/list")
    @ResponseBody
    @RequiresPermissions("officeBuildingLabel:list")
    public FebsResponse officeBuildingLabelList(QueryRequest request, OfficeBuildingLabel officeBuildingLabel) {
        Map<String, Object> dataTable = getDataTable(this.officeBuildingLabelService.findOfficeBuildingLabels(request
                , officeBuildingLabel));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增OfficeBuildingLabel", exceptionMessage = "新增OfficeBuildingLabel失败")
    @PostMapping("officeBuildingLabel")
    @ResponseBody
    @RequiresPermissions("officeBuildingLabel:add")
    public FebsResponse addOfficeBuildingLabel(@Valid OfficeBuildingLabel officeBuildingLabel) {
        this.officeBuildingLabelService.createOfficeBuildingLabel(officeBuildingLabel);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OfficeBuildingLabel", exceptionMessage = "删除OfficeBuildingLabel失败")
    @GetMapping("officeBuildingLabel/delete")
    @ResponseBody
    @RequiresPermissions("officeBuildingLabel:delete")
    public FebsResponse deleteOfficeBuildingLabel(OfficeBuildingLabel officeBuildingLabel) {
        this.officeBuildingLabelService.deleteOfficeBuildingLabel(officeBuildingLabel);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeBuildingLabel", exceptionMessage = "修改OfficeBuildingLabel失败")
    @PostMapping("officeBuildingLabel/update")
    @ResponseBody
    @RequiresPermissions("officeBuildingLabel:update")
    public FebsResponse updateOfficeBuildingLabel(OfficeBuildingLabel officeBuildingLabel) {
        this.officeBuildingLabelService.updateOfficeBuildingLabel(officeBuildingLabel);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeBuildingLabel", exceptionMessage = "导出Excel失败")
    @PostMapping("officeBuildingLabel/excel")
    @ResponseBody
    @RequiresPermissions("officeBuildingLabel:export")
    public void export(QueryRequest queryRequest, OfficeBuildingLabel officeBuildingLabel,
                       HttpServletResponse response) {
        List<OfficeBuildingLabel> officeBuildingLabels =
                this.officeBuildingLabelService.findOfficeBuildingLabels(queryRequest, officeBuildingLabel).getRecords();
        ExcelKit.$Export(OfficeBuildingLabel.class, response).downXlsx(officeBuildingLabels, false);
    }

    @ControllerEndpoint(operation = "查询写字楼标签", exceptionMessage = "查询写字楼标签失败")
    @GetMapping("selectOfficeBuildingLabel")
    @ResponseBody
    public Body selectOfficeBuildingLabel() {
        return this.officeBuildingLabelService.selectOfficeBuildingLabel();
    }

    @ControllerEndpoint(operation = "添加写字楼标签", exceptionMessage = "添加写字楼标签失败")
    @PostMapping("insertOfficeBuildingLabel")
    @ResponseBody
    public Body insertOfficeBuildingLabel(String name, Integer userId) {
        return this.officeBuildingLabelService.insertOfficeBuildingLabel(name, userId);
    }
}
