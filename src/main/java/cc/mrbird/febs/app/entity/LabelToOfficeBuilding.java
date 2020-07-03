package cc.mrbird.febs.app.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:39
 */
@Data
@TableName("t_label_to_office_building")
public class LabelToOfficeBuilding {

    /**
     * 关联写字楼与标签
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 写字楼标签id
     */
    @TableField("office_building_label_id")
    private Integer officeBuildingLabelId;

    /**
     * 写字楼id
     */
    @TableField("office_building_id")
    private Integer officeBuildingId;

}
