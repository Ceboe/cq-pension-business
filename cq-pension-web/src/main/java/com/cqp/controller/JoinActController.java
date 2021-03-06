package com.cqp.controller;

import com.cqp.model.JoinAct;
import com.cqp.service.api.JoinActService;
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
@RequestMapping("/joinAct")
@CrossOrigin
public class JoinActController {

    @Autowired
    private JoinActService joinActService;

    /***
     * JoinAct分页条件搜索实现
     * @param joinAct
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) JoinAct joinAct, @PathVariable  int page, @PathVariable  int size){
        //调用JoinActService实现分页条件查询JoinAct
        PageInfo<JoinAct> pageInfo = joinActService.findPage(joinAct, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * JoinAct分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用JoinActService实现分页查询JoinAct
        PageInfo<JoinAct> pageInfo = joinActService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param joinAct
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<JoinAct>> findList(@RequestBody(required = false) JoinAct joinAct){
        //调用JoinActService实现条件查询JoinAct
        List<JoinAct> list = joinActService.findList(joinAct);
        return new Result<List<JoinAct>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用JoinActService实现根据主键删除
        joinActService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改JoinAct数据
     * @param joinAct
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody JoinAct joinAct, @PathVariable Integer id){
        //设置主键值
        joinAct.setJaId(id);
        //调用JoinActService实现修改JoinAct
        joinActService.update(joinAct);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增JoinAct数据
     * @param joinAct
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody JoinAct joinAct){
        //调用JoinActService实现添加JoinAct
        joinActService.add(joinAct);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询JoinAct数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<JoinAct> findById(@PathVariable Integer id){
        //调用JoinActService实现根据主键查询JoinAct
        JoinAct joinAct = joinActService.findById(id);
        return new Result<JoinAct>(true,StatusCode.OK,"查询成功",joinAct);
    }

    /***
     * 查询JoinAct全部数据
     * @return
     */
    @GetMapping
    public Result<List<JoinAct>> findAll(){
        //调用JoinActService实现查询所有JoinAct
        List<JoinAct> list = joinActService.findAll();
        return new Result<List<JoinAct>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
