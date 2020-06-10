package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.Office;
import cc.mrbird.febs.app.entity.UserToOffice;
import cc.mrbird.febs.app.mapper.OfficeMapper;
import cc.mrbird.febs.app.mapper.UserToOfficeMapper;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Lessee;
import cc.mrbird.febs.app.mapper.LesseeMapper;
import cc.mrbird.febs.app.service.ILesseeService;
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

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 16:04:09
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LesseeServiceImpl extends ServiceImpl<LesseeMapper, Lessee> implements ILesseeService {

    private final LesseeMapper lesseeMapper;

    private final UserToOfficeMapper userToOfficeMapper;

    private final OfficeMapper officeMapper;

    @Override
    public IPage<Lessee> findLessees(QueryRequest request, Lessee lessee) {
        LambdaQueryWrapper<Lessee> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Lessee> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Lessee> findLessees(Lessee lessee) {
        LambdaQueryWrapper<Lessee> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createLessee(Lessee lessee) {
        this.save(lessee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLessee(Lessee lessee) {
        this.saveOrUpdate(lessee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLessee(Lessee lessee) {
        LambdaQueryWrapper<Lessee> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectLesseeByOffice(Integer id) {
        Map<String, Object> map = this.lesseeMapper.selectLesseeByOffice(id);
        return Body.newInstance(map);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Body insertLessee(Lessee lessee, Integer officeId) {
        int count = this.lesseeMapper.insert(lessee);
        if (count == 1) {
            Office office = new Office();
            office.setType("B");
            office.setUserId(lessee.getId().toString());
            office.setUpdateTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_TIME_SPLIT_PATTERN));
            office.setId(officeId);
            this.officeMapper.updateById(office);
            UserToOffice userToOffice = new UserToOffice();
            userToOffice.setOfiiceId(officeId);
            userToOffice.setUserId(lessee.getUserId());
            userToOfficeMapper.insert(userToOffice);
            return Body.newInstance(lessee);
        }
        return Body.newInstance(201, "添加错误");
    }

    @Override
    public Body updateLesseeDetails(Lessee lessee) {
        int count = this.lesseeMapper.updateById(lessee);
        if (count == 1) {
            return Body.BODY_200;
        }
        return Body.newInstance(201, "修改错误");
    }
}
