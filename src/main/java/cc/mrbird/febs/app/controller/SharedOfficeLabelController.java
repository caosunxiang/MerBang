package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.SharedOfficeLabel;
import cc.mrbird.febs.app.service.ISharedOfficeLabelService;
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
 * @date 2020-05-15 14:45:20
 */
@Slf4j
@Validated
@Controller
@CrossOrigin
@RequestMapping("app")
@RequiredArgsConstructor
public class SharedOfficeLabelController extends BaseController {

    private final ISharedOfficeLabelService sharedOfficeLabelService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "sharedOfficeLabel")
    public String sharedOfficeLabelIndex() {
        return FebsUtil.view("sharedOfficeLabel/sharedOfficeLabel");
    }

    @GetMapping("sharedOfficeLabel")
    @ResponseBody
    @RequiresPermissions("sharedOfficeLabel:list")
    public FebsResponse getAllSharedOfficeLabels(SharedOfficeLabel sharedOfficeLabel) {
        return new FebsResponse().success().data(sharedOfficeLabelService.findSharedOfficeLabels(sharedOfficeLabel));
    }

    @GetMapping("sharedOfficeLabel/list")
    @ResponseBody
    @RequiresPermissions("sharedOfficeLabel:list")
    public FebsResponse sharedOfficeLabelList(QueryRequest request, SharedOfficeLabel sharedOfficeLabel) {
        Map<String, Object> dataTable = getDataTable(this.sharedOfficeLabelService.findSharedOfficeLabels(request,
                sharedOfficeLabel));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增SharedOfficeLabel", exceptionMessage = "新增SharedOfficeLabel失败")
    @PostMapping("sharedOfficeLabel")
    @ResponseBody
    @RequiresPermissions("sharedOfficeLabel:add")
    public FebsResponse addSharedOfficeLabel(@Valid SharedOfficeLabel sharedOfficeLabel) {
        this.sharedOfficeLabelService.createSharedOfficeLabel(sharedOfficeLabel);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除SharedOfficeLabel", exceptionMessage = "删除SharedOfficeLabel失败")
    @GetMapping("sharedOfficeLabel/delete")
    @ResponseBody
    @RequiresPermissions("sharedOfficeLabel:delete")
    public FebsResponse deleteSharedOfficeLabel(SharedOfficeLabel sharedOfficeLabel) {
        this.sharedOfficeLabelService.deleteSharedOfficeLabel(sharedOfficeLabel);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改SharedOfficeLabel", exceptionMessage = "修改SharedOfficeLabel失败")
    @PostMapping("sharedOfficeLabel/update")
    @ResponseBody
    @RequiresPermissions("sharedOfficeLabel:update")
    public FebsResponse updateSharedOfficeLabel(SharedOfficeLabel sharedOfficeLabel) {
        this.sharedOfficeLabelService.updateSharedOfficeLabel(sharedOfficeLabel);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改SharedOfficeLabel", exceptionMessage = "导出Excel失败")
    @PostMapping("sharedOfficeLabel/excel")
    @ResponseBody
    @RequiresPermissions("sharedOfficeLabel:export")
    public void export(QueryRequest queryRequest, SharedOfficeLabel sharedOfficeLabel, HttpServletResponse response) {
        List<SharedOfficeLabel> sharedOfficeLabels =
                this.sharedOfficeLabelService.findSharedOfficeLabels(queryRequest, sharedOfficeLabel).getRecords();
        ExcelKit.$Export(SharedOfficeLabel.class, response).downXlsx(sharedOfficeLabels, false);
    }

    @ControllerEndpoint(operation = "查询共享办公标签", exceptionMessage = "查询共享办公失败")
    @GetMapping("selectSharedOfficeLabel")
    @ResponseBody
    public Body selectSharedOfficeLabel() {
        return this.sharedOfficeLabelService.selectSharedOfficeLabel();
    }

    @ControllerEndpoint(operation = "添加共享办公标签", exceptionMessage = "添加共享办公标签失败")
    @PostMapping("insertSharedOfficeLabel")
    @ResponseBody
    public Body insertSharedOfficeLabel(String name, Integer userId) {
        return this.sharedOfficeLabelService.insertSharedOfficeLabel(name, userId);
    }
}
