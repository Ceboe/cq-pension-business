package com.cqp.service.api;


import com.cqp.model.IllHistory;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:IllHistory业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface IllHistoryService {

    /***
     * IllHistory多条件分页查询
     * @param illHistory
     * @param page
     * @param size
     * @return
     */
    PageInfo<IllHistory> findPage(IllHistory illHistory, int page, int size);

    /***
     * IllHistory分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<IllHistory> findPage(int page, int size);

    /***
     * IllHistory多条件搜索方法
     * @param illHistory
     * @return
     */
    List<IllHistory> findList(IllHistory illHistory);

    /***
     * 删除IllHistory
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改IllHistory数据
     * @param illHistory
     */
    void update(IllHistory illHistory);

    /***
     * 新增IllHistory
     * @param illHistory
     */
    void add(IllHistory illHistory);

    /**
     * 根据ID查询IllHistory
     * @param id
     * @return
     */
     IllHistory findById(Integer id);

    /***
     * 查询所有IllHistory
     * @return
     */
    List<IllHistory> findAll();
}
