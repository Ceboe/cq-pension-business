package com.cqp.controller;

import com.cqp.model.Permissions;
import com.cqp.service.api.PermissionsService;
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
@RequestMapping("/permissions")
@CrossOrigin
public class PermissionsController {

    @Autowired
    private PermissionsService permissionsService;

    /***
     * Permissions分页条件搜索实现
     * @param permissions
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Permissions permissions, @PathVariable  int page, @PathVariable  int size){
        //调用PermissionsService实现分页条件查询Permissions
        PageInfo<Permissions> pageInfo = permissionsService.findPage(permissions, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Permissions分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PermissionsService实现分页查询Permissions
        PageInfo<Permissions> pageInfo = permissionsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param permissions
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Permissions>> findList(@RequestBody(required = false) Permissions permissions){
        //调用PermissionsService实现条件查询Permissions
        List<Permissions> list = permissionsService.findList(permissions);
        return new Result<List<Permissions>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用PermissionsService实现根据主键删除
        permissionsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Permissions数据
     * @param permissions
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Permissions permissions, @PathVariable Integer id){
        //设置主键值
        permissions.setPerId(id);
        //调用PermissionsService实现修改Permissions
        permissionsService.update(permissions);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Permissions数据
     * @param permissions
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Permissions permissions){
        //调用PermissionsService实现添加Permissions
        permissionsService.add(permissions);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Permissions数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Permissions> findById(@PathVariable Integer id){
        //调用PermissionsService实现根据主键查询Permissions
        Permissions permissions = permissionsService.findById(id);
        return new Result<Permissions>(true,StatusCode.OK,"查询成功",permissions);
    }

    /***
     * 查询Permissions全部数据
     * @return
     */
    @GetMapping
    public Result<List<Permissions>> findAll(){
        //调用PermissionsService实现查询所有Permissions
        List<Permissions> list = permissionsService.findAll();
        return new Result<List<Permissions>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
