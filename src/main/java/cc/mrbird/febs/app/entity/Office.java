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
 * @date 2020-05-06 09:16:31
 */
@Data
@TableName("t_office")
public class Office {

    /**
     * 办公室信息id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 办公室名称
     */
    @TableField("name")
    private String name;

    /**
     * 办公室信息创建时间
     */
    @TableField("creation_time")
    private String creationTime;

    /**
     * 办公室信息修改时间
     */
    @TableField("update_time")
    private String updateTime;

    /**
     * 显示状态  A-在用;X-删除
     */
    @TableField("state")
    private String state;

    /**
     * 消息创建人id
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * 所属的公共办公区域id
     */
    @TableField("shared_office_id")
    private Integer sharedOfficeId;

    /**
     * 所属的写字楼id
     */
    @TableField("office_building")
    private Integer officeBuilding;

    /**
     * 办公室价格
     */
    @TableField("price")
    private String price;

    /**
     * 办公室面积
     */
    @TableField("area")
    private String area;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 办公室简介
     */
    @TableField("about")
    private String about;

    /**
     * 办公室经度
     */
    @TableField("log")
    private String log;

    /**
     * 办公室纬度
     */
    @TableField("lat")
    private String lat;

    /**
     * 办公室位置
     */
    @TableField("address")
    private String address;

    /**
     * 办公室租赁状态
     */
    @TableField("type")
    private String type;

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
     * 照片
     */
    @TableField("picture")
    private String picture;

    /**
     * 到期时间
     */
    @TableField("end_time")
    private String endTime;

    /**
     * 用户
     */
    @TableField("user_id")
    private String userId;
    /**
     * 楼层
     */
    @TableField("floor")
    private String floor;
    /**
     * 门牌号
     */
    @TableField("door")
    private String door;

    /**
     * 开窗方向
     */
    @TableField("direction")
    private String direction;
    /**
     * 格局
     */
    @TableField("pattern")
    private String pattern;
    /**
     * 佣金
     */
    @TableField("commission")
    private String commission;
    /**
     * 实用率
     */
    @TableField("rate")
    private String rate;

    @TableField(exist = false)
    private Integer fid;

    @TableField(exist = false)
    private Integer floorid;

}
