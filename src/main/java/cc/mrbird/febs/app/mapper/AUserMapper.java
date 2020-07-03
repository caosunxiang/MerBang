package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.AUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author MrBird
 * @date 2020-04-21 16:52:25
 */
public interface AUserMapper extends BaseMapper<AUser> {
    public Map<String, Object> selectAllAreaByUid(@Param("uId") Integer uId);

    public Map<String, Object> selectAllCountByUid(@Param("uId") Integer uId);

    public List<Map<String, Object>> selectAllRateByUid(@Param("uId") Integer uId);

    public Map<String, Object> selectAllPriceByUid(@Param("uId") Integer uId);
}
