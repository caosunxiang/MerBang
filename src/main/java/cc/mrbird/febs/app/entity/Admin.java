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
 * @date 2020-05-06 09:17:33
 */
@Data
@TableName("t_admin")
public class Admin {

    /**
     * 管理员名称
     */
    @TableField("name")
    private String name;

    /**
     * 版本号
     */
    @TableField("version")
    private String version;

    /**
     * 图片
     */
    @TableField("picture")
    private String picture;

    /**
     * 描述
     */
    @TableField("about")
    private String about;

}
