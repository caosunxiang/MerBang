package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.LabelToOffice;
import cc.mrbird.febs.app.mapper.LabelToOfficeMapper;
import cc.mrbird.febs.app.service.ILabelToOfficeService;
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
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-06 09:17:12
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LabelToOfficeServiceImpl extends ServiceImpl<LabelToOfficeMapper, LabelToOffice> implements ILabelToOfficeService {

    private final LabelToOfficeMapper labelToOfficeMapper;

    @Override
    public IPage<LabelToOffice> findLabelToOffices(QueryRequest request, LabelToOffice labelToOffice) {
        LambdaQueryWrapper<LabelToOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<LabelToOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<LabelToOffice> findLabelToOffices(LabelToOffice labelToOffice) {
	    LambdaQueryWrapper<LabelToOffice> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createLabelToOffice(LabelToOffice labelToOffice) {
        this.save(labelToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLabelToOffice(LabelToOffice labelToOffice) {
        this.saveOrUpdate(labelToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLabelToOffice(LabelToOffice labelToOffice) {
        LambdaQueryWrapper<LabelToOffice> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public Body selectLabelByOfficeId(Integer officeId) {
        List<Map<String,Object>>list=this.labelToOfficeMapper.selectOfficeLabel(officeId);
        if (list.size()>0){
            for (Map<String, Object> stringObjectMap : list) {
                if (!StringUtils.isEmpty(stringObjectMap.get("oid"))){
                    stringObjectMap.put("oid","bopdd_opp");
                }
            }
            return  Body.newInstance(list);
        }
        return Body.newInstance(201,"尚未选择");
    }
}
