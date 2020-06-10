package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AUser;
import cc.mrbird.febs.app.mapper.AUserMapper;
import cc.mrbird.febs.app.mapper.ContractMapper;
import cc.mrbird.febs.app.mapper.CostMapper;
import cc.mrbird.febs.app.service.IAUserService;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.service.RedisService;
import cc.mrbird.febs.common.utils.*;
import cc.mrbird.febs.common.utils.json.Body;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.model.sns.SnsAccessToken;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service实现
 *
 * @author MrBird
 * @date 2020-04-21 16:52:25
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AUserServiceImpl extends ServiceImpl<AUserMapper, AUser> implements IAUserService {

    private final AUserMapper aUserMapper;

    private final CostMapper costMapper;

    private final ContractMapper contractMapper;

    @Autowired
    private RedisService redisService;


    @Override
    public IPage<AUser> findAUsers(QueryRequest request, AUser aUser) {
        LambdaQueryWrapper<AUser> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<AUser> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<AUser> findAUsers(AUser aUser) {
        LambdaQueryWrapper<AUser> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAUser(AUser aUser) {
        this.save(aUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAUser(AUser aUser) {
        this.saveOrUpdate(aUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAUser(AUser aUser) {
        LambdaQueryWrapper<AUser> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public SnsAccessToken scanQRCode(String code,String userid) {
        try {
            Weixin weixin =new Weixin();
            SnsAccessToken snsAccessToken=weixin.sns().getSnsOAuth2AccessToken(code);
            WebSocket websocket = new WebSocket();
            Map<String, Object> msg = new HashMap<>();
            msg.put("touser", userid);
            msg.put("openid", snsAccessToken.getOpenid());
            websocket.onMessage(JsonUtils.objectToJson(msg));
            return snsAccessToken;
        } catch (WeixinException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Body appGetUser(String userid) {
        return Body.newInstance(this.aUserMapper.selectById(userid));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body signInORLogin(AUser user) {
        Map<SFunction<AUser, ?>, Object> map = new HashMap();
        if (StringUtils.isEmpty(user.getOpenid())){
            map.put(AUser::getPhone, user.getPhone());
            map.put(AUser::getPassword,user.getPassword());
        }else {
            map.put(AUser::getOpenid, user.getOpenid());
        }
        LambdaQueryWrapper<AUser> wrapper = new LambdaQueryWrapper();
        wrapper.allEq(map);
        AUser aUser = this.baseMapper.selectOne(wrapper);
        if (aUser == null&&StringUtils.isEmpty(user.getOpenid())) {
           LambdaQueryWrapper<AUser> wrapper1=new LambdaQueryWrapper<>();
           wrapper1.eq(AUser::getPhone,user.getPhone());
            wrapper1.eq(AUser::getPassword,user.getPassword());
            AUser user1 =this.aUserMapper.selectOne(wrapper1);
            if (user1==null){
                return Body.newInstance(201,"密码输入错误");
            }else {
                Integer count = this.getBaseMapper().insert(user);
                if (count == 1) {
                    return Body.newInstance(user);
                } else {
                    return Body.newInstance(201, "登入失败，请联系管理员");
                }
            }
        } else if (aUser == null&&!StringUtils.isEmpty(user.getOpenid())){
            Integer count = this.getBaseMapper().insert(user);
            if (count == 1) {
                return Body.newInstance(user);
            } else {
                return Body.newInstance(201, "登入失败，请联系管理员");
            }
        }else {
            return Body.newInstance(aUser);
        }

    }

    @Override
    public Body updateUser(AUser user) {
        Integer count = this.aUserMapper.updateById(user);
        if (count == 1) {
            return Body.newInstance(200, "修改个人消息成功");
        }
        return Body.newInstance(201, "修改个人信息失败");
    }

    @Override
    public Body selectAllAreaByUid(Integer uId) {
        return Body.newInstance(this.aUserMapper.selectAllAreaByUid(uId));
    }

    @Override
    public Body selectAllCountByUid(Integer uId) {
        return Body.newInstance(this.aUserMapper.selectAllCountByUid(uId));
    }

    @Override
    public Body selectAllRateByUid(Integer uId) {
        List<Map<String, Object>> list = this.aUserMapper.selectAllRateByUid(uId);
        int count = 0;
        int all = list.size();
        for (Map<String, Object> stringObjectMap : list) {
            if (stringObjectMap.get("type").equals("B") || stringObjectMap.get("type").equals("D")) {
                count++;
            }
        }
        return Body.newInstance(DataHandleUtil.division(count, all));
    }

    @Override
    public Body selectAllPriceByUid(Integer uId) {
        return Body.newInstance(this.aUserMapper.selectAllPriceByUid(uId));
    }

    @Override
    public Body selectByPhone(String phone) {
        LambdaQueryWrapper<AUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AUser::getPhone, phone);
        AUser aUser = this.aUserMapper.selectOne(wrapper);
        if (aUser != null) {
            return Body.newInstance(aUser);
        } else {
            return Body.newInstance(201, "查无此人");
        }
    }

    @Override
    public Body weChatEmpty(Integer userId, String openid) {
        AUser aUser = new AUser();
        aUser.setOpenid(openid);
        aUser.setId(userId);
        Integer count = this.aUserMapper.updateById(aUser);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "微信已解绑");
    }

    @Override
    public Body resetPasswords(Integer userId, String pwd) {
        AUser aUser = new AUser();
        aUser.setPassword(pwd);
        aUser.setId(userId);
        Integer count = this.aUserMapper.updateById(aUser);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "密码已重置");
    }

    @Override
    public Body homeStatisticsLately(Integer id) {
        Map<String, Integer> map = new HashMap<>();
        map.put("cost", this.costMapper.selectLatelyCost(id));
        map.put("contract", this.contractMapper.selectLatelyContract(id));
        return Body.newInstance(map);
    }

    @Override
    public Body homeStatisticsPass(Integer id, Integer month) {
        Map<String, Integer> map = new HashMap<>();
        map.put("cost", this.costMapper.selectPassCost(id, month));
        map.put("contract", this.contractMapper.selectPassContract(id, month));
        return Body.newInstance(map);
    }

    @Override
    public Body QRCode(String data) {
        String url = null;
        try {
            url= QRCodeUtil.encode(data, null,"C:/Users/Administrator/Pictures", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Body.newInstance(url);
    }


}
