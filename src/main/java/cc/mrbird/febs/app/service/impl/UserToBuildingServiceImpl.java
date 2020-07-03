package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.app.entity.UserToBuilding;
import cc.mrbird.febs.app.mapper.OfficeMapper;
import cc.mrbird.febs.app.mapper.UserToBuildingMapper;
import cc.mrbird.febs.app.service.IUserToBuildingService;
import cc.mrbird.febs.common.entity.FebsResponse;
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

import java.util.List;
import java.util.Map;

/**
 * Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-08 10:16:51
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserToBuildingServiceImpl extends ServiceImpl<UserToBuildingMapper, UserToBuilding> implements IUserToBuildingService {

    private final UserToBuildingMapper userToBuildingMapper;

    private final OfficeMapper officeMapper;

    @Override
    public IPage<UserToBuilding> findUserToBuildings(QueryRequest request, UserToBuilding userToBuilding) {
        LambdaQueryWrapper<UserToBuilding> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<UserToBuilding> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<UserToBuilding> findUserToBuildings(UserToBuilding userToBuilding) {
        LambdaQueryWrapper<UserToBuilding> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUserToBuilding(UserToBuilding userToBuilding) {
        this.save(userToBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserToBuilding(UserToBuilding userToBuilding) {
        this.saveOrUpdate(userToBuilding);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserToBuilding(UserToBuilding userToBuilding) {
        LambdaQueryWrapper<UserToBuilding> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public Body selectBuildingInLessee(String name) {
        List<Map<String, Object>> list = this.userToBuildingMapper.selectBuildingInLessee(name);
        if (list.size() > 0) {
            for (Map<String, Object> stringObjectMap : list) {
                Integer id = Integer.parseInt((String) stringObjectMap.get("id"));
                Integer count = officeMapper.selectCountByBuildingId(id);
                stringObjectMap.put("count", count);
            }
            return Body.newInstance(list);
        } else {
            return Body.newInstance(201, "没有相关记录");
        }
    }
}
