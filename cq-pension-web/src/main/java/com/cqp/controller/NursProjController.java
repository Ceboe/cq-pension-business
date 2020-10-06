package com.cqp.controller;

import com.cqp.model.NursProj;
import com.cqp.service.api.NursProjService;
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
@RequestMapping("/nursProj")
@CrossOrigin
public class NursProjController {

    @Autowired
    private NursProjService nursProjService;

    /***
     * NursProj分页条件搜索实现
     * @param nursProj
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) NursProj nursProj, @PathVariable  int page, @PathVariable  int size){
        //调用NursProjService实现分页条件查询NursProj
        PageInfo<NursProj> pageInfo = nursProjService.findPage(nursProj, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * NursProj分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用NursProjService实现分页查询NursProj
        PageInfo<NursProj> pageInfo = nursProjService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param nursProj
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<NursProj>> findList(@RequestBody(required = false) NursProj nursProj){
        //调用NursProjService实现条件查询NursProj
        List<NursProj> list = nursProjService.findList(nursProj);
        return new Result<List<NursProj>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用NursProjService实现根据主键删除
        nursProjService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改NursProj数据
     * @param nursProj
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody NursProj nursProj, @PathVariable Integer id){
        //设置主键值
        nursProj.setNpId(id);
        //调用NursProjService实现修改NursProj
        nursProjService.update(nursProj);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增NursProj数据
     * @param nursProj
     * @return
     */
    @PostMapping
    public Result add(@RequestBody NursProj nursProj){
        //调用NursProjService实现添加NursProj
        nursProjService.add(nursProj);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询NursProj数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<NursProj> findById(@PathVariable Integer id){
        //调用NursProjService实现根据主键查询NursProj
        NursProj nursProj = nursProjService.findById(id);
        return new Result<NursProj>(true,StatusCode.OK,"查询成功",nursProj);
    }

    /***
     * 查询NursProj全部数据
     * @return
     */
    @GetMapping
    public Result<List<NursProj>> findAll(){
        //调用NursProjService实现查询所有NursProj
        List<NursProj> list = nursProjService.findAll();
        return new Result<List<NursProj>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
