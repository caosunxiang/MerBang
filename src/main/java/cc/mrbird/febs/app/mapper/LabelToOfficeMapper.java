package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.LabelToOffice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 *  Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:12
 */
public interface LabelToOfficeMapper extends BaseMapper<LabelToOffice> {

    List<Map<String,Object>> selectOfficeLabel(@Param("id")Integer id);
}
