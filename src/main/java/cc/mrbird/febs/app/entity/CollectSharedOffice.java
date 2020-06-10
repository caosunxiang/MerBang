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
 * @date 2020-05-26 09:53:33
 */
@Data
@TableName("t_collect_shared_office")
public class CollectSharedOffice {

    /**
     * 
     */
    @TableId(value = "collect_id", type = IdType.AUTO)
    private Integer collectId;

    /**
     * 
     */
    @TableField("collect_user")
    private Integer collectUser;

    /**
     * 
     */
    @TableField("collect_shared_office_id")
    private Integer collectSharedOfficeId;

    /**
     * 
     */
    @TableField("create_time")
    private String createTime;

}
