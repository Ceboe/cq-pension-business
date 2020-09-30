package com.cqp.controller;

import com.cqp.model.PersonEat;
import com.cqp.service.api.PersonEatService;
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
@RequestMapping("/personEat")
@CrossOrigin
public class PersonEatController {

    @Autowired
    private PersonEatService personEatService;

    /***
     * PersonEat分页条件搜索实现
     * @param personEat
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) PersonEat personEat, @PathVariable  int page, @PathVariable  int size){
        //调用PersonEatService实现分页条件查询PersonEat
        PageInfo<PersonEat> pageInfo = personEatService.findPage(personEat, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * PersonEat分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PersonEatService实现分页查询PersonEat
        PageInfo<PersonEat> pageInfo = personEatService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param personEat
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<PersonEat>> findList(@RequestBody(required = false) PersonEat personEat){
        //调用PersonEatService实现条件查询PersonEat
        List<PersonEat> list = personEatService.findList(personEat);
        return new Result<List<PersonEat>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用PersonEatService实现根据主键删除
        personEatService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改PersonEat数据
     * @param personEat
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody PersonEat personEat, @PathVariable Integer id){
        //设置主键值
        personEat.setPeId(id);
        //调用PersonEatService实现修改PersonEat
        personEatService.update(personEat);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增PersonEat数据
     * @param personEat
     * @return
     */
    @PostMapping
    public Result add(@RequestBody PersonEat personEat){
        //调用PersonEatService实现添加PersonEat
        personEatService.add(personEat);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询PersonEat数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<PersonEat> findById(@PathVariable Integer id){
        //调用PersonEatService实现根据主键查询PersonEat
        PersonEat personEat = personEatService.findById(id);
        return new Result<PersonEat>(true,StatusCode.OK,"查询成功",personEat);
    }

    /***
     * 查询PersonEat全部数据
     * @return
     */
    @GetMapping
    public Result<List<PersonEat>> findAll(){
        //调用PersonEatService实现查询所有PersonEat
        List<PersonEat> list = personEatService.findAll();
        return new Result<List<PersonEat>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
