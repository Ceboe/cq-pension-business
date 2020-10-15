package com.cqp.controller;

import com.cqp.model.IllRecord;
import com.cqp.service.api.IllRecordService;
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
@RequestMapping("/illRecord")
@CrossOrigin
public class IllRecordController {

    @Autowired
    private IllRecordService illRecordService;

    /***
     * IllRecord分页条件搜索实现
     * @param illRecord
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) IllRecord illRecord, @PathVariable  int page, @PathVariable  int size){
        //调用IllRecordService实现分页条件查询IllRecord
        PageInfo<IllRecord> pageInfo = illRecordService.findPage(illRecord, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * IllRecord分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用IllRecordService实现分页查询IllRecord
        PageInfo<IllRecord> pageInfo = illRecordService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param illRecord
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<IllRecord>> findList(@RequestBody(required = false) IllRecord illRecord){
        //调用IllRecordService实现条件查询IllRecord
        List<IllRecord> list = illRecordService.findList(illRecord);
        return new Result<List<IllRecord>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用IllRecordService实现根据主键删除
        illRecordService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改IllRecord数据
     * @param illRecord
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody IllRecord illRecord, @PathVariable Integer id){
        //设置主键值
        illRecord.setIllId(id);
        //调用IllRecordService实现修改IllRecord
        illRecordService.update(illRecord);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增IllRecord数据
     * @param illRecord
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody IllRecord illRecord){
        //调用IllRecordService实现添加IllRecord
        illRecordService.add(illRecord);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询IllRecord数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<IllRecord> findById(@PathVariable Integer id){
        //调用IllRecordService实现根据主键查询IllRecord
        IllRecord illRecord = illRecordService.findById(id);
        return new Result<IllRecord>(true,StatusCode.OK,"查询成功",illRecord);
    }

    /***
     * 查询IllRecord全部数据
     * @return
     */
    @GetMapping
    public Result<List<IllRecord>> findAll(){
        //调用IllRecordService实现查询所有IllRecord
        List<IllRecord> list = illRecordService.findAll();
        return new Result<List<IllRecord>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
