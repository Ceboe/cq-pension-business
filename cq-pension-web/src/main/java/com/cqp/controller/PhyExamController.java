package com.cqp.controller;

import com.cqp.model.PhyExam;
import com.cqp.service.api.PhyExamService;
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
@RequestMapping("/phyExam")
@CrossOrigin
public class PhyExamController {

    @Autowired
    private PhyExamService phyExamService;

    /***
     * PhyExam分页条件搜索实现
     * @param phyExam
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) PhyExam phyExam, @PathVariable  int page, @PathVariable  int size){
        //调用PhyExamService实现分页条件查询PhyExam
        PageInfo<PhyExam> pageInfo = phyExamService.findPage(phyExam, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * PhyExam分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PhyExamService实现分页查询PhyExam
        PageInfo<PhyExam> pageInfo = phyExamService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param phyExam
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<PhyExam>> findList(@RequestBody(required = false) PhyExam phyExam){
        //调用PhyExamService实现条件查询PhyExam
        List<PhyExam> list = phyExamService.findList(phyExam);
        return new Result<List<PhyExam>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用PhyExamService实现根据主键删除
        phyExamService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改PhyExam数据
     * @param phyExam
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody PhyExam phyExam, @PathVariable Integer id){
        //设置主键值
        phyExam.setPeId(id);
        //调用PhyExamService实现修改PhyExam
        phyExamService.update(phyExam);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增PhyExam数据
     * @param phyExam
     * @return
     */
    @PostMapping
    public Result add(@RequestBody PhyExam phyExam){
        //调用PhyExamService实现添加PhyExam
        phyExamService.add(phyExam);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询PhyExam数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<PhyExam> findById(@PathVariable Integer id){
        //调用PhyExamService实现根据主键查询PhyExam
        PhyExam phyExam = phyExamService.findById(id);
        return new Result<PhyExam>(true,StatusCode.OK,"查询成功",phyExam);
    }

    /***
     * 查询PhyExam全部数据
     * @return
     */
    @GetMapping
    public Result<List<PhyExam>> findAll(){
        //调用PhyExamService实现查询所有PhyExam
        List<PhyExam> list = phyExamService.findAll();
        return new Result<List<PhyExam>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
