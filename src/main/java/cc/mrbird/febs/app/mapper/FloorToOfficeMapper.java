package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.FloorToOffice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 13:40:47
 */
public interface FloorToOfficeMapper extends BaseMapper<FloorToOffice> {
    /**
     * @Description: 查询指定楼层下的办公室
     * @Param: [id]
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @Author: 冷酷的苹果
     * @Date: 2020/5/8 14:40
     */
    List<Map<String, Object>> selectOfficeByfloor(@Param("id") Integer id, @Param("fid") Integer fid);

    List<Map<String, Object>> selectOfficeFloor(@Param("pid") Integer pid, @Param("id") Integer id);
}
