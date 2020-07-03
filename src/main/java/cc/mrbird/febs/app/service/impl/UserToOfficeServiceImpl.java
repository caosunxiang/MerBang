package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.UserToOffice;
import cc.mrbird.febs.app.mapper.UserToOfficeMapper;
import cc.mrbird.febs.app.service.IUserToOfficeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 10:08:20
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserToOfficeServiceImpl extends ServiceImpl<UserToOfficeMapper, UserToOffice> implements IUserToOfficeService {

    private final UserToOfficeMapper userToOfficeMapper;

    @Override
    public IPage<UserToOffice> findUserToOffices(QueryRequest request, UserToOffice userToOffice) {
        LambdaQueryWrapper<UserToOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<UserToOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<UserToOffice> findUserToOffices(UserToOffice userToOffice) {
        LambdaQueryWrapper<UserToOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUserToOffice(UserToOffice userToOffice) {
        this.save(userToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserToOffice(UserToOffice userToOffice) {
        this.saveOrUpdate(userToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserToOffice(UserToOffice userToOffice) {
        LambdaQueryWrapper<UserToOffice> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }
}
