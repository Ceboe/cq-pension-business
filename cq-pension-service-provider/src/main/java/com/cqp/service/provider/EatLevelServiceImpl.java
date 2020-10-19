package com.cqp.service.provider;

import com.cqp.mapper.EatLevelMapper;
import com.cqp.model.EatLevel;
import com.cqp.service.api.EatLevelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:EatLevel业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class EatLevelServiceImpl implements EatLevelService {

    @Autowired
    private EatLevelMapper eatLevelMapper;


    /**
     * EatLevel条件+分页查询
     * @param eatLevel 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<EatLevel> findPage(EatLevel eatLevel, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(eatLevel);
        //执行搜索
        return new PageInfo<EatLevel>(eatLevelMapper.selectByExample(example));
    }

    /**
     * EatLevel分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<EatLevel> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<EatLevel>(eatLevelMapper.selectAll());
    }

    /**
     * EatLevel条件查询
     * @param eatLevel
     * @return
     */
    @Override
    public List<EatLevel> findList(EatLevel eatLevel){
        //构建查询条件
        Example example = createExample(eatLevel);
        //根据构建的条件查询数据
        return eatLevelMapper.selectByExample(example);
    }


    /**
     * EatLevel构建查询对象
     * @param eatLevel
     * @return
     */
    public Example createExample(EatLevel eatLevel){
        Example example=new Example(EatLevel.class);
        Example.Criteria criteria = example.createCriteria();
        if(eatLevel!=null){
            // 规格编号
            if(!StringUtils.isEmpty(eatLevel.getElId())){
                    criteria.andEqualTo("elId",eatLevel.getElId());
            }
            // 描述
            if(!StringUtils.isEmpty(eatLevel.getElDes())){
                    criteria.andEqualTo("elDes",eatLevel.getElDes());
            }
            // 价格
            if(!StringUtils.isEmpty(eatLevel.getElPrice())){
                    criteria.andEqualTo("elPrice",eatLevel.getElPrice());
            }
            // 记录人
            if(!StringUtils.isEmpty(eatLevel.getNoteTaker())){
                    criteria.andEqualTo("noteTaker",eatLevel.getNoteTaker());
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
        return eatLevelMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改EatLevel
     * @param eatLevel
     */
    @Override
    public int update(EatLevel eatLevel){
        return eatLevelMapper.updateByPrimaryKey(eatLevel);
    }

    /**
     * 增加EatLevel
     * @param eatLevel
     */
    @Override
    public int add(EatLevel eatLevel){
        return eatLevelMapper.insert(eatLevel);
    }

    /**
     * 根据ID查询EatLevel
     * @param id
     * @return
     */
    @Override
    public EatLevel findById(Integer id){
        return  eatLevelMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询EatLevel全部数据
     * @return
     */
    @Override
    public List<EatLevel> findAll() {
        return eatLevelMapper.selectAll();
    }
}
