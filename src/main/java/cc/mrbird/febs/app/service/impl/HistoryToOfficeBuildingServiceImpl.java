package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.HistoryToOfficeBuilding;
import cc.mrbird.febs.app.mapper.HistoryToOfficeBuildingMapper;
import cc.mrbird.febs.app.service.IHistoryToOfficeBuildingService;
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
 * @date 2020-05-06 09:18:07
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HistoryToOfficeBuildingServiceImpl extends ServiceImpl<HistoryToOfficeBuildingMapper, HistoryToOfficeBuilding> implements IHistoryToOfficeBuildingService {

    private final HistoryToOfficeBuildingMapper historyToOfficeBuildingMapper;

    @Override
    public IPage<HistoryToOfficeBuilding> findHistoryToOfficeBuildings(QueryRequest request, HistoryToOfficeBuilding historyToOfficeBuilding) {
        LambdaQueryWrapper<HistoryToOfficeBuilding> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<HistoryToOfficeBuilding> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<HistoryToOfficeBuilding> findHistoryToOfficeBuildings(HistoryToOfficeBuilding historyToOfficeBuilding) {
	    LambdaQueryWrapper<HistoryToOfficeBuilding> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createHistoryToOfficeBuilding(HistoryToOfficeBuilding historyToOfficeBuilding) {
        this.save(historyToOfficeBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateHistoryToOfficeBuilding(HistoryToOfficeBuilding historyToOfficeBuilding) {
        this.saveOrUpdate(historyToOfficeBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteHistoryToOfficeBuilding(HistoryToOfficeBuilding historyToOfficeBuilding) {
        LambdaQueryWrapper<HistoryToOfficeBuilding> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
