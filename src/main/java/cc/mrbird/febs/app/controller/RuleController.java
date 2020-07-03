package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Rule;
import cc.mrbird.febs.app.service.IRuleService;
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
 * @date 2020-05-18 09:55:18
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class RuleController extends BaseController {

    private final IRuleService ruleService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "rule")
    public String ruleIndex() {
        return FebsUtil.view("rule/rule");
    }

    @GetMapping("rule")
    @ResponseBody
    @RequiresPermissions("rule:list")
    public FebsResponse getAllRules(Rule rule) {
        return new FebsResponse().success().data(ruleService.findRules(rule));
    }

    @GetMapping("rule/list")
    @ResponseBody
    @RequiresPermissions("rule:list")
    public FebsResponse ruleList(QueryRequest request, Rule rule) {
        Map<String, Object> dataTable = getDataTable(this.ruleService.findRules(request, rule));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Rule", exceptionMessage = "新增Rule失败")
    @PostMapping("rule")
    @ResponseBody
    @RequiresPermissions("rule:add")
    public FebsResponse addRule(@Valid Rule rule) {
        this.ruleService.createRule(rule);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Rule", exceptionMessage = "删除Rule失败")
    @GetMapping("rule/delete")
    @ResponseBody
    @RequiresPermissions("rule:delete")
    public FebsResponse deleteRule(Rule rule) {
        this.ruleService.deleteRule(rule);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Rule", exceptionMessage = "修改Rule失败")
    @PostMapping("rule/update")
    @ResponseBody
    @RequiresPermissions("rule:update")
    public FebsResponse updateRule(Rule rule) {
        this.ruleService.updateRule(rule);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Rule", exceptionMessage = "导出Excel失败")
    @PostMapping("rule/excel")
    @ResponseBody
    @RequiresPermissions("rule:export")
    public void export(QueryRequest queryRequest, Rule rule, HttpServletResponse response) {
        List<Rule> rules = this.ruleService.findRules(queryRequest, rule).getRecords();
        ExcelKit.$Export(Rule.class, response).downXlsx(rules, false);
    }

    @ControllerEndpoint(operation = "添加收租规则", exceptionMessage = "添加收租规则失败")
    @PostMapping("insertRule")
    @ResponseBody
    public Body insertRule(Rule rule, Integer userid, Integer house) {
        return this.ruleService.insertRule(rule, userid, house);
    }

    @ControllerEndpoint(operation = "修改收租规则", exceptionMessage = "修改收租规则失败")
    @PostMapping("updateRuleDetails")
    @ResponseBody
    public Body updateRuleDetails(Rule rule, Integer userid, Integer house) {
        return this.ruleService.updateRuleDetails(rule, userid, house);
    }

    @ControllerEndpoint(operation = "根据租户id查找收租规则", exceptionMessage = "根据租户id查找收租规则失败")
    @GetMapping("selectRule")
    @ResponseBody
    public Body selectRule(Integer lesseeId) {
        return this.ruleService.selectRule(lesseeId);
    }
}
