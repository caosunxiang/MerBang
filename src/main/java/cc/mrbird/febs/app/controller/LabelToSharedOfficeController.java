package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.LabelToSharedOffice;
import cc.mrbird.febs.app.service.ILabelToSharedOfficeService;
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
 *  Controller
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:50
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class LabelToSharedOfficeController extends BaseController {

    private final ILabelToSharedOfficeService labelToSharedOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "labelToSharedOffice")
    public String labelToSharedOfficeIndex(){
        return FebsUtil.view("labelToSharedOffice/labelToSharedOffice");
    }

    @GetMapping("labelToSharedOffice")
    @ResponseBody
    @RequiresPermissions("labelToSharedOffice:list")
    public FebsResponse getAllLabelToSharedOffices(LabelToSharedOffice labelToSharedOffice) {
        return new FebsResponse().success().data(labelToSharedOfficeService.findLabelToSharedOffices(labelToSharedOffice));
    }

    @GetMapping("labelToSharedOffice/list")
    @ResponseBody
    @RequiresPermissions("labelToSharedOffice:list")
    public FebsResponse labelToSharedOfficeList(QueryRequest request, LabelToSharedOffice labelToSharedOffice) {
        Map<String, Object> dataTable = getDataTable(this.labelToSharedOfficeService.findLabelToSharedOffices(request, labelToSharedOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增LabelToSharedOffice", exceptionMessage = "新增LabelToSharedOffice失败")
    @PostMapping("labelToSharedOffice")
    @ResponseBody
    @RequiresPermissions("labelToSharedOffice:add")
    public FebsResponse addLabelToSharedOffice(@Valid LabelToSharedOffice labelToSharedOffice) {
        this.labelToSharedOfficeService.createLabelToSharedOffice(labelToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除LabelToSharedOffice", exceptionMessage = "删除LabelToSharedOffice失败")
    @GetMapping("labelToSharedOffice/delete")
    @ResponseBody
    @RequiresPermissions("labelToSharedOffice:delete")
    public FebsResponse deleteLabelToSharedOffice(LabelToSharedOffice labelToSharedOffice) {
        this.labelToSharedOfficeService.deleteLabelToSharedOffice(labelToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改LabelToSharedOffice", exceptionMessage = "修改LabelToSharedOffice失败")
    @PostMapping("labelToSharedOffice/update")
    @ResponseBody
    @RequiresPermissions("labelToSharedOffice:update")
    public FebsResponse updateLabelToSharedOffice(LabelToSharedOffice labelToSharedOffice) {
        this.labelToSharedOfficeService.updateLabelToSharedOffice(labelToSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改LabelToSharedOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("labelToSharedOffice/excel")
    @ResponseBody
    @RequiresPermissions("labelToSharedOffice:export")
    public void export(QueryRequest queryRequest, LabelToSharedOffice labelToSharedOffice, HttpServletResponse response) {
        List<LabelToSharedOffice> labelToSharedOffices = this.labelToSharedOfficeService.findLabelToSharedOffices(queryRequest, labelToSharedOffice).getRecords();
        ExcelKit.$Export(LabelToSharedOffice.class, response).downXlsx(labelToSharedOffices, false);
    }

    @ControllerEndpoint(operation = "关联共享办公标签", exceptionMessage = "关联共享办公标签失败")
    @PostMapping("insertLabelAndSharedOffice")
    @ResponseBody
    public Body insertLabelAndSharedOffice(Integer SharedOfficeId, String labelId, Integer id) {
        return this.labelToSharedOfficeService.insertLabelAndSharedOffice(SharedOfficeId,labelId,id);
    }

    @ControllerEndpoint(operation = "查找共享办公标签", exceptionMessage = "查找共享办公标签失败")
    @GetMapping("selectLabelBySharedOfficeId")
    @ResponseBody
    public Body selectLabelBySharedOfficeId(Integer SharedOfficeId) {
        return this.labelToSharedOfficeService.selectLabelBySharedOfficeId(SharedOfficeId);
    }

}
