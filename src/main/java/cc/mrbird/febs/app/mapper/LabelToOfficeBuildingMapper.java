package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.LabelToOfficeBuilding;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 *  Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:39
 */
public interface LabelToOfficeBuildingMapper extends BaseMapper<LabelToOfficeBuilding> {
List<Map<String,Object>>selectBuildLabel(@Param("id")Integer id);
}
