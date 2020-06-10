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
 * @date 2020-04-30 17:22:24
 */
@Data
@TableName("t_office_building")
public class OfficeBuilding {

    /**
     * 写字楼id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 写字楼名字
     */
    @TableField("name")
    private String name;

    /**
     * 写字楼创建时间
     */
    @TableField("creation_time")
    private String creationTime;

    /**
     * 写字楼修改时间
     */
    @TableField("update_time")
    private String updateTime;

    /**
     * 写字楼状态  A-在用;X-删除
     */
    @TableField("state")
    private String state;

    /**
     * 写字楼创建人id
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * 写字楼价格
     */
    @TableField("price")
    private String price;

    /**
     * 写字楼面积
     */
    @TableField("area")
    private String area;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 写字楼简介
     */
    @TableField("about")
    private String about;

    /**
     * 写字楼经度
     */
    @TableField("log")
    private String log;

    /**
     * 写字楼纬度
     */
    @TableField("lat")
    private String lat;

    /**
     * 写字楼位置
     */
    @TableField("address")
    private String address;

    /**
     * 装修状态
     */
    @TableField("fitment")
    private String fitment;

    /**
     * 人数
     */
    @TableField("person")
    private String person;

    /**
     * 图片
     */
    @TableField("picture")
    private String picture;
}
