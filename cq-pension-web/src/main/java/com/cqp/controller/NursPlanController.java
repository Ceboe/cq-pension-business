package com.cqp.controller;

import com.cqp.model.NursPlan;
import com.cqp.service.api.NursPlanService;
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
@RequestMapping("/nursPlan")
@CrossOrigin
public class NursPlanController {

    @Autowired
    private NursPlanService nursPlanService;

    /***
     * NursPlan分页条件搜索实现
     * @param nursPlan
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) NursPlan nursPlan, @PathVariable  int page, @PathVariable  int size){
        //调用NursPlanService实现分页条件查询NursPlan
        PageInfo<NursPlan> pageInfo = nursPlanService.findPage(nursPlan, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * NursPlan分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用NursPlanService实现分页查询NursPlan
        PageInfo<NursPlan> pageInfo = nursPlanService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param nursPlan
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<NursPlan>> findList(@RequestBody(required = false) NursPlan nursPlan){
        //调用NursPlanService实现条件查询NursPlan
        List<NursPlan> list = nursPlanService.findList(nursPlan);
        return new Result<List<NursPlan>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用NursPlanService实现根据主键删除
        nursPlanService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改NursPlan数据
     * @param nursPlan
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody NursPlan nursPlan, @PathVariable Integer id){
        //设置主键值
        nursPlan.setNId(id);
        //调用NursPlanService实现修改NursPlan
        nursPlanService.update(nursPlan);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增NursPlan数据
     * @param nursPlan
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody NursPlan nursPlan){
        //调用NursPlanService实现添加NursPlan
        nursPlanService.add(nursPlan);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询NursPlan数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<NursPlan> findById(@PathVariable Integer id){
        //调用NursPlanService实现根据主键查询NursPlan
        NursPlan nursPlan = nursPlanService.findById(id);
        return new Result<NursPlan>(true,StatusCode.OK,"查询成功",nursPlan);
    }

    /***
     * 查询NursPlan全部数据
     * @return
     */
    @GetMapping
    public Result<List<NursPlan>> findAll(){
        //调用NursPlanService实现查询所有NursPlan
        List<NursPlan> list = nursPlanService.findAll();
        return new Result<List<NursPlan>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
