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
 * @date 2020-05-06 09:17:50
 */
@Data
@TableName("t_label_to_shared_office")
public class LabelToSharedOffice {

    /**
     * 关联共享办公与标签
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 共享办公标签id
     */
    @TableField("shared_office_label_id")
    private Integer sharedOfficeLabelId;

    /**
     * 共享办公
     */
    @TableField("shared_office_id")
    private Integer sharedOfficeId;

}
