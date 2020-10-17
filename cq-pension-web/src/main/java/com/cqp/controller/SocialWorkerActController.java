package com.cqp.controller;

import com.cqp.model.SocialWorkerAct;
import com.cqp.service.api.SocialWorkerActService;
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
@RequestMapping("/socialWorkerAct")
@CrossOrigin
public class SocialWorkerActController {

    @Autowired
    private SocialWorkerActService socialWorkerActService;

    /***
     * SocialWorkerAct分页条件搜索实现
     * @param socialWorkerAct
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) SocialWorkerAct socialWorkerAct, @PathVariable  int page, @PathVariable  int size){
        //调用SocialWorkerActService实现分页条件查询SocialWorkerAct
        PageInfo<SocialWorkerAct> pageInfo = socialWorkerActService.findPage(socialWorkerAct, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SocialWorkerAct分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SocialWorkerActService实现分页查询SocialWorkerAct
        PageInfo<SocialWorkerAct> pageInfo = socialWorkerActService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param socialWorkerAct
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<SocialWorkerAct>> findList(@RequestBody(required = false) SocialWorkerAct socialWorkerAct){
        //调用SocialWorkerActService实现条件查询SocialWorkerAct
        List<SocialWorkerAct> list = socialWorkerActService.findList(socialWorkerAct);
        return new Result<List<SocialWorkerAct>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SocialWorkerActService实现根据主键删除
        socialWorkerActService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SocialWorkerAct数据
     * @param socialWorkerAct
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody SocialWorkerAct socialWorkerAct, @PathVariable Integer id){
        //设置主键值
        socialWorkerAct.setSwaId(id);
        //调用SocialWorkerActService实现修改SocialWorkerAct
        socialWorkerActService.update(socialWorkerAct);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SocialWorkerAct数据
     * @param socialWorkerAct
     * @return
     */
    @PostMapping
    public Result add(@RequestBody SocialWorkerAct socialWorkerAct){
        //调用SocialWorkerActService实现添加SocialWorkerAct
        socialWorkerActService.add(socialWorkerAct);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SocialWorkerAct数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<SocialWorkerAct> findById(@PathVariable Integer id){
        //调用SocialWorkerActService实现根据主键查询SocialWorkerAct
        SocialWorkerAct socialWorkerAct = socialWorkerActService.findById(id);
        return new Result<SocialWorkerAct>(true,StatusCode.OK,"查询成功",socialWorkerAct);
    }

    /***
     * 查询SocialWorkerAct全部数据
     * @return
     */
    @GetMapping
    public Result<List<SocialWorkerAct>> findAll(){
        //调用SocialWorkerActService实现查询所有SocialWorkerAct
        List<SocialWorkerAct> list = socialWorkerActService.findAll();
        return new Result<List<SocialWorkerAct>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
