package cc.mrbird.febs.app.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Entity
 *
 * @author 冷酷的苹果
 * @date 2020-05-18 09:55:16
 */
@Data
@TableName("t_invoice")
public class Invoice {

    /**
     * 凭证id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 租户id
     */
    @TableField("lessee_id")
    private Integer lesseeId;

    /**
     * 公司名称
     */
    @TableField("name")
    private String name;

    /**
     * 识别码
     */
    @TableField("heading_code")
    private String headingCode;

    /**
     * 银行
     */
    @TableField("bank")
    private String bank;

    /**
     * 银行账号
     */
    @TableField("bank_no")
    private String bankNo;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 手机
     */
    @TableField("phone")
    private String phone;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

}
