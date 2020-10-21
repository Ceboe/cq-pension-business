package com.cqp.service.provider;

import com.cqp.mapper.EmmUserMapper;
import com.cqp.model.EmmUser;
import com.cqp.service.api.EmmUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:EmmUser业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class EmmUserServiceImpl implements EmmUserService {

    @Autowired
    private EmmUserMapper emmUserMapper;


    /**
     * EmmUser条件+分页查询
     * @param emmUser 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<EmmUser> findPage(EmmUser emmUser, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(emmUser);
        //执行搜索
        return new PageInfo<EmmUser>(emmUserMapper.selectByExample(example));
    }

    /**
     * EmmUser分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<EmmUser> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<EmmUser>(emmUserMapper.selectAll());
    }

    /**
     * EmmUser条件查询
     * @param emmUser
     * @return
     */
    @Override
    public List<EmmUser> findList(EmmUser emmUser){
        //构建查询条件
        Example example = createExample(emmUser);
        //根据构建的条件查询数据
        return emmUserMapper.selectByExample(example);
    }


    /**
     * EmmUser构建查询对象
     * @param emmUser
     * @return
     */
    public Example createExample(EmmUser emmUser){
        Example example=new Example(EmmUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(emmUser!=null){
            // 编号
            if(!StringUtils.isEmpty(emmUser.getId())){
                    criteria.andEqualTo("id",emmUser.getId());
            }
            // 员工编号
            if(!StringUtils.isEmpty(emmUser.getEmpId())){
                    criteria.andEqualTo("empId",emmUser.getEmpId());
            }
            // 姓名
            if(!StringUtils.isEmpty(emmUser.getEmpName())){
                    criteria.andEqualTo("empName",emmUser.getEmpName());
            }
            // 密码
            if(!StringUtils.isEmpty(emmUser.getEmpPassword())){
                    criteria.andEqualTo("empPassword",emmUser.getEmpPassword());
            }
            // 角色
            if(!StringUtils.isEmpty(emmUser.getRoleId())){
                    criteria.andEqualTo("roleId",emmUser.getRoleId());
            }
            // 是否可用
            if(!StringUtils.isEmpty(emmUser.getCanUse())){
                    criteria.andEqualTo("canUse",emmUser.getCanUse());
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
        return emmUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改EmmUser
     * @param emmUser
     */
    @Override
    public int update(EmmUser emmUser){
        return emmUserMapper.updateByPrimaryKey(emmUser);
    }

    /**
     * 增加EmmUser
     * @param emmUser
     */
    @Override
    public void add(EmmUser emmUser){
        emmUserMapper.insert(emmUser);
    }

    /**
     * 根据ID查询EmmUser
     * @param id
     * @return
     */
    @Override
    public EmmUser findById(Integer id){
        return  emmUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询EmmUser全部数据
     * @return
     */
    @Override
    public List<EmmUser> findAll() {
        return emmUserMapper.selectAll();
    }

}
