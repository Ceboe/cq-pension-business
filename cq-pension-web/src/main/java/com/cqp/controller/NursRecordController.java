package com.cqp.controller;

import com.cqp.model.NursRecord;
import com.cqp.service.api.NursRecordService;
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
@RequestMapping("/nursRecord")
@CrossOrigin
public class NursRecordController {

    @Autowired
    private NursRecordService nursRecordService;

    /***
     * NursRecord分页条件搜索实现
     * @param nursRecord
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) NursRecord nursRecord, @PathVariable  int page, @PathVariable  int size){
        //调用NursRecordService实现分页条件查询NursRecord
        PageInfo<NursRecord> pageInfo = nursRecordService.findPage(nursRecord, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * NursRecord分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用NursRecordService实现分页查询NursRecord
        PageInfo<NursRecord> pageInfo = nursRecordService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param nursRecord
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<NursRecord>> findList(@RequestBody(required = false) NursRecord nursRecord){
        //调用NursRecordService实现条件查询NursRecord
        List<NursRecord> list = nursRecordService.findList(nursRecord);
        return new Result<List<NursRecord>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用NursRecordService实现根据主键删除
        nursRecordService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改NursRecord数据
     * @param nursRecord
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody NursRecord nursRecord, @PathVariable Integer id){
        //设置主键值
        nursRecord.setNId(id);
        //调用NursRecordService实现修改NursRecord
        nursRecordService.update(nursRecord);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增NursRecord数据
     * @param nursRecord
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody NursRecord nursRecord){
        //调用NursRecordService实现添加NursRecord
        nursRecordService.add(nursRecord);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询NursRecord数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<NursRecord> findById(@PathVariable Integer id){
        //调用NursRecordService实现根据主键查询NursRecord
        NursRecord nursRecord = nursRecordService.findById(id);
        return new Result<NursRecord>(true,StatusCode.OK,"查询成功",nursRecord);
    }

    /***
     * 查询NursRecord全部数据
     * @return
     */
    @GetMapping
    public Result<List<NursRecord>> findAll(){
        //调用NursRecordService实现查询所有NursRecord
        List<NursRecord> list = nursRecordService.findAll();
        return new Result<List<NursRecord>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
