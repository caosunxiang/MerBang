package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.Lessee;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.LesseeUtil;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.FloorToOffice;
import cc.mrbird.febs.app.mapper.FloorToOfficeMapper;
import cc.mrbird.febs.app.service.IFloorToOfficeService;
import cc.mrbird.febs.common.utils.json.Body;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 13:40:47
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FloorToOfficeServiceImpl extends ServiceImpl<FloorToOfficeMapper, FloorToOffice> implements IFloorToOfficeService {

    private final FloorToOfficeMapper floorToOfficeMapper;

    @Override
    public IPage<FloorToOffice> findFloorToOffices(QueryRequest request, FloorToOffice floorToOffice) {
        LambdaQueryWrapper<FloorToOffice> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<FloorToOffice> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<FloorToOffice> findFloorToOffices(FloorToOffice floorToOffice) {
	    LambdaQueryWrapper<FloorToOffice> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createFloorToOffice(FloorToOffice floorToOffice) {
        this.save(floorToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateFloorToOffice(FloorToOffice floorToOffice) {
        this.saveOrUpdate(floorToOffice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteFloorToOffice(FloorToOffice floorToOffice) {
        LambdaQueryWrapper<FloorToOffice> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

//    @Override
//    public Body selectOfficeByfloor(Integer id) {
//        List<Map<String,Object>> list=this.floorToOfficeMapper.selectOfficeByfloor(id);
//        if (list.size()>0){
//            return Body.newInstance(list);
//        } else {
//            return Body.newInstance(201,"查询不到结果");
//        }
//    }

    @Override
    public Body selectOfficeFloor(Integer pid, Integer id) {
        List<LesseeUtil>list=new ArrayList<>();
        List<Map<String,Object>> flist=this.floorToOfficeMapper.selectOfficeFloor(pid,id);
        for (Map<String, Object> stringObjectMap : flist) {
            LesseeUtil lesseeUtil=new LesseeUtil();
            lesseeUtil.setFloor(stringObjectMap.get("floor").toString());
            if (!StringUtils.isEmpty(stringObjectMap.get("area"))){
                lesseeUtil.setArea(stringObjectMap.get("area").toString());
            }else {
                lesseeUtil.setArea(null);
            }
            lesseeUtil.setList(this.floorToOfficeMapper.selectOfficeByfloor(id,
                    Integer.parseInt(stringObjectMap.get("floor").toString())));
            list.add(lesseeUtil);
        }
        return Body.newInstance(list);
    }
}
