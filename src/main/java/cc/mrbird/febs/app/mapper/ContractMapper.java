package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.Contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import javax.jws.WebParam;
import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-18 14:04:02
 */
public interface ContractMapper extends BaseMapper<Contract> {
    List<Map<String, Object>> selectContract(@Param("condition") String condition, @Param("id") String id, @Param(
            "door") Integer door);

    Map<String, Object> selectContractByConIdAndDoor(@Param("id") Integer id, @Param("door") Integer door);

    Integer selectLatelyContract(@Param("id")Integer id);

    Integer selectPassContract(@Param("id")Integer id,@Param("month")Integer month);
}
