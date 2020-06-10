package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.OfficeToPicture;
import cc.mrbird.febs.app.service.IOfficeToPictureService;
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
 * @date 2020-05-06 09:17:53
 */
@Slf4j
@Validated
@Controller
@CrossOrigin
@RequestMapping("app")
@RequiredArgsConstructor
public class OfficeToPictureController extends BaseController {

    private final IOfficeToPictureService officeToPictureService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "officeToPicture")
    public String officeToPictureIndex(){
        return FebsUtil.view("officeToPicture/officeToPicture");
    }

    @GetMapping("officeToPicture")
    @ResponseBody
    @RequiresPermissions("officeToPicture:list")
    public FebsResponse getAllOfficeToPictures(OfficeToPicture officeToPicture) {
        return new FebsResponse().success().data(officeToPictureService.findOfficeToPictures(officeToPicture));
    }

    @GetMapping("officeToPicture/list")
    @ResponseBody
    @RequiresPermissions("officeToPicture:list")
    public FebsResponse officeToPictureList(QueryRequest request, OfficeToPicture officeToPicture) {
        Map<String, Object> dataTable = getDataTable(this.officeToPictureService.findOfficeToPictures(request, officeToPicture));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增OfficeToPicture", exceptionMessage = "新增OfficeToPicture失败")
    @PostMapping("officeToPicture")
    @ResponseBody
    @RequiresPermissions("officeToPicture:add")
    public FebsResponse addOfficeToPicture(@Valid OfficeToPicture officeToPicture) {
        this.officeToPictureService.createOfficeToPicture(officeToPicture);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OfficeToPicture", exceptionMessage = "删除OfficeToPicture失败")
    @GetMapping("officeToPicture/delete")
    @ResponseBody
    @RequiresPermissions("officeToPicture:delete")
    public FebsResponse deleteOfficeToPicture(OfficeToPicture officeToPicture) {
        this.officeToPictureService.deleteOfficeToPicture(officeToPicture);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeToPicture", exceptionMessage = "修改OfficeToPicture失败")
    @PostMapping("officeToPicture/update")
    @ResponseBody
    @RequiresPermissions("officeToPicture:update")
    public FebsResponse updateOfficeToPicture(OfficeToPicture officeToPicture) {
        this.officeToPictureService.updateOfficeToPicture(officeToPicture);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeToPicture", exceptionMessage = "导出Excel失败")
    @PostMapping("officeToPicture/excel")
    @ResponseBody
    @RequiresPermissions("officeToPicture:export")
    public void export(QueryRequest queryRequest, OfficeToPicture officeToPicture, HttpServletResponse response) {
        List<OfficeToPicture> officeToPictures = this.officeToPictureService.findOfficeToPictures(queryRequest, officeToPicture).getRecords();
        ExcelKit.$Export(OfficeToPicture.class, response).downXlsx(officeToPictures, false);
    }
    @ControllerEndpoint(operation = "上传办公室照片", exceptionMessage = "上传办公室照片失败")
    @PostMapping("uploadOfficeIntroduce")
    @ResponseBody
    public Body uploadOfficeIntroduce(String picture, Integer userId, Integer office, String introduce) {
        return this.officeToPictureService.uploadIntroduce(picture,userId,office,introduce);
    }

    @ControllerEndpoint(operation = "查询指定楼照片", exceptionMessage = "查询指定办公室照片失败")
    @GetMapping("selectPictureByofficeId")
    @ResponseBody
    public Body selectPictureByofficeId(Integer id) {
        return this.officeToPictureService.selectByofficeBuildingId(id);
    }


    @ControllerEndpoint(operation = "删除指定办公室照片", exceptionMessage = "删除指定办公室照片失败")
    @PostMapping("deleteOfficePicture")
    @ResponseBody
    public Body deleteOfficePicture(Integer Id) {
        return this.officeToPictureService.deleteOfficePicture(Id);
    }
}
