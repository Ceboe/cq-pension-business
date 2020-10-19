package com.cqp.service.api;

import com.cqp.model.Kitchen;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Kitchen业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface KitchenService {

    /***
     * Kitchen多条件分页查询
     * @param kitchen
     * @param page
     * @param size
     * @return
     */
    PageInfo<Kitchen> findPage(Kitchen kitchen, int page, int size);

    /***
     * Kitchen分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Kitchen> findPage(int page, int size);

    /***
     * Kitchen多条件搜索方法
     * @param kitchen
     * @return
     */
    List<Kitchen> findList(Kitchen kitchen);

    /***
     * 删除Kitchen
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改Kitchen数据
     * @param kitchen
     */
    int update(Kitchen kitchen);

    /***
     * 新增Kitchen
     * @param kitchen
     */
    int add(Kitchen kitchen);

    /**
     * 根据ID查询Kitchen
     * @param id
     * @return
     */
     Kitchen findById(Integer id);

    /***
     * 查询所有Kitchen
     * @return
     */
    List<Kitchen> findAll();
}
