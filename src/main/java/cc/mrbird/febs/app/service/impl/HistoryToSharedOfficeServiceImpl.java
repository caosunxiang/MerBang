package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.HistoryToSharedOffice;
import cc.mrbird.febs.app.mapper.HistoryToSharedOfficeMapper;
import cc.mrbird.febs.app.service.IHistoryToSharedOfficeService;
import cc.mrbird.febs.common.entity.QueryRequest;
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
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:05
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HistoryToSharedOfficeServiceImpl extends ServiceImpl<HistoryToSharedOfficeMapper, HistoryToSharedOffice> implements IHistoryToSharedOfficeService {

    private final HistoryToSharedOfficeMapper historyToSharedOfficeMapper;

    @Override
    public IPage<HistoryToSharedOffice> findHistoryToSharedOffices(QueryRequest request, HistoryToSharedOffice historyToSharedOffice) {
        LambdaQueryWrapper<HistoryToSharedOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<HistoryToSharedOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<HistoryToSharedOffice> findHistoryToSharedOffices(HistoryToSharedOffice historyToSharedOffice) {
	    LambdaQueryWrapper<HistoryToSharedOffice> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createHistoryToSharedOffice(HistoryToSharedOffice historyToSharedOffice) {
        this.save(historyToSharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateHistoryToSharedOffice(HistoryToSharedOffice historyToSharedOffice) {
        this.saveOrUpdate(historyToSharedOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteHistoryToSharedOffice(HistoryToSharedOffice historyToSharedOffice) {
        LambdaQueryWrapper<HistoryToSharedOffice> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
