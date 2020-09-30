package com.cqp.controller;

import com.cqp.model.Live;
import com.cqp.service.api.LiveService;
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
@RequestMapping("/live")
@CrossOrigin
public class LiveController {

    @Autowired
    private LiveService liveService;

    /***
     * Live分页条件搜索实现
     * @param live
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Live live, @PathVariable  int page, @PathVariable  int size){
        //调用LiveService实现分页条件查询Live
        PageInfo<Live> pageInfo = liveService.findPage(live, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Live分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用LiveService实现分页查询Live
        PageInfo<Live> pageInfo = liveService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param live
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Live>> findList(@RequestBody(required = false) Live live){
        //调用LiveService实现条件查询Live
        List<Live> list = liveService.findList(live);
        return new Result<List<Live>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用LiveService实现根据主键删除
        liveService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Live数据
     * @param live
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Live live, @PathVariable Integer id){
        //设置主键值
        live.setLiveId(id);
        //调用LiveService实现修改Live
        liveService.update(live);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Live数据
     * @param live
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Live live){
        //调用LiveService实现添加Live
        liveService.add(live);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Live数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Live> findById(@PathVariable Integer id){
        //调用LiveService实现根据主键查询Live
        Live live = liveService.findById(id);
        return new Result<Live>(true,StatusCode.OK,"查询成功",live);
    }

    /***
     * 查询Live全部数据
     * @return
     */
    @GetMapping
    public Result<List<Live>> findAll(){
        //调用LiveService实现查询所有Live
        List<Live> list = liveService.findAll();
        return new Result<List<Live>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
