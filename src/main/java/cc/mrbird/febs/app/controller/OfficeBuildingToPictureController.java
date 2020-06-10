package cc.mrbird.febs.app.controller;

import cc.mrbird.febs.app.entity.OfficeBuildingToPicture;
import cc.mrbird.febs.app.service.IOfficeBuildingToPictureService;
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
 * @date 2020-05-06 09:17:56
 */
@Slf4j
@Validated
@Controller
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("app")
public class OfficeBuildingToPictureController extends BaseController {

    private final IOfficeBuildingToPictureService officeBuildingToPictureService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "officeBuildingToPicture")
    public String officeBuildingToPictureIndex() {
        return FebsUtil.view("officeBuildingToPicture/officeBuildingToPicture");
    }

    @GetMapping("officeBuildingToPicture")
    @ResponseBody
    @RequiresPermissions("officeBuildingToPicture:list")
    public FebsResponse getAllOfficeBuildingToPictures(OfficeBuildingToPicture officeBuildingToPicture) {
        return new FebsResponse().success().data(officeBuildingToPictureService.findOfficeBuildingToPictures(officeBuildingToPicture));
    }

    @GetMapping("officeBuildingToPicture/list")
    @ResponseBody
    @RequiresPermissions("officeBuildingToPicture:list")
    public FebsResponse officeBuildingToPictureList(QueryRequest request,
                                                    OfficeBuildingToPicture officeBuildingToPicture) {
        Map<String, Object> dataTable =
                getDataTable(this.officeBuildingToPictureService.findOfficeBuildingToPictures(request,
                        officeBuildingToPicture));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增OfficeBuildingToPicture", exceptionMessage = "新增OfficeBuildingToPicture失败")
    @PostMapping("officeBuildingToPicture")
    @ResponseBody
    @RequiresPermissions("officeBuildingToPicture:add")
    public FebsResponse addOfficeBuildingToPicture(@Valid OfficeBuildingToPicture officeBuildingToPicture) {
        this.officeBuildingToPictureService.createOfficeBuildingToPicture(officeBuildingToPicture);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OfficeBuildingToPicture", exceptionMessage = "删除OfficeBuildingToPicture失败")
    @GetMapping("officeBuildingToPicture/delete")
    @ResponseBody
    @RequiresPermissions("officeBuildingToPicture:delete")
    public FebsResponse deleteOfficeBuildingToPicture(OfficeBuildingToPicture officeBuildingToPicture) {
        this.officeBuildingToPictureService.deleteOfficeBuildingToPicture(officeBuildingToPicture);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeBuildingToPicture", exceptionMessage = "修改OfficeBuildingToPicture失败")
    @PostMapping("officeBuildingToPicture/update")
    @ResponseBody
    @RequiresPermissions("officeBuildingToPicture:update")
    public FebsResponse updateOfficeBuildingToPicture(OfficeBuildingToPicture officeBuildingToPicture) {
        this.officeBuildingToPictureService.updateOfficeBuildingToPicture(officeBuildingToPicture);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OfficeBuildingToPicture", exceptionMessage = "导出Excel失败")
    @PostMapping("officeBuildingToPicture/excel")
    @ResponseBody
    @RequiresPermissions("officeBuildingToPicture:export")
    public void export(QueryRequest queryRequest, OfficeBuildingToPicture officeBuildingToPicture,
                       HttpServletResponse response) {
        List<OfficeBuildingToPicture> officeBuildingToPictures =
                this.officeBuildingToPictureService.findOfficeBuildingToPictures(queryRequest,
                        officeBuildingToPicture).getRecords();
        ExcelKit.$Export(OfficeBuildingToPicture.class, response).downXlsx(officeBuildingToPictures, false);
    }

    @ControllerEndpoint(operation = "上传写字楼照片", exceptionMessage = "上传写字楼照片失败")
    @PostMapping("uploadIntroduce")
    @ResponseBody
    public Body uploadIntroduce(String picture, Integer userId, Integer officeBuilding, String introduce) {
        return this.officeBuildingToPictureService.uploadIntroduce(picture, userId, officeBuilding, introduce);
    }

    @ControllerEndpoint(operation = "查询指定写字楼照片", exceptionMessage = "查询指定写字楼照片失败")
    @GetMapping("selectPictureByofficeBuildingId")
    @ResponseBody
    public Body selectByofficeBuildingId(Integer id) {
        return this.officeBuildingToPictureService.selectByofficeBuildingId(id);
    }

    @ControllerEndpoint(operation = "删除指定写字楼照片", exceptionMessage = "删除指定写字楼照片失败")
    @PostMapping("deleteOfficeBuildingPicture")
    @ResponseBody
    public Body deleteOfficeBuildingPicture(Integer Id) {
        return this.officeBuildingToPictureService.deleteOfficeBuildingPicture(Id);
    }
}
