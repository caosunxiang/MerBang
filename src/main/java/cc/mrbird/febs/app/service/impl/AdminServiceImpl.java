package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.Admin;
import cc.mrbird.febs.app.mapper.AdminMapper;
import cc.mrbird.febs.app.service.IAdminService;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:33
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    private final AdminMapper adminMapper;

    @Override
    public IPage<Admin> findAdmins(QueryRequest request, Admin admin) {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Admin> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Admin> findAdmins(Admin admin) {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAdmin(Admin admin) {
        this.save(admin);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAdmin(Admin admin) {
        this.saveOrUpdate(admin);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAdmin(Admin admin) {
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body adminParticulars() {
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        List<Admin> list = this.adminMapper.selectList(wrapper);
        return Body.newInstance(list);
    }
}
