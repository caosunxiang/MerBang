package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.AppLog;
import cc.mrbird.febs.app.entity.SharedOfficeLabel;
import cc.mrbird.febs.app.mapper.AppLogMapper;
import cc.mrbird.febs.app.mapper.SharedOfficeLabelMapper;
import cc.mrbird.febs.app.service.ISharedOfficeLabelService;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.DateUtil;
import cc.mrbird.febs.common.utils.json.Body;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-15 14:45:20
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SharedOfficeLabelServiceImpl extends ServiceImpl<SharedOfficeLabelMapper, SharedOfficeLabel> implements ISharedOfficeLabelService {

    private final SharedOfficeLabelMapper sharedOfficeLabelMapper;

    private final AppLogMapper appLogMapper;
    @Override
    public IPage<SharedOfficeLabel> findSharedOfficeLabels(QueryRequest request, SharedOfficeLabel sharedOfficeLabel) {
        LambdaQueryWrapper<SharedOfficeLabel> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<SharedOfficeLabel> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<SharedOfficeLabel> findSharedOfficeLabels(SharedOfficeLabel sharedOfficeLabel) {
	    LambdaQueryWrapper<SharedOfficeLabel> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createSharedOfficeLabel(SharedOfficeLabel sharedOfficeLabel) {
        this.save(sharedOfficeLabel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSharedOfficeLabel(SharedOfficeLabel sharedOfficeLabel) {
        this.saveOrUpdate(sharedOfficeLabel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSharedOfficeLabel(SharedOfficeLabel sharedOfficeLabel) {
        LambdaQueryWrapper<SharedOfficeLabel> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public Body selectSharedOfficeLabel() {
        LambdaQueryWrapper<SharedOfficeLabel> wrapper = new LambdaQueryWrapper<>();
        List<SharedOfficeLabel> list = this.sharedOfficeLabelMapper.selectList(wrapper);
        if (list.size() > 0) {
            return Body.newInstance(list);
        } else {
            return Body.newInstance(201,"没有相关信息");
        }
    }

    @Override
    public Body insertSharedOfficeLabel(String name, Integer userId) {
        SharedOfficeLabel sharedOffice=new SharedOfficeLabel();
        sharedOffice.setCreationTime(DateUtil.getDateFormat(new Date(),DateUtil.FULL_TIME_SPLIT_PATTERN));
        sharedOffice.setName(name);
        Integer count=this.sharedOfficeLabelMapper.insert(sharedOffice);
        if (count==1){
            return Body.BODY_200;
        }
        return Body.newInstance(201,"添加失败");
    }

}
