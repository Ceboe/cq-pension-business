package com.cqp.controller;

import com.cqp.model.IllHistory;
import com.cqp.service.api.IllHistoryService;
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
@RequestMapping("/illHistory")
@CrossOrigin
public class IllHistoryController {

    @Autowired
    private IllHistoryService illHistoryService;

    /***
     * IllHistory分页条件搜索实现
     * @param illHistory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) IllHistory illHistory, @PathVariable  int page, @PathVariable  int size){
        //调用IllHistoryService实现分页条件查询IllHistory
        PageInfo<IllHistory> pageInfo = illHistoryService.findPage(illHistory, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * IllHistory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用IllHistoryService实现分页查询IllHistory
        PageInfo<IllHistory> pageInfo = illHistoryService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param illHistory
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<IllHistory>> findList(@RequestBody(required = false) IllHistory illHistory){
        //调用IllHistoryService实现条件查询IllHistory
        List<IllHistory> list = illHistoryService.findList(illHistory);
        return new Result<List<IllHistory>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用IllHistoryService实现根据主键删除
        illHistoryService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改IllHistory数据
     * @param illHistory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody IllHistory illHistory, @PathVariable Integer id){
        //设置主键值
        illHistory.setIhId(id);
        //调用IllHistoryService实现修改IllHistory
        illHistoryService.update(illHistory);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增IllHistory数据
     * @param illHistory
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody IllHistory illHistory){
        //调用IllHistoryService实现添加IllHistory
        illHistoryService.add(illHistory);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询IllHistory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<IllHistory> findById(@PathVariable Integer id){
        //调用IllHistoryService实现根据主键查询IllHistory
        IllHistory illHistory = illHistoryService.findById(id);
        return new Result<IllHistory>(true,StatusCode.OK,"查询成功",illHistory);
    }

    /***
     * 查询IllHistory全部数据
     * @return
     */
    @GetMapping
    public Result<List<IllHistory>> findAll(){
        //调用IllHistoryService实现查询所有IllHistory
        List<IllHistory> list = illHistoryService.findAll();
        return new Result<List<IllHistory>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
