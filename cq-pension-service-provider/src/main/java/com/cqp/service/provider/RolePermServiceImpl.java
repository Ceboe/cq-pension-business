package com.cqp.service.provider;

import com.cqp.mapper.RolePermMapper;
import com.cqp.model.RolePerm;
import com.cqp.service.api.RolePermService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:RolePerm业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RolePermServiceImpl implements RolePermService {

    @Autowired
    private RolePermMapper rolePermMapper;


    /**
     * RolePerm条件+分页查询
     * @param rolePerm 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<RolePerm> findPage(RolePerm rolePerm, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(rolePerm);
        //执行搜索
        return new PageInfo<RolePerm>(rolePermMapper.selectByExample(example));
    }

    /**
     * RolePerm分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<RolePerm> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<RolePerm>(rolePermMapper.selectAll());
    }

    /**
     * RolePerm条件查询
     * @param rolePerm
     * @return
     */
    @Override
    public List<RolePerm> findList(RolePerm rolePerm){
        //构建查询条件
        Example example = createExample(rolePerm);
        //根据构建的条件查询数据
        return rolePermMapper.selectByExample(example);
    }


    /**
     * RolePerm构建查询对象
     * @param rolePerm
     * @return
     */
    public Example createExample(RolePerm rolePerm){
        Example example=new Example(RolePerm.class);
        Example.Criteria criteria = example.createCriteria();
        if(rolePerm!=null){
            // 角色ID
            if(!StringUtils.isEmpty(rolePerm.getRoleId())){
                    criteria.andEqualTo("roleId",rolePerm.getRoleId());
            }
            // 权限ID
            if(!StringUtils.isEmpty(rolePerm.getPerId())){
                    criteria.andEqualTo("perId",rolePerm.getPerId());
            }
            // 描述
            if(!StringUtils.isEmpty(rolePerm.getRpRem())){
                    criteria.andEqualTo("rpRem",rolePerm.getRpRem());
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
        rolePermMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改RolePerm
     * @param rolePerm
     */
    @Override
    public void update(RolePerm rolePerm){
        rolePermMapper.updateByPrimaryKey(rolePerm);
    }

    /**
     * 增加RolePerm
     * @param rolePerm
     */
    @Override
    public void add(RolePerm rolePerm){
        rolePermMapper.insert(rolePerm);
    }

    /**
     * 根据ID查询RolePerm
     * @param id
     * @return
     */
    @Override
    public RolePerm findById(Integer id){
        return  rolePermMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询RolePerm全部数据
     * @return
     */
    @Override
    public List<RolePerm> findAll() {
        return rolePermMapper.selectAll();
    }
}
