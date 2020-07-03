package cc.mrbird.febs.app.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-07 16:30:04
 */
@Data
@TableName("t_attention")
public class Attention {

    /**
     * 关注id
     */
    @TableId(value = "attention_id", type = IdType.AUTO)
    private Integer attentionId;

    /**
     * 谁关注
     */
    @TableField("attention_user")
    private Integer attentionUser;

    /**
     * 关注谁
     */
    @TableField("attention_label")
    private Integer attentionLabel;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private String createTime;

    /**
     * 关注的什么  A办公楼  B共享办公  C办公室
     */
    @TableField("attention_type")
    private String attentionType;

}
