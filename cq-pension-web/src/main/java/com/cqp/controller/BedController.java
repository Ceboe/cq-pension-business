package com.cqp.controller;

import com.cqp.model.Bed;
import com.cqp.service.api.BedService;
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
@RequestMapping("/bed")
@CrossOrigin
public class BedController {

    @Autowired
    private BedService bedService;

    /***
     * Bed分页条件搜索实现
     * @param bed
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Bed bed, @PathVariable  int page, @PathVariable  int size){
        //调用BedService实现分页条件查询Bed
        PageInfo<Bed> pageInfo = bedService.findPage(bed, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Bed分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用BedService实现分页查询Bed
        PageInfo<Bed> pageInfo = bedService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param bed
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Bed>> findList(@RequestBody(required = false) Bed bed){
        //调用BedService实现条件查询Bed
        List<Bed> list = bedService.findList(bed);
        return new Result<List<Bed>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用BedService实现根据主键删除
        bedService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Bed数据
     * @param bed
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Bed bed, @PathVariable Integer id){
        //设置主键值
        bed.setBedId(id);
        //调用BedService实现修改Bed
        bedService.update(bed);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Bed数据
     * @param bed
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Bed bed){
        //调用BedService实现添加Bed
        bedService.add(bed);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Bed数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Bed> findById(@PathVariable Integer id){
        //调用BedService实现根据主键查询Bed
        Bed bed = bedService.findById(id);
        return new Result<Bed>(true,StatusCode.OK,"查询成功",bed);
    }

    /***
     * 查询Bed全部数据
     * @return
     */
    @GetMapping
    public Result<List<Bed>> findAll(){
        //调用BedService实现查询所有Bed
        List<Bed> list = bedService.findAll();
        return new Result<List<Bed>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
