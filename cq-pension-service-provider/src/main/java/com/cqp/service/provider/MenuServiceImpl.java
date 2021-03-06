package com.cqp.service.provider;

import com.cqp.mapper.MenuMapper;
import com.cqp.model.Menu;
import com.cqp.service.api.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Menu业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    /**
     * Menu条件+分页查询
     * @param menu 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Menu> findPage(Menu menu, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(menu);
        //执行搜索
        return new PageInfo<Menu>(menuMapper.selectByExample(example));
    }

    /**
     * Menu分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Menu> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Menu>(menuMapper.selectAll());
    }

    /**
     * Menu条件查询
     * @param menu
     * @return
     */
    @Override
    public List<Menu> findList(Menu menu){
        //构建查询条件
        Example example = createExample(menu);
        //根据构建的条件查询数据
        return menuMapper.selectByExample(example);
    }


    /**
     * Menu构建查询对象
     * @param menu
     * @return
     */
    public Example createExample(Menu menu){
        Example example=new Example(Menu.class);
        Example.Criteria criteria = example.createCriteria();
        if(menu!=null){
            // 菜单编号
            if(!StringUtils.isEmpty(menu.getMenuId())){
                    criteria.andEqualTo("menuId",menu.getMenuId());
            }
            // 菜单级别
            if(!StringUtils.isEmpty(menu.getLevel())){
                    criteria.andEqualTo("level",menu.getLevel());
            }
            // 菜单名称
            if(!StringUtils.isEmpty(menu.getName())){
                    criteria.andLike("name","%"+menu.getName()+"%");
            }
            // 菜单图标
            if(!StringUtils.isEmpty(menu.getIcon())){
                    criteria.andEqualTo("icon",menu.getIcon());
            }
            // 菜单地址
            if(!StringUtils.isEmpty(menu.getUrl())){
                    criteria.andEqualTo("url",menu.getUrl());
            }
            // 父菜单编号
            if(!StringUtils.isEmpty(menu.getParent())){
                    criteria.andEqualTo("parent",menu.getParent());
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
        return menuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Menu
     * @param menu
     */
    @Override
    public int update(Menu menu){
        return menuMapper.updateByPrimaryKey(menu);
    }

    /**
     * 增加Menu
     * @param menu
     */
    @Override
    public int add(Menu menu){
        return menuMapper.insert(menu);
    }

    /**
     * 根据ID查询Menu
     * @param id
     * @return
     */
    @Override
    public Menu findById(Integer id){
        return  menuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Menu全部数据
     * @return
     */
    @Override
    public List<Menu> findAll() {
        return menuMapper.selectAll();
    }
    /***
     * 根据角色id查询树形菜单
     * @return
     */
    @Override
    public List<Menu> getMenuForRole(Integer roleId) {
        List<Menu> list = menuMapper.getMenuForRole(roleId);
        List<Menu> result = new ArrayList<Menu>();
        for(Menu menu : list){
            if(menu.getLevel().equals(1)){//为1级菜单添加子菜单
                List<Menu> second = getChildenMenu(menu.getMenuId(),list);
                for(Menu menu2 : second){//为2级菜单添加子菜单
                    List<Menu> three = getChildenMenu(menu2.getMenuId(),list);
                    menu2.setChildren(three);
                }
                menu.setChildren(second);
                result.add(menu);
            }
        }
        return result;
    }

    /***
     * 查找子菜单
     * @param parentId
     * @return
     */
    public List<Menu> getChildenMenu(Integer parentId, List<Menu> allMenu){
        List<Menu> children = new ArrayList<Menu>();
        for(Menu menu : allMenu){
            if(parentId.equals(menu.getParent())){
                children.add(menu);
            }
        }
        return children;
    }


}
