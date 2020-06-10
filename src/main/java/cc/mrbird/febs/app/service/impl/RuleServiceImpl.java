package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.entity.Contract;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.app.mapper.ContractMapper;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Rule;
import cc.mrbird.febs.app.mapper.RuleMapper;
import cc.mrbird.febs.app.service.IRuleService;
import cc.mrbird.febs.common.utils.DateUtil;
import cc.mrbird.febs.common.utils.json.Body;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-18 09:55:18
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RuleServiceImpl extends ServiceImpl<RuleMapper, Rule> implements IRuleService {

    private final RuleMapper ruleMapper;

    private final AppLogMapper appLogMapper;

    private final ContractMapper contractMapper;

    @Override
    public IPage<Rule> findRules(QueryRequest request, Rule rule) {
        LambdaQueryWrapper<Rule> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Rule> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Rule> findRules(Rule rule) {
        LambdaQueryWrapper<Rule> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createRule(Rule rule) {
        this.save(rule);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRule(Rule rule) {
        this.saveOrUpdate(rule);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRule(Rule rule) {
        LambdaQueryWrapper<Rule> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectRule(Integer lesseeId) {
        LambdaQueryWrapper<Rule> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Rule::getLesseeId, lesseeId);
        Rule rule = this.ruleMapper.selectOne(wrapper);
        if (rule != null) {
            return Body.newInstance(rule);
        }
        return Body.newInstance(201, "尚未录入规则");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertRule(Rule rule, Integer userid, Integer house) {
        this.ruleMapper.insert(rule);
        AppLog appLog = new AppLog();
        appLog.setCreateUser(userid);
        appLog.setContent("新增租金信息");
        appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        appLog.setRemark("A");
        appLog.setHouse⁯(house);
        this.appLogMapper.insert(appLog);
        int start=0;
        Date date = new Date();
        Date date1=new Date();
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date1 = fmt.parse(rule.getPayTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date.getDay()>date1.getDay()){
            start=1;
        }
        for (int i = start; i < Integer.parseInt(rule.getPayType()); i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);//设置起时间
            cal.add(Calendar.MONTH, i);
            Contract contract = new Contract();
            contract.setRoom(house);
            contract.setState("A");
            contract.setLesseeId(rule.getLesseeId());
            contract.setTime(DateUtil.getDateFormat(cal.getTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            contract.setRuleId(rule.getId());
            this.contractMapper.insert(contract);
        }
        return Body.newInstance(200, "操作完成");
    }

    @Override
    public Body updateRuleDetails(Rule rule, Integer userid, Integer house) {
        this.ruleMapper.updateById(rule);
        AppLog appLog = new AppLog();
        appLog.setCreateUser(userid);
        appLog.setContent("修改租金规则信息");
        appLog.setCreateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        appLog.setRemark("A");
        appLog.setHouse⁯(house);
        this.appLogMapper.insert(appLog);
        return Body.newInstance(200, "操作完成");
    }
}
