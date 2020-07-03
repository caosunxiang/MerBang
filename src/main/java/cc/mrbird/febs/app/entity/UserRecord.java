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
 * @date 2020-05-06 09:17:27
 */
@Data
@TableName("t_user_record")
public class UserRecord {

    /**
     * 操作记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 操作人
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 操作时间
     */
    @TableField("creation_time")
    private Date creationTime;

    /**
     * 操作备注
     */
    @TableField("remark")
    private String remark;

}
