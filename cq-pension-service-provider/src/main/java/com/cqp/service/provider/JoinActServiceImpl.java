package com.cqp.service.provider;

import com.cqp.mapper.JoinActMapper;
import com.cqp.model.JoinAct;
import com.cqp.service.api.JoinActService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:JoinAct业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class JoinActServiceImpl implements JoinActService {

    @Autowired
    private JoinActMapper joinActMapper;


    /**
     * JoinAct条件+分页查询
     * @param joinAct 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<JoinAct> findPage(JoinAct joinAct, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(joinAct);
        //执行搜索
        return new PageInfo<JoinAct>(joinActMapper.selectByExample(example));
    }

    /**
     * JoinAct分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<JoinAct> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<JoinAct>(joinActMapper.selectAll());
    }

    /**
     * JoinAct条件查询
     * @param joinAct
     * @return
     */
    @Override
    public List<JoinAct> findList(JoinAct joinAct){
        //构建查询条件
        Example example = createExample(joinAct);
        //根据构建的条件查询数据
        return joinActMapper.selectByExample(example);
    }


    /**
     * JoinAct构建查询对象
     * @param joinAct
     * @return
     */
    public Example createExample(JoinAct joinAct){
        Example example=new Example(JoinAct.class);
        Example.Criteria criteria = example.createCriteria();
        if(joinAct!=null){
            // id
            if(!StringUtils.isEmpty(joinAct.getJaId())){
                    criteria.andEqualTo("jaId",joinAct.getJaId());
            }
            // 活动id
            if(!StringUtils.isEmpty(joinAct.getActId())){
                    criteria.andEqualTo("actId",joinAct.getActId());
            }
            // 活动名称
            if(!StringUtils.isEmpty(joinAct.getActName())){
                    criteria.andEqualTo("actName",joinAct.getActName());
            }
            // 老人id
            if(!StringUtils.isEmpty(joinAct.getOpId())){
                    criteria.andEqualTo("opId",joinAct.getOpId());
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
        return joinActMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改JoinAct
     * @param joinAct
     */
    @Override
    public int update(JoinAct joinAct){
        return joinActMapper.updateByPrimaryKey(joinAct);
    }

    /**
     * 增加JoinAct
     * @param joinAct
     */
    @Override
    public int add(JoinAct joinAct){
        return joinActMapper.insert(joinAct);
    }

    /**
     * 根据ID查询JoinAct
     * @param id
     * @return
     */
    @Override
    public JoinAct findById(Integer id){
        return  joinActMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询JoinAct全部数据
     * @return
     */
    @Override
    public List<JoinAct> findAll() {
        return joinActMapper.selectAll();
    }
}
