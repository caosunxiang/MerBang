package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.Cost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 16:18:21
 */
public interface CostMapper extends BaseMapper<Cost> {
    List<Map<String, Object>> costStatistics(@Param("id") Integer id);

    List<Map<String, Object>> selectCost(@Param("condition") String condition, @Param("id") Integer id,
                                         @Param("door") String door);

    Integer selectLatelyCost(@Param("id") Integer id);

    Integer selectPassCost(@Param("id") Integer id, @Param("month") Integer month);
}
