package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.LabelToSharedOffice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:50
 */
public interface LabelToSharedOfficeMapper extends BaseMapper<LabelToSharedOffice> {
    List<Map<String, Object>> selectSharedLabel(@Param("id") Integer id);
}
