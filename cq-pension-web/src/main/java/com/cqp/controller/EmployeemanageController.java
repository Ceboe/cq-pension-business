package com.cqp.controller;

import com.cqp.model.Employeemanage;
import com.cqp.service.api.EmployeemanageService;
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
@RequestMapping("/employeemanage")
@CrossOrigin
public class EmployeemanageController {

    @Autowired
    private EmployeemanageService employeemanageService;

    /***
     * Employeemanage分页条件搜索实现
     * @param employeemanage
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Employeemanage employeemanage, @PathVariable  int page, @PathVariable  int size){
        //调用EmployeemanageService实现分页条件查询Employeemanage
        PageInfo<Employeemanage> pageInfo = employeemanageService.findPage(employeemanage, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Employeemanage分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用EmployeemanageService实现分页查询Employeemanage
        PageInfo<Employeemanage> pageInfo = employeemanageService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param employeemanage
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Employeemanage>> findList(@RequestBody(required = false) Employeemanage employeemanage){
        //调用EmployeemanageService实现条件查询Employeemanage
        List<Employeemanage> list = employeemanageService.findList(employeemanage);
        return new Result<List<Employeemanage>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用EmployeemanageService实现根据主键删除
        employeemanageService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Employeemanage数据
     * @param employeemanage
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Employeemanage employeemanage, @PathVariable Integer id){
        //设置主键值
        employeemanage.setEmmId(id);
        //调用EmployeemanageService实现修改Employeemanage
        employeemanageService.update(employeemanage);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Employeemanage数据
     * @param employeemanage
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Employeemanage employeemanage){
        //调用EmployeemanageService实现添加Employeemanage
        employeemanageService.add(employeemanage);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Employeemanage数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Employeemanage> findById(@PathVariable Integer id){
        //调用EmployeemanageService实现根据主键查询Employeemanage
        Employeemanage employeemanage = employeemanageService.findById(id);
        return new Result<Employeemanage>(true,StatusCode.OK,"查询成功",employeemanage);
    }

    /***
     * 查询Employeemanage全部数据
     * @return
     */
    @GetMapping
    public Result<List<Employeemanage>> findAll(){
        //调用EmployeemanageService实现查询所有Employeemanage
        List<Employeemanage> list = employeemanageService.findAll();
        return new Result<List<Employeemanage>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
