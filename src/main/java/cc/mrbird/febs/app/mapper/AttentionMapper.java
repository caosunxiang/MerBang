package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.AUser;
import cc.mrbird.febs.app.entity.Attention;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-07 16:30:04
 */
public interface AttentionMapper extends BaseMapper<Attention> {

    Integer selectCountByOffice(@Param("userid") Integer userId);


    List<AUser> selectByOfficeBuilding(@Param("phone") String phone, @Param("id") Integer id);

    List<Map<String, Object>> selectBuildingInLessee(@Param("name") String name, @Param("id") Integer id);

    List<Map<String, Object>> selectUserByType(@Param("type") String type, @Param("id") Integer id);


    List<Map<String, Object>> selectHouseInSet(@Param("id") Integer id);
}
