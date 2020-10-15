package com.cqp.controller;

import com.cqp.model.Material;
import com.cqp.service.api.MaterialService;
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
@RequestMapping("/material")
@CrossOrigin
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    /***
     * Material分页条件搜索实现
     * @param material
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Material material, @PathVariable  int page, @PathVariable  int size){
        //调用MaterialService实现分页条件查询Material
        PageInfo<Material> pageInfo = materialService.findPage(material, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Material分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用MaterialService实现分页查询Material
        PageInfo<Material> pageInfo = materialService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param material
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Material>> findList(@RequestBody(required = false) Material material){
        //调用MaterialService实现条件查询Material
        List<Material> list = materialService.findList(material);
        return new Result<List<Material>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用MaterialService实现根据主键删除
        materialService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Material数据
     * @param material
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Material material, @PathVariable Integer id){
        //设置主键值
        material.setMId(id);
        //调用MaterialService实现修改Material
        materialService.update(material);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Material数据
     * @param material
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Material material){
        //调用MaterialService实现添加Material
        materialService.add(material);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Material数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Material> findById(@PathVariable Integer id){
        //调用MaterialService实现根据主键查询Material
        Material material = materialService.findById(id);
        return new Result<Material>(true,StatusCode.OK,"查询成功",material);
    }

    /***
     * 查询Material全部数据
     * @return
     */
    @GetMapping
    public Result<List<Material>> findAll(){
        //调用MaterialService实现查询所有Material
        List<Material> list = materialService.findAll();
        return new Result<List<Material>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
