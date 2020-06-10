package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 *  Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-19 13:56:57
 */
public interface OrderMapper extends BaseMapper<Order> {
List<Map<String,Object>>selectLineChart(@Param("id")Integer id );
}
