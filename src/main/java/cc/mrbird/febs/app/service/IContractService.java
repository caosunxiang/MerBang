package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Contract;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-18 14:04:02
 */
public interface IContractService extends IService<Contract> {
    /**
     * 查询（分页）
     *
     * @param request  QueryRequest
     * @param contract contract
     * @return IPage<Contract>
     */
    IPage<Contract> findContracts(QueryRequest request, Contract contract);

    /**
     * 查询（所有）
     *
     * @param contract contract
     * @return List<Contract>
     */
    List<Contract> findContracts(Contract contract);

    /**
     * 新增
     *
     * @param contract contract
     */
    void createContract(Contract contract);

    /**
     * 修改
     *
     * @param contract contract
     */
    void updateContract(Contract contract);

    /**
     * 删除
     *
     * @param contract contract
     */
    void deleteContract(Contract contract);

    /**
     * @Description: 查找租金详情
     * @Param: [condition, id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 18:00
     */
    Body selectContract(String condition, String id, Integer door);

    /**
     * @Description: 查询租金订单详情
     * @Param: [id, door]
     * @return:
     * @Author: 冷酷的苹果
     * @Date: 2020/5/19 11:08
     */
    Body selectContractByConIdAndDoor(Integer id, Integer door);

}
