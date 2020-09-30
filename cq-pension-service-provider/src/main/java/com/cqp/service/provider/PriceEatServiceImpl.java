package com.cqp.service.provider;

import com.cqp.mapper.PriceEatMapper;
import com.cqp.model.PriceEat;
import com.cqp.service.api.PriceEatService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:PriceEat业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PriceEatServiceImpl implements PriceEatService {

    @Autowired
    private PriceEatMapper priceEatMapper;


    /**
     * PriceEat条件+分页查询
     * @param priceEat 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PriceEat> findPage(PriceEat priceEat, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(priceEat);
        //执行搜索
        return new PageInfo<PriceEat>(priceEatMapper.selectByExample(example));
    }

    /**
     * PriceEat分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PriceEat> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PriceEat>(priceEatMapper.selectAll());
    }

    /**
     * PriceEat条件查询
     * @param priceEat
     * @return
     */
    @Override
    public List<PriceEat> findList(PriceEat priceEat){
        //构建查询条件
        Example example = createExample(priceEat);
        //根据构建的条件查询数据
        return priceEatMapper.selectByExample(example);
    }


    /**
     * PriceEat构建查询对象
     * @param priceEat
     * @return
     */
    public Example createExample(PriceEat priceEat){
        Example example=new Example(PriceEat.class);
        Example.Criteria criteria = example.createCriteria();
        if(priceEat!=null){
            // 套餐编号
            if(!StringUtils.isEmpty(priceEat.getPeId())){
                    criteria.andEqualTo("peId",priceEat.getPeId());
            }
            // 套餐名
            if(!StringUtils.isEmpty(priceEat.getMael())){
                    criteria.andEqualTo("mael",priceEat.getMael());
            }
            // 特点
            if(!StringUtils.isEmpty(priceEat.getFeature())){
                    criteria.andEqualTo("feature",priceEat.getFeature());
            }
            // 规格编号
            if(!StringUtils.isEmpty(priceEat.getPeSpec())){
                    criteria.andEqualTo("peSpec",priceEat.getPeSpec());
            }
            // 套餐组成
            if(!StringUtils.isEmpty(priceEat.getMMake())){
                    criteria.andEqualTo("mMake",priceEat.getMMake());
            }
            // 套餐配置人
            if(!StringUtils.isEmpty(priceEat.getMPerson())){
                    criteria.andEqualTo("mPerson",priceEat.getMPerson());
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
        priceEatMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PriceEat
     * @param priceEat
     */
    @Override
    public void update(PriceEat priceEat){
        priceEatMapper.updateByPrimaryKey(priceEat);
    }

    /**
     * 增加PriceEat
     * @param priceEat
     */
    @Override
    public void add(PriceEat priceEat){
        priceEatMapper.insert(priceEat);
    }

    /**
     * 根据ID查询PriceEat
     * @param id
     * @return
     */
    @Override
    public PriceEat findById(Integer id){
        return  priceEatMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PriceEat全部数据
     * @return
     */
    @Override
    public List<PriceEat> findAll() {
        return priceEatMapper.selectAll();
    }
}
