package com.cqp.controller;

import com.cqp.model.UseRecord;
import com.cqp.service.api.UseRecordService;
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
@RequestMapping("/useRecord")
@CrossOrigin
public class UseRecordController {

    @Autowired
    private UseRecordService useRecordService;

    /***
     * UseRecord分页条件搜索实现
     * @param useRecord
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) UseRecord useRecord, @PathVariable  int page, @PathVariable  int size){
        //调用UseRecordService实现分页条件查询UseRecord
        PageInfo<UseRecord> pageInfo = useRecordService.findPage(useRecord, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * UseRecord分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UseRecordService实现分页查询UseRecord
        PageInfo<UseRecord> pageInfo = useRecordService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param useRecord
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<UseRecord>> findList(@RequestBody(required = false) UseRecord useRecord){
        //调用UseRecordService实现条件查询UseRecord
        List<UseRecord> list = useRecordService.findList(useRecord);
        return new Result<List<UseRecord>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用UseRecordService实现根据主键删除
        useRecordService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改UseRecord数据
     * @param useRecord
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody UseRecord useRecord, @PathVariable Integer id){
        //设置主键值
        useRecord.setUrId(id);
        //调用UseRecordService实现修改UseRecord
        useRecordService.update(useRecord);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增UseRecord数据
     * @param useRecord
     * @return
     */
    @PostMapping
    public Result add(@RequestBody UseRecord useRecord){
        //调用UseRecordService实现添加UseRecord
        useRecordService.add(useRecord);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询UseRecord数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<UseRecord> findById(@PathVariable Integer id){
        //调用UseRecordService实现根据主键查询UseRecord
        UseRecord useRecord = useRecordService.findById(id);
        return new Result<UseRecord>(true,StatusCode.OK,"查询成功",useRecord);
    }

    /***
     * 查询UseRecord全部数据
     * @return
     */
    @GetMapping
    public Result<List<UseRecord>> findAll(){
        //调用UseRecordService实现查询所有UseRecord
        List<UseRecord> list = useRecordService.findAll();
        return new Result<List<UseRecord>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
