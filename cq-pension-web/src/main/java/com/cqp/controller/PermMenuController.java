package com.cqp.controller;

import com.cqp.model.PermMenu;
import com.cqp.service.api.PermMenuService;
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
@RequestMapping("/permMenu")
@CrossOrigin
public class PermMenuController {

    @Autowired
    private PermMenuService permMenuService;

    /***
     * PermMenu分页条件搜索实现
     * @param permMenu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) PermMenu permMenu, @PathVariable  int page, @PathVariable  int size){
        //调用PermMenuService实现分页条件查询PermMenu
        PageInfo<PermMenu> pageInfo = permMenuService.findPage(permMenu, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * PermMenu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PermMenuService实现分页查询PermMenu
        PageInfo<PermMenu> pageInfo = permMenuService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param permMenu
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<PermMenu>> findList(@RequestBody(required = false) PermMenu permMenu){
        //调用PermMenuService实现条件查询PermMenu
        List<PermMenu> list = permMenuService.findList(permMenu);
        return new Result<List<PermMenu>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用PermMenuService实现根据主键删除
        permMenuService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改PermMenu数据
     * @param permMenu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody PermMenu permMenu, @PathVariable Integer id){
        //设置主键值
        permMenu.setPerId(id);
        //调用PermMenuService实现修改PermMenu
        permMenuService.update(permMenu);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增PermMenu数据
     * @param permMenu
     * @return
     */
    @PostMapping
    public Result add(@RequestBody PermMenu permMenu){
        //调用PermMenuService实现添加PermMenu
        permMenuService.add(permMenu);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询PermMenu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<PermMenu> findById(@PathVariable Integer id){
        //调用PermMenuService实现根据主键查询PermMenu
        PermMenu permMenu = permMenuService.findById(id);
        return new Result<PermMenu>(true,StatusCode.OK,"查询成功",permMenu);
    }

    /***
     * 查询PermMenu全部数据
     * @return
     */
    @GetMapping
    public Result<List<PermMenu>> findAll(){
        //调用PermMenuService实现查询所有PermMenu
        List<PermMenu> list = permMenuService.findAll();
        return new Result<List<PermMenu>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
