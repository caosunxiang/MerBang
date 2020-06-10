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
 * @date 2020-05-06 09:17:12
 */
@Data
@TableName("t_label_to_office")
public class LabelToOffice {

    /**
     * 关联办公室信息与标签
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 办公室标签id
     */
    @TableField("office_label_id")
    private Integer officeLabelId;

    /**
     * 办公室id
     */
    @TableField("office_id")
    private Integer officeId;

}
