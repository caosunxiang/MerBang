package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Lessee;
import cc.mrbird.febs.app.service.ILesseeService;
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
 * @date 2020-05-08 16:04:09
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class LesseeController extends BaseController {

    private final ILesseeService lesseeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "lessee")
    public String lesseeIndex() {
        return FebsUtil.view("lessee/lessee");
    }

    @GetMapping("lessee")
    @ResponseBody
    @RequiresPermissions("lessee:list")
    public FebsResponse getAllLessees(Lessee lessee) {
        return new FebsResponse().success().data(lesseeService.findLessees(lessee));
    }

    @GetMapping("lessee/list")
    @ResponseBody
    @RequiresPermissions("lessee:list")
    public FebsResponse lesseeList(QueryRequest request, Lessee lessee) {
        Map<String, Object> dataTable = getDataTable(this.lesseeService.findLessees(request, lessee));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Lessee", exceptionMessage = "新增Lessee失败")
    @PostMapping("lessee")
    @ResponseBody
    @RequiresPermissions("lessee:add")
    public FebsResponse addLessee(@Valid Lessee lessee) {
        this.lesseeService.createLessee(lessee);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Lessee", exceptionMessage = "删除Lessee失败")
    @GetMapping("lessee/delete")
    @ResponseBody
    @RequiresPermissions("lessee:delete")
    public FebsResponse deleteLessee(Lessee lessee) {
        this.lesseeService.deleteLessee(lessee);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Lessee", exceptionMessage = "修改Lessee失败")
    @PostMapping("lessee/update")
    @ResponseBody
    @RequiresPermissions("lessee:update")
    public FebsResponse updateLessee(Lessee lessee) {
        this.lesseeService.updateLessee(lessee);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Lessee", exceptionMessage = "导出Excel失败")
    @PostMapping("lessee/excel")
    @ResponseBody
    @RequiresPermissions("lessee:export")
    public void export(QueryRequest queryRequest, Lessee lessee, HttpServletResponse response) {
        List<Lessee> lessees = this.lesseeService.findLessees(queryRequest, lessee).getRecords();
        ExcelKit.$Export(Lessee.class, response).downXlsx(lessees, false);
    }

    @ControllerEndpoint(operation = "查询指定办公室的租户信息", exceptionMessage = "查询指定办公室的租户信息失败")
    @GetMapping("selectLesseeByOffice")
    @ResponseBody
    public Body selectLesseeByOffice(Integer id) {
        return this.lesseeService.selectLesseeByOffice(id);
    }

    /**
     * @Description:
     * @Param: [lessee]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 9:22
     */
    @ControllerEndpoint(operation = "新增租户信息", exceptionMessage = "新增租户信息失败")
    @PostMapping("insertLessee")
    @ResponseBody
    public Body insertLessee(Lessee lessee, Integer officeId) {
        return this.lesseeService.insertLessee(lessee, officeId);
    }

    @ControllerEndpoint(operation = "修改租户信息", exceptionMessage = "修改租户信息失败")
    @PostMapping("updateLesseeDetails")
    @ResponseBody
    public Body updateLesseeDetails(Lessee lessee) {
        return this.lesseeService.updateLesseeDetails(lessee);
    }
}
