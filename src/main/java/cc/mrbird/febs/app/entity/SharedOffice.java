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
 * @date 2020-05-06 09:17:09
 */
@Data
@TableName("t_shared_office")
public class SharedOffice {

    /**
     * 共享办公id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 共享办公名称
     */
    @TableField("name")
    private String name;

    /**
     * 共享办公创建时间
     */
    @TableField("creation_time")
    private String creationTime;

    /**
     * 共享办公修改时间
     */
    @TableField("update_time")
    private String updateTime;

    /**
     * 显示状态   A-在用;
     * X-删除
     */
    @TableField("state")
    private String state;

    /**
     * 消息创建人id
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * 所属的写字楼id
     */
    @TableField("office_building")
    private Integer officeBuilding;

    /**
     * 共享办公价格
     */
    @TableField("price")
    private String price;

    /**
     * 共享办公面积
     */
    @TableField("area")
    private String area;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 共享办公简介
     */
    @TableField("about")
    private String about;

    /**
     * 共享办公经度
     */
    @TableField("log")
    private String log;

    /**
     * 共享办公纬度
     */
    @TableField("lat")
    private String lat;

    /**
     * 共享办公位置
     */
    @TableField("address")
    private String address;

    /**
     * 照片
     */
    @TableField("picture")
    private String picture;

    /**
     * 类型 A独立办公  B开放工位
     */
    @TableField("type")
    private String type;

    /**
     * 装修风格
     */
    @TableField("fitment")
    private String fitment;
    /**
     * 前台
     */
    @TableField("reception")
    private String reception;
    /**
     * 会议室
     */
    @TableField("meeting_room")
    private String meetingRoom;

}
