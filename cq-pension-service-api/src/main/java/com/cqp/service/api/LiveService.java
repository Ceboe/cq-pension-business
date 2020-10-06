package com.cqp.service.api;

import com.cqp.model.Live;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Live业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface LiveService {

    /***
     * Live多条件分页查询
     * @param live
     * @param page
     * @param size
     * @return
     */
    PageInfo<Live> findPage(Live live, int page, int size);

    /***
     * Live分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Live> findPage(int page, int size);

    /***
     * Live多条件搜索方法
     * @param live
     * @return
     */
    List<Live> findList(Live live);

    /***
     * 删除Live
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Live数据
     * @param live
     */
    void update(Live live);

    /***
     * 新增Live
     * @param live
     */
    void add(Live live);

    /**
     * 根据ID查询Live
     * @param id
     * @return
     */
     Live findById(Integer id);

    /***
     * 查询所有Live
     * @return
     */
    List<Live> findAll();
}
