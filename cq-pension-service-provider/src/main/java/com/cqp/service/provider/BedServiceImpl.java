package com.cqp.service.provider;

import com.cqp.mapper.BedMapper;
import com.cqp.model.Bed;
import com.cqp.service.api.BedService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Bed业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedMapper bedMapper;


    /**
     * Bed条件+分页查询
     * @param bed 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Bed> findPage(Bed bed, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(bed);
        //执行搜索
        return new PageInfo<Bed>(bedMapper.selectByExample(example));
    }

    /**
     * Bed分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Bed> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Bed>(bedMapper.selectAll());
    }

    /**
     * Bed条件查询
     * @param bed
     * @return
     */
    @Override
    public List<Bed> findList(Bed bed){
        //构建查询条件
        Example example = createExample(bed);
        //根据构建的条件查询数据
        return bedMapper.selectByExample(example);
    }


    /**
     * Bed构建查询对象
     * @param bed
     * @return
     */
    public Example createExample(Bed bed){
        Example example=new Example(Bed.class);
        Example.Criteria criteria = example.createCriteria();
        if(bed!=null){
            // 床位编号
            if(!StringUtils.isEmpty(bed.getBedId())){
                    criteria.andEqualTo("bedId",bed.getBedId());
            }
            // 房间编号
            if(!StringUtils.isEmpty(bed.getRoomId())){
                    criteria.andEqualTo("roomId",bed.getRoomId());
            }
            // 入住价格
            if(!StringUtils.isEmpty(bed.getBedPrice())){
                    criteria.andEqualTo("bedPrice",bed.getBedPrice());
            }
            // 是否占用
            if(!StringUtils.isEmpty(bed.getBedOccupy())){
                    criteria.andEqualTo("bedOccupy",bed.getBedOccupy());
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
        bedMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Bed
     * @param bed
     */
    @Override
    public void update(Bed bed){
        bedMapper.updateByPrimaryKey(bed);
    }

    /**
     * 增加Bed
     * @param bed
     */
    @Override
    public void add(Bed bed){
        bedMapper.insert(bed);
    }

    /**
     * 根据ID查询Bed
     * @param id
     * @return
     */
    @Override
    public Bed findById(Integer id){
        return  bedMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Bed全部数据
     * @return
     */
    @Override
    public List<Bed> findAll() {
        return bedMapper.selectAll();
    }
}
