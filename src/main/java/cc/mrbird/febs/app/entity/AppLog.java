package cc.mrbird.febs.app.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:21
 */
@Data
@TableName("t_app_log")
public class AppLog {

    /**
     * 操作记录
     */
    @TableId(value = "app_log_id", type = IdType.AUTO)
    private Integer appLogId;

    /**
     * 操作内容
     */
    @TableField("content")
    private String content;

    /**
     * 操作时间
     */
    @TableField("create_time")
    private String createTime;

    /**
     * 操作人
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 房源id
     */
    @TableField("house")
    private Integer house⁯;

}
