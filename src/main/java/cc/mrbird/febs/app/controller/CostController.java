package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Cost;
import cc.mrbird.febs.app.service.ICostService;
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
 * @date 2020-05-19 16:18:21
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class CostController extends BaseController {

    private final ICostService costService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "cost")
    public String costIndex() {
        return FebsUtil.view("cost/cost");
    }

    @GetMapping("cost")
    @ResponseBody
    @RequiresPermissions("cost:list")
    public FebsResponse getAllCosts(Cost cost) {
        return new FebsResponse().success().data(costService.findCosts(cost));
    }

    @GetMapping("cost/list")
    @ResponseBody
    @RequiresPermissions("cost:list")
    public FebsResponse costList(QueryRequest request, Cost cost) {
        Map<String, Object> dataTable = getDataTable(this.costService.findCosts(request, cost));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Cost", exceptionMessage = "新增Cost失败")
    @PostMapping("cost")
    @ResponseBody
    @RequiresPermissions("cost:add")
    public FebsResponse addCost(@Valid Cost cost) {
        this.costService.createCost(cost);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Cost", exceptionMessage = "删除Cost失败")
    @GetMapping("cost/delete")
    @ResponseBody
    @RequiresPermissions("cost:delete")
    public FebsResponse deleteCost(Cost cost) {
        this.costService.deleteCost(cost);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Cost", exceptionMessage = "修改Cost失败")
    @PostMapping("cost/update")
    @ResponseBody
    @RequiresPermissions("cost:update")
    public FebsResponse updateCost(Cost cost) {
        this.costService.updateCost(cost);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Cost", exceptionMessage = "导出Excel失败")
    @PostMapping("cost/excel")
    @ResponseBody
    @RequiresPermissions("cost:export")
    public void export(QueryRequest queryRequest, Cost cost, HttpServletResponse response) {
        List<Cost> costs = this.costService.findCosts(queryRequest, cost).getRecords();
        ExcelKit.$Export(Cost.class, response).downXlsx(costs, false);
    }

    /**
     * @Description:
     * @Param: [cost]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/20 16:55
     */
    @ControllerEndpoint(operation = "添加物业费", exceptionMessage = "添加物业费失败")
    @PostMapping("InsertCost")
    @ResponseBody
    public Body InsertCost(Cost cost) {
        return this.costService.InsertCost(cost);
    }

    /**
     * @Description:
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/20 16:55
     */
    @ControllerEndpoint(operation = "查找指定物业账单", exceptionMessage = "查找指定物业账单失败")
    @GetMapping("selectCostByCostId")
    @ResponseBody
    public Body selectCostByCostId(Integer id) {
        return this.costService.selectCostByCostId(id);
    }

    /**
     * @Description:
     * @Param: [costId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/20 16:55
     */
    @ControllerEndpoint(operation = "统计", exceptionMessage = "统计失败")
    @GetMapping("costStatistics")
    @ResponseBody
    public Body costStatistics(Integer costId) {
        return this.costService.costStatistics(costId);
    }

    /**
     * @Description:
     * @Param: [condition, id, door]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/20 16:55
     */
    @ControllerEndpoint(operation = "条件查询物业费", exceptionMessage = "条件查询物业费失败")
    @GetMapping("selectCost")
    @ResponseBody
    public Body selectCost(String condition, Integer id, String door) {
        return this.costService.selectCost(condition, id, door);
    }
}
