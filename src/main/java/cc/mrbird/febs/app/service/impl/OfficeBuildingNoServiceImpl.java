package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.Office;
import cc.mrbird.febs.app.entity.OfficeBuildingNo;
import cc.mrbird.febs.app.mapper.OfficeBuildingNoMapper;
import cc.mrbird.febs.app.service.IOfficeBuildingNoService;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
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
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:18:10
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OfficeBuildingNoServiceImpl extends ServiceImpl<OfficeBuildingNoMapper, OfficeBuildingNo> implements IOfficeBuildingNoService {

    private final OfficeBuildingNoMapper officeBuildingNoMapper;

    @Override
    public IPage<OfficeBuildingNo> findOfficeBuildingNos(QueryRequest request, OfficeBuildingNo officeBuildingNo) {
        LambdaQueryWrapper<OfficeBuildingNo> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OfficeBuildingNo> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OfficeBuildingNo> findOfficeBuildingNos(OfficeBuildingNo officeBuildingNo) {
	    LambdaQueryWrapper<OfficeBuildingNo> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOfficeBuildingNo(OfficeBuildingNo officeBuildingNo) {
        this.save(officeBuildingNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOfficeBuildingNo(OfficeBuildingNo officeBuildingNo) {
        this.saveOrUpdate(officeBuildingNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOfficeBuildingNo(OfficeBuildingNo officeBuildingNo) {
        LambdaQueryWrapper<OfficeBuildingNo> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public Body selectOfficeBuildingNo(Integer officeBuildingId) {
        LambdaQueryWrapper<OfficeBuildingNo> wrapper=new LambdaQueryWrapper<>();
        List<OfficeBuildingNo> list= this.officeBuildingNoMapper.selectList(wrapper);
        if (list.size()>0) {
            return Body.newInstance(list);
        } else {
            return Body.newInstance(201,"没有楼号记录");
        }
    }
}
