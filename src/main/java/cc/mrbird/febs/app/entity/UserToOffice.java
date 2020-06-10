package cc.mrbird.febs.app.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 10:08:20
 */
@Data
@TableName("t_user_to_office")
public class UserToOffice {

    /**
     * 关联用户和所管理的办公室
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 办公室id
     */
    @TableField("ofiice_id")
    private Integer ofiiceId;

}
