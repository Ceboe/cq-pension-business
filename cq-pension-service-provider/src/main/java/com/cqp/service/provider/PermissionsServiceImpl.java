package com.cqp.service.provider;

import com.cqp.mapper.PermissionsMapper;
import com.cqp.model.Permissions;
import com.cqp.service.api.PermissionsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Permissions业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PermissionsServiceImpl implements PermissionsService {

    @Autowired
    private PermissionsMapper permissionsMapper;


    /**
     * Permissions条件+分页查询
     * @param permissions 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Permissions> findPage(Permissions permissions, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(permissions);
        //执行搜索
        return new PageInfo<Permissions>(permissionsMapper.selectByExample(example));
    }

    /**
     * Permissions分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Permissions> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Permissions>(permissionsMapper.selectAll());
    }

    /**
     * Permissions条件查询
     * @param permissions
     * @return
     */
    @Override
    public List<Permissions> findList(Permissions permissions){
        //构建查询条件
        Example example = createExample(permissions);
        //根据构建的条件查询数据
        return permissionsMapper.selectByExample(example);
    }


    /**
     * Permissions构建查询对象
     * @param permissions
     * @return
     */
    public Example createExample(Permissions permissions){
        Example example=new Example(Permissions.class);
        Example.Criteria criteria = example.createCriteria();
        if(permissions!=null){
            // 权限ID
            if(!StringUtils.isEmpty(permissions.getPerId())){
                    criteria.andEqualTo("perId",permissions.getPerId());
            }
            // 名称
            if(!StringUtils.isEmpty(permissions.getPerName())){
                    criteria.andEqualTo("perName",permissions.getPerName());
            }
            // 描述
            if(!StringUtils.isEmpty(permissions.getPerDes())){
                    criteria.andEqualTo("perDes",permissions.getPerDes());
            }
            // 子菜单
            if(!StringUtils.isEmpty(permissions.getPerMenu())){
                    criteria.andEqualTo("perMenu",permissions.getPerMenu());
            }
            // 备注
            if(!StringUtils.isEmpty(permissions.getPerRem())){
                    criteria.andEqualTo("perRem",permissions.getPerRem());
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
        return permissionsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Permissions
     * @param permissions
     */
    @Override
    public int update(Permissions permissions){
        return permissionsMapper.updateByPrimaryKey(permissions);
    }

    /**
     * 增加Permissions
     * @param permissions
     */
    @Override
    public int add(Permissions permissions){
        return permissionsMapper.insert(permissions);
    }

    /**
     * 根据ID查询Permissions
     * @param id
     * @return
     */
    @Override
    public Permissions findById(Integer id){
        return  permissionsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Permissions全部数据
     * @return
     */
    @Override
    public List<Permissions> findAll() {
        return permissionsMapper.selectAll();
    }
}
