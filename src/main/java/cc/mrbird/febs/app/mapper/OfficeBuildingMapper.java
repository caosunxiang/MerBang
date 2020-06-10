package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.OfficeBuilding;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-04-30 17:22:24
 */
public interface OfficeBuildingMapper extends BaseMapper<OfficeBuilding> {
    /**
     * @Description: PC段办公室条件查询
     * @Param: [condition, areaLow, areaHigh, priceLow, priceHigh, fitment, name, position, userid, myId]
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @Author: 冷酷的苹果
     * @Date: 2020/5/7 8:52
     */
    public List<Map<String, Object>> selectOfficeBuildingMyId(@Param("condition") String condition,
                                                              @Param("areaLow") Integer areaLow,
                                                              @Param("areaHigh") Integer areaHigh,
                                                              @Param("priceLow") String priceLow,
                                                              @Param("priceHigh") String priceHigh,
                                                              @Param("fitment") String fitment,
                                                              @Param("name") String name,
                                                              @Param("position") String position,
                                                              @Param("myId") String myId,
                                                              @Param("address") String address,
                                                              @Param("order") String order);


    public List<Map<String, Object>> selectOfficeBuildingUserId(@Param("condition") String condition,
                                                                @Param("areaLow") Integer areaLow,
                                                                @Param("areaHigh") Integer areaHigh,
                                                                @Param("priceLow") String priceLow,
                                                                @Param("priceHigh") String priceHigh,
                                                                @Param("fitment") String fitment,
                                                                @Param("name") String name,
                                                                @Param("position") String position,
                                                                @Param("userId") String userId,
                                                                @Param("address") String address,
                                                                @Param("order") String order);

    public List<Map<String, Object>> selectOfficeBuilding(@Param("condition") String condition,
                                                          @Param("areaLow") Integer areaLow,
                                                          @Param("areaHigh") Integer areaHigh,
                                                          @Param("priceLow") String priceLow,
                                                          @Param("priceHigh") String priceHigh,
                                                          @Param("fitment") String fitment,
                                                          @Param("name") String name,
                                                          @Param("position") String position,
                                                          @Param("address") String address,
                                                          @Param("order") String order);
}
