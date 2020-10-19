package com.cqp.service.api;

import com.cqp.model.Build;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Build业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface BuildService {

    /***
     * Build多条件分页查询
     * @param build
     * @param page
     * @param size
     * @return
     */
    PageInfo<Build> findPage(Build build, int page, int size);

    /***
     * Build分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Build> findPage(int page, int size);

    /***
     * Build多条件搜索方法
     * @param build
     * @return
     */
    List<Build> findList(Build build);

    /***
     * 删除Build
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改Build数据
     * @param build
     */
    int update(Build build);

    /***
     * 新增Build
     * @param build
     */
    int add(Build build);

    /**
     * 根据ID查询Build
     * @param id
     * @return
     */
     Build findById(Integer id);

    /***
     * 查询所有Build
     * @return
     */
    List<Build> findAll();
}
