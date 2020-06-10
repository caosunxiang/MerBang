package cc.mrbird.febs.app.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotBlank;

/**
 *  Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 13:40:43
 */
@Data
@TableName("t_floor")
public class Floor {

    /**
     * 楼层编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 层数
     */
    @TableField("name")
    private String name;

    /**
     * 面积
     */
    @TableField("area")
    private String area;

    /**
     * 写字楼
     */
    @TableField("floor_to_id")
    private Integer floorToBuildingId;

    /**
     * 所属类型  A  写字楼   B共享空间   C  办公室
     */
    @TableField("state")
    private String state;

}
