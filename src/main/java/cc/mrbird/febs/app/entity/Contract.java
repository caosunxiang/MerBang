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
 * @date 2020-05-18 14:04:02
 */
@Data
@TableName("t_contract")
public class Contract {

    /**
     * 合同id
     */
    @TableId(value = "contract_id", type = IdType.AUTO)
    private Integer contractId;


    /**
     * 租户id
     */
    @TableField("lessee_id")
    private Integer lesseeId;

    /**
     * 收款状态   A未付B已付C结清
     */
    @TableField("state")
    private String state;

    /**
     * 当前时间
账单所属时间
     */
    @TableField("time")
    private String time;


    /**
     * 规则
     */
    @TableField("rule_id")
    private Integer ruleId;

    /**
     * 房间id
     */
    @TableField("room")
    private Integer room;

}
