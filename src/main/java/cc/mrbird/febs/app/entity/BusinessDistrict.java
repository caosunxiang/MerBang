package cc.mrbird.febs.app.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 11:24:48
 */
@Data
@TableName("t_business_district")
public class BusinessDistrict {

    /**
     * 商圈id
     */
    @TableId(value = "business_district_id", type = IdType.AUTO)
    private Integer businessDistrictId;

    /**
     * 商圈名称
     */
    @TableField("name")
    private String name;

    /**
     * 商区热度
     */
    @TableField("hot")
    private Integer hot;

    /**
     * 商圈创建时间
     */
    @TableField("creation_time")
    private String creationTime;

    /**
     * 状态  可用 A  不可用 X
     */
    @TableField("state")
    private String state;

    /**
     * 所属城市
     */
    @TableField("city")
    private String city;

}
