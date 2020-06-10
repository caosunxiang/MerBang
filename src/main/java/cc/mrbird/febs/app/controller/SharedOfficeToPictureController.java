package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.SharedOfficeToPicture;
import cc.mrbird.febs.app.service.ISharedOfficeToPictureService;
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
 *  Controller
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:58
 */
@Slf4j
@Validated
@Controller
@CrossOrigin
@RequestMapping("app")
@RequiredArgsConstructor
public class SharedOfficeToPictureController extends BaseController {

    private final ISharedOfficeToPictureService sharedOfficeToPictureService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "sharedOfficeToPicture")
    public String sharedOfficeToPictureIndex(){
        return FebsUtil.view("sharedOfficeToPicture/sharedOfficeToPicture");
    }

    @GetMapping("sharedOfficeToPicture")
    @ResponseBody
    @RequiresPermissions("sharedOfficeToPicture:list")
    public FebsResponse getAllSharedOfficeToPictures(SharedOfficeToPicture sharedOfficeToPicture) {
        return new FebsResponse().success().data(sharedOfficeToPictureService.findSharedOfficeToPictures(sharedOfficeToPicture));
    }

    @GetMapping("sharedOfficeToPicture/list")
    @ResponseBody
    @RequiresPermissions("sharedOfficeToPicture:list")
    public FebsResponse sharedOfficeToPictureList(QueryRequest request, SharedOfficeToPicture sharedOfficeToPicture) {
        Map<String, Object> dataTable = getDataTable(this.sharedOfficeToPictureService.findSharedOfficeToPictures(request, sharedOfficeToPicture));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增SharedOfficeToPicture", exceptionMessage = "新增SharedOfficeToPicture失败")
    @PostMapping("sharedOfficeToPicture")
    @ResponseBody
    @RequiresPermissions("sharedOfficeToPicture:add")
    public FebsResponse addSharedOfficeToPicture(@Valid SharedOfficeToPicture sharedOfficeToPicture) {
        this.sharedOfficeToPictureService.createSharedOfficeToPicture(sharedOfficeToPicture);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除SharedOfficeToPicture", exceptionMessage = "删除SharedOfficeToPicture失败")
    @GetMapping("sharedOfficeToPicture/delete")
    @ResponseBody
    @RequiresPermissions("sharedOfficeToPicture:delete")
    public FebsResponse deleteSharedOfficeToPicture(SharedOfficeToPicture sharedOfficeToPicture) {
        this.sharedOfficeToPictureService.deleteSharedOfficeToPicture(sharedOfficeToPicture);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改SharedOfficeToPicture", exceptionMessage = "修改SharedOfficeToPicture失败")
    @PostMapping("sharedOfficeToPicture/update")
    @ResponseBody
    @RequiresPermissions("sharedOfficeToPicture:update")
    public FebsResponse updateSharedOfficeToPicture(SharedOfficeToPicture sharedOfficeToPicture) {
        this.sharedOfficeToPictureService.updateSharedOfficeToPicture(sharedOfficeToPicture);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改SharedOfficeToPicture", exceptionMessage = "导出Excel失败")
    @PostMapping("sharedOfficeToPicture/excel")
    @ResponseBody
    @RequiresPermissions("sharedOfficeToPicture:export")
    public void export(QueryRequest queryRequest, SharedOfficeToPicture sharedOfficeToPicture, HttpServletResponse response) {
        List<SharedOfficeToPicture> sharedOfficeToPictures = this.sharedOfficeToPictureService.findSharedOfficeToPictures(queryRequest, sharedOfficeToPicture).getRecords();
        ExcelKit.$Export(SharedOfficeToPicture.class, response).downXlsx(sharedOfficeToPictures, false);
    }

    @ControllerEndpoint(operation = "上传共享办公照片", exceptionMessage = "上传共享办公照片失败")
    @PostMapping("uploadSharedOfficeIntroduce")
    @ResponseBody
    public Body uploadSharedOfficeIntroduce(String picture, Integer userId, Integer sharedOffice, String introduce) {
        return this.sharedOfficeToPictureService.uploadIntroduce(picture,userId,sharedOffice,introduce);
    }

    @ControllerEndpoint(operation = "查询指定楼照片", exceptionMessage = "查询指定共享办公照片失败")
    @GetMapping("selectPictureBySharedOfficeId")
    @ResponseBody
    public Body selectPictureBySharedOfficeId(Integer id) {
        return this.sharedOfficeToPictureService.selectByofficeBuildingId(id);
    }

    @ControllerEndpoint(operation = "删除指定写字楼照片", exceptionMessage = "删除指定写字楼照片失败")
    @PostMapping("deleteSharedOfficePicture")
    @ResponseBody
    public Body deleteSharedOfficePicture(Integer Id) {
        return this.sharedOfficeToPictureService.deleteSharedOfficePicture(Id);
    }
}
