package com.cqp.service.api;

import com.cqp.model.JoinAct;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:JoinAct业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface JoinActService {

    /***
     * JoinAct多条件分页查询
     * @param joinAct
     * @param page
     * @param size
     * @return
     */
    PageInfo<JoinAct> findPage(JoinAct joinAct, int page, int size);

    /***
     * JoinAct分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<JoinAct> findPage(int page, int size);

    /***
     * JoinAct多条件搜索方法
     * @param joinAct
     * @return
     */
    List<JoinAct> findList(JoinAct joinAct);

    /***
     * 删除JoinAct
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改JoinAct数据
     * @param joinAct
     */
    int update(JoinAct joinAct);

    /***
     * 新增JoinAct
     * @param joinAct
     */
    int add(JoinAct joinAct);

    /**
     * 根据ID查询JoinAct
     * @param id
     * @return
     */
     JoinAct findById(Integer id);

    /***
     * 查询所有JoinAct
     * @return
     */
    List<JoinAct> findAll();
}
