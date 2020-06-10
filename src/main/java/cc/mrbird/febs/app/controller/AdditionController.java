package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Addition;
import cc.mrbird.febs.app.service.IAdditionService;
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
 * @date 2020-05-19 16:18:23
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class AdditionController extends BaseController {

    private final IAdditionService additionService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "addition")
    public String additionIndex() {
        return FebsUtil.view("addition/addition");
    }

    @GetMapping("addition")
    @ResponseBody
    @RequiresPermissions("addition:list")
    public FebsResponse getAllAdditions(Addition addition) {
        return new FebsResponse().success().data(additionService.findAdditions(addition));
    }

    @GetMapping("addition/list")
    @ResponseBody
    @RequiresPermissions("addition:list")
    public FebsResponse additionList(QueryRequest request, Addition addition) {
        Map<String, Object> dataTable = getDataTable(this.additionService.findAdditions(request, addition));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Addition", exceptionMessage = "新增Addition失败")
    @PostMapping("addition")
    @ResponseBody
    @RequiresPermissions("addition:add")
    public FebsResponse addAddition(@Valid Addition addition) {
        this.additionService.createAddition(addition);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Addition", exceptionMessage = "删除Addition失败")
    @GetMapping("addition/delete")
    @ResponseBody
    @RequiresPermissions("addition:delete")
    public FebsResponse deleteAddition(Addition addition) {
        this.additionService.deleteAddition(addition);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Addition", exceptionMessage = "修改Addition失败")
    @PostMapping("addition/update")
    @ResponseBody
    @RequiresPermissions("addition:update")
    public FebsResponse updateAddition(Addition addition) {
        this.additionService.updateAddition(addition);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Addition", exceptionMessage = "导出Excel失败")
    @PostMapping("addition/excel")
    @ResponseBody
    @RequiresPermissions("addition:export")
    public void export(QueryRequest queryRequest, Addition addition, HttpServletResponse response) {
        List<Addition> additions = this.additionService.findAdditions(queryRequest, addition).getRecords();
        ExcelKit.$Export(Addition.class, response).downXlsx(additions, false);
    }

    /**
     * @Description:
     * @Param: [addition]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 17:35
     */
    @ControllerEndpoint(operation = "添加物业费附加款项", exceptionMessage = "添加物业费附加款项失败")
    @PostMapping("insertAddition")
    @ResponseBody
    public Body insertAddition(Addition addition) {
        return this.additionService.insertAddition(addition);
    }

    /**
     * @Description:
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 17:35
     */
    @ControllerEndpoint(operation = "删除物业费附加款项", exceptionMessage = "删除物业费附加款项失败")
    @PostMapping("delectAddition")
    @ResponseBody
    public Body delectAddition(Integer id) {
        return this.additionService.delectAddition(id);
    }

    /**
     * @Description:
     * @Param: [costId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 17:35
     */
    @ControllerEndpoint(operation = "查找物业费附加款项", exceptionMessage = "查找物业费附加款项失败")
    @GetMapping("selectAdditionByCostId")
    @ResponseBody
    public Body selectAdditionByCostId(Integer costId) {
        return this.additionService.selectAdditionByCostId(costId);
    }

}
