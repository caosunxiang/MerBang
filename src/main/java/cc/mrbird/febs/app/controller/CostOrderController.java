package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.CostOrder;
import cc.mrbird.febs.app.service.ICostOrderService;
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
 * @date 2020-05-19 16:18:25
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class CostOrderController extends BaseController {

    private final ICostOrderService costOrderService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "costOrder")
    public String costOrderIndex(){
        return FebsUtil.view("costOrder/costOrder");
    }

    @GetMapping("costOrder")
    @ResponseBody
    @RequiresPermissions("costOrder:list")
    public FebsResponse getAllCostOrders(CostOrder costOrder) {
        return new FebsResponse().success().data(costOrderService.findCostOrders(costOrder));
    }

    @GetMapping("costOrder/list")
    @ResponseBody
    @RequiresPermissions("costOrder:list")
    public FebsResponse costOrderList(QueryRequest request, CostOrder costOrder) {
        Map<String, Object> dataTable = getDataTable(this.costOrderService.findCostOrders(request, costOrder));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增CostOrder", exceptionMessage = "新增CostOrder失败")
    @PostMapping("costOrder")
    @ResponseBody
    @RequiresPermissions("costOrder:add")
    public FebsResponse addCostOrder(@Valid CostOrder costOrder) {
        this.costOrderService.createCostOrder(costOrder);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除CostOrder", exceptionMessage = "删除CostOrder失败")
    @GetMapping("costOrder/delete")
    @ResponseBody
    @RequiresPermissions("costOrder:delete")
    public FebsResponse deleteCostOrder(CostOrder costOrder) {
        this.costOrderService.deleteCostOrder(costOrder);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改CostOrder", exceptionMessage = "修改CostOrder失败")
    @PostMapping("costOrder/update")
    @ResponseBody
    @RequiresPermissions("costOrder:update")
    public FebsResponse updateCostOrder(CostOrder costOrder) {
        this.costOrderService.updateCostOrder(costOrder);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改CostOrder", exceptionMessage = "导出Excel失败")
    @PostMapping("costOrder/excel")
    @ResponseBody
    @RequiresPermissions("costOrder:export")
    public void export(QueryRequest queryRequest, CostOrder costOrder, HttpServletResponse response) {
        List<CostOrder> costOrders = this.costOrderService.findCostOrders(queryRequest, costOrder).getRecords();
        ExcelKit.$Export(CostOrder.class, response).downXlsx(costOrders, false);
    }
/** 
* @Description: 
* @Param: [costOrder, id]
* @return: cc.mrbird.febs.common.utils.json.Body
* @Author: 冷酷的苹果
* @Date: 2020/5/20 16:36
*/
    @ControllerEndpoint(operation = "添加物业费收款账单", exceptionMessage = "添加物业费收款账单失败")
    @PostMapping("insertCostOrder")
    @ResponseBody
    public Body insertCostOrder(CostOrder costOrder, Integer id) {
        return this.costOrderService.insertCostOrder(costOrder,id);
    }
/** 
* @Description:
* @Param: [id]
* @return: cc.mrbird.febs.common.utils.json.Body
* @Author: 冷酷的苹果
* @Date: 2020/5/20 16:36
*/
    @ControllerEndpoint(operation = "查找物业费下的收费账单", exceptionMessage = "查找物业费下的收费账单失败")
    @GetMapping("selectCostOrderByCostId")
    @ResponseBody
    public Body selectCostOrderByCostId(Integer id) {
        return this.costOrderService.selectCostOrderByCostId(id);
    }
}
