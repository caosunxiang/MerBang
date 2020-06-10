package cc.mrbird.febs.app.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:53
 */
@Data
@TableName("t_office_to_picture")
public class OfficeToPicture {

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
     * 办公室id
     */
    @TableField("office_id")
    private Integer officeId;

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
     * 详情
     */
    @TableField("introduce")
    private String introduce;

}
