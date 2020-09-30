package com.cqp.service.provider;

import com.cqp.mapper.RepContentMapper;
import com.cqp.model.RepContent;
import com.cqp.service.api.RepContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:RepContent业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RepContentServiceImpl implements RepContentService {

    @Autowired
    private RepContentMapper repContentMapper;


    /**
     * RepContent条件+分页查询
     * @param repContent 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<RepContent> findPage(RepContent repContent, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(repContent);
        //执行搜索
        return new PageInfo<RepContent>(repContentMapper.selectByExample(example));
    }

    /**
     * RepContent分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<RepContent> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<RepContent>(repContentMapper.selectAll());
    }

    /**
     * RepContent条件查询
     * @param repContent
     * @return
     */
    @Override
    public List<RepContent> findList(RepContent repContent){
        //构建查询条件
        Example example = createExample(repContent);
        //根据构建的条件查询数据
        return repContentMapper.selectByExample(example);
    }


    /**
     * RepContent构建查询对象
     * @param repContent
     * @return
     */
    public Example createExample(RepContent repContent){
        Example example=new Example(RepContent.class);
        Example.Criteria criteria = example.createCriteria();
        if(repContent!=null){
            // ID
            if(!StringUtils.isEmpty(repContent.getRcId())){
                    criteria.andEqualTo("rcId",repContent.getRcId());
            }
            // 所属报表ID
            if(!StringUtils.isEmpty(repContent.getRepId())){
                    criteria.andEqualTo("repId",repContent.getRepId());
            }
            // 数据表
            if(!StringUtils.isEmpty(repContent.getRcData())){
                    criteria.andEqualTo("rcData",repContent.getRcData());
            }
            // 字段
            if(!StringUtils.isEmpty(repContent.getRcField())){
                    criteria.andEqualTo("rcField",repContent.getRcField());
            }
            // 字段注释
            if(!StringUtils.isEmpty(repContent.getFieldName())){
                    criteria.andEqualTo("fieldName",repContent.getFieldName());
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
        repContentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改RepContent
     * @param repContent
     */
    @Override
    public void update(RepContent repContent){
        repContentMapper.updateByPrimaryKey(repContent);
    }

    /**
     * 增加RepContent
     * @param repContent
     */
    @Override
    public void add(RepContent repContent){
        repContentMapper.insert(repContent);
    }

    /**
     * 根据ID查询RepContent
     * @param id
     * @return
     */
    @Override
    public RepContent findById(Integer id){
        return  repContentMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询RepContent全部数据
     * @return
     */
    @Override
    public List<RepContent> findAll() {
        return repContentMapper.selectAll();
    }
}
