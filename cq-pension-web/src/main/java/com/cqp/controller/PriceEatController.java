package com.cqp.controller;

import com.cqp.model.PriceEat;
import com.cqp.service.api.PriceEatService;
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
@RequestMapping("/priceEat")
@CrossOrigin
public class PriceEatController {

    @Autowired
    private PriceEatService priceEatService;

    /***
     * PriceEat分页条件搜索实现
     * @param priceEat
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) PriceEat priceEat, @PathVariable  int page, @PathVariable  int size){
        //调用PriceEatService实现分页条件查询PriceEat
        PageInfo<PriceEat> pageInfo = priceEatService.findPage(priceEat, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * PriceEat分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PriceEatService实现分页查询PriceEat
        PageInfo<PriceEat> pageInfo = priceEatService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param priceEat
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<PriceEat>> findList(@RequestBody(required = false) PriceEat priceEat){
        //调用PriceEatService实现条件查询PriceEat
        List<PriceEat> list = priceEatService.findList(priceEat);
        return new Result<List<PriceEat>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用PriceEatService实现根据主键删除
        priceEatService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改PriceEat数据
     * @param priceEat
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody PriceEat priceEat, @PathVariable Integer id){
        //设置主键值
        priceEat.setPeId(id);
        //调用PriceEatService实现修改PriceEat
        priceEatService.update(priceEat);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增PriceEat数据
     * @param priceEat
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody PriceEat priceEat){
        //调用PriceEatService实现添加PriceEat
        priceEatService.add(priceEat);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询PriceEat数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<PriceEat> findById(@PathVariable Integer id){
        //调用PriceEatService实现根据主键查询PriceEat
        PriceEat priceEat = priceEatService.findById(id);
        return new Result<PriceEat>(true,StatusCode.OK,"查询成功",priceEat);
    }

    /***
     * 查询PriceEat全部数据
     * @return
     */
    @GetMapping
    public Result<List<PriceEat>> findAll(){
        //调用PriceEatService实现查询所有PriceEat
        List<PriceEat> list = priceEatService.findAll();
        return new Result<List<PriceEat>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
