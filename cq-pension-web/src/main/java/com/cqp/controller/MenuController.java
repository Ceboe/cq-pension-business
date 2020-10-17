package com.cqp.controller;

import com.cqp.model.Menu;
import com.cqp.service.api.MenuService;
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
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {

    @Autowired
    private MenuService menuService;

    /***
     * Menu分页条件搜索实现
     * @param menu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Menu menu, @PathVariable  int page, @PathVariable  int size){
        //调用MenuService实现分页条件查询Menu
        PageInfo<Menu> pageInfo = menuService.findPage(menu, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Menu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用MenuService实现分页查询Menu
        PageInfo<Menu> pageInfo = menuService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param menu
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Menu>> findList(@RequestBody(required = false) Menu menu){
        //调用MenuService实现条件查询Menu
        List<Menu> list = menuService.findList(menu);
        return new Result<List<Menu>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用MenuService实现根据主键删除
        menuService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Menu数据
     * @param menu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Menu menu, @PathVariable Integer id){
        //设置主键值
        menu.setMenuId(id);
        //调用MenuService实现修改Menu
        menuService.update(menu);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Menu数据
     * @param menu
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Menu menu){
        //调用MenuService实现添加Menu
        menuService.add(menu);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Menu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Menu> findById(@PathVariable Integer id){
        //调用MenuService实现根据主键查询Menu
        Menu menu = menuService.findById(id);
        return new Result<Menu>(true,StatusCode.OK,"查询成功",menu);
    }

    /***
     * 查询Menu全部数据
     * @return
     */
    @GetMapping
    public Result<List<Menu>> findAll(){
        //调用MenuService实现查询所有Menu
        List<Menu> list = menuService.findAll();
        return new Result<List<Menu>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
