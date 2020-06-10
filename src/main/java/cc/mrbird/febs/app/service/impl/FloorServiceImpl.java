package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Floor;
import cc.mrbird.febs.app.mapper.FloorMapper;
import cc.mrbird.febs.app.service.IFloorService;
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
 * @date 2020-05-08 13:40:43
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FloorServiceImpl extends ServiceImpl<FloorMapper, Floor> implements IFloorService {

    private final FloorMapper floorMapper;

    @Override
    public IPage<Floor> findFloors(QueryRequest request, Floor floor) {
        LambdaQueryWrapper<Floor> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Floor> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Floor> findFloors(Floor floor) {
        LambdaQueryWrapper<Floor> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createFloor(Floor floor) {
        this.save(floor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateFloor(Floor floor) {
        this.saveOrUpdate(floor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteFloor(Floor floor) {
        LambdaQueryWrapper<Floor> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectFloorById(Integer buildingId) {
        LambdaQueryWrapper<Floor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Floor::getFloorToBuildingId, buildingId);
        List<Floor> list = this.floorMapper.selectList(wrapper);
        if (list.size()>0) {
            return Body.newInstance(list);
        } else {
            return Body.newInstance(201,"没有查询到信息");
        }
    }

    @Override
    public Body insertFloor(Floor floor) {
        Integer count=this.floorMapper.insert(floor);
        if (count==1){
            return Body.newInstance(floor);
        }
        return Body.newInstance(201,"添加楼层失败");
    }

    @Override
    public Body selectFloorToId(Integer pid, String state) {
        LambdaQueryWrapper<Floor> wrapper=new LambdaQueryWrapper();
        wrapper.eq(Floor::getFloorToBuildingId,pid);
        wrapper.eq(Floor::getState,state);
        List<Floor>list=this.floorMapper.selectList(wrapper);
        if (list.size()>0){
            return Body.newInstance(list);
        }
        return Body.newInstance(201,"没有添加楼栋");
    }

}
