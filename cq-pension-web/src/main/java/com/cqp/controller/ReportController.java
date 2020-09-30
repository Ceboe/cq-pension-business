package com.cqp.controller;

import com.cqp.model.Report;
import com.cqp.service.api.ReportService;
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
@RequestMapping("/report")
@CrossOrigin
public class ReportController {

    @Autowired
    private ReportService reportService;

    /***
     * Report分页条件搜索实现
     * @param report
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Report report, @PathVariable  int page, @PathVariable  int size){
        //调用ReportService实现分页条件查询Report
        PageInfo<Report> pageInfo = reportService.findPage(report, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Report分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ReportService实现分页查询Report
        PageInfo<Report> pageInfo = reportService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param report
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Report>> findList(@RequestBody(required = false) Report report){
        //调用ReportService实现条件查询Report
        List<Report> list = reportService.findList(report);
        return new Result<List<Report>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用ReportService实现根据主键删除
        reportService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Report数据
     * @param report
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Report report, @PathVariable Integer id){
        //设置主键值
        report.setRepId(id);
        //调用ReportService实现修改Report
        reportService.update(report);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Report数据
     * @param report
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Report report){
        //调用ReportService实现添加Report
        reportService.add(report);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Report数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Report> findById(@PathVariable Integer id){
        //调用ReportService实现根据主键查询Report
        Report report = reportService.findById(id);
        return new Result<Report>(true,StatusCode.OK,"查询成功",report);
    }

    /***
     * 查询Report全部数据
     * @return
     */
    @GetMapping
    public Result<List<Report>> findAll(){
        //调用ReportService实现查询所有Report
        List<Report> list = reportService.findAll();
        return new Result<List<Report>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
