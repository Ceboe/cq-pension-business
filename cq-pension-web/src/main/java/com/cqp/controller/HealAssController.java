package com.cqp.controller;

import com.cqp.model.HealAss;
import com.cqp.service.api.HealAssService;
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
@RequestMapping("/healAss")
@CrossOrigin
public class HealAssController {

    @Autowired
    private HealAssService healAssService;

    /***
     * HealAss分页条件搜索实现
     * @param healAss
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) HealAss healAss, @PathVariable  int page, @PathVariable  int size){
        //调用HealAssService实现分页条件查询HealAss
        PageInfo<HealAss> pageInfo = healAssService.findPage(healAss, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * HealAss分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用HealAssService实现分页查询HealAss
        PageInfo<HealAss> pageInfo = healAssService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param healAss
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<HealAss>> findList(@RequestBody(required = false) HealAss healAss){
        //调用HealAssService实现条件查询HealAss
        List<HealAss> list = healAssService.findList(healAss);
        return new Result<List<HealAss>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用HealAssService实现根据主键删除
        healAssService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改HealAss数据
     * @param healAss
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody HealAss healAss, @PathVariable Integer id){
        //设置主键值
        healAss.setHaId(id);
        //调用HealAssService实现修改HealAss
        healAssService.update(healAss);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增HealAss数据
     * @param healAss
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody HealAss healAss){
        //调用HealAssService实现添加HealAss
        healAssService.add(healAss);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询HealAss数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<HealAss> findById(@PathVariable Integer id){
        //调用HealAssService实现根据主键查询HealAss
        HealAss healAss = healAssService.findById(id);
        return new Result<HealAss>(true,StatusCode.OK,"查询成功",healAss);
    }

    /***
     * 查询HealAss全部数据
     * @return
     */
    @GetMapping
    public Result<List<HealAss>> findAll(){
        //调用HealAssService实现查询所有HealAss
        List<HealAss> list = healAssService.findAll();
        return new Result<List<HealAss>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
