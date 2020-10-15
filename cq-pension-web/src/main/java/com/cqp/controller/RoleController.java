package com.cqp.controller;

import com.cqp.model.Role;
import com.cqp.service.api.RoleService;
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
@RequestMapping("/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    /***
     * Role分页条件搜索实现
     * @param role
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Role role, @PathVariable  int page, @PathVariable  int size){
        //调用RoleService实现分页条件查询Role
        PageInfo<Role> pageInfo = roleService.findPage(role, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Role分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RoleService实现分页查询Role
        PageInfo<Role> pageInfo = roleService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param role
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Role>> findList(@RequestBody(required = false) Role role){
        //调用RoleService实现条件查询Role
        List<Role> list = roleService.findList(role);
        return new Result<List<Role>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用RoleService实现根据主键删除
        roleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Role数据
     * @param role
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Role role, @PathVariable Integer id){
        //设置主键值
        role.setRoleId(id);
        //调用RoleService实现修改Role
        roleService.update(role);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Role数据
     * @param role
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Role role){
        //调用RoleService实现添加Role
        roleService.add(role);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Role数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Role> findById(@PathVariable Integer id){
        //调用RoleService实现根据主键查询Role
        Role role = roleService.findById(id);
        return new Result<Role>(true,StatusCode.OK,"查询成功",role);
    }

    /***
     * 查询Role全部数据
     * @return
     */
    @GetMapping
    public Result<List<Role>> findAll(){
        //调用RoleService实现查询所有Role
        List<Role> list = roleService.findAll();
        return new Result<List<Role>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
