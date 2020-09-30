package com.cqp.controller;

import com.cqp.model.DutyRecord;
import com.cqp.service.api.DutyRecordService;
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
@RequestMapping("/dutyRecord")
@CrossOrigin
public class DutyRecordController {

    @Autowired
    private DutyRecordService dutyRecordService;

    /***
     * DutyRecord分页条件搜索实现
     * @param dutyRecord
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) DutyRecord dutyRecord, @PathVariable  int page, @PathVariable  int size){
        //调用DutyRecordService实现分页条件查询DutyRecord
        PageInfo<DutyRecord> pageInfo = dutyRecordService.findPage(dutyRecord, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * DutyRecord分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用DutyRecordService实现分页查询DutyRecord
        PageInfo<DutyRecord> pageInfo = dutyRecordService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param dutyRecord
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<DutyRecord>> findList(@RequestBody(required = false) DutyRecord dutyRecord){
        //调用DutyRecordService实现条件查询DutyRecord
        List<DutyRecord> list = dutyRecordService.findList(dutyRecord);
        return new Result<List<DutyRecord>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用DutyRecordService实现根据主键删除
        dutyRecordService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改DutyRecord数据
     * @param dutyRecord
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody DutyRecord dutyRecord, @PathVariable Integer id){
        //设置主键值
        dutyRecord.setDrId(id);
        //调用DutyRecordService实现修改DutyRecord
        dutyRecordService.update(dutyRecord);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增DutyRecord数据
     * @param dutyRecord
     * @return
     */
    @PostMapping
    public Result add(@RequestBody DutyRecord dutyRecord){
        //调用DutyRecordService实现添加DutyRecord
        dutyRecordService.add(dutyRecord);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询DutyRecord数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<DutyRecord> findById(@PathVariable Integer id){
        //调用DutyRecordService实现根据主键查询DutyRecord
        DutyRecord dutyRecord = dutyRecordService.findById(id);
        return new Result<DutyRecord>(true,StatusCode.OK,"查询成功",dutyRecord);
    }

    /***
     * 查询DutyRecord全部数据
     * @return
     */
    @GetMapping
    public Result<List<DutyRecord>> findAll(){
        //调用DutyRecordService实现查询所有DutyRecord
        List<DutyRecord> list = dutyRecordService.findAll();
        return new Result<List<DutyRecord>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
