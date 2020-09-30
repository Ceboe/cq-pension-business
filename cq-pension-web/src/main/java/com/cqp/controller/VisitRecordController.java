package com.cqp.controller;

import com.cqp.model.VisitRecord;
import com.cqp.service.api.VisitRecordService;
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
@RequestMapping("/visitRecord")
@CrossOrigin
public class VisitRecordController {

    @Autowired
    private VisitRecordService visitRecordService;

    /***
     * VisitRecord分页条件搜索实现
     * @param visitRecord
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) VisitRecord visitRecord, @PathVariable  int page, @PathVariable  int size){
        //调用VisitRecordService实现分页条件查询VisitRecord
        PageInfo<VisitRecord> pageInfo = visitRecordService.findPage(visitRecord, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * VisitRecord分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用VisitRecordService实现分页查询VisitRecord
        PageInfo<VisitRecord> pageInfo = visitRecordService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param visitRecord
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<VisitRecord>> findList(@RequestBody(required = false) VisitRecord visitRecord){
        //调用VisitRecordService实现条件查询VisitRecord
        List<VisitRecord> list = visitRecordService.findList(visitRecord);
        return new Result<List<VisitRecord>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用VisitRecordService实现根据主键删除
        visitRecordService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改VisitRecord数据
     * @param visitRecord
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody VisitRecord visitRecord, @PathVariable Integer id){
        //设置主键值
        visitRecord.setVrId(id);
        //调用VisitRecordService实现修改VisitRecord
        visitRecordService.update(visitRecord);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增VisitRecord数据
     * @param visitRecord
     * @return
     */
    @PostMapping
    public Result add(@RequestBody VisitRecord visitRecord){
        //调用VisitRecordService实现添加VisitRecord
        visitRecordService.add(visitRecord);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询VisitRecord数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<VisitRecord> findById(@PathVariable Integer id){
        //调用VisitRecordService实现根据主键查询VisitRecord
        VisitRecord visitRecord = visitRecordService.findById(id);
        return new Result<VisitRecord>(true,StatusCode.OK,"查询成功",visitRecord);
    }

    /***
     * 查询VisitRecord全部数据
     * @return
     */
    @GetMapping
    public Result<List<VisitRecord>> findAll(){
        //调用VisitRecordService实现查询所有VisitRecord
        List<VisitRecord> list = visitRecordService.findAll();
        return new Result<List<VisitRecord>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
