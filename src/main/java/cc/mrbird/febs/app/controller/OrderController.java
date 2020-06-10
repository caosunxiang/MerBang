package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Order;
import cc.mrbird.febs.app.service.IOrderService;
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
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 13:56:57
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController extends BaseController {

    private final IOrderService orderService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "order")
    public String orderIndex() {
        return FebsUtil.view("order/order");
    }

    @GetMapping("order")
    @ResponseBody
    @RequiresPermissions("order:list")
    public FebsResponse getAllOrders(Order order) {
        return new FebsResponse().success().data(orderService.findOrders(order));
    }

    @GetMapping("order/list")
    @ResponseBody
    @RequiresPermissions("order:list")
    public FebsResponse orderList(QueryRequest request, Order order) {
        Map<String, Object> dataTable = getDataTable(this.orderService.findOrders(request, order));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Order", exceptionMessage = "新增Order失败")
    @PostMapping("order")
    @ResponseBody
    @RequiresPermissions("order:add")
    public FebsResponse addOrder(@Valid Order order) {
        this.orderService.createOrder(order);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Order", exceptionMessage = "删除Order失败")
    @GetMapping("order/delete")
    @ResponseBody
    @RequiresPermissions("order:delete")
    public FebsResponse deleteOrder(Order order) {
        this.orderService.deleteOrder(order);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Order", exceptionMessage = "修改Order失败")
    @PostMapping("order/update")
    @ResponseBody
    @RequiresPermissions("order:update")
    public FebsResponse updateOrder(Order order) {
        this.orderService.updateOrder(order);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Order", exceptionMessage = "导出Excel失败")
    @PostMapping("order/excel")
    @ResponseBody
    @RequiresPermissions("order:export")
    public void export(QueryRequest queryRequest, Order order, HttpServletResponse response) {
        List<Order> orders = this.orderService.findOrders(queryRequest, order).getRecords();
        ExcelKit.$Export(Order.class, response).downXlsx(orders, false);
    }

    /**
     * @Description:
     * @Param: [payer, date, peice, picture, remark, id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 14:31
     */
    @ControllerEndpoint(operation = "增加订单支付记录", exceptionMessage = "增加订单支付记录失败")
    @PostMapping("insertOrderDetails")
    @ResponseBody
    public Body insertOrderDetails(String payer, String date, BigDecimal peice, String picture, String remark,
                                   Integer id,Integer contractId) {
        return this.orderService.insertOrderDetails(payer, date, peice, picture, remark, id,contractId);
    }

    /**
     * @Description:
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 14:32
     */
    @ControllerEndpoint(operation = "查找支付凭证", exceptionMessage = "查找支付凭证失败")
    @PostMapping("selectByContractId")
    @ResponseBody
    public Body selectByContractId(Integer id) {
        return this.orderService.selectByContractId(id);
    }

    /**
     * @Description:
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 14:37
     */
    @ControllerEndpoint(operation = "查找支付凭证详情", exceptionMessage = "查找支付凭证详情失败")
    @GetMapping("selectByOrderId")
    @ResponseBody
    public Body selectByOrderId(Integer id) {
        return this.orderService.selectByOrderId(id);
    }

    /**
     * @Description:
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/22 9:00
     */
    @ControllerEndpoint(operation = "首页折线图", exceptionMessage = "首页折线图失败")
    @GetMapping("selectLineChart")
    @ResponseBody
    public Body selectLineChart(Integer id) {
        return this.orderService.selectLineChart(id);
    }
}
