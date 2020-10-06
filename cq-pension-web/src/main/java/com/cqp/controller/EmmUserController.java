package com.cqp.controller;

import com.cqp.model.EmmUser;
import com.cqp.service.api.EmmUserService;
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
@RequestMapping("/emmUser")
@CrossOrigin
public class EmmUserController {

    @Autowired
    private EmmUserService emmUserService;

    /***
     * EmmUser分页条件搜索实现
     * @param emmUser
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) EmmUser emmUser, @PathVariable  int page, @PathVariable  int size){
        //调用EmmUserService实现分页条件查询EmmUser
        PageInfo<EmmUser> pageInfo = emmUserService.findPage(emmUser, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * EmmUser分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用EmmUserService实现分页查询EmmUser
        PageInfo<EmmUser> pageInfo = emmUserService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param emmUser
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<EmmUser>> findList(@RequestBody(required = false) EmmUser emmUser){
        //调用EmmUserService实现条件查询EmmUser
        List<EmmUser> list = emmUserService.findList(emmUser);
        return new Result<List<EmmUser>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用EmmUserService实现根据主键删除
        emmUserService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改EmmUser数据
     * @param emmUser
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody EmmUser emmUser, @PathVariable Integer id){
        //设置主键值
        emmUser.setId(id);
        //调用EmmUserService实现修改EmmUser
        emmUserService.update(emmUser);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增EmmUser数据
     * @param emmUser
     * @return
     */
    @PostMapping
    public Result add(@RequestBody EmmUser emmUser){
        //调用EmmUserService实现添加EmmUser
        emmUserService.add(emmUser);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询EmmUser数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<EmmUser> findById(@PathVariable Integer id){
        //调用EmmUserService实现根据主键查询EmmUser
        EmmUser emmUser = emmUserService.findById(id);
        return new Result<EmmUser>(true,StatusCode.OK,"查询成功",emmUser);
    }

    /***
     * 查询EmmUser全部数据
     * @return
     */
    @GetMapping
    public Result<List<EmmUser>> findAll(){
        //调用EmmUserService实现查询所有EmmUser
        List<EmmUser> list = emmUserService.findAll();
        return new Result<List<EmmUser>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
