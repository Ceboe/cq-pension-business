package com.cqp.controller;

import com.cqp.model.Family;
import com.cqp.service.api.FamilyService;
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
@RequestMapping("/family")
@CrossOrigin
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    /***
     * Family分页条件搜索实现
     * @param family
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Family family, @PathVariable  int page, @PathVariable  int size){
        //调用FamilyService实现分页条件查询Family
        PageInfo<Family> pageInfo = familyService.findPage(family, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Family分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FamilyService实现分页查询Family
        PageInfo<Family> pageInfo = familyService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param family
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Family>> findList(@RequestBody(required = false) Family family){
        //调用FamilyService实现条件查询Family
        List<Family> list = familyService.findList(family);
        return new Result<List<Family>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用FamilyService实现根据主键删除
        familyService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Family数据
     * @param family
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Family family, @PathVariable Integer id){
        //设置主键值
        family.setFmId(id);
        //调用FamilyService实现修改Family
        familyService.update(family);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Family数据
     * @param family
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Family family){
        //调用FamilyService实现添加Family
        familyService.add(family);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Family数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Family> findById(@PathVariable Integer id){
        //调用FamilyService实现根据主键查询Family
        Family family = familyService.findById(id);
        return new Result<Family>(true,StatusCode.OK,"查询成功",family);
    }

    /***
     * 查询Family全部数据
     * @return
     */
    @GetMapping("/add")
    public Result<List<Family>> findAll(){
        //调用FamilyService实现查询所有Family
        List<Family> list = familyService.findAll();
        return new Result<List<Family>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
