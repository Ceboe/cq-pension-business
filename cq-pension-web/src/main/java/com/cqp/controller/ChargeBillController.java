package com.cqp.controller;

import com.cqp.model.ChargeBill;
import com.cqp.service.api.ChargeBillService;
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
@RequestMapping("/chargeBill")
@CrossOrigin
public class ChargeBillController {

    @Autowired
    private ChargeBillService chargeBillService;

    /***
     * ChargeBill分页条件搜索实现
     * @param chargeBill
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) ChargeBill chargeBill, @PathVariable  int page, @PathVariable  int size){
        //调用ChargeBillService实现分页条件查询ChargeBill
        PageInfo<ChargeBill> pageInfo = chargeBillService.findPage(chargeBill, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }
    /***
     * ChargeBill分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ChargeBillService实现分页查询ChargeBill
        PageInfo<ChargeBill> pageInfo = chargeBillService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param chargeBill
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<ChargeBill>> findList(@RequestBody(required = false) ChargeBill chargeBill){
        //调用ChargeBillService实现条件查询ChargeBill
        List<ChargeBill> list = chargeBillService.findList(chargeBill);
        return new Result<List<ChargeBill>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用ChargeBillService实现根据主键删除
        int result = chargeBillService.delete(id);
        if(result>=1)
        return new Result(true,StatusCode.OK,"删除成功");
        else return new Result(true,StatusCode.ERROR,"删除失败");
    }

    /***
     * 修改ChargeBill数据
     * @param chargeBill
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody ChargeBill chargeBill, @PathVariable Integer id){
        //设置主键值
        chargeBill.setCbId(id);
        //调用ChargeBillService实现修改ChargeBill
        chargeBillService.update(chargeBill);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ChargeBill数据
     * @param chargeBill
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ChargeBill chargeBill){
        //调用ChargeBillService实现添加ChargeBill
        chargeBillService.add(chargeBill);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ChargeBill数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<ChargeBill> findById(@PathVariable Integer id){
        //调用ChargeBillService实现根据主键查询ChargeBill
        ChargeBill chargeBill = chargeBillService.findById(id);
        return new Result<ChargeBill>(true,StatusCode.OK,"查询成功",chargeBill);
    }

    /***
     * 查询ChargeBill全部数据
     * @return
     */
    @GetMapping("/findAll")
    public Result<List<ChargeBill>> findAll(){
        //调用ChargeBillService实现查询所有ChargeBill
        List<ChargeBill> list = chargeBillService.findAll();
        return new Result<List<ChargeBill>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
