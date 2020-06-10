package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Collect;
import cc.mrbird.febs.app.service.ICollectService;
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
 * @date 2020-05-26 09:53:12
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class CollectController extends BaseController {

    private final ICollectService collectService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "collect")
    public String collectIndex() {
        return FebsUtil.view("collect/collect");
    }

    @GetMapping("collect")
    @ResponseBody
    @RequiresPermissions("collect:list")
    public FebsResponse getAllCollects(Collect collect) {
        return new FebsResponse().success().data(collectService.findCollects(collect));
    }

    @GetMapping("collect/list")
    @ResponseBody
    @RequiresPermissions("collect:list")
    public FebsResponse collectList(QueryRequest request, Collect collect) {
        Map<String, Object> dataTable = getDataTable(this.collectService.findCollects(request, collect));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Collect", exceptionMessage = "新增Collect失败")
    @PostMapping("collect")
    @ResponseBody
    @RequiresPermissions("collect:add")
    public FebsResponse addCollect(@Valid Collect collect) {
        this.collectService.createCollect(collect);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Collect", exceptionMessage = "删除Collect失败")
    @GetMapping("collect/delete")
    @ResponseBody
    @RequiresPermissions("collect:delete")
    public FebsResponse deleteCollect(Collect collect) {
        this.collectService.deleteCollect(collect);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Collect", exceptionMessage = "修改Collect失败")
    @PostMapping("collect/update")
    @ResponseBody
    @RequiresPermissions("collect:update")
    public FebsResponse updateCollect(Collect collect) {
        this.collectService.updateCollect(collect);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Collect", exceptionMessage = "导出Excel失败")
    @PostMapping("collect/excel")
    @ResponseBody
    @RequiresPermissions("collect:export")
    public void export(QueryRequest queryRequest, Collect collect, HttpServletResponse response) {
        List<Collect> collects = this.collectService.findCollects(queryRequest, collect).getRecords();
        ExcelKit.$Export(Collect.class, response).downXlsx(collects, false);
    }

    @ControllerEndpoint(operation = "查找收藏信息", exceptionMessage = "查找收藏信息失败")
    @GetMapping("selectCollect")
    @ResponseBody
    public Body selectCollect() {
        return this.collectService.selectCollect();
    }

    @ControllerEndpoint(operation = "添加收藏", exceptionMessage = "添加收藏失败")
    @PostMapping("insertCollect")
    @ResponseBody
    public Body insertCollect(Integer collectUser, Integer collectOfficeBuildingId, String type) {
        return this.collectService.insertCollect(collectUser,collectOfficeBuildingId,type);
    }

    @ControllerEndpoint(operation = "删除收藏", exceptionMessage = "删除收藏失败")
    @PostMapping("deleteCollect")
    @ResponseBody
    public Body deleteCollect(Integer id) {
        return this.collectService.deleteCollect(id);
    }
}
