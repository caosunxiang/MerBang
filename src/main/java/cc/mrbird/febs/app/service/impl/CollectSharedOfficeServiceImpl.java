package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.CollectSharedOffice;
import cc.mrbird.febs.app.mapper.CollectSharedOfficeMapper;
import cc.mrbird.febs.app.service.ICollectSharedOfficeService;
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
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-26 09:53:33
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CollectSharedOfficeServiceImpl extends ServiceImpl<CollectSharedOfficeMapper, CollectSharedOffice> implements ICollectSharedOfficeService {

    private final CollectSharedOfficeMapper collectSharedOfficeMapper;

    @Override
    public IPage<CollectSharedOffice> findCollectSharedOffices(QueryRequest request, CollectSharedOffice collectSharedOffice) {
        LambdaQueryWrapper<CollectSharedOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<CollectSharedOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<CollectSharedOffice> findCollectSharedOffices(CollectSharedOffice collectSharedOffice) {
	    LambdaQueryWrapper<CollectSharedOffice> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCollectSharedOffice(CollectSharedOffice collectSharedOffice) {
        this.save(collectSharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCollectSharedOffice(CollectSharedOffice collectSharedOffice) {
        this.saveOrUpdate(collectSharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCollectSharedOffice(CollectSharedOffice collectSharedOffice) {
        LambdaQueryWrapper<CollectSharedOffice> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
