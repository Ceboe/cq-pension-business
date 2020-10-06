package com.cqp.service.api;

import com.cqp.model.Log;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Log业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface LogService {

    /***
     * Log多条件分页查询
     * @param log
     * @param page
     * @param size
     * @return
     */
    PageInfo<Log> findPage(Log log, int page, int size);

    /***
     * Log分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Log> findPage(int page, int size);

    /***
     * Log多条件搜索方法
     * @param log
     * @return
     */
    List<Log> findList(Log log);

    /***
     * 删除Log
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Log数据
     * @param log
     */
    void update(Log log);

    /***
     * 新增Log
     * @param log
     */
    void add(Log log);

    /**
     * 根据ID查询Log
     * @param id
     * @return
     */
     Log findById(Integer id);

    /***
     * 查询所有Log
     * @return
     */
    List<Log> findAll();
}
