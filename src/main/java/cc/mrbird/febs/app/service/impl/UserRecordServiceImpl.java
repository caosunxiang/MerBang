package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.UserRecord;
import cc.mrbird.febs.app.mapper.UserRecordMapper;
import cc.mrbird.febs.app.service.IUserRecordService;
import cc.mrbird.febs.common.entity.QueryRequest;
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
 * @date 2020-05-06 09:17:27
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserRecordServiceImpl extends ServiceImpl<UserRecordMapper, UserRecord> implements IUserRecordService {

    private final UserRecordMapper userRecordMapper;

    @Override
    public IPage<UserRecord> findUserRecords(QueryRequest request, UserRecord userRecord) {
        LambdaQueryWrapper<UserRecord> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<UserRecord> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<UserRecord> findUserRecords(UserRecord userRecord) {
        LambdaQueryWrapper<UserRecord> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUserRecord(UserRecord userRecord) {
        this.save(userRecord);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserRecord(UserRecord userRecord) {
        this.saveOrUpdate(userRecord);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserRecord(UserRecord userRecord) {
        LambdaQueryWrapper<UserRecord> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }
}
