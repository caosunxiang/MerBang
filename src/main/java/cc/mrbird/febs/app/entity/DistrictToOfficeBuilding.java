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
 * @date 2020-05-06 09:17:36
 */
@Data
@TableName("t_district_to_office_building")
public class DistrictToOfficeBuilding {

    /**
     *  关联商圈与写字楼
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商圈id
     */
    @TableField("business_district_id")
    private Integer businessDistrictId;

    /**
     * 写字楼id
     */
    @TableField("office_building_id")
    private Integer officeBuildingId;

}
