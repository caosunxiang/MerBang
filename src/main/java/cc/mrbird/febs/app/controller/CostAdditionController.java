package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.CostAddition;
import cc.mrbird.febs.app.service.ICostAdditionService;
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
 * @date 2020-05-19 16:18:18
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class CostAdditionController extends BaseController {

    private final ICostAdditionService costAdditionService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "costAddition")
    public String costAdditionIndex() {
        return FebsUtil.view("costAddition/costAddition");
    }

    @GetMapping("costAddition")
    @ResponseBody
    @RequiresPermissions("costAddition:list")
    public FebsResponse getAllCostAdditions(CostAddition costAddition) {
        return new FebsResponse().success().data(costAdditionService.findCostAdditions(costAddition));
    }

    @GetMapping("costAddition/list")
    @ResponseBody
    @RequiresPermissions("costAddition:list")
    public FebsResponse costAdditionList(QueryRequest request, CostAddition costAddition) {
        Map<String, Object> dataTable = getDataTable(this.costAdditionService.findCostAdditions(request, costAddition));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增CostAddition", exceptionMessage = "新增CostAddition失败")
    @PostMapping("costAddition")
    @ResponseBody
    @RequiresPermissions("costAddition:add")
    public FebsResponse addCostAddition(@Valid CostAddition costAddition) {
        this.costAdditionService.createCostAddition(costAddition);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除CostAddition", exceptionMessage = "删除CostAddition失败")
    @GetMapping("costAddition/delete")
    @ResponseBody
    @RequiresPermissions("costAddition:delete")
    public FebsResponse deleteCostAddition(CostAddition costAddition) {
        this.costAdditionService.deleteCostAddition(costAddition);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改CostAddition", exceptionMessage = "修改CostAddition失败")
    @PostMapping("costAddition/update")
    @ResponseBody
    @RequiresPermissions("costAddition:update")
    public FebsResponse updateCostAddition(CostAddition costAddition) {
        this.costAdditionService.updateCostAddition(costAddition);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改CostAddition", exceptionMessage = "导出Excel失败")
    @PostMapping("costAddition/excel")
    @ResponseBody
    @RequiresPermissions("costAddition:export")
    public void export(QueryRequest queryRequest, CostAddition costAddition, HttpServletResponse response) {
        List<CostAddition> costAdditions =
                this.costAdditionService.findCostAdditions(queryRequest, costAddition).getRecords();
        ExcelKit.$Export(CostAddition.class, response).downXlsx(costAdditions, false);
    }

    /**
     * @Description:
     * @Param: [costAddition]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 16:41
     */
    @ControllerEndpoint(operation = "添加CostAddition", exceptionMessage = "添加Excel失败")
    @PostMapping("insertCostAddition")
    @ResponseBody
    public Body insertCostAddition(CostAddition costAddition, Integer userid) {
        return this.costAdditionService.insertCostAddition(costAddition, userid);
    }

    /**
     * @Description:
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 16:43
     */
    @ControllerEndpoint(operation = "查找所有分类", exceptionMessage = "查找所有分类失败")
    @GetMapping("selectCostAdditionaAll")
    @ResponseBody
    public Body selectCostAdditionaAll() {
        return this.costAdditionService.selectCostAdditionaAll();
    }

    /**
     * @Description:
     * @Param: [pid]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 16:43
     */
    @ControllerEndpoint(operation = "查找子分类", exceptionMessage = "查找子分类失败")
    @GetMapping("selectCostAdditionaByPid")
    @ResponseBody
    public Body selectCostAdditionaByPid(Integer pid) {
        return this.costAdditionService.selectCostAdditionaByPid(pid);
    }

    @ControllerEndpoint(operation = "查找名称", exceptionMessage = "查找名称失败")
    @PostMapping("updateCostAdditionaName")
    @ResponseBody
    public Body updateCostAdditionaName(CostAddition costAddition) {
        return this.costAdditionService.updateCostAdditionaName(costAddition);
    }

    /**
     * @Description: 删除收款选项
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/6/1 18:00
     */
    @ControllerEndpoint(operation = "删除收款选项", exceptionMessage = "删除收款失败")
    @PostMapping("deleteCost")
    @ResponseBody
    public Body deleteCost(Integer id) {
        return this.costAdditionService.deleteCost(id);
    }
}
