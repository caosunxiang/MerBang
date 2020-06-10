package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.Attention;
import cc.mrbird.febs.app.service.IAttentionService;
import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
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
 * @date 2020-05-07 16:30:04
 */
@Slf4j
@Validated
@Controller
@CrossOrigin
@RequestMapping("app")
@RequiredArgsConstructor
public class AttentionController extends BaseController {

    private final IAttentionService attentionService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "attention")
    public String attentionIndex() {
        return FebsUtil.view("attention/attention");
    }

    @GetMapping("attention")
    @ResponseBody
    @RequiresPermissions("attention:list")
    public FebsResponse getAllAttentions(Attention attention) {
        return new FebsResponse().success().data(attentionService.findAttentions(attention));
    }

    @GetMapping("attention/list")
    @ResponseBody
    @RequiresPermissions("attention:list")
    public FebsResponse attentionList(QueryRequest request, Attention attention) {
        Map<String, Object> dataTable = getDataTable(this.attentionService.findAttentions(request, attention));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Attention", exceptionMessage = "新增Attention失败")
    @PostMapping("attention")
    @ResponseBody
    @RequiresPermissions("attention:add")
    public FebsResponse addAttention(@Valid Attention attention) {
        this.attentionService.createAttention(attention);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Attention", exceptionMessage = "删除Attention失败")
    @GetMapping("attention/delete")
    @ResponseBody
    @RequiresPermissions("attention:delete")
    public FebsResponse deleteAttention(Attention attention) {
        this.attentionService.deleteAttention(attention);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Attention", exceptionMessage = "修改Attention失败")
    @PostMapping("attention/update")
    @ResponseBody
    @RequiresPermissions("attention:update")
    public FebsResponse updateAttention(Attention attention) {
        this.attentionService.updateAttention(attention);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Attention", exceptionMessage = "导出Excel失败")
    @PostMapping("attention/excel")
    @ResponseBody
    @RequiresPermissions("attention:export")

    public void export(QueryRequest queryRequest, Attention attention, HttpServletResponse response) {
        List<Attention> attentions = this.attentionService.findAttentions(queryRequest, attention).getRecords();
        ExcelKit.$Export(Attention.class, response).downXlsx(attentions, false);
    }

    @ControllerEndpoint(operation = "查询指定写字楼关注", exceptionMessage = "查询指定写字楼关注失败")
    @GetMapping("selectByOfficeBuilding")
    @ResponseBody
    public Body selectByOfficeBuilding(String phone, Integer id) {
        return this.attentionService.selectByOfficeBuilding(phone, id);
    }

    @ControllerEndpoint(operation = "租户页面查询写字楼", exceptionMessage = "租户页面查询写字楼失败")
    @GetMapping("selectBuildingInLessee")
    @ResponseBody
    public Body selectBuildingInLessee(String name, Integer id) {
        return this.attentionService.selectBuildingInLessee(name, id);
    }

    @ControllerEndpoint(operation = "查询房源管理员", exceptionMessage = "查询房源管理员失败")
    @GetMapping("selectUserByType")
    @ResponseBody
    public Body selectUserByType(String type, Integer id) {
        return this.attentionService.selectUserByType(type, id);
    }

    @ControllerEndpoint(operation = "添加房源管理员", exceptionMessage = "添加房源管理员失败")
    @PostMapping("insertAttention")
    @ResponseBody
    public Body insertAttention(Attention attention, Integer id) {
        return this.attentionService.insertAttention(attention, id);
    }

    @ControllerEndpoint(operation = "删除房源管理员", exceptionMessage = "删除房源管理员失败")
    @PostMapping("delectUser")
    @ResponseBody
    public Body delectUser(Integer userid, Integer id) {
        return attentionService.delectUser(userid, id);
    }

    /**
     * @Description: 查询用户下管理的房源
     * @Param: [userid]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/16 13:48
     */
    @ControllerEndpoint(operation = "查询用户下管理的房源", exceptionMessage = "查询用户下管理的房源失败")
    @GetMapping("selectAttentionByUserid")
    @ResponseBody
    public Body selectAttentionByUserid(Integer userid) {
        return this.attentionService.selectAttentionByUserid(userid);
    }

    /**
     * @Description:
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/22 16:37
     */
    @ControllerEndpoint(operation = "查询旗下的房源", exceptionMessage = "查询旗下的房源失败")
    @GetMapping("selectHouseInSet")
    @ResponseBody
    public Body selectHouseInSet(Integer id) {
        return this.attentionService.selectHouseInSet(id);
    }
}
