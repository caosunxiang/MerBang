package cc.mrbird.febs.app.service;

import cc.mrbird.febs.app.entity.AUser;

import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.weixin4j.WeixinException;
import org.weixin4j.model.base.Token;
import org.weixin4j.model.sns.SnsAccessToken;

import java.util.List;

/**
 * Service接口
 *
 * @author MrBird
 * @date 2020-04-21 16:52:25
 */
public interface IAUserService extends IService<AUser> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param aUser   aUser
     * @return IPage<AUser>
     */
    IPage<AUser> findAUsers(QueryRequest request, AUser aUser);

    /**
     * 查询（所有）
     *
     * @param aUser aUser
     * @return List<AUser>
     */
    List<AUser> findAUsers(AUser aUser);

    /**
     * 新增
     *
     * @param aUser aUser
     */
    void createAUser(AUser aUser);

    /**
     * 修改
     *
     * @param aUser aUser
     */
    void updateAUser(AUser aUser);

    /**
     * 删除
     *
     * @param aUser aUser
     */
    void deleteAUser(AUser aUser);

    /**
     * @Description:微信扫描二维码
     * @Param: []
     * @return: java.util.List<cc.mrbird.febs.app.entity.AUser>
     * @Author: 冷酷的苹果
     * @Date: 2020/4/21 17:09
     */
    SnsAccessToken scanQRCode(String code, String userid);

    /**
     * @Description: 获取用户信息
     * @Param: [userid]
     * @return: cc.mrbird.febs.app.entity.AUser
     * @Author: 冷酷的苹果
     * @Date: 2020/4/28 8:41
     */
    Body appGetUser(String userid);

    /**
     * @Description: 扫码登入后的注册或者登入
     * @Param: [user]
     * @return: FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/4/30 13:45
     */
    Body signInORLogin(AUser user);

    /**
     * @Description: 修改个人信息
     * @Param: [user]
     * @return: cc.mrbird.febs.common.entity.FebsResponse
     * @Author: 冷酷的苹果
     * @Date: 2020/4/30 16:47
     */
    Body updateUser(AUser user);

    /**
     * @Description: 首页查询总租赁面积
     * @Param: [uId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/15 8:48
     */
    Body selectAllAreaByUid(Integer uId);

    /**
     * @Description: 首页查询总房源数
     * @Param: [uId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/15 8:49
     */
    Body selectAllCountByUid(Integer uId);

    /**
     * @Description: 首页查询总出租率
     * @Param: [uId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/15 8:57
     */
    Body selectAllRateByUid(Integer uId);

    /**
     * @Description: 首页查询在实际单价
     * @Param: [uId]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/15 8:58
     */
    Body selectAllPriceByUid(Integer uId);

    /**
     * @Description: 根据手机号查询用户信息
     * @Param: [phone]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/15 17:04
     */
    Body selectByPhone(String phone);

    /**
     * @Description: 修改微信
     * @Param: []
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 8:33
     */
    Body weChatEmpty(Integer userId, String openid);

    /**
     * @Description: 修改密码
     * @Param: [userId, pwd]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/18 9:07
     */
    Body resetPasswords(Integer userId, String pwd);

    /**
     * @Description: 首页查询最近的账单
     * @Param: [id]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/22 10:45
     */
    Body homeStatisticsLately(Integer id);

    /**
     * @Description: 首页查询过期的账单
     * @Param: [id, month]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/5/22 10:46
     */
    Body homeStatisticsPass(Integer id, Integer month);

    /**
     * @Description: 生成二维码
     * @Param: [data]
     * @return: cc.mrbird.febs.common.utils.json.Body
     * @Author: 冷酷的苹果
     * @Date: 2020/6/2 13:29
     */
    Body QRCode(String data);
}
