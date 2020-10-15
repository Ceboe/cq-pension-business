package com.cqp.controller;

import com.cqp.model.RolePerm;
import com.cqp.service.api.RolePermService;
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
@RequestMapping("/rolePerm")
@CrossOrigin
public class RolePermController {

    @Autowired
    private RolePermService rolePermService;

    /***
     * RolePerm分页条件搜索实现
     * @param rolePerm
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) RolePerm rolePerm, @PathVariable  int page, @PathVariable  int size){
        //调用RolePermService实现分页条件查询RolePerm
        PageInfo<RolePerm> pageInfo = rolePermService.findPage(rolePerm, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * RolePerm分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RolePermService实现分页查询RolePerm
        PageInfo<RolePerm> pageInfo = rolePermService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param rolePerm
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<RolePerm>> findList(@RequestBody(required = false) RolePerm rolePerm){
        //调用RolePermService实现条件查询RolePerm
        List<RolePerm> list = rolePermService.findList(rolePerm);
        return new Result<List<RolePerm>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用RolePermService实现根据主键删除
        rolePermService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改RolePerm数据
     * @param rolePerm
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody RolePerm rolePerm, @PathVariable Integer id){
        //设置主键值
        rolePerm.setRpId(id);
        //调用RolePermService实现修改RolePerm
        rolePermService.update(rolePerm);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增RolePerm数据
     * @param rolePerm
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody RolePerm rolePerm){
        //调用RolePermService实现添加RolePerm
        rolePermService.add(rolePerm);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询RolePerm数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<RolePerm> findById(@PathVariable Integer id){
        //调用RolePermService实现根据主键查询RolePerm
        RolePerm rolePerm = rolePermService.findById(id);
        return new Result<RolePerm>(true,StatusCode.OK,"查询成功",rolePerm);
    }

    /***
     * 查询RolePerm全部数据
     * @return
     */
    @GetMapping
    public Result<List<RolePerm>> findAll(){
        //调用RolePermService实现查询所有RolePerm
        List<RolePerm> list = rolePermService.findAll();
        return new Result<List<RolePerm>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
