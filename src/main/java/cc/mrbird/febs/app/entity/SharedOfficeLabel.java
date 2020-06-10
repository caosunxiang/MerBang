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
 * @date 2020-05-15 14:45:20
 */
@Data
@TableName("t_shared_office_label")
public class SharedOfficeLabel {

    /**
     * 共享办公标签
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 共享办公标签名称
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
    private String creationTime;

    /**
     * 标签状态 A可以使用；X禁用
     */
    @TableField("state")
    private String state;

}
