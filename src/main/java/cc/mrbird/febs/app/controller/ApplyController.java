package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Apply;
import cc.mrbird.febs.app.service.IApplyService;
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
 * @date 2020-05-08 16:04:13
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class ApplyController extends BaseController {

    private final IApplyService applyService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "apply")
    public String applyIndex() {
        return FebsUtil.view("apply/apply");
    }

    @GetMapping("apply")
    @ResponseBody
    @RequiresPermissions("apply:list")
    public FebsResponse getAllApplys(Apply apply) {
        return new FebsResponse().success().data(applyService.findApplys(apply));
    }

    @GetMapping("apply/list")
    @ResponseBody
    @RequiresPermissions("apply:list")
    public FebsResponse applyList(QueryRequest request, Apply apply) {
        Map<String, Object> dataTable = getDataTable(this.applyService.findApplys(request, apply));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Apply", exceptionMessage = "新增Apply失败")
    @PostMapping("apply")
    @ResponseBody
    @RequiresPermissions("apply:add")
    public FebsResponse addApply(@Valid Apply apply) {
        this.applyService.createApply(apply);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Apply", exceptionMessage = "删除Apply失败")
    @GetMapping("apply/delete")
    @ResponseBody
    @RequiresPermissions("apply:delete")
    public FebsResponse deleteApply(Apply apply) {
        this.applyService.deleteApply(apply);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Apply", exceptionMessage = "修改Apply失败")
    @PostMapping("apply/update")
    @ResponseBody
    @RequiresPermissions("apply:update")
    public FebsResponse updateApply(Apply apply) {
        this.applyService.updateApply(apply);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Apply", exceptionMessage = "导出Excel失败")
    @PostMapping("apply/excel")
    @ResponseBody
    @RequiresPermissions("apply:export")
    public void export(QueryRequest queryRequest, Apply apply, HttpServletResponse response) {
        List<Apply> applys = this.applyService.findApplys(queryRequest, apply).getRecords();
        ExcelKit.$Export(Apply.class, response).downXlsx(applys, false);
    }

    @ControllerEndpoint(operation = "办公室请求", exceptionMessage = "办公室请求获取失败")
    @GetMapping("selectApplyCount")
    @ResponseBody
    public Body selectApplyCount(Integer id) {
        return this.applyService.selectApplyCount(id);
    }

    @ControllerEndpoint(operation = "指定办公室请求", exceptionMessage = "指定办公室请求获取失败")
    @GetMapping("selectApplyByOffice")
    @ResponseBody
    public Body selectApplyByOffice(Integer id) {
        return this.applyService.selectApplyByOffice(id);
    }
}
