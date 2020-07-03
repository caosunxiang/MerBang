package cc.mrbird.febs.app.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 16:04:13
 */
@Data
@TableName("t_apply")
public class Apply {

    /**
     * 申请
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 办公室id
     */
    @TableField("office_id")
    private Integer officeId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 状态
     */
    @TableField("state")
    private String state;

}
