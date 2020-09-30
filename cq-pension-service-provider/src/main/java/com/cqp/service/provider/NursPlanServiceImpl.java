package com.cqp.service.provider;

import com.cqp.mapper.NursPlanMapper;
import com.cqp.model.NursPlan;
import com.cqp.service.api.NursPlanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:NursPlan业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class NursPlanServiceImpl implements NursPlanService {

    @Autowired
    private NursPlanMapper nursPlanMapper;


    /**
     * NursPlan条件+分页查询
     * @param nursPlan 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<NursPlan> findPage(NursPlan nursPlan, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(nursPlan);
        //执行搜索
        return new PageInfo<NursPlan>(nursPlanMapper.selectByExample(example));
    }

    /**
     * NursPlan分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<NursPlan> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<NursPlan>(nursPlanMapper.selectAll());
    }

    /**
     * NursPlan条件查询
     * @param nursPlan
     * @return
     */
    @Override
    public List<NursPlan> findList(NursPlan nursPlan){
        //构建查询条件
        Example example = createExample(nursPlan);
        //根据构建的条件查询数据
        return nursPlanMapper.selectByExample(example);
    }


    /**
     * NursPlan构建查询对象
     * @param nursPlan
     * @return
     */
    public Example createExample(NursPlan nursPlan){
        Example example=new Example(NursPlan.class);
        Example.Criteria criteria = example.createCriteria();
        if(nursPlan!=null){
            // 计划编号
            if(!StringUtils.isEmpty(nursPlan.getNId())){
                    criteria.andEqualTo("nId",nursPlan.getNId());
            }
            // 老人编号
            if(!StringUtils.isEmpty(nursPlan.getOpId())){
                    criteria.andEqualTo("opId",nursPlan.getOpId());
            }
            // 护理等级
            if(!StringUtils.isEmpty(nursPlan.getNpLevel())){
                    criteria.andEqualTo("npLevel",nursPlan.getNpLevel());
            }
            // 描述
            if(!StringUtils.isEmpty(nursPlan.getDescription())){
                    criteria.andEqualTo("description",nursPlan.getDescription());
            }
            // 附件地址
            if(!StringUtils.isEmpty(nursPlan.getAddaAddr())){
                    criteria.andEqualTo("addaAddr",nursPlan.getAddaAddr());
            }
            // 记录人
            if(!StringUtils.isEmpty(nursPlan.getNoteTaker())){
                    criteria.andEqualTo("noteTaker",nursPlan.getNoteTaker());
            }
            // 备注
            if(!StringUtils.isEmpty(nursPlan.getRemark())){
                    criteria.andEqualTo("remark",nursPlan.getRemark());
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
        nursPlanMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改NursPlan
     * @param nursPlan
     */
    @Override
    public void update(NursPlan nursPlan){
        nursPlanMapper.updateByPrimaryKey(nursPlan);
    }

    /**
     * 增加NursPlan
     * @param nursPlan
     */
    @Override
    public void add(NursPlan nursPlan){
        nursPlanMapper.insert(nursPlan);
    }

    /**
     * 根据ID查询NursPlan
     * @param id
     * @return
     */
    @Override
    public NursPlan findById(Integer id){
        return  nursPlanMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询NursPlan全部数据
     * @return
     */
    @Override
    public List<NursPlan> findAll() {
        return nursPlanMapper.selectAll();
    }
}
