package com.cqp.controller;

import com.cqp.model.Floor;
import com.cqp.service.api.FloorService;
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
@RequestMapping("/floor")
@CrossOrigin
public class FloorController {

    @Autowired
    private FloorService floorService;

    /***
     * Floor分页条件搜索实现
     * @param floor
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Floor floor, @PathVariable  int page, @PathVariable  int size){
        //调用FloorService实现分页条件查询Floor
        PageInfo<Floor> pageInfo = floorService.findPage(floor, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Floor分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FloorService实现分页查询Floor
        PageInfo<Floor> pageInfo = floorService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param floor
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Floor>> findList(@RequestBody(required = false) Floor floor){
        //调用FloorService实现条件查询Floor
        List<Floor> list = floorService.findList(floor);
        return new Result<List<Floor>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用FloorService实现根据主键删除
        floorService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Floor数据
     * @param floor
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Floor floor, @PathVariable Integer id){
        //设置主键值
        floor.setFlId(id);
        //调用FloorService实现修改Floor
        floorService.update(floor);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Floor数据
     * @param floor
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Floor floor){
        //调用FloorService实现添加Floor
        floorService.add(floor);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Floor数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Floor> findById(@PathVariable Integer id){
        //调用FloorService实现根据主键查询Floor
        Floor floor = floorService.findById(id);
        return new Result<Floor>(true,StatusCode.OK,"查询成功",floor);
    }

    /***
     * 查询Floor全部数据
     * @return
     */
    @GetMapping
    public Result<List<Floor>> findAll(){
        //调用FloorService实现查询所有Floor
        List<Floor> list = floorService.findAll();
        return new Result<List<Floor>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
