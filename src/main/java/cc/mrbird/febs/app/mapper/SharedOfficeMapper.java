package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.SharedOffice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:09
 */
public interface SharedOfficeMapper extends BaseMapper<SharedOffice> {

    /**
     * @Description: 高级查询共享办公
     * @Param: [condition, areaLow, areaHigh, priceLow, priceHigh, fitment, name, position, userId, myId]
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @Author: 冷酷的苹果
     * @Date: 2020/5/7 17:14
     */
    public List<Map<String, Object>> selectSharedOffice(@Param("condition") String condition,
                                                        @Param("id") Integer id,
                                                        @Param("areaLow") Integer areaLow,
                                                        @Param("areaHigh") Integer areaHigh,
                                                        @Param("priceLow") Integer priceLow,
                                                        @Param("priceHigh") Integer priceHigh,
                                                        @Param("type") String type,
                                                        @Param("name") String name,
                                                        @Param("position") String position,
                                                        @Param("address") String address,
                                                        @Param("order") String order);

    public List<Map<String, Object>> selectSharedOfficeMyId(@Param("condition") String condition,
                                                            @Param("id") Integer id,
                                                            @Param("areaLow") Integer areaLow,
                                                            @Param("areaHigh") Integer areaHigh,
                                                            @Param("priceLow") Integer priceLow,
                                                            @Param("priceHigh") Integer priceHigh,
                                                            @Param("type") String type,
                                                            @Param("name") String name,
                                                            @Param("position") String position,
                                                            @Param("myId") String myId,
                                                            @Param("address") String address,
                                                            @Param("order") String order);

    public List<Map<String, Object>> selectSharedOfficeUserId(@Param("condition") String condition,
                                                              @Param("id") Integer id,
                                                              @Param("areaLow") Integer areaLow,
                                                              @Param("areaHigh") Integer areaHigh,
                                                              @Param("priceLow") Integer priceLow,
                                                              @Param("priceHigh") Integer priceHigh,
                                                              @Param("type") String type,
                                                              @Param("name") String name,
                                                              @Param("position") String position,
                                                              @Param("userId") String userId,
                                                              @Param("address") String address,
                                                              @Param("order") String order);
}
