package com.cqp.service.provider;

import com.cqp.mapper.PermMenuMapper;
import com.cqp.model.PermMenu;
import com.cqp.service.api.PermMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:PermMenu业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PermMenuServiceImpl implements PermMenuService {

    @Autowired
    private PermMenuMapper permMenuMapper;


    /**
     * PermMenu条件+分页查询
     * @param permMenu 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PermMenu> findPage(PermMenu permMenu, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(permMenu);
        //执行搜索
        return new PageInfo<PermMenu>(permMenuMapper.selectByExample(example));
    }

    /**
     * PermMenu分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PermMenu> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PermMenu>(permMenuMapper.selectAll());
    }

    /**
     * PermMenu条件查询
     * @param permMenu
     * @return
     */
    @Override
    public List<PermMenu> findList(PermMenu permMenu){
        //构建查询条件
        Example example = createExample(permMenu);
        //根据构建的条件查询数据
        return permMenuMapper.selectByExample(example);
    }


    /**
     * PermMenu构建查询对象
     * @param permMenu
     * @return
     */
    public Example createExample(PermMenu permMenu){
        Example example=new Example(PermMenu.class);
        Example.Criteria criteria = example.createCriteria();
        if(permMenu!=null){
            // 权限编号
            if(!StringUtils.isEmpty(permMenu.getPerId())){
                    criteria.andEqualTo("perId",permMenu.getPerId());
            }
            // 菜单编号
            if(!StringUtils.isEmpty(permMenu.getMenuId())){
                    criteria.andEqualTo("menuId",permMenu.getMenuId());
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
        permMenuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PermMenu
     * @param permMenu
     */
    @Override
    public void update(PermMenu permMenu){
        permMenuMapper.updateByPrimaryKey(permMenu);
    }

    /**
     * 增加PermMenu
     * @param permMenu
     */
    @Override
    public void add(PermMenu permMenu){
        permMenuMapper.insert(permMenu);
    }

    /**
     * 根据ID查询PermMenu
     * @param id
     * @return
     */
    @Override
    public PermMenu findById(Integer id){
        return  permMenuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PermMenu全部数据
     * @return
     */
    @Override
    public List<PermMenu> findAll() {
        return permMenuMapper.selectAll();
    }
}
