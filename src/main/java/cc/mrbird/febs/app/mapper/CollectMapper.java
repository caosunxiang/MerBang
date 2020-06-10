package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.Collect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 *  Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-26 09:53:12
 */
public interface CollectMapper extends BaseMapper<Collect> {
List<Map<String,Object>>selectCollect();
}
