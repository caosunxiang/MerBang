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
 * @date 2020-05-07 16:30:14
 */
@Data
@TableName("t_metro_to_shared_office")
public class MetroToSharedOffice {

    /**
     * 
     */
    @TableId(value = "metro_to_shared_id", type = IdType.AUTO)
    private Integer metroToSharedId;

    /**
     * 
     */
    @TableField("metro_id")
    private Integer metroId;

    /**
     * 
     */
    @TableField("shared_office_id")
    private Integer sharedOfficeId;

}
