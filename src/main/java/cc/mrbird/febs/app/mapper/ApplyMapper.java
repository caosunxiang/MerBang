package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.Apply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 16:04:13
 */
public interface ApplyMapper extends BaseMapper<Apply> {
    /**
     * @Description: 办公室请求
     * @Param: [id]
     * @return: java.lang.Integer
     * @Author: 冷酷的苹果
     * @Date: 2020/5/8 16:31
     */
    Integer selectApplyCount(@Param("id") Integer id);

    /**
     * @Description: 查询指定办公室的请求
     * @Param: [id]
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @Author: 冷酷的苹果
     * @Date: 2020/5/8 16:42
     */
    List<Map<String, Object>> selectApplyByOffice(@Param("id") Integer id);
}
