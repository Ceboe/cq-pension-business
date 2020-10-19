package com.cqp.service.provider;

import com.cqp.mapper.PersonEatMapper;
import com.cqp.model.PersonEat;
import com.cqp.service.api.PersonEatService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:PersonEat业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PersonEatServiceImpl implements PersonEatService {

    @Autowired
    private PersonEatMapper personEatMapper;


    /**
     * PersonEat条件+分页查询
     * @param personEat 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PersonEat> findPage(PersonEat personEat, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(personEat);
        //执行搜索
        return new PageInfo<PersonEat>(personEatMapper.selectByExample(example));
    }

    /**
     * PersonEat分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PersonEat> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PersonEat>(personEatMapper.selectAll());
    }

    /**
     * PersonEat条件查询
     * @param personEat
     * @return
     */
    @Override
    public List<PersonEat> findList(PersonEat personEat){
        //构建查询条件
        Example example = createExample(personEat);
        //根据构建的条件查询数据
        return personEatMapper.selectByExample(example);
    }


    /**
     * PersonEat构建查询对象
     * @param personEat
     * @return
     */
    public Example createExample(PersonEat personEat){
        Example example=new Example(PersonEat.class);
        Example.Criteria criteria = example.createCriteria();
        if(personEat!=null){
            // 需求编号
            if(!StringUtils.isEmpty(personEat.getPeId())){
                    criteria.andEqualTo("peId",personEat.getPeId());
            }
            // 老人编号
            if(!StringUtils.isEmpty(personEat.getOpId())){
                    criteria.andEqualTo("opId",personEat.getOpId());
            }
            // 忌口
            if(!StringUtils.isEmpty(personEat.getDishlike())){
                    criteria.andEqualTo("dishlike",personEat.getDishlike());
            }
            // 饮食编号
            if(!StringUtils.isEmpty(personEat.getHabbit())){
                    criteria.andEqualTo("habbit",personEat.getHabbit());
            }
            // 记录人
            if(!StringUtils.isEmpty(personEat.getPeRec())){
                    criteria.andEqualTo("peRec",personEat.getPeRec());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public int delete(Integer id){
        return personEatMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PersonEat
     * @param personEat
     */
    @Override
    public int update(PersonEat personEat){
        return personEatMapper.updateByPrimaryKey(personEat);
    }

    /**
     * 增加PersonEat
     * @param personEat
     */
    @Override
    public int add(PersonEat personEat){
        return personEatMapper.insert(personEat);
    }

    /**
     * 根据ID查询PersonEat
     * @param id
     * @return
     */
    @Override
    public PersonEat findById(Integer id){
        return  personEatMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PersonEat全部数据
     * @return
     */
    @Override
    public List<PersonEat> findAll() {
        return personEatMapper.selectAll();
    }
}
