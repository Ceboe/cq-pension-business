package com.cqp.service.provider;

import com.cqp.mapper.FamilyMapper;
import com.cqp.model.Family;
import com.cqp.service.api.FamilyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Family业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyMapper familyMapper;


    /**
     * Family条件+分页查询
     * @param family 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Family> findPage(Family family, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(family);
        //执行搜索
        return new PageInfo<Family>(familyMapper.selectByExample(example));
    }

    /**
     * Family分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Family> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Family>(familyMapper.selectAll());
    }

    /**
     * Family条件查询
     * @param family
     * @return
     */
    @Override
    public List<Family> findList(Family family){
        //构建查询条件
        Example example = createExample(family);
        //根据构建的条件查询数据
        return familyMapper.selectByExample(example);
    }


    /**
     * Family构建查询对象
     * @param family
     * @return
     */
    public Example createExample(Family family){
        Example example=new Example(Family.class);
        Example.Criteria criteria = example.createCriteria();
        if(family!=null){
            // 家属编号
            if(!StringUtils.isEmpty(family.getFmId())){
                    criteria.andEqualTo("fmId",family.getFmId());
            }
            // 老人编号
            if(!StringUtils.isEmpty(family.getOpId())){
                    criteria.andEqualTo("opId",family.getOpId());
            }
            // 家属名字
            if(!StringUtils.isEmpty(family.getFmName())){
                    criteria.andEqualTo("fmName",family.getFmName());
            }
            // 性别
            if(!StringUtils.isEmpty(family.getFmSex())){
                    criteria.andEqualTo("fmSex",family.getFmSex());
            }
            // 联系电话
            if(!StringUtils.isEmpty(family.getFmPhone())){
                    criteria.andEqualTo("fmPhone",family.getFmPhone());
            }
            // 家庭地址
            if(!StringUtils.isEmpty(family.getFmAddress())){
                    criteria.andEqualTo("fmAddress",family.getFmAddress());
            }
            // 办公地址
            if(!StringUtils.isEmpty(family.getFmOffice())){
                    criteria.andEqualTo("fmOffice",family.getFmOffice());
            }
            // 亲属关系
            if(!StringUtils.isEmpty(family.getFmRel())){
                    criteria.andEqualTo("fmRel",family.getFmRel());
            }
            // 是否负责人
            if(!StringUtils.isEmpty(family.getFmCharge())){
                    criteria.andEqualTo("fmCharge",family.getFmCharge());
            }
            // 记录人
            if(!StringUtils.isEmpty(family.getFmRecord())){
                    criteria.andEqualTo("fmRecord",family.getFmRecord());
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
        return familyMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Family
     * @param family
     */
    @Override
    public void update(Family family){
        familyMapper.updateByPrimaryKey(family);
    }

    /**
     * 增加Family
     * @param family
     */
    @Override
    public int add(Family family){
        return familyMapper.insert(family);
    }

    /**
     * 根据ID查询Family
     * @param id
     * @return
     */
    @Override
    public Family findById(Integer id){
        return  familyMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Family全部数据
     * @return
     */
    @Override
    public List<Family> findAll() {
        return familyMapper.selectAll();
    }
}
