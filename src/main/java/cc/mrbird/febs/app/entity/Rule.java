package cc.mrbird.febs.app.entity;

import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-18 09:55:18
 */
@Data
@TableName("t_rule")
public class Rule {

    /**
     * 合同规则
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 开始时间
     */
    @TableField("start_time")
    private String startTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private String endTime;

    /**
     * 免租期
     */
    @TableField("rent_free")
    private String rentFree;

    /**
     * 租金
     */
    @TableField("price")
    private BigDecimal price;
    /**
     * 付款方式
     */
    @TableField("pay_type")
    private String payType;

    /**
     * 付款日期
     */
    @TableField("pay_time")
    private String payTime;

    /**
     * 保证金
     */
    @TableField("cash_price")
    private BigDecimal cashPrice;
    /**
     * 签属日期
     */
    @TableField("Signed_date")
    private String signedDate;

    /**
     * 附件
     */
    @TableField("accessory")
    private String accessory;
    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 租户信息
     */
    @TableField("lessee_id")
    private Integer lesseeId;

}
