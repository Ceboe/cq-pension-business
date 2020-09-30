package com.cqp.controller;

import com.cqp.model.Out;
import com.cqp.service.api.OutService;
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
@RequestMapping("/out")
@CrossOrigin
public class OutController {

    @Autowired
    private OutService outService;

    /***
     * Out分页条件搜索实现
     * @param out
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Out out, @PathVariable  int page, @PathVariable  int size){
        //调用OutService实现分页条件查询Out
        PageInfo<Out> pageInfo = outService.findPage(out, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Out分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OutService实现分页查询Out
        PageInfo<Out> pageInfo = outService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param out
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Out>> findList(@RequestBody(required = false) Out out){
        //调用OutService实现条件查询Out
        List<Out> list = outService.findList(out);
        return new Result<List<Out>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用OutService实现根据主键删除
        outService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Out数据
     * @param out
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Out out, @PathVariable Integer id){
        //设置主键值
        out.setOutId(id);
        //调用OutService实现修改Out
        outService.update(out);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Out数据
     * @param out
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Out out){
        //调用OutService实现添加Out
        outService.add(out);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Out数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Out> findById(@PathVariable Integer id){
        //调用OutService实现根据主键查询Out
        Out out = outService.findById(id);
        return new Result<Out>(true,StatusCode.OK,"查询成功",out);
    }

    /***
     * 查询Out全部数据
     * @return
     */
    @GetMapping
    public Result<List<Out>> findAll(){
        //调用OutService实现查询所有Out
        List<Out> list = outService.findAll();
        return new Result<List<Out>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
