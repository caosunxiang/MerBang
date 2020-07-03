package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.Invoice;

import cc.mrbird.febs.app.entity.Lessee;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author 冷酷的苹果
 * @date 2020-05-18 09:55:16
 */
public interface IInvoiceService extends IService<Invoice> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param invoice invoice
     * @return IPage<Invoice>
     */
    IPage<Invoice> findInvoices(QueryRequest request, Invoice invoice);

    /**
     * 查询（所有）
     *
     * @param invoice invoice
     * @return List<Invoice>
     */
    List<Invoice> findInvoices(Invoice invoice);

    /**
     * 新增
     *
     * @param invoice invoice
     */
    void createInvoice(Invoice invoice);

    /**
     * 修改
     *
     * @param invoice invoice
     */
    void updateInvoice(Invoice invoice);

    /**
     * 删除
     *
     * @param invoice invoice
     */
    void deleteInvoice(Invoice invoice);

    /**
     * @Description: 查找租户开票信息
     * @Param: [lesseeId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 10:04
     */
    Body selectInvoice(Integer lesseeId);

    /**
     * @Description: 新增开票信息
     * @Param: [invoice]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 10:11
     */
    Body insertInvoice(Invoice invoice);

    /**
     * @Description: 修改开票信息
     * @Param: [invoice]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 10:11
     */
    Body updateInvoiceDetails(Invoice invoice);
}
