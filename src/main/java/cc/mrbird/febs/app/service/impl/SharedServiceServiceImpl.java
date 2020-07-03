package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.SharedService;
import cc.mrbird.febs.app.mapper.SharedServiceMapper;
import cc.mrbird.febs.app.service.ISharedServiceService;
import cc.mrbird.febs.common.utils.json.Body;
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
 * @date 2020-05-15 15:53:58
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SharedServiceServiceImpl extends ServiceImpl<SharedServiceMapper, SharedService> implements ISharedServiceService {

    private final SharedServiceMapper sharedServiceMapper;

    @Override
    public IPage<SharedService> findSharedServices(QueryRequest request, SharedService sharedService) {
        LambdaQueryWrapper<SharedService> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<SharedService> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<SharedService> findSharedServices(SharedService sharedService) {
        LambdaQueryWrapper<SharedService> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createSharedService(SharedService sharedService) {
        this.save(sharedService);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSharedService(SharedService sharedService) {
        this.saveOrUpdate(sharedService);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSharedService(SharedService sharedService) {
        LambdaQueryWrapper<SharedService> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectSharedService() {
        LambdaQueryWrapper<SharedService> wrapper = new LambdaQueryWrapper<>();
        List<SharedService> sharedServices = this.sharedServiceMapper.selectList(wrapper);
        if (sharedServices.size() > 0) {
            return Body.newInstance(sharedServices);
        }
        return Body.newInstance(201, "尚未添加");
    }
}
