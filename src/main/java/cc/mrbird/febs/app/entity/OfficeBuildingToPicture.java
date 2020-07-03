package cc.mrbird.febs.app.entity;

import java.util.Date;

import cc.mrbird.febs.common.utils.json.Body;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:56
 */
@Data
@TableName("t_office_building_to_picture")
public class OfficeBuildingToPicture {

    /**
     * 图片id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片地址
     */
    @TableField("picture")
    private String picture;

    /**
     * 创建人
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * 办公楼id
     */
    @TableField("office_building_id")
    private Integer officeBuildingId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private String createTime;

    /**
     * 状态 A可用 X不可用
     */
    @TableField("state")
    private String state;

    /**
     * 描述
     */
    @TableField("introduce")
    private String introduce;

}
