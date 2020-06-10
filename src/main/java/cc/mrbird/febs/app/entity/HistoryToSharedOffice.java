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
 * @date 2020-05-06 09:18:05
 */
@Data
@TableName("t_history_to_shared_office")
public class HistoryToSharedOffice {

    /**
     * 共享办公搜索记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 查询人
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 状态   A可用   X不可用
     */
    @TableField("state")
    private String state;

}
