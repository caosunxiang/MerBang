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
 * @date 2020-05-19 16:18:23
 */
@Data
@TableName("t_addition")
public class Addition {

    /**
     * 物业费明细
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 开始时间
     */
    @TableField("start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private Date endTime;

    /**
     * 款项类别
     */
    @TableField("cost_addition")
    private String costAddition;

    /**
     * 物业费单
     */
    @TableField("cost")
    private BigDecimal cost;
    /**
     * 价格
     */
    @TableField("price")
    private BigDecimal price;
}
