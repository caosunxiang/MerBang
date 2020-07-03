package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.OfficeLabel;
import cc.mrbird.febs.app.service.IOfficeLabelService;
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
 * @date 2020-05-06 09:16:37
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class OfficeLabelController extends BaseController {

    private final IOfficeLabelService officeLabelService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "officeLabel")
    public String officeLabelIndex() {
        return FebsUtil.view("officeLabel/officeLabel");
    }

    @GetMapping("officeLabel")
    @ResponseBody
    @RequiresPermissions("officeLabel:list")
    public FebsResponse getAllOfficeLabels(OfficeLabel officeLabel) {
        return new FebsResponse().success().data(officeLabelService.findOfficeLabels(officeLabel));
    }

    @GetMapping("officeLabel/list")
    @ResponseBody
    @RequiresPermissions("officeLabel:list")
    public FebsResponse officeLabelList(QueryRequest request, OfficeLabel officeLabel) {
        Map<String, Object> dataTable = getDataTable(this.officeLabelService.findOfficeLabels(request, officeLabel));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增OfficeLabel", exceptionMessage = "新增OfficeLabel失败")
    @PostMapping("officeLabel")
    @ResponseBody
    @RequiresPermissions("officeLabel:add")
    public FebsResponse addOfficeLabel(@Valid OfficeLabel officeLabel) {
        this.officeLabelService.createOfficeLabel(officeLabel);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OfficeLabel", exceptionMessage = "删除OfficeLabel失败")
    @GetMapping("officeLabel/delete")
    @ResponseBody
    @RequiresPermissions("officeLabel:delete")
    public FebsResponse deleteOfficeLabel(OfficeLabel officeLabel) {
        this.officeLabelService.deleteOfficeLabel(officeLabel);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeLabel", exceptionMessage = "修改OfficeLabel失败")
    @PostMapping("officeLabel/update")
    @ResponseBody
    @RequiresPermissions("officeLabel:update")
    public FebsResponse updateOfficeLabel(OfficeLabel officeLabel) {
        this.officeLabelService.updateOfficeLabel(officeLabel);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeLabel", exceptionMessage = "导出Excel失败")
    @PostMapping("officeLabel/excel")
    @ResponseBody
    @RequiresPermissions("officeLabel:export")
    public void export(QueryRequest queryRequest, OfficeLabel officeLabel, HttpServletResponse response) {
        List<OfficeLabel> officeLabels =
                this.officeLabelService.findOfficeLabels(queryRequest, officeLabel).getRecords();
        ExcelKit.$Export(OfficeLabel.class, response).downXlsx(officeLabels, false);
    }
}
