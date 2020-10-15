package com.cqp.controller;

import com.cqp.model.RepContent;
import com.cqp.service.api.RepContentService;
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
@RequestMapping("/repContent")
@CrossOrigin
public class RepContentController {

    @Autowired
    private RepContentService repContentService;

    /***
     * RepContent分页条件搜索实现
     * @param repContent
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) RepContent repContent, @PathVariable  int page, @PathVariable  int size){
        //调用RepContentService实现分页条件查询RepContent
        PageInfo<RepContent> pageInfo = repContentService.findPage(repContent, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * RepContent分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RepContentService实现分页查询RepContent
        PageInfo<RepContent> pageInfo = repContentService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param repContent
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<RepContent>> findList(@RequestBody(required = false) RepContent repContent){
        //调用RepContentService实现条件查询RepContent
        List<RepContent> list = repContentService.findList(repContent);
        return new Result<List<RepContent>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用RepContentService实现根据主键删除
        repContentService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改RepContent数据
     * @param repContent
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody RepContent repContent, @PathVariable Integer id){
        //设置主键值
        repContent.setRcId(id);
        //调用RepContentService实现修改RepContent
        repContentService.update(repContent);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增RepContent数据
     * @param repContent
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody RepContent repContent){
        //调用RepContentService实现添加RepContent
        repContentService.add(repContent);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询RepContent数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<RepContent> findById(@PathVariable Integer id){
        //调用RepContentService实现根据主键查询RepContent
        RepContent repContent = repContentService.findById(id);
        return new Result<RepContent>(true,StatusCode.OK,"查询成功",repContent);
    }

    /***
     * 查询RepContent全部数据
     * @return
     */
    @GetMapping
    public Result<List<RepContent>> findAll(){
        //调用RepContentService实现查询所有RepContent
        List<RepContent> list = repContentService.findAll();
        return new Result<List<RepContent>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
