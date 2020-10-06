package com.cqp.service.api;

import com.cqp.model.Floor;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Floor业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FloorService {

    /***
     * Floor多条件分页查询
     * @param floor
     * @param page
     * @param size
     * @return
     */
    PageInfo<Floor> findPage(Floor floor, int page, int size);

    /***
     * Floor分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Floor> findPage(int page, int size);

    /***
     * Floor多条件搜索方法
     * @param floor
     * @return
     */
    List<Floor> findList(Floor floor);

    /***
     * 删除Floor
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Floor数据
     * @param floor
     */
    void update(Floor floor);

    /***
     * 新增Floor
     * @param floor
     */
    void add(Floor floor);

    /**
     * 根据ID查询Floor
     * @param id
     * @return
     */
     Floor findById(Integer id);

    /***
     * 查询所有Floor
     * @return
     */
    List<Floor> findAll();
}
