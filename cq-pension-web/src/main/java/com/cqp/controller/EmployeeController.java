package com.cqp.controller;

import com.cqp.model.Employee;
import com.cqp.service.api.EmployeeService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /***
     * Employee分页条件搜索实现
     * @param employee
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Employee employee, @PathVariable  int page, @PathVariable  int size){
        //调用EmployeeService实现分页条件查询Employee
        PageInfo<Employee> pageInfo = employeeService.findPage(employee, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Employee分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用EmployeeService实现分页查询Employee
        PageInfo<Employee> pageInfo = employeeService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param employee
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Employee>> findList(@RequestBody(required = false) Employee employee){
        //调用EmployeeService实现条件查询Employee
        List<Employee> list = employeeService.findList(employee);
        return new Result<List<Employee>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用EmployeeService实现根据主键删除
        employeeService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Employee数据
     * @param employee
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Employee employee, @PathVariable Integer id){
        //设置主键值
        employee.setEmpId(id);
        //调用EmployeeService实现修改Employee
        employeeService.update(employee);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Employee数据
     * @param employee
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Employee employee){
        //调用EmployeeService实现添加Employee
        employeeService.add(employee);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Employee数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Employee> findById(@PathVariable Integer id){
        //调用EmployeeService实现根据主键查询Employee
        Employee employee = employeeService.findById(id);
        return new Result<Employee>(true,StatusCode.OK,"查询成功",employee);
    }

    /***
     * 查询Employee全部数据
     * @return
     */
    @GetMapping("/findAll")
    public Result<List<Employee>> findAll(){
        //调用EmployeeService实现查询所有Employee
        List<Employee> list = employeeService.findAll();
        return new Result<List<Employee>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
