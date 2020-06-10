package cc.mrbird.febs.app.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotBlank;

/**
 * Entity
 *
 * @author 冷酷的苹果
 * @date 2020-04-21 16:52:25
 */
@Data
@TableName("a_user")
public class AUser {

    /**
     * 用户标识
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer id;

    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 微信用户的唯一标识，现在是28位，在此保留40
     */
    @TableField("openid")
    private String openid;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码（AES128加密）
     */
    @TableField("password")
    private String password;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 创建时间
     */
    @TableField("created_date")
    private String createdDate;

    /**
     * 状态日期
     */
    @TableField("state_date")
    private String stateDate;

    /**
     * 状态：
     * A-在用;
     * X-删除
     */
    @TableField("state")
    private String state;

    /**
     * 头像
     */
    @TableField("head")
    private String head;

    /**
     * 身份标识
     */
    @TableField("sex")
    private String sex;
}
