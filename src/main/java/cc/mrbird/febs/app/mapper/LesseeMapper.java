package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.Lessee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 16:04:09
 */
public interface LesseeMapper extends BaseMapper<Lessee> {

    /**
     * @Description: 查询指定办公室的租户信息
     * @Param: [id]
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @Author: 冷酷的苹果
     * @Date: 2020/5/8 17:37
     */
    Map<String, Object> selectLesseeByOffice(@Param("id") Integer id);

    Map<String, Object> selectVerifyOffice(@Param("id") Integer id);
}
