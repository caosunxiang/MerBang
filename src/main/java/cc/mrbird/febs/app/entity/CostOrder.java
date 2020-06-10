package cc.mrbird.febs.app.entity;

import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 16:18:25
 */
@Data
@TableName("t_cost_order")
public class CostOrder {

    /**
     * 物业费账单
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 付款方
     */
    @TableField("payer")
    private String payer;

    /**
     * 付款时间
     */
    @TableField("pay_time")
    private String payTime;

    /**
     * 付款金额
     */
    @TableField("price")
    private BigDecimal price;
    /**
     * 付款凭证
     */
    @TableField("invoice")
    private String invoice;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 物业费账单
     */
    @TableField("cost")
    private Integer cost;

}
