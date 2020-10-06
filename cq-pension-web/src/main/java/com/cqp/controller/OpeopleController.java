package com.cqp.controller;

import com.cqp.model.Opeople;
import com.cqp.service.api.OpeopleService;
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
@RequestMapping("/opeople")
@CrossOrigin
public class OpeopleController {

    @Autowired
    private OpeopleService opeopleService;

    /***
     * Opeople分页条件搜索实现
     * @param opeople
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Opeople opeople, @PathVariable  int page, @PathVariable  int size){
        //调用OpeopleService实现分页条件查询Opeople
        PageInfo<Opeople> pageInfo = opeopleService.findPage(opeople, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Opeople分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OpeopleService实现分页查询Opeople
        PageInfo<Opeople> pageInfo = opeopleService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param opeople
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Opeople>> findList(@RequestBody(required = false) Opeople opeople){
        //调用OpeopleService实现条件查询Opeople
        List<Opeople> list = opeopleService.findList(opeople);
        return new Result<List<Opeople>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用OpeopleService实现根据主键删除
        opeopleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Opeople数据
     * @param opeople
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Opeople opeople, @PathVariable Integer id){
        //设置主键值
        opeople.setOpId(id);
        //调用OpeopleService实现修改Opeople
        opeopleService.update(opeople);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Opeople数据
     * @param opeople
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Opeople opeople){
        //调用OpeopleService实现添加Opeople
        opeopleService.add(opeople);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Opeople数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Opeople> findById(@PathVariable Integer id){
        //调用OpeopleService实现根据主键查询Opeople
        Opeople opeople = opeopleService.findById(id);
        return new Result<Opeople>(true,StatusCode.OK,"查询成功",opeople);
    }

    /***
     * 查询Opeople全部数据
     * @return
     */
    @GetMapping
    public Result<List<Opeople>> findAll(){
        //调用OpeopleService实现查询所有Opeople
        List<Opeople> list = opeopleService.findAll();
        return new Result<List<Opeople>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
