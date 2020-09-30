package com.cqp.service.provider;

import com.cqp.mapper.OpeopleMapper;
import com.cqp.model.Opeople;
import com.cqp.service.api.OpeopleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Opeople业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class OpeopleServiceImpl implements OpeopleService {

    @Autowired
    private OpeopleMapper opeopleMapper;


    /**
     * Opeople条件+分页查询
     * @param opeople 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Opeople> findPage(Opeople opeople, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(opeople);
        //执行搜索
        return new PageInfo<Opeople>(opeopleMapper.selectByExample(example));
    }

    /**
     * Opeople分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Opeople> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Opeople>(opeopleMapper.selectAll());
    }

    /**
     * Opeople条件查询
     * @param opeople
     * @return
     */
    @Override
    public List<Opeople> findList(Opeople opeople){
        //构建查询条件
        Example example = createExample(opeople);
        //根据构建的条件查询数据
        return opeopleMapper.selectByExample(example);
    }


    /**
     * Opeople构建查询对象
     * @param opeople
     * @return
     */
    public Example createExample(Opeople opeople){
        Example example=new Example(Opeople.class);
        Example.Criteria criteria = example.createCriteria();
        if(opeople!=null){
            // 老人编号
            if(!StringUtils.isEmpty(opeople.getOpId())){
                    criteria.andEqualTo("opId",opeople.getOpId());
            }
            // 姓名
            if(!StringUtils.isEmpty(opeople.getOpName())){
                    criteria.andEqualTo("opName",opeople.getOpName());
            }
            // 年龄
            if(!StringUtils.isEmpty(opeople.getOpAge())){
                    criteria.andEqualTo("opAge",opeople.getOpAge());
            }
            // 性别
            if(!StringUtils.isEmpty(opeople.getOpSex())){
                    criteria.andEqualTo("opSex",opeople.getOpSex());
            }
            // 籍贯
            if(!StringUtils.isEmpty(opeople.getOpNative())){
                    criteria.andEqualTo("opNative",opeople.getOpNative());
            }
            // 生日
            if(!StringUtils.isEmpty(opeople.getOpBirthday())){
                    criteria.andEqualTo("opBirthday",opeople.getOpBirthday());
            }
            // 住址
            if(!StringUtils.isEmpty(opeople.getOpAddress())){
                    criteria.andEqualTo("opAddress",opeople.getOpAddress());
            }
            // 身份证号
            if(!StringUtils.isEmpty(opeople.getOpCard())){
                    criteria.andEqualTo("opCard",opeople.getOpCard());
            }
            // 照片
            if(!StringUtils.isEmpty(opeople.getOpPhoto())){
                    criteria.andEqualTo("opPhoto",opeople.getOpPhoto());
            }
            // 电话
            if(!StringUtils.isEmpty(opeople.getOpPhone())){
                    criteria.andEqualTo("opPhone",opeople.getOpPhone());
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
        opeopleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Opeople
     * @param opeople
     */
    @Override
    public void update(Opeople opeople){
        opeopleMapper.updateByPrimaryKey(opeople);
    }

    /**
     * 增加Opeople
     * @param opeople
     */
    @Override
    public void add(Opeople opeople){
        opeopleMapper.insert(opeople);
    }

    /**
     * 根据ID查询Opeople
     * @param id
     * @return
     */
    @Override
    public Opeople findById(Integer id){
        return  opeopleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Opeople全部数据
     * @return
     */
    @Override
    public List<Opeople> findAll() {
        return opeopleMapper.selectAll();
    }
}
