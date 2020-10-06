package com.cqp.service.provider;

import com.cqp.mapper.NursProjMapper;
import com.cqp.model.NursProj;
import com.cqp.service.api.NursProjService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:NursProj业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class NursProjServiceImpl implements NursProjService {

    @Autowired
    private NursProjMapper nursProjMapper;


    /**
     * NursProj条件+分页查询
     * @param nursProj 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<NursProj> findPage(NursProj nursProj, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(nursProj);
        //执行搜索
        return new PageInfo<NursProj>(nursProjMapper.selectByExample(example));
    }

    /**
     * NursProj分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<NursProj> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<NursProj>(nursProjMapper.selectAll());
    }

    /**
     * NursProj条件查询
     * @param nursProj
     * @return
     */
    @Override
    public List<NursProj> findList(NursProj nursProj){
        //构建查询条件
        Example example = createExample(nursProj);
        //根据构建的条件查询数据
        return nursProjMapper.selectByExample(example);
    }


    /**
     * NursProj构建查询对象
     * @param nursProj
     * @return
     */
    public Example createExample(NursProj nursProj){
        Example example=new Example(NursProj.class);
        Example.Criteria criteria = example.createCriteria();
        if(nursProj!=null){
            // 护理项编号
            if(!StringUtils.isEmpty(nursProj.getNpId())){
                    criteria.andEqualTo("npId",nursProj.getNpId());
            }
            // 护理项名称
            if(!StringUtils.isEmpty(nursProj.getNaName())){
                    criteria.andEqualTo("naName",nursProj.getNaName());
            }
            // 详情
            if(!StringUtils.isEmpty(nursProj.getNpDes())){
                    criteria.andEqualTo("npDes",nursProj.getNpDes());
            }
            // 价格
            if(!StringUtils.isEmpty(nursProj.getNpPrice())){
                    criteria.andEqualTo("npPrice",nursProj.getNpPrice());
            }
            // 备注
            if(!StringUtils.isEmpty(nursProj.getRemark())){
                    criteria.andEqualTo("remark",nursProj.getRemark());
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
        nursProjMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改NursProj
     * @param nursProj
     */
    @Override
    public void update(NursProj nursProj){
        nursProjMapper.updateByPrimaryKey(nursProj);
    }

    /**
     * 增加NursProj
     * @param nursProj
     */
    @Override
    public void add(NursProj nursProj){
        nursProjMapper.insert(nursProj);
    }

    /**
     * 根据ID查询NursProj
     * @param id
     * @return
     */
    @Override
    public NursProj findById(Integer id){
        return  nursProjMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询NursProj全部数据
     * @return
     */
    @Override
    public List<NursProj> findAll() {
        return nursProjMapper.selectAll();
    }
}
