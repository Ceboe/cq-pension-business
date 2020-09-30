package com.cqp.service.api;


import com.cqp.model.Report;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Report业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ReportService {

    /***
     * Report多条件分页查询
     * @param report
     * @param page
     * @param size
     * @return
     */
    PageInfo<Report> findPage(Report report, int page, int size);

    /***
     * Report分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Report> findPage(int page, int size);

    /***
     * Report多条件搜索方法
     * @param report
     * @return
     */
    List<Report> findList(Report report);

    /***
     * 删除Report
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Report数据
     * @param report
     */
    void update(Report report);

    /***
     * 新增Report
     * @param report
     */
    void add(Report report);

    /**
     * 根据ID查询Report
     * @param id
     * @return
     */
     Report findById(Integer id);

    /***
     * 查询所有Report
     * @return
     */
    List<Report> findAll();
}
