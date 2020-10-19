package com.cqp.service.api;

import com.cqp.model.Employeemanage;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Employeemanage业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface EmployeemanageService {

    /***
     * Employeemanage多条件分页查询
     * @param employeemanage
     * @param page
     * @param size
     * @return
     */
    PageInfo<Employeemanage> findPage(Employeemanage employeemanage, int page, int size);

    /***
     * Employeemanage分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Employeemanage> findPage(int page, int size);

    /***
     * Employeemanage多条件搜索方法
     * @param employeemanage
     * @return
     */
    List<Employeemanage> findList(Employeemanage employeemanage);

    /***
     * 删除Employeemanage
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改Employeemanage数据
     * @param employeemanage
     */
    int update(Employeemanage employeemanage);

    /***
     * 新增Employeemanage
     * @param employeemanage
     */
    int add(Employeemanage employeemanage);

    /**
     * 根据ID查询Employeemanage
     * @param id
     * @return
     */
     Employeemanage findById(Integer id);

    /***
     * 查询所有Employeemanage
     * @return
     */
    List<Employeemanage> findAll();
}
