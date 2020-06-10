package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Invoice;
import cc.mrbird.febs.app.service.IInvoiceService;
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
 * @date 2020-05-18 09:55:16
 */
@Slf4j
@Validated
@RequestMapping("app")
@CrossOrigin
@Controller
@RequiredArgsConstructor
public class InvoiceController extends BaseController {

    private final IInvoiceService invoiceService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "invoice")
    public String invoiceIndex() {
        return FebsUtil.view("invoice/invoice");
    }

    @GetMapping("invoice")
    @ResponseBody
    @RequiresPermissions("invoice:list")
    public FebsResponse getAllInvoices(Invoice invoice) {
        return new FebsResponse().success().data(invoiceService.findInvoices(invoice));
    }

    @GetMapping("invoice/list")
    @ResponseBody
    @RequiresPermissions("invoice:list")
    public FebsResponse invoiceList(QueryRequest request, Invoice invoice) {
        Map<String, Object> dataTable = getDataTable(this.invoiceService.findInvoices(request, invoice));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Invoice", exceptionMessage = "新增Invoice失败")
    @PostMapping("invoice")
    @ResponseBody
    @RequiresPermissions("invoice:add")
    public FebsResponse addInvoice(@Valid Invoice invoice) {
        this.invoiceService.createInvoice(invoice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Invoice", exceptionMessage = "删除Invoice失败")
    @GetMapping("invoice/delete")
    @ResponseBody
    @RequiresPermissions("invoice:delete")
    public FebsResponse deleteInvoice(Invoice invoice) {
        this.invoiceService.deleteInvoice(invoice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Invoice", exceptionMessage = "修改Invoice失败")
    @PostMapping("invoice/update")
    @ResponseBody
    @RequiresPermissions("invoice:update")
    public FebsResponse updateInvoice(Invoice invoice) {
        this.invoiceService.updateInvoice(invoice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Invoice", exceptionMessage = "导出Excel失败")
    @PostMapping("invoice/excel")
    @ResponseBody
    @RequiresPermissions("invoice:export")
    public void export(QueryRequest queryRequest, Invoice invoice, HttpServletResponse response) {
        List<Invoice> invoices = this.invoiceService.findInvoices(queryRequest, invoice).getRecords();
        ExcelKit.$Export(Invoice.class, response).downXlsx(invoices, false);
    }

    /**
     * @Description:
     * @Param: [lesseeId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 10:08
     */
    @ControllerEndpoint(operation = "查找开票信息", exceptionMessage = "查找开票信息失败")
    @GetMapping("selectInvoice")
    @ResponseBody
    public Body selectInvoice(Integer lesseeId) {
        return this.invoiceService.selectInvoice(lesseeId);
    }

    /**
     * @Description:
     * @Param: [invoice]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 10:16
     */
    @ControllerEndpoint(operation = "新增开票信息", exceptionMessage = "查找开票信息失败")
    @PostMapping("insertInvoice")
    @ResponseBody
    public Body insertInvoice(Invoice invoice) {
        return this.invoiceService.insertInvoice(invoice);
    }

    /**
     * @Description:
     * @Param: [invoice]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 10:16
     */
    @ControllerEndpoint(operation = "修改开票信息", exceptionMessage = "查找开票信息失败")
    @PostMapping("updateInvoiceDetails")
    @ResponseBody
    public Body updateInvoiceDetails(Invoice invoice) {
        return this.invoiceService.updateInvoiceDetails(invoice);
    }
}
