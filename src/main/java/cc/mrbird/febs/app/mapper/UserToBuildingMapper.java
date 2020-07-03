package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.UserToBuilding;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 10:16:51
 */
public interface UserToBuildingMapper extends BaseMapper<UserToBuilding> {

    /**
     * @Description: 租户页面查找写字楼信息
     * @Param: [name]
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @Author: 冷酷的苹果
     * @Date: 2020/5/8 10:32
     */
    public List<Map<String, Object>> selectBuildingInLessee(@Param("name") String name);

}
