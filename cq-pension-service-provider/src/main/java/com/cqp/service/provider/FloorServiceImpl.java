package com.cqp.service.provider;

import com.cqp.mapper.FloorMapper;
import com.cqp.model.Floor;
import com.cqp.service.api.FloorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Floor业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorMapper floorMapper;


    /**
     * Floor条件+分页查询
     * @param floor 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Floor> findPage(Floor floor, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(floor);
        //执行搜索
        return new PageInfo<Floor>(floorMapper.selectByExample(example));
    }

    /**
     * Floor分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Floor> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Floor>(floorMapper.selectAll());
    }

    /**
     * Floor条件查询
     * @param floor
     * @return
     */
    @Override
    public List<Floor> findList(Floor floor){
        //构建查询条件
        Example example = createExample(floor);
        //根据构建的条件查询数据
        return floorMapper.selectByExample(example);
    }


    /**
     * Floor构建查询对象
     * @param floor
     * @return
     */
    public Example createExample(Floor floor){
        Example example=new Example(Floor.class);
        Example.Criteria criteria = example.createCriteria();
        if(floor!=null){
            // 楼层编号
            if(!StringUtils.isEmpty(floor.getFlId())){
                    criteria.andEqualTo("flId",floor.getFlId());
            }
            // 楼房编号
            if(!StringUtils.isEmpty(floor.getBId())){
                    criteria.andEqualTo("bId",floor.getBId());
            }
            // 房间数量
            if(!StringUtils.isEmpty(floor.getRNum())){
                    criteria.andEqualTo("rNum",floor.getRNum());
            }
            // 楼层名称
            if(!StringUtils.isEmpty(floor.getFlName())){
                    criteria.andEqualTo("flName",floor.getFlName());
            }
            //
            if(!StringUtils.isEmpty(floor.getFlCharge())){
                    criteria.andEqualTo("flCharge",floor.getFlCharge());
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
        return floorMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Floor
     * @param floor
     */
    @Override
    public int update(Floor floor){
        return floorMapper.updateByPrimaryKey(floor);
    }

    /**
     * 增加Floor
     * @param floor
     */
    @Override
    public int add(Floor floor){
        return floorMapper.insert(floor);
    }

    /**
     * 根据ID查询Floor
     * @param id
     * @return
     */
    @Override
    public Floor findById(Integer id){
        return  floorMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Floor全部数据
     * @return
     */
    @Override
    public List<Floor> findAll() {
        return floorMapper.selectAll();
    }
}
