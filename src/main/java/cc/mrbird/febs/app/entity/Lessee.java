package cc.mrbird.febs.app.entity;

import java.math.BigDecimal;
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
 * @date 2020-05-08 16:04:09
 */
@Data
@TableName("t_lessee")
public class Lessee {

    /**
     * 住户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 租户名称
     */
    @TableField("name")
    private String name;

    /**
     * 租户联系方式
     */
    @TableField("contacts")
    private String contacts;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private String createTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private String endTime;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 预收
     */
    @TableField("accepting")
    private BigDecimal accepting;

}
