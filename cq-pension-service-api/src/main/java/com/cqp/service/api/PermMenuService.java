package com.cqp.service.api;

import com.cqp.model.PermMenu;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:PermMenu业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PermMenuService {

    /***
     * PermMenu多条件分页查询
     * @param permMenu
     * @param page
     * @param size
     * @return
     */
    PageInfo<PermMenu> findPage(PermMenu permMenu, int page, int size);

    /***
     * PermMenu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PermMenu> findPage(int page, int size);

    /***
     * PermMenu多条件搜索方法
     * @param permMenu
     * @return
     */
    List<PermMenu> findList(PermMenu permMenu);

    /***
     * 删除PermMenu
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改PermMenu数据
     * @param permMenu
     */
    int update(PermMenu permMenu);

    /***
     * 新增PermMenu
     * @param permMenu
     */
    int add(PermMenu permMenu);

    /**
     * 根据ID查询PermMenu
     * @param id
     * @return
     */
     PermMenu findById(Integer id);

    /***
     * 查询所有PermMenu
     * @return
     */
    List<PermMenu> findAll();
}
