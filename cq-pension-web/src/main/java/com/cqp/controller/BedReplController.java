package com.cqp.controller;

import com.cqp.model.BedRepl;
import com.cqp.service.api.BedReplService;
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
@RequestMapping("/bedRepl")
@CrossOrigin
public class BedReplController {

    @Autowired
    private BedReplService bedReplService;

    /***
     * BedRepl分页条件搜索实现
     * @param bedRepl
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) BedRepl bedRepl, @PathVariable  int page, @PathVariable  int size){
        //调用BedReplService实现分页条件查询BedRepl
        PageInfo<BedRepl> pageInfo = bedReplService.findPage(bedRepl, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * BedRepl分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用BedReplService实现分页查询BedRepl
        PageInfo<BedRepl> pageInfo = bedReplService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param bedRepl
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<BedRepl>> findList(@RequestBody(required = false) BedRepl bedRepl){
        //调用BedReplService实现条件查询BedRepl
        List<BedRepl> list = bedReplService.findList(bedRepl);
        return new Result<List<BedRepl>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用BedReplService实现根据主键删除
        bedReplService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改BedRepl数据
     * @param bedRepl
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody BedRepl bedRepl, @PathVariable Integer id){
        //设置主键值
        bedRepl.setBrId(id);
        //调用BedReplService实现修改BedRepl
        bedReplService.update(bedRepl);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增BedRepl数据
     * @param bedRepl
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody BedRepl bedRepl){
        //调用BedReplService实现添加BedRepl
        bedReplService.add(bedRepl);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询BedRepl数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<BedRepl> findById(@PathVariable Integer id){
        //调用BedReplService实现根据主键查询BedRepl
        BedRepl bedRepl = bedReplService.findById(id);
        return new Result<BedRepl>(true,StatusCode.OK,"查询成功",bedRepl);
    }

    /***
     * 查询BedRepl全部数据
     * @return
     */
    @GetMapping
    public Result<List<BedRepl>> findAll(){
        //调用BedReplService实现查询所有BedRepl
        List<BedRepl> list = bedReplService.findAll();
        return new Result<List<BedRepl>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
