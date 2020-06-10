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
 * @date 2020-05-19 13:56:57
 */
@Data
@TableName("t_order")
public class Order {

    /**
     * 支付凭证id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 付款方
     */
    @TableField("payer")
    private String payer;

    /**
     * 实收日期
     */
    @TableField("paid_in_date")
    private String paidInDate;

    /**
     * 实收租金
     */
    @TableField("paid_in_price")
    private BigDecimal paidInPrice;
    /**
     * 发票
     */
    @TableField("invoice")
    private String invoice;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 租金账单
     */
    @TableField("contract_id")
    private Integer contractId;

}
