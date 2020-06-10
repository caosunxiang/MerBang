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
 * @date 2020-05-07 16:30:08
 */
@Data
@TableName("t_district_to_shared_office")
public class DistrictToSharedOffice {

    /**
     * 
     */
    @TableId(value = "district_to_shared_office_id", type = IdType.AUTO)
    private Integer districtToSharedOfficeId;

    /**
     * 
     */
    @TableField("district_id")
    private Integer districtId;

    /**
     * 
     */
    @TableField("shared_office_id")
    private Integer sharedOfficeId;

}
