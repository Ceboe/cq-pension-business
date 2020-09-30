package com.cqp.controller;

import com.cqp.model.Build;
import com.cqp.service.api.BuildService;
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
@RequestMapping("/build")
@CrossOrigin
public class BuildController {

    @Autowired
    private BuildService buildService;

    /***
     * Build分页条件搜索实现
     * @param build
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Build build, @PathVariable  int page, @PathVariable  int size){
        //调用BuildService实现分页条件查询Build
        PageInfo<Build> pageInfo = buildService.findPage(build, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Build分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用BuildService实现分页查询Build
        PageInfo<Build> pageInfo = buildService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param build
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Build>> findList(@RequestBody(required = false) Build build){
        //调用BuildService实现条件查询Build
        List<Build> list = buildService.findList(build);
        return new Result<List<Build>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用BuildService实现根据主键删除
        buildService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Build数据
     * @param build
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Build build, @PathVariable Integer id){
        //设置主键值
        build.setBId(id);
        //调用BuildService实现修改Build
        buildService.update(build);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Build数据
     * @param build
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Build build){
        //调用BuildService实现添加Build
        buildService.add(build);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Build数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Build> findById(@PathVariable Integer id){
        //调用BuildService实现根据主键查询Build
        Build build = buildService.findById(id);
        return new Result<Build>(true,StatusCode.OK,"查询成功",build);
    }

    /***
     * 查询Build全部数据
     * @return
     */
    @GetMapping
    public Result<List<Build>> findAll(){
        //调用BuildService实现查询所有Build
        List<Build> list = buildService.findAll();
        return new Result<List<Build>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
