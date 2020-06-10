package cc.mrbird.febs.app.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.app.entity.Contract;
import cc.mrbird.febs.app.mapper.ContractMapper;
import cc.mrbird.febs.app.service.IContractService;
import cc.mrbird.febs.common.utils.json.Body;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *  Service实现
 *
 * @author 冷酷的苹果
 * @date 2020-05-18 14:04:02
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

    private final ContractMapper contractMapper;

    @Override
    public IPage<Contract> findContracts(QueryRequest request, Contract contract) {
        LambdaQueryWrapper<Contract> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Contract> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Contract> findContracts(Contract contract) {
	    LambdaQueryWrapper<Contract> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createContract(Contract contract) {
        this.save(contract);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateContract(Contract contract) {
        this.saveOrUpdate(contract);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteContract(Contract contract) {
        LambdaQueryWrapper<Contract> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public Body selectContract(String condition, String id,Integer door) {
        List<Map<String,Object>> list=this.contractMapper.selectContract(condition,id,door);
        if (list.size()>0){
            return Body.newInstance(list);
        }
        return Body.newInstance(201,"没有数据");
    }

    @Override
    public Body selectContractByConIdAndDoor(Integer id, Integer door) {
        Map<String,Object>list=this.contractMapper.selectContractByConIdAndDoor(id,door);
        if (list.size()>0){
            return Body.newInstance(list);
        }
        return Body.newInstance(201,"查询失败");
    }
}
