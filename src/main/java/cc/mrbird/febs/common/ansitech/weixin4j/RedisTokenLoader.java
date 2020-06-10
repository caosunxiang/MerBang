/**
 * Copyright (C), 2020-2020, 众马科技有限公司
 * FileName: RedisTokenLoader
 * Author:   冷酷的苹果
 * Date:     2020/4/21 10:59
 * Description: 实现ITokenLoader，自主选择存储AccessToken方式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cc.mrbird.febs.common.ansitech.weixin4j;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.loader.DefaultTokenLoader;
import org.weixin4j.loader.ITokenLoader;
import org.weixin4j.model.base.Token;

import java.util.concurrent.TimeUnit;


/**
 * 〈一句话功能简述〉<br>
 * 〈实现ITokenLoader，自主选择存储AccessToken方式〉
 *
 * @author 冷酷的苹果
 * @create 2020/4/21
 * @since 1.0.0
 */
@Component
public class RedisTokenLoader implements ITokenLoader {

    private static final Logger LOG = LoggerFactory.getLogger(RedisTokenLoader.class);

    private final String ACCESS_TOKEN_KEY = "ats_wx100000000001";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Token get() {
        String accessToken = stringRedisTemplate.opsForValue().get(ACCESS_TOKEN_KEY);
        LOG.info("wechat access_token:{}", accessToken);
        return JSON.parseObject(accessToken, Token.class);
    }

    @Override
    public void refresh(Token token) {
        LOG.info("refresh wechat access_token:{}", token.toString());
        String accessToken = JSON.toJSONString(token);
        //ticket.getExpires_in() - 600L，是为了提前10分钟过期
        stringRedisTemplate.opsForValue().set(ACCESS_TOKEN_KEY, accessToken, token.getExpires_in() - 600L,
                TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        Weixin weixin = new Weixin();
        ITokenLoader loader = new DefaultTokenLoader();
        try {
           loader.refresh(weixin.base().token());
        } catch (WeixinException e) {
            e.printStackTrace();
        }
        System.out.println("access_token:" + loader.get());
    }
}
