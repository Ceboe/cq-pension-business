package com.cqp.service.api;


import com.cqp.model.Refund;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Refund业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface RefundService {

    /***
     * Refund多条件分页查询
     * @param refund
     * @param page
     * @param size
     * @return
     */
    PageInfo<Refund> findPage(Refund refund, int page, int size);

    /***
     * Refund分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Refund> findPage(int page, int size);

    /***
     * Refund多条件搜索方法
     * @param refund
     * @return
     */
    List<Refund> findList(Refund refund);

    /***
     * 删除Refund
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Refund数据
     * @param refund
     */
    void update(Refund refund);

    /***
     * 新增Refund
     * @param refund
     */
    void add(Refund refund);

    /**
     * 根据ID查询Refund
     * @param id
     * @return
     */
     Refund findById(Integer id);

    /***
     * 查询所有Refund
     * @return
     */
    List<Refund> findAll();
}
