/**
 * Copyright (C), 2020-2020, 众马科技有限公司
 * FileName: RedisTicketLoader
 * Author:   冷酷的苹果
 * Date:     2020/4/21 11:30
 * Description: 实现ITicketLoader
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cc.mrbird.febs.common.ansitech.weixin4j.factory;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.weixin4j.loader.ITicketLoader;
import org.weixin4j.model.js.Ticket;
import org.weixin4j.model.js.TicketType;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈实现ITicketLoader〉
 *
 * @author 冷酷的苹果
 * @create 2020/4/21
 * @since 1.0.0
 */
@Component
public class RedisTicketLoader implements ITicketLoader {

    private static final Logger LOG = LoggerFactory.getLogger(RedisTicketLoader.class);

    private final String ACCESS_TOKEN_KEY = "ats_wx100000000001";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Ticket get(TicketType ticketType) {
        String key = "";
        if (null != ticketType) {
            switch (ticketType) {
                case JSAPI:
                    key = "wechat_ticket_jsapi";
                    break;
                case WX_CARD:
                    key = "wechat_ticket_wxcard";
                    break;
                default:
                    key = "wechat_ticket";
                    break;
            }
        }
        String ticket = stringRedisTemplate.opsForValue().get(key);
        LOG.info("wechat ticket:{}", ticket);
        return JSON.parseObject(ticket, Ticket.class);
    }

    @Override
    public void refresh(Ticket ticket) {
        String key = "";
        if (null != ticket.getTicketType()) {
            switch (ticket.getTicketType()) {
                case JSAPI:
                    key = "wechat_ticket_jsapi_" + "wxbd6e93d642139b7e";
                    break;
                case WX_CARD:
                    key = "wechat_ticket_wxcard_" + "wxbd6e93d642139b7e";
                    break;
                default:
                    key = "wechat_ticket_" + "wxbd6e93d642139b7e";
                    break;
            }
        }
        LOG.info("refresh wechat ticket:{}", ticket.toString());
        String ticketValue = JSON.toJSONString(ticket);
        //ticket.getExpires_in() - 600L，是为了提前10分钟过期
        stringRedisTemplate.opsForValue().set(key, ticketValue, ticket.getExpires_in() - 600L, TimeUnit.SECONDS);
    }
}
