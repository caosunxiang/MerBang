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
 * @date 2020-05-14 15:23:01
 */
@Data
@TableName("t_lease_to_office")
public class LeaseToOffice {

    /**
     * 办公室租约信息id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 押付方式
     */
    @TableField("pay_way")
    private String payWay;

    /**
     * 租赁税
     */
    @TableField("lease_tax")
    private String leaseTax;

    /**
     * 免租期
     */
    @TableField("rent_holiday")
    private String rentHoliday;

    /**
     * 最短租期
     */
    @TableField("shortest_lease")
    private String shortestLease;

    /**
     * 最早
     */
    @TableField("earliest_lease")
    private String earliestLease;

    /**
     * 参观时减
     */
    @TableField("visit_time")
    private String visitTime;

    /**
     * 办公室id
     */
    @TableField("office_id")
    private Integer officeId;

}
