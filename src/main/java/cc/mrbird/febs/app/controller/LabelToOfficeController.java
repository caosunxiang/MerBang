package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.LabelToOffice;
import cc.mrbird.febs.app.service.ILabelToOfficeService;
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
 * @date 2020-05-06 09:17:12
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class LabelToOfficeController extends BaseController {

    private final ILabelToOfficeService labelToOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "labelToOffice")
    public String labelToOfficeIndex() {
        return FebsUtil.view("labelToOffice/labelToOffice");
    }

    @GetMapping("labelToOffice")
    @ResponseBody
    @RequiresPermissions("labelToOffice:list")
    public FebsResponse getAllLabelToOffices(LabelToOffice labelToOffice) {
        return new FebsResponse().success().data(labelToOfficeService.findLabelToOffices(labelToOffice));
    }

    @GetMapping("labelToOffice/list")
    @ResponseBody
    @RequiresPermissions("labelToOffice:list")
    public FebsResponse labelToOfficeList(QueryRequest request, LabelToOffice labelToOffice) {
        Map<String, Object> dataTable = getDataTable(this.labelToOfficeService.findLabelToOffices(request,
                labelToOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增LabelToOffice", exceptionMessage = "新增LabelToOffice失败")
    @PostMapping("labelToOffice")
    @ResponseBody
    @RequiresPermissions("labelToOffice:add")
    public FebsResponse addLabelToOffice(@Valid LabelToOffice labelToOffice) {
        this.labelToOfficeService.createLabelToOffice(labelToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除LabelToOffice", exceptionMessage = "删除LabelToOffice失败")
    @GetMapping("labelToOffice/delete")
    @ResponseBody
    @RequiresPermissions("labelToOffice:delete")
    public FebsResponse deleteLabelToOffice(LabelToOffice labelToOffice) {
        this.labelToOfficeService.deleteLabelToOffice(labelToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改LabelToOffice", exceptionMessage = "修改LabelToOffice失败")
    @PostMapping("labelToOffice/update")
    @ResponseBody
    @RequiresPermissions("labelToOffice:update")
    public FebsResponse updateLabelToOffice(LabelToOffice labelToOffice) {
        this.labelToOfficeService.updateLabelToOffice(labelToOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改LabelToOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("labelToOffice/excel")
    @ResponseBody
    @RequiresPermissions("labelToOffice:export")
    public void export(QueryRequest queryRequest, LabelToOffice labelToOffice, HttpServletResponse response) {
        List<LabelToOffice> labelToOffices = this.labelToOfficeService.findLabelToOffices(queryRequest,
                labelToOffice).getRecords();
        ExcelKit.$Export(LabelToOffice.class, response).downXlsx(labelToOffices, false);
    }

    @ControllerEndpoint(operation = "查找已经选择的标签", exceptionMessage = "查找已经选择的标签失败")
    @GetMapping("selectLabelByOfficeId")
    @ResponseBody
    public Body selectLabelByBuildingId(Integer officeId) {
        return this.labelToOfficeService.selectLabelByOfficeId(officeId);
    }
}
