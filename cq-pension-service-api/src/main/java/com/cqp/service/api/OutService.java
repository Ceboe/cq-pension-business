package com.cqp.service.api;

import com.cqp.model.Out;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Out业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface OutService {

    /***
     * Out多条件分页查询
     * @param out
     * @param page
     * @param size
     * @return
     */
    PageInfo<Out> findPage(Out out, int page, int size);

    /***
     * Out分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Out> findPage(int page, int size);

    /***
     * Out多条件搜索方法
     * @param out
     * @return
     */
    List<Out> findList(Out out);

    /***
     * 删除Out
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改Out数据
     * @param out
     */
    int update(Out out);

    /***
     * 新增Out
     * @param out
     */
    int add(Out out);

    /**
     * 根据ID查询Out
     * @param id
     * @return
     */
     Out findById(Integer id);

    /***
     * 查询所有Out
     * @return
     */
    List<Out> findAll();
}
