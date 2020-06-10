package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Contract;
import cc.mrbird.febs.app.service.IContractService;
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
 * @date 2020-05-18 14:04:02
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class ContractController extends BaseController {

    private final IContractService contractService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "contract")
    public String contractIndex() {
        return FebsUtil.view("contract/contract");
    }

    @GetMapping("contract")
    @ResponseBody
    @RequiresPermissions("contract:list")
    public FebsResponse getAllContracts(Contract contract) {
        return new FebsResponse().success().data(contractService.findContracts(contract));
    }

    @GetMapping("contract/list")
    @ResponseBody
    @RequiresPermissions("contract:list")
    public FebsResponse contractList(QueryRequest request, Contract contract) {
        Map<String, Object> dataTable = getDataTable(this.contractService.findContracts(request, contract));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Contract", exceptionMessage = "新增Contract失败")
    @PostMapping("contract")
    @ResponseBody
    @RequiresPermissions("contract:add")
    public FebsResponse addContract(@Valid Contract contract) {
        this.contractService.createContract(contract);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Contract", exceptionMessage = "删除Contract失败")
    @GetMapping("contract/delete")
    @ResponseBody
    @RequiresPermissions("contract:delete")
    public FebsResponse deleteContract(Contract contract) {
        this.contractService.deleteContract(contract);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Contract", exceptionMessage = "修改Contract失败")
    @PostMapping("contract/update")
    @ResponseBody
    @RequiresPermissions("contract:update")
    public FebsResponse updateContract(Contract contract) {
        this.contractService.updateContract(contract);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Contract", exceptionMessage = "导出Excel失败")
    @PostMapping("contract/excel")
    @ResponseBody
    @RequiresPermissions("contract:export")
    public void export(QueryRequest queryRequest, Contract contract, HttpServletResponse response) {
        List<Contract> contracts = this.contractService.findContracts(queryRequest, contract).getRecords();
        ExcelKit.$Export(Contract.class, response).downXlsx(contracts, false);
    }

    /** 
    * @Description: 
    * @Param: [condition, id]
    * @return: cc.mrbird.febs.common.utils.json.Body
    * @Author: 冷酷的苹果
    * @Date: 2020/5/18 18:02
    */
    @ControllerEndpoint(operation = "查找租金信息", exceptionMessage = "查找租金信息失败")
    @GetMapping("selectContract")
    @ResponseBody
    public Body selectContract(String condition, String id,Integer door) {
        return this.contractService.selectContract(condition, id,door);
    }

    /** 
    * @Description:
    * @Param: [id, door]
    * @return: cc.mrbird.febs.common.utils.json.Body
    * @Author: 冷酷的苹果
    * @Date: 2020/5/19 11:15
    */
    @ControllerEndpoint(operation = "查找租金详情", exceptionMessage = "查找租金详情失败")
    @GetMapping("selectContractByConIdAndDoor")
    @ResponseBody
    public Body selectContractByConIdAndDoor(Integer id,Integer door){
        return this.contractService.selectContractByConIdAndDoor(id,door);
    }
}
