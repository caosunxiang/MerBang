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
 * @date 2020-05-19 16:18:18
 */
@Data
@TableName("t_cost_addition")
public class CostAddition {

    /**
     * 收费单添加id
     */
    @TableId(value = "cost_addition_id", type = IdType.AUTO)
    private Integer costAdditionId;

    /**
     * 名字
     */
    @TableField("name")
    private String name;

    /**
     * 上级id
     */
    @TableField("pid")
    private Integer pid;

    /**
     * 上级id
     */
    @TableField("create_user")
    private Integer createUser;

}
