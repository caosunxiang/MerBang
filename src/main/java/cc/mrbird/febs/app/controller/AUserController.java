package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.AUser;
import cc.mrbird.febs.app.service.IAUserService;
import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.DateUtil;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.utils.json.Body;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author MrBird
 * @date 2020-04-21 16:52:25
 */
@Slf4j
@Validated
@Controller
@RequestMapping("app")
@CrossOrigin
@RequiredArgsConstructor
public class AUserController extends BaseController {

    private final IAUserService aUserService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "aUser")
    public String aUserIndex() {
        return FebsUtil.view("aUser/aUser");
    }

    @GetMapping("aUser")
    @ResponseBody
    @RequiresPermissions("aUser:list")
    public FebsResponse getAllAUsers(AUser aUser) {
        return new FebsResponse().success().data(aUserService.findAUsers(aUser));
    }

    @GetMapping("aUser/list")
    @ResponseBody
    @RequiresPermissions("aUser:list")
    public FebsResponse aUserList(QueryRequest request, AUser aUser) {
        Map<String, Object> dataTable = getDataTable(this.aUserService.findAUsers(request, aUser));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增AUser", exceptionMessage = "新增AUser失败")
    @PostMapping("aUser")
    @ResponseBody
    @RequiresPermissions("aUser:add")
    public FebsResponse addAUser(@Valid AUser aUser) {
        this.aUserService.createAUser(aUser);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除AUser", exceptionMessage = "删除AUser失败")
    @GetMapping("aUser/delete")
    @ResponseBody
    @RequiresPermissions("aUser:delete")
    public FebsResponse deleteAUser(AUser aUser) {
        this.aUserService.deleteAUser(aUser);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改AUser", exceptionMessage = "修改AUser失败")
    @PostMapping("aUser/update")
    @ResponseBody
    @RequiresPermissions("aUser:update")
    public FebsResponse updateAUser(AUser aUser) {
        this.aUserService.updateAUser(aUser);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改AUser", exceptionMessage = "导出Excel失败")
    @PostMapping("aUser/excel")
    @ResponseBody
    @RequiresPermissions("aUser:export")
    public void export(QueryRequest queryRequest, AUser aUser, HttpServletResponse response) {
        List<AUser> aUsers = this.aUserService.findAUsers(queryRequest, aUser).getRecords();
        ExcelKit.$Export(AUser.class, response).downXlsx(aUsers, false);
    }


    @ControllerEndpoint(operation = "扫描二维码", exceptionMessage = "扫描失败")
    @PostMapping("scanQRCode")
    @ResponseBody
    public Body scanQRCode(String code,String userid) {
        return Body.newInstance(this.aUserService.scanQRCode(code,userid));
    }


    @ControllerEndpoint(operation = "查询指定人员信息", exceptionMessage = "查询指定人员信息失败")
    @GetMapping("getUserApp")
    @ResponseBody
    public Body selectByUserId(String userid) {
        return this.aUserService.appGetUser(userid);
    }

//    @ControllerEndpoint(operation = "操作成功", exceptionMessage = "操作失败")
    @PostMapping("insertUserApp")
    @ResponseBody
    public Body signInORLogin(AUser user) {
        user.setCreatedDate(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        user.setStateDate(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        user.setState("A");
        return this.aUserService.signInORLogin(user);
    }

    @ControllerEndpoint(operation = "修改个人信息", exceptionMessage = "修改失败")
    @PostMapping("updateUser")
    @ResponseBody
    public Body updateUser(AUser user) {
        return this.aUserService.updateUser(user);
    }

    @ControllerEndpoint(operation = "查询个人消息", exceptionMessage = "查询个人消息失败")
    @GetMapping("appGetUser")
    @ResponseBody
    public AUser appGetUser(String userid) {
        return this.aUserService.getById(userid);
    }

    @ControllerEndpoint(operation = "首页查询总面积", exceptionMessage = "首页查询消息失败")
    @GetMapping("selectAllAreaByUid")
    @ResponseBody
    public Body selectAllAreaByUid(Integer uId) {
        return this.aUserService.selectAllAreaByUid(uId);
    }

    @ControllerEndpoint(operation = "首页查询总房间数", exceptionMessage = "首页查询消息失败")
    @GetMapping("selectAllCountByUid")
    @ResponseBody
    public Body selectAllCountByUid(Integer uId) {
        return this.aUserService.selectAllCountByUid(uId);
    }


    @ControllerEndpoint(operation = "首页查询总百分比", exceptionMessage = "首页查询消息失败")
    @GetMapping("selectAllRateByUid")
    @ResponseBody
    public Body selectAllRateByUid(Integer uId) {
        return this.aUserService.selectAllRateByUid(uId);
    }

    @ControllerEndpoint(operation = "查询平均价", exceptionMessage = "查询个人消息失败")
    @GetMapping("selectAllPriceByUid")
    @ResponseBody
    public Body selectAllPriceByUid(Integer uId) {
        return this.aUserService.selectAllPriceByUid(uId);
    }

    @ControllerEndpoint(operation = "根据手机号查询用户信息", exceptionMessage = "根据手机号查询用户信息失败")
    @GetMapping("selectByPhone")
    @ResponseBody
    public Body selectByPhone(String phone) {
        return this.aUserService.selectByPhone(phone);
    }

    /**
     * @Description:
     * @Param: [userId, openid]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 9:19
     */
    @ControllerEndpoint(operation = "修改微信", exceptionMessage = "修改微信失败")
    @PostMapping("weChatEmpty")
    @ResponseBody
    public Body weChatEmpty(Integer userId, String openid) {
        return this.aUserService.weChatEmpty(userId, openid);
    }

    /**
     * @Description:
     * @Param: [userId, pwd]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 9:19
     */
    @ControllerEndpoint(operation = "重置密码", exceptionMessage = "重置密码失败")
    @PostMapping("resetPasswords")
    @ResponseBody
    public Body resetPasswords(Integer userId, String pwd) {
        return this.aUserService.resetPasswords(userId, pwd);
    }

    /**
     * @Description:
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/22 10:54
     */
    @ControllerEndpoint(operation = "首页查询最近", exceptionMessage = "首页查询最近失败")
    @GetMapping("homeStatisticsLately")
    @ResponseBody
    public Body homeStatisticsLately(Integer id) {
        return this.aUserService.homeStatisticsLately(id);
    }

    /**
     * @Description:
     * @Param: [id, month]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/22 10:54
     */
    @ControllerEndpoint(operation = "首页查询逾期", exceptionMessage = "首页查询逾期失败")
    @GetMapping("homeStatisticsPass")
    @ResponseBody
    public Body homeStatisticsPass(Integer id, Integer month) {
        return this.aUserService.homeStatisticsPass(id, month);
    }

    @ControllerEndpoint(operation = "跳转", exceptionMessage = "跳转失败")
    @GetMapping("openid")
    @ResponseBody
    public void openid(HttpServletRequest request, HttpServletResponse response) {
        String openid = request.getParameter("openid");
        Cookie cookie = new Cookie("openid", openid);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

    }
    @ControllerEndpoint(operation = "生成二维码", exceptionMessage = "生成二维码失败")
    @GetMapping("QRCode")
    @ResponseBody
    public Body QRCode(String data) {
        return this.aUserService.QRCode(data);
    }
}
