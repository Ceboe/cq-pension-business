package com.cqp.controller;

import com.cqp.model.EatLevel;
import com.cqp.service.api.EatLevelService;
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
@RequestMapping("/eatLevel")
@CrossOrigin
public class EatLevelController {

    @Autowired
    private EatLevelService eatLevelService;

    /***
     * EatLevel分页条件搜索实现
     * @param eatLevel
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) EatLevel eatLevel, @PathVariable  int page, @PathVariable  int size){
        //调用EatLevelService实现分页条件查询EatLevel
        PageInfo<EatLevel> pageInfo = eatLevelService.findPage(eatLevel, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * EatLevel分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用EatLevelService实现分页查询EatLevel
        PageInfo<EatLevel> pageInfo = eatLevelService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param eatLevel
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<EatLevel>> findList(@RequestBody(required = false) EatLevel eatLevel){
        //调用EatLevelService实现条件查询EatLevel
        List<EatLevel> list = eatLevelService.findList(eatLevel);
        return new Result<List<EatLevel>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用EatLevelService实现根据主键删除
        eatLevelService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改EatLevel数据
     * @param eatLevel
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody EatLevel eatLevel, @PathVariable Integer id){
        //设置主键值
        eatLevel.setElId(id);
        //调用EatLevelService实现修改EatLevel
        eatLevelService.update(eatLevel);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增EatLevel数据
     * @param eatLevel
     * @return
     */
    @PostMapping
    public Result add(@RequestBody EatLevel eatLevel){
        //调用EatLevelService实现添加EatLevel
        eatLevelService.add(eatLevel);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询EatLevel数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<EatLevel> findById(@PathVariable Integer id){
        //调用EatLevelService实现根据主键查询EatLevel
        EatLevel eatLevel = eatLevelService.findById(id);
        return new Result<EatLevel>(true,StatusCode.OK,"查询成功",eatLevel);
    }

    /***
     * 查询EatLevel全部数据
     * @return
     */
    @GetMapping
    public Result<List<EatLevel>> findAll(){
        //调用EatLevelService实现查询所有EatLevel
        List<EatLevel> list = eatLevelService.findAll();
        return new Result<List<EatLevel>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
