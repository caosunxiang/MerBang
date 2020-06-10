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
 * @date 2020-05-19 16:18:21
 */
@Data
@TableName("t_cost")
public class Cost {

    /**
     * 物业单id
     */
    @TableId(value = "cost_id", type = IdType.AUTO)
    private Integer costId;

    /**
     * 写字楼id
     */
    @TableField("office_building_id")
    private Integer officeBuildingId;

    /**
     * 共享办公id
     */
    @TableField("office_shared_id")
    private Integer officeSharedId;

    /**
     * 办公室id
     */
    @TableField("office")
    private String office;

    /**
     * 开始时间
     */
    @TableField("start_time")
    private String startTime;

    /**
     * 结束日期
     */
    @TableField("end_time")
    private String endTime;

    /**
     * 收款日期
     */
    @TableField("collection_time")
    private String collectionTime;

    /**
     * 收取金额
     */
    @TableField("price")
    private BigDecimal price;
    /**
     * 总价
     */
    @TableField(" total_prices")
    private BigDecimal  totalPrices;
    /**
     * 上次结余
     */
    @TableField("surplus")
    private BigDecimal surplus;
    /**
     * 状态   A可用   X不可用
     */
    @TableField("state")
    private String state;

    /**
     * 创建者
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * 缴费状态 1未交 2已交 3未交完
     */
    @TableField("type")
    private Integer type;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 实收
     */
    @TableField("receipts")
    private Integer receipts;

}
