package com.cqp.controller;

import com.cqp.model.Refund;
import com.cqp.service.api.RefundService;
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
@RequestMapping("/refund")
@CrossOrigin
public class RefundController {

    @Autowired
    private RefundService refundService;

    /***
     * Refund分页条件搜索实现
     * @param refund
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Refund refund, @PathVariable  int page, @PathVariable  int size){
        //调用RefundService实现分页条件查询Refund
        PageInfo<Refund> pageInfo = refundService.findPage(refund, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Refund分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RefundService实现分页查询Refund
        PageInfo<Refund> pageInfo = refundService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param refund
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Refund>> findList(@RequestBody(required = false) Refund refund){
        //调用RefundService实现条件查询Refund
        List<Refund> list = refundService.findList(refund);
        return new Result<List<Refund>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用RefundService实现根据主键删除
        refundService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Refund数据
     * @param refund
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Refund refund, @PathVariable Integer id){
        //设置主键值
        refund.setReId(id);
        //调用RefundService实现修改Refund
        refundService.update(refund);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Refund数据
     * @param refund
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Refund refund){
        //调用RefundService实现添加Refund
        refundService.add(refund);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Refund数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Refund> findById(@PathVariable Integer id){
        //调用RefundService实现根据主键查询Refund
        Refund refund = refundService.findById(id);
        return new Result<Refund>(true,StatusCode.OK,"查询成功",refund);
    }

    /***
     * 查询Refund全部数据
     * @return
     */
    @GetMapping
    public Result<List<Refund>> findAll(){
        //调用RefundService实现查询所有Refund
        List<Refund> list = refundService.findAll();
        return new Result<List<Refund>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
