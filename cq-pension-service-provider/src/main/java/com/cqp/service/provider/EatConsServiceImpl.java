package com.cqp.service.provider;

import com.cqp.mapper.EatConsMapper;
import com.cqp.model.EatCons;
import com.cqp.service.api.EatConsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:EatCons业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class EatConsServiceImpl implements EatConsService {

    @Autowired
    private EatConsMapper eatConsMapper;


    /**
     * EatCons条件+分页查询
     * @param eatCons 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<EatCons> findPage(EatCons eatCons, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(eatCons);
        //执行搜索
        return new PageInfo<EatCons>(eatConsMapper.selectByExample(example));
    }

    /**
     * EatCons分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<EatCons> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<EatCons>(eatConsMapper.selectAll());
    }

    /**
     * EatCons条件查询
     * @param eatCons
     * @return
     */
    @Override
    public List<EatCons> findList(EatCons eatCons){
        //构建查询条件
        Example example = createExample(eatCons);
        //根据构建的条件查询数据
        return eatConsMapper.selectByExample(example);
    }


    /**
     * EatCons构建查询对象
     * @param eatCons
     * @return
     */
    public Example createExample(EatCons eatCons){
        Example example=new Example(EatCons.class);
        Example.Criteria criteria = example.createCriteria();
        if(eatCons!=null){
            // 消费记录编号
            if(!StringUtils.isEmpty(eatCons.getEcId())){
                    criteria.andEqualTo("ecId",eatCons.getEcId());
            }
            // 老人编号
            if(!StringUtils.isEmpty(eatCons.getOpId())){
                    criteria.andEqualTo("opId",eatCons.getOpId());
            }
            // 收费单号
            if(!StringUtils.isEmpty(eatCons.getCbId())){
                    criteria.andEqualTo("cbId",eatCons.getCbId());
            }
            // 消费时间
            if(!StringUtils.isEmpty(eatCons.getConsTime())){
                    criteria.andEqualTo("consTime",eatCons.getConsTime());
            }
            // 套餐编号
            if(!StringUtils.isEmpty(eatCons.getPeId())){
                    criteria.andEqualTo("peId",eatCons.getPeId());
            }
            // 消费金额
            if(!StringUtils.isEmpty(eatCons.getPePrice())){
                    criteria.andEqualTo("pePrice",eatCons.getPePrice());
            }
            // 支付状态
            if(!StringUtils.isEmpty(eatCons.getEcStatus())){
                    criteria.andEqualTo("ecStatus",eatCons.getEcStatus());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        eatConsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改EatCons
     * @param eatCons
     */
    @Override
    public void update(EatCons eatCons){
        eatConsMapper.updateByPrimaryKey(eatCons);
    }

    /**
     * 增加EatCons
     * @param eatCons
     */
    @Override
    public void add(EatCons eatCons){
        eatConsMapper.insert(eatCons);
    }

    /**
     * 根据ID查询EatCons
     * @param id
     * @return
     */
    @Override
    public EatCons findById(Integer id){
        return  eatConsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询EatCons全部数据
     * @return
     */
    @Override
    public List<EatCons> findAll() {
        return eatConsMapper.selectAll();
    }
}
