package com.cqp.controller;

import com.cqp.model.EatCons;
import com.cqp.service.api.EatConsService;
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
@RequestMapping("/eatCons")
@CrossOrigin
public class EatConsController {

    @Autowired
    private EatConsService eatConsService;

    /***
     * EatCons分页条件搜索实现
     * @param eatCons
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) EatCons eatCons, @PathVariable  int page, @PathVariable  int size){
        //调用EatConsService实现分页条件查询EatCons
        PageInfo<EatCons> pageInfo = eatConsService.findPage(eatCons, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * EatCons分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用EatConsService实现分页查询EatCons
        PageInfo<EatCons> pageInfo = eatConsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param eatCons
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<EatCons>> findList(@RequestBody(required = false) EatCons eatCons){
        //调用EatConsService实现条件查询EatCons
        List<EatCons> list = eatConsService.findList(eatCons);
        return new Result<List<EatCons>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用EatConsService实现根据主键删除
        eatConsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改EatCons数据
     * @param eatCons
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody EatCons eatCons, @PathVariable Integer id){
        //设置主键值
        eatCons.setEcId(id);
        //调用EatConsService实现修改EatCons
        eatConsService.update(eatCons);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增EatCons数据
     * @param eatCons
     * @return
     */
    @PostMapping
    public Result add(@RequestBody EatCons eatCons){
        //调用EatConsService实现添加EatCons
        eatConsService.add(eatCons);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询EatCons数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<EatCons> findById(@PathVariable Integer id){
        //调用EatConsService实现根据主键查询EatCons
        EatCons eatCons = eatConsService.findById(id);
        return new Result<EatCons>(true,StatusCode.OK,"查询成功",eatCons);
    }

    /***
     * 查询EatCons全部数据
     * @return
     */
    @GetMapping
    public Result<List<EatCons>> findAll(){
        //调用EatConsService实现查询所有EatCons
        List<EatCons> list = eatConsService.findAll();
        return new Result<List<EatCons>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
