package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Lessee;

import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 16:04:09
 */
public interface ILesseeService extends IService<Lessee> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param lessee  lessee
     * @return IPage<Lessee>
     */
    IPage<Lessee> findLessees(QueryRequest request, Lessee lessee);

    /**
     * 查询（所有）
     *
     * @param lessee lessee
     * @return List<Lessee>
     */
    List<Lessee> findLessees(Lessee lessee);

    /**
     * 新增
     *
     * @param lessee lessee
     */
    void createLessee(Lessee lessee);

    /**
     * 修改
     *
     * @param lessee lessee
     */
    void updateLessee(Lessee lessee);

    /**
     * 删除
     *
     * @param lessee lessee
     */
    void deleteLessee(Lessee lessee);

    /**
     * @Description: 查询指定办公室的租户消息
     * @Param: []
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/5/8 16:46
     */
    Body selectLesseeByOffice(Integer id);

    /**
     * @Description: 添加租户信息
     * @Param: [lessee]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 9:19
     */
    Body insertLessee(Lessee lessee, Integer officeId);

    /**
     * @Description: 修改租户信息
     * @Param: [lessee]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/28 8:43
     */
    Body updateLesseeDetails(Lessee lessee);
}
