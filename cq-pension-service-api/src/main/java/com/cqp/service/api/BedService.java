package com.cqp.service.api;

import com.cqp.model.Bed;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Bed业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface BedService {

    /***
     * Bed多条件分页查询
     * @param bed
     * @param page
     * @param size
     * @return
     */
    PageInfo<Bed> findPage(Bed bed, int page, int size);

    /***
     * Bed分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Bed> findPage(int page, int size);

    /***
     * Bed多条件搜索方法
     * @param bed
     * @return
     */
    List<Bed> findList(Bed bed);

    /***
     * 删除Bed
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改Bed数据
     * @param bed
     */
    int update(Bed bed);

    /***
     * 新增Bed
     * @param bed
     */
    int add(Bed bed);

    /**
     * 根据ID查询Bed
     * @param id
     * @return
     */
     Bed findById(Integer id);

    /***
     * 查询所有Bed
     * @return
     */
    List<Bed> findAll();
}
