package com.cqp.service.provider;

import com.cqp.mapper.BuildMapper;
import com.cqp.model.Build;
import com.cqp.service.api.BuildService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Build业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class BuildServiceImpl implements BuildService {

    @Autowired
    private BuildMapper buildMapper;


    /**
     * Build条件+分页查询
     * @param build 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Build> findPage(Build build, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(build);
        //执行搜索
        return new PageInfo<Build>(buildMapper.selectByExample(example));
    }

    /**
     * Build分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Build> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Build>(buildMapper.selectAll());
    }

    /**
     * Build条件查询
     * @param build
     * @return
     */
    @Override
    public List<Build> findList(Build build){
        //构建查询条件
        Example example = createExample(build);
        //根据构建的条件查询数据
        return buildMapper.selectByExample(example);
    }


    /**
     * Build构建查询对象
     * @param build
     * @return
     */
    public Example createExample(Build build){
        Example example=new Example(Build.class);
        Example.Criteria criteria = example.createCriteria();
        if(build!=null){
            // 楼房编号
            if(!StringUtils.isEmpty(build.getBId())){
                    criteria.andEqualTo("bId",build.getBId());
            }
            // 名称
            if(!StringUtils.isEmpty(build.getBName())){
                    criteria.andEqualTo("bName",build.getBName());
            }
            // 层数
            if(!StringUtils.isEmpty(build.getFlNum())){
                    criteria.andEqualTo("flNum",build.getFlNum());
            }
            // 建成时间
            if(!StringUtils.isEmpty(build.getBTime())){
                    criteria.andEqualTo("bTime",build.getBTime());
            }
            // 用途
            if(!StringUtils.isEmpty(build.getBPer())){
                    criteria.andEqualTo("bPer",build.getBPer());
            }
            // 建设负责人
            if(!StringUtils.isEmpty(build.getDevCharge())){
                    criteria.andEqualTo("devCharge",build.getDevCharge());
            }
            // 楼房负责人
            if(!StringUtils.isEmpty(build.getBCharge())){
                    criteria.andEqualTo("bCharge",build.getBCharge());
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
        return buildMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Build
     * @param build
     */
    @Override
    public int update(Build build){
        return buildMapper.updateByPrimaryKey(build);
    }

    /**
     * 增加Build
     * @param build
     */
    @Override
    public int add(Build build){
        return buildMapper.insert(build);
    }

    /**
     * 根据ID查询Build
     * @param id
     * @return
     */
    @Override
    public Build findById(Integer id){
        return  buildMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Build全部数据
     * @return
     */
    @Override
    public List<Build> findAll() {
        return buildMapper.selectAll();
    }
}
