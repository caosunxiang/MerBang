package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.UserToBuilding;
import cc.mrbird.febs.app.service.IUserToBuildingService;
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
 * @date 2020-05-08 10:16:51
 */
@Slf4j
@Validated
@Controller
@CrossOrigin
@RequestMapping("app")
@RequiredArgsConstructor
public class UserToBuildingController extends BaseController {

    private final IUserToBuildingService userToBuildingService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "userToBuilding")
    public String userToBuildingIndex() {
        return FebsUtil.view("userToBuilding/userToBuilding");
    }

    @GetMapping("userToBuilding")
    @ResponseBody
    @RequiresPermissions("userToBuilding:list")
    public FebsResponse getAllUserToBuildings(UserToBuilding userToBuilding) {
        return new FebsResponse().success().data(userToBuildingService.findUserToBuildings(userToBuilding));
    }

    @GetMapping("userToBuilding/list")
    @ResponseBody
    @RequiresPermissions("userToBuilding:list")
    public FebsResponse userToBuildingList(QueryRequest request, UserToBuilding userToBuilding) {
        Map<String, Object> dataTable = getDataTable(this.userToBuildingService.findUserToBuildings(request,
                userToBuilding));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增UserToBuilding", exceptionMessage = "新增UserToBuilding失败")
    @PostMapping("userToBuilding")
    @ResponseBody
    @RequiresPermissions("userToBuilding:add")
    public FebsResponse addUserToBuilding(@Valid UserToBuilding userToBuilding) {
        this.userToBuildingService.createUserToBuilding(userToBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除UserToBuilding", exceptionMessage = "删除UserToBuilding失败")
    @GetMapping("userToBuilding/delete")
    @ResponseBody
    @RequiresPermissions("userToBuilding:delete")
    public FebsResponse deleteUserToBuilding(UserToBuilding userToBuilding) {
        this.userToBuildingService.deleteUserToBuilding(userToBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改UserToBuilding", exceptionMessage = "修改UserToBuilding失败")
    @PostMapping("userToBuilding/update")
    @ResponseBody
    @RequiresPermissions("userToBuilding:update")
    public FebsResponse updateUserToBuilding(UserToBuilding userToBuilding) {
        this.userToBuildingService.updateUserToBuilding(userToBuilding);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改UserToBuilding", exceptionMessage = "导出Excel失败")
    @PostMapping("userToBuilding/excel")
    @ResponseBody
    @RequiresPermissions("userToBuilding:export")
    public void export(QueryRequest queryRequest, UserToBuilding userToBuilding, HttpServletResponse response) {
        List<UserToBuilding> userToBuildings = this.userToBuildingService.findUserToBuildings(queryRequest,
                userToBuilding).getRecords();
        ExcelKit.$Export(UserToBuilding.class, response).downXlsx(userToBuildings, false);
    }

    //    @ControllerEndpoint(operation = "租户页面查询写字楼", exceptionMessage = "租户页面查询写字楼失败")
//    @GetMapping("selectBuildingInLessee")
//    @ResponseBody
    public Body selectBuildingInLessee(String name) {
        return this.userToBuildingService.selectBuildingInLessee(name);
    }
}
