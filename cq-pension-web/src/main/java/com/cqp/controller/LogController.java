package com.cqp.controller;

import com.cqp.model.Log;
import com.cqp.service.api.LogService;
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
@RequestMapping("/log")
@CrossOrigin
public class LogController {

    @Autowired
    private LogService logService;

    /***
     * Log分页条件搜索实现
     * @param log
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Log log, @PathVariable  int page, @PathVariable  int size){
        //调用LogService实现分页条件查询Log
        PageInfo<Log> pageInfo = logService.findPage(log, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Log分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用LogService实现分页查询Log
        PageInfo<Log> pageInfo = logService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param log
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Log>> findList(@RequestBody(required = false) Log log){
        //调用LogService实现条件查询Log
        List<Log> list = logService.findList(log);
        return new Result<List<Log>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用LogService实现根据主键删除
        logService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Log数据
     * @param log
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Log log, @PathVariable Integer id){
        //设置主键值
        log.setLogId(id);
        //调用LogService实现修改Log
        logService.update(log);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Log数据
     * @param log
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Log log){
        //调用LogService实现添加Log
        logService.add(log);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Log数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Log> findById(@PathVariable Integer id){
        //调用LogService实现根据主键查询Log
        Log log = logService.findById(id);
        return new Result<Log>(true,StatusCode.OK,"查询成功",log);
    }

    /***
     * 查询Log全部数据
     * @return
     */
    @GetMapping
    public Result<List<Log>> findAll(){
        //调用LogService实现查询所有Log
        List<Log> list = logService.findAll();
        return new Result<List<Log>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
