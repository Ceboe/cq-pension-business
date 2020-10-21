package com.cqp.service.api;

import com.cqp.model.Menu;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Menu业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface MenuService {

    /***
     * Menu多条件分页查询
     * @param menu
     * @param page
     * @param size
     * @return
     */
    PageInfo<Menu> findPage(Menu menu, int page, int size);

    /***
     * Menu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Menu> findPage(int page, int size);

    /***
     * Menu多条件搜索方法
     * @param menu
     * @return
     */
    List<Menu> findList(Menu menu);

    /***
     * 删除Menu
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改Menu数据
     * @param menu
     */
    int update(Menu menu);

    /***
     * 新增Menu
     * @param menu
     */
    int add(Menu menu);

    /**
     * 根据ID查询Menu
     * @param id
     * @return
     */
     Menu findById(Integer id);

    /***
     * 查询所有Menu
     * @return
     */
    List<Menu> findAll();

    /***
     * 根据角色id查询菜单
     * @return
     */
    List<Menu> getMenuForRole(Integer roleId);
}
