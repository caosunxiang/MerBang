package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Apply;
import cc.mrbird.febs.app.mapper.ApplyMapper;
import cc.mrbird.febs.app.service.IApplyService;
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
import java.util.Map;

/**
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 16:04:13
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper, Apply> implements IApplyService {

    private final ApplyMapper applyMapper;

    @Override
    public IPage<Apply> findApplys(QueryRequest request, Apply apply) {
        LambdaQueryWrapper<Apply> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Apply> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Apply> findApplys(Apply apply) {
	    LambdaQueryWrapper<Apply> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createApply(Apply apply) {
        this.save(apply);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateApply(Apply apply) {
        this.saveOrUpdate(apply);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteApply(Apply apply) {
        LambdaQueryWrapper<Apply> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public Body selectApplyCount(Integer id) {
        return Body.newInstance(this.applyMapper.selectApplyCount(id));
    }

    @Override
    public Body selectApplyByOffice(Integer id) {
        List<Map<String,Object>> list=this.applyMapper.selectApplyByOffice(id);
        if (list.size()>0){
            return Body.newInstance(list);
        } else {
            return Body.newInstance(201,"没有请求");
        }
    }
}
