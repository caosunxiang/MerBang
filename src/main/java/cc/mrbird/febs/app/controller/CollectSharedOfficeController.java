package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.CollectSharedOffice;
import cc.mrbird.febs.app.service.ICollectSharedOfficeService;
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
 * @date 2020-05-26 09:53:33
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class CollectSharedOfficeController extends BaseController {

    private final ICollectSharedOfficeService collectSharedOfficeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "collectSharedOffice")
    public String collectSharedOfficeIndex() {
        return FebsUtil.view("collectSharedOffice/collectSharedOffice");
    }

    @GetMapping("collectSharedOffice")
    @ResponseBody
    @RequiresPermissions("collectSharedOffice:list")
    public FebsResponse getAllCollectSharedOffices(CollectSharedOffice collectSharedOffice) {
        return new FebsResponse().success().data(collectSharedOfficeService.findCollectSharedOffices(collectSharedOffice));
    }

    @GetMapping("collectSharedOffice/list")
    @ResponseBody
    @RequiresPermissions("collectSharedOffice:list")
    public FebsResponse collectSharedOfficeList(QueryRequest request, CollectSharedOffice collectSharedOffice) {
        Map<String, Object> dataTable = getDataTable(this.collectSharedOfficeService.findCollectSharedOffices(request
                , collectSharedOffice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增CollectSharedOffice", exceptionMessage = "新增CollectSharedOffice失败")
    @PostMapping("collectSharedOffice")
    @ResponseBody
    @RequiresPermissions("collectSharedOffice:add")
    public FebsResponse addCollectSharedOffice(@Valid CollectSharedOffice collectSharedOffice) {
        this.collectSharedOfficeService.createCollectSharedOffice(collectSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除CollectSharedOffice", exceptionMessage = "删除CollectSharedOffice失败")
    @GetMapping("collectSharedOffice/delete")
    @ResponseBody
    @RequiresPermissions("collectSharedOffice:delete")
    public FebsResponse deleteCollectSharedOffice(CollectSharedOffice collectSharedOffice) {
        this.collectSharedOfficeService.deleteCollectSharedOffice(collectSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改CollectSharedOffice", exceptionMessage = "修改CollectSharedOffice失败")
    @PostMapping("collectSharedOffice/update")
    @ResponseBody
    @RequiresPermissions("collectSharedOffice:update")
    public FebsResponse updateCollectSharedOffice(CollectSharedOffice collectSharedOffice) {
        this.collectSharedOfficeService.updateCollectSharedOffice(collectSharedOffice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改CollectSharedOffice", exceptionMessage = "导出Excel失败")
    @PostMapping("collectSharedOffice/excel")
    @ResponseBody
    @RequiresPermissions("collectSharedOffice:export")
    public void export(QueryRequest queryRequest, CollectSharedOffice collectSharedOffice,
                       HttpServletResponse response) {
        List<CollectSharedOffice> collectSharedOffices =
                this.collectSharedOfficeService.findCollectSharedOffices(queryRequest, collectSharedOffice).getRecords();
        ExcelKit.$Export(CollectSharedOffice.class, response).downXlsx(collectSharedOffices, false);
    }
}
