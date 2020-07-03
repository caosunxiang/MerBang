package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.CostOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 16:18:25
 */
public interface CostOrderMapper extends BaseMapper<CostOrder> {
    List<Map<String, Object>> selectCostOrderByCostId(@Param("id") Integer id);
}
