package com.cqp.controller;

import com.cqp.model.Kitchen;
import com.cqp.service.api.KitchenService;
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
@RequestMapping("/kitchen")
@CrossOrigin
public class KitchenController {

    @Autowired
    private KitchenService kitchenService;

    /***
     * Kitchen分页条件搜索实现
     * @param kitchen
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Kitchen kitchen, @PathVariable  int page, @PathVariable  int size){
        //调用KitchenService实现分页条件查询Kitchen
        PageInfo<Kitchen> pageInfo = kitchenService.findPage(kitchen, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Kitchen分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用KitchenService实现分页查询Kitchen
        PageInfo<Kitchen> pageInfo = kitchenService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param kitchen
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Kitchen>> findList(@RequestBody(required = false) Kitchen kitchen){
        //调用KitchenService实现条件查询Kitchen
        List<Kitchen> list = kitchenService.findList(kitchen);
        return new Result<List<Kitchen>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用KitchenService实现根据主键删除
        kitchenService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Kitchen数据
     * @param kitchen
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Kitchen kitchen, @PathVariable Integer id){
        //设置主键值
        kitchen.setKId(id);
        //调用KitchenService实现修改Kitchen
        kitchenService.update(kitchen);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Kitchen数据
     * @param kitchen
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Kitchen kitchen){
        //调用KitchenService实现添加Kitchen
        kitchenService.add(kitchen);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Kitchen数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Kitchen> findById(@PathVariable Integer id){
        //调用KitchenService实现根据主键查询Kitchen
        Kitchen kitchen = kitchenService.findById(id);
        return new Result<Kitchen>(true,StatusCode.OK,"查询成功",kitchen);
    }

    /***
     * 查询Kitchen全部数据
     * @return
     */
    @GetMapping
    public Result<List<Kitchen>> findAll(){
        //调用KitchenService实现查询所有Kitchen
        List<Kitchen> list = kitchenService.findAll();
        return new Result<List<Kitchen>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
