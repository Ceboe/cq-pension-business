package com.cqp.service.api;

import com.cqp.model.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Employee业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface EmployeeService {

    /***
     * Employee多条件分页查询
     * @param employee
     * @param page
     * @param size
     * @return
     */
    PageInfo<Employee> findPage(Employee employee, int page, int size);

    /***
     * Employee分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Employee> findPage(int page, int size);

    /***
     * Employee多条件搜索方法
     * @param employee
     * @return
     */
    List<Employee> findList(Employee employee);

    /***
     * 删除Employee
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改Employee数据
     * @param employee
     */
    int update(Employee employee);

    /***
     * 新增Employee
     * @param employee
     */
    int add(Employee employee);

    /**
     * 根据ID查询Employee
     * @param id
     * @return
     */
     Employee findById(Integer id);

    /***
     * 查询所有Employee
     * @return
     */
    List<Employee> findAll();
}
