package com.cqp.service.provider;

import com.cqp.mapper.KitchenMapper;
import com.cqp.model.Kitchen;
import com.cqp.service.api.KitchenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Kitchen业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class KitchenServiceImpl implements KitchenService {

    @Autowired
    private KitchenMapper kitchenMapper;


    /**
     * Kitchen条件+分页查询
     * @param kitchen 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Kitchen> findPage(Kitchen kitchen, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(kitchen);
        //执行搜索
        return new PageInfo<Kitchen>(kitchenMapper.selectByExample(example));
    }

    /**
     * Kitchen分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Kitchen> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Kitchen>(kitchenMapper.selectAll());
    }

    /**
     * Kitchen条件查询
     * @param kitchen
     * @return
     */
    @Override
    public List<Kitchen> findList(Kitchen kitchen){
        //构建查询条件
        Example example = createExample(kitchen);
        //根据构建的条件查询数据
        return kitchenMapper.selectByExample(example);
    }


    /**
     * Kitchen构建查询对象
     * @param kitchen
     * @return
     */
    public Example createExample(Kitchen kitchen){
        Example example=new Example(Kitchen.class);
        Example.Criteria criteria = example.createCriteria();
        if(kitchen!=null){
            // 菜品编号
            if(!StringUtils.isEmpty(kitchen.getKId())){
                    criteria.andEqualTo("kId",kitchen.getKId());
            }
            // 时间
            if(!StringUtils.isEmpty(kitchen.getTime())){
                    criteria.andEqualTo("time",kitchen.getTime());
            }
            // 菜品名
            if(!StringUtils.isEmpty(kitchen.getDishName())){
                    criteria.andEqualTo("dishName",kitchen.getDishName());
            }
            // 菜品组成
            if(!StringUtils.isEmpty(kitchen.getDishMake())){
                    criteria.andEqualTo("dishMake",kitchen.getDishMake());
            }
            // 菜品配料
            if(!StringUtils.isEmpty(kitchen.getDishMix())){
                    criteria.andEqualTo("dishMix",kitchen.getDishMix());
            }
            // 厨师
            if(!StringUtils.isEmpty(kitchen.getCooker())){
                    criteria.andEqualTo("cooker",kitchen.getCooker());
            }
            // 厨房负责人
            if(!StringUtils.isEmpty(kitchen.getCharge())){
                    criteria.andEqualTo("charge",kitchen.getCharge());
            }
            // 记录人
            if(!StringUtils.isEmpty(kitchen.getRecorder())){
                    criteria.andEqualTo("recorder",kitchen.getRecorder());
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
        return kitchenMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Kitchen
     * @param kitchen
     */
    @Override
    public int update(Kitchen kitchen){
        return kitchenMapper.updateByPrimaryKey(kitchen);
    }

    /**
     * 增加Kitchen
     * @param kitchen
     */
    @Override
    public int add(Kitchen kitchen){
        return kitchenMapper.insert(kitchen);
    }

    /**
     * 根据ID查询Kitchen
     * @param id
     * @return
     */
    @Override
    public Kitchen findById(Integer id){
        return  kitchenMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Kitchen全部数据
     * @return
     */
    @Override
    public List<Kitchen> findAll() {
        return kitchenMapper.selectAll();
    }
}
