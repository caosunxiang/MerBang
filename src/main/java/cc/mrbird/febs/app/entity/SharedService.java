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
 * @date 2020-05-15 15:53:58
 */
@Data
@TableName("t_shared_service")
public class SharedService {

    /**
     * 共享服务id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 共享类别
     */
    @TableField("shared_type")
    private Integer sharedType;

    /**
     * 图
     */
    @TableField("picture")
    private String picture;
    /**
     * 名
     */
    @TableField("name")
    private String name;

    /**
     * 状态  A可用  X禁用
     */
    @TableField("state")
    private String state;

    /**
     * 热度
     */
    @TableField("hot")
    private Integer hot;

}
