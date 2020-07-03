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
 * @date 2020-05-12 13:47:16
 */
@Data
@TableName("t_about_to_building")
public class AboutToBuilding {

    /**
     * 写字楼详细情况
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 写字楼id
     */
    @TableField("office_building_id")
    private Integer officeBuildingId;

    /**
     *
     */
    @TableField("end_time")
    private String endTime;

    /**
     *
     */
    @TableField("company")
    private String company;

    /**
     *
     */
    @TableField("price")
    private String price;
    /**
     *
     */
    @TableField("park")
    private String park;

    /**
     *
     */
    @TableField("park_price")
    private String parkPrice;
    /**
     *
     */
    @TableField("about")
    private String about;

}
