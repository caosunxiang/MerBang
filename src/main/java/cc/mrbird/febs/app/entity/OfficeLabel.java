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
 * @date 2020-05-06 09:16:37
 */
@Data
@TableName("t_office_label")
public class OfficeLabel {

    /**
     * 房源标签id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标签内容
     */
    @TableField("name")
    private String name;

    /**
     * 标签热度
     */
    @TableField("hot")
    private Integer hot;

    /**
     * 标签创建时间
     */
    @TableField("creation_time")
    private Date creationTime;

    /**
     * 状态 A可以使用；X禁用
     */
    @TableField("state")
    private String state;

}
