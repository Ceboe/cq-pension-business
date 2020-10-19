package com.cqp.service.api;

import com.cqp.model.Opeople;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Opeople业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface OpeopleService {

    /***
     * Opeople多条件分页查询
     * @param opeople
     * @param page
     * @param size
     * @return
     */
    PageInfo<Opeople> findPage(Opeople opeople, int page, int size);

    /***
     * Opeople分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Opeople> findPage(int page, int size);

    /***
     * Opeople多条件搜索方法
     * @param opeople
     * @return
     */
    List<Opeople> findList(Opeople opeople);

    /***
     * 删除Opeople
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改Opeople数据
     * @param opeople
     */
    int update(Opeople opeople);

    /***
     * 新增Opeople
     * @param opeople
     */
    int add(Opeople opeople);

    /**
     * 根据ID查询Opeople
     * @param id
     * @return
     */
     Opeople findById(Integer id);

    /***
     * 查询所有Opeople
     * @return
     */
    List<Opeople> findAll();
}
