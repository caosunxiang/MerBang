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
 * @date 2020-05-06 09:18:18
 */
@Data
@TableName("t_metro_to_office_building")
public class MetroToOfficeBuilding {

    /**
     * 关联地铁与写字楼
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地铁id
     */
    @TableField("metro_position_id")
    private Integer metroPositionId;

    /**
     * 写字楼id
     */
    @TableField("office_building_id")
    private Integer officeBuildingId;

}
