package cc.mrbird.febs.app.mapper;

import cc.mrbird.febs.app.entity.Office;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:16:31
 */
public interface OfficeMapper extends BaseMapper<Office> {

    public Integer selectCountByBuildingId(@Param("officeBuildingId") Integer officeBuildingId);

    public Integer selectCountByBuildingForA(@Param("officeBuildingId") Integer officeBuildingId);

    public Integer selectCountBySharedId(@Param("sharedOfficeId") Integer sharedOfficeId);

    public Integer selectCountBySharedForA(@Param("sharedOfficeId") Integer sharedOfficeId);

    public List<Map<String, Object>> selectOffice(@Param("condition") String condition,
                                                  @Param("id") Integer id,
                                                  @Param("areaLow") Integer areaLow,
                                                  @Param("areaHigh") Integer areaHigh,
                                                  @Param("priceLow") String priceLow,
                                                  @Param("priceHigh") String priceHigh,
                                                  @Param("fitment") String fitment,
                                                  @Param("name") String name,
                                                  @Param("position") String position,
                                                  @Param("address") String address,
                                                  @Param("order") String order);

    public List<Map<String, Object>> selectOfficeUserId(@Param("condition") String condition,
                                                        @Param("id") Integer id,
                                                        @Param("areaLow") Integer areaLow,
                                                        @Param("areaHigh") Integer areaHigh,
                                                        @Param("priceLow") String priceLow,
                                                        @Param("priceHigh") String priceHigh,
                                                        @Param("fitment") String fitment,
                                                        @Param("name") String name,
                                                        @Param("position") String position,
                                                        @Param("address") String address,
                                                        @Param("userId") String userId,
                                                        @Param("order") String order);

    public List<Map<String, Object>> selectOfficeMyId(@Param("condition") String condition,
                                                      @Param("id") Integer id,
                                                      @Param("areaLow") Integer areaLow,
                                                      @Param("areaHigh") Integer areaHigh,
                                                      @Param("priceLow") String priceLow,
                                                      @Param("priceHigh") String priceHigh,
                                                      @Param("fitment") String fitment,
                                                      @Param("name") String name,
                                                      @Param("position") String position,
                                                      @Param("address") String address,
                                                      @Param("myId") String myId,
                                                      @Param("order") String order);


    public List<Map<String, Object>> officeDown(@Param("id") Integer id);

    public List<Map<String, Object>> selectOfficeDetails(@Param("id") Integer id);

    public List<Map<String, Object>> selectOfficeInPrice(@Param("pid") Integer pid, @Param("door") String door,
                                                         @Param("id") Integer id);

    public List<Map<String, Object>> selectOfficeInCost(@Param("id") Integer id, @Param("uid") Integer uid, @Param(
            "type") String type);
}
