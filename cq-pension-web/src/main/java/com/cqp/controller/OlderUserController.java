package com.cqp.controller;

import com.cqp.model.OlderUser;
import com.cqp.service.api.OlderUserService;
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
@RequestMapping("/olderUser")
@CrossOrigin
public class OlderUserController {

    @Autowired
    private OlderUserService olderUserService;

    /***
     * OlderUser分页条件搜索实现
     * @param olderUser
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) OlderUser olderUser, @PathVariable  int page, @PathVariable  int size){
        //调用OlderUserService实现分页条件查询OlderUser
        PageInfo<OlderUser> pageInfo = olderUserService.findPage(olderUser, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OlderUser分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OlderUserService实现分页查询OlderUser
        PageInfo<OlderUser> pageInfo = olderUserService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param olderUser
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<OlderUser>> findList(@RequestBody(required = false) OlderUser olderUser){
        //调用OlderUserService实现条件查询OlderUser
        List<OlderUser> list = olderUserService.findList(olderUser);
        return new Result<List<OlderUser>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用OlderUserService实现根据主键删除
        olderUserService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OlderUser数据
     * @param olderUser
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody OlderUser olderUser, @PathVariable Integer id){
        //设置主键值
        olderUser.setId(id);
        //调用OlderUserService实现修改OlderUser
        olderUserService.update(olderUser);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OlderUser数据
     * @param olderUser
     * @return
     */
    @PostMapping
    public Result add(@RequestBody OlderUser olderUser){
        //调用OlderUserService实现添加OlderUser
        olderUserService.add(olderUser);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OlderUser数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<OlderUser> findById(@PathVariable Integer id){
        //调用OlderUserService实现根据主键查询OlderUser
        OlderUser olderUser = olderUserService.findById(id);
        return new Result<OlderUser>(true,StatusCode.OK,"查询成功",olderUser);
    }

    /***
     * 查询OlderUser全部数据
     * @return
     */
    @GetMapping
    public Result<List<OlderUser>> findAll(){
        //调用OlderUserService实现查询所有OlderUser
        List<OlderUser> list = olderUserService.findAll();
        return new Result<List<OlderUser>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
