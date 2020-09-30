package com.cqp.service.provider;

import com.cqp.mapper.BedReplMapper;
import com.cqp.model.BedRepl;
import com.cqp.service.api.BedReplService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:BedRepl业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class BedReplServiceImpl implements BedReplService {

    @Autowired
    private BedReplMapper bedReplMapper;


    /**
     * BedRepl条件+分页查询
     * @param bedRepl 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<BedRepl> findPage(BedRepl bedRepl, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(bedRepl);
        //执行搜索
        return new PageInfo<BedRepl>(bedReplMapper.selectByExample(example));
    }

    /**
     * BedRepl分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<BedRepl> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<BedRepl>(bedReplMapper.selectAll());
    }

    /**
     * BedRepl条件查询
     * @param bedRepl
     * @return
     */
    @Override
    public List<BedRepl> findList(BedRepl bedRepl){
        //构建查询条件
        Example example = createExample(bedRepl);
        //根据构建的条件查询数据
        return bedReplMapper.selectByExample(example);
    }


    /**
     * BedRepl构建查询对象
     * @param bedRepl
     * @return
     */
    public Example createExample(BedRepl bedRepl){
        Example example=new Example(BedRepl.class);
        Example.Criteria criteria = example.createCriteria();
        if(bedRepl!=null){
            // 记录编号
            if(!StringUtils.isEmpty(bedRepl.getBrId())){
                    criteria.andEqualTo("brId",bedRepl.getBrId());
            }
            // 老人编号
            if(!StringUtils.isEmpty(bedRepl.getOpId())){
                    criteria.andEqualTo("opId",bedRepl.getOpId());
            }
            // 原床位编号
            if(!StringUtils.isEmpty(bedRepl.getOBedId())){
                    criteria.andEqualTo("oBedId",bedRepl.getOBedId());
            }
            // 新床位编号
            if(!StringUtils.isEmpty(bedRepl.getNBedId())){
                    criteria.andEqualTo("nBedId",bedRepl.getNBedId());
            }
            // 负责人
            if(!StringUtils.isEmpty(bedRepl.getCharge())){
                    criteria.andEqualTo("charge",bedRepl.getCharge());
            }
            // 备注
            if(!StringUtils.isEmpty(bedRepl.getRemark())){
                    criteria.andEqualTo("remark",bedRepl.getRemark());
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
        bedReplMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改BedRepl
     * @param bedRepl
     */
    @Override
    public void update(BedRepl bedRepl){
        bedReplMapper.updateByPrimaryKey(bedRepl);
    }

    /**
     * 增加BedRepl
     * @param bedRepl
     */
    @Override
    public void add(BedRepl bedRepl){
        bedReplMapper.insert(bedRepl);
    }

    /**
     * 根据ID查询BedRepl
     * @param id
     * @return
     */
    @Override
    public BedRepl findById(Integer id){
        return  bedReplMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询BedRepl全部数据
     * @return
     */
    @Override
    public List<BedRepl> findAll() {
        return bedReplMapper.selectAll();
    }
}
