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
 * @date 2020-05-26 09:53:12
 */
@Data
@TableName("t_collect")
public class Collect {

    /**
     * 收藏表id
     */
    @TableId(value = "collect_id", type = IdType.AUTO)
    private Integer collectId;

    /**
     * 收藏者id
     */
    @TableField("collect_user")
    private Integer collectUser;

    /**
     * 收藏办公室id
     */
    @TableField("collect_office_building_id")
    private Integer collectOfficeBuildingId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private String createTime;

    /**
     * 热度
     */
    @TableField("hot")
    private String hot;

}
