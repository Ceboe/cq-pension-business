package com.cqp.service.provider;

import com.cqp.mapper.RoleMapper;
import com.cqp.model.Menu;
import com.cqp.model.Role;
import com.cqp.service.api.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Role业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    /**
     * Role条件+分页查询
     * @param role 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Role> findPage(Role role, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(role);
        //执行搜索
        return new PageInfo<Role>(roleMapper.selectByExample(example));
    }

    /**
     * Role分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Role> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Role>(roleMapper.selectAll());
    }

    /**
     * Role条件查询
     * @param role
     * @return
     */
    @Override
    public List<Role> findList(Role role){
        //构建查询条件
        Example example = createExample(role);
        //根据构建的条件查询数据
        return roleMapper.selectByExample(example);
    }


    /**
     * Role构建查询对象
     * @param role
     * @return
     */
    public Example createExample(Role role){
        Example example=new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        if(role!=null){
            // 角色表ID
            if(!StringUtils.isEmpty(role.getRoleId())){
                    criteria.andEqualTo("roleId",role.getRoleId());
            }
            // 名称
            if(!StringUtils.isEmpty(role.getRoleName())){
                    criteria.andEqualTo("roleName",role.getRoleName());
            }
            // 描述
            if(!StringUtils.isEmpty(role.getRoleDes())){
                    criteria.andEqualTo("roleDes",role.getRoleDes());
            }
            // 记录状态
            if(!StringUtils.isEmpty(role.getRoleRec())){
                    criteria.andEqualTo("roleRec",role.getRoleRec());
            }
            // 备注
            if(!StringUtils.isEmpty(role.getRoleRem())){
                    criteria.andEqualTo("roleRem",role.getRoleRem());
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
        return roleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Role
     * @param role
     */
    @Override
    public int update(Role role){
        return roleMapper.updateByPrimaryKey(role);
    }

    /**
     * 增加Role
     * @param role
     */
    @Override
    public int add(Role role){
        return roleMapper.insert(role);
    }

    /**
     * 根据ID查询Role
     * @param id
     * @return
     */
    @Override
    public Role findById(Integer id){
        return  roleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Role全部数据
     * @return
     */
    @Override
    public List<Role> findAll() {
        return roleMapper.selectAll();
    }

    public List<Menu> getMyMenu() {
        List<Menu> menuList = null;



        return menuList;
    }
}
