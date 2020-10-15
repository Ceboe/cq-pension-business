package com.cqp.controller;

import com.cqp.model.Room;
import com.cqp.service.api.RoomService;
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
@RequestMapping("/room")
@CrossOrigin
public class RoomController {

    @Autowired
    private RoomService roomService;

    /***
     * Room分页条件搜索实现
     * @param room
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Room room, @PathVariable  int page, @PathVariable  int size){
        //调用RoomService实现分页条件查询Room
        PageInfo<Room> pageInfo = roomService.findPage(room, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Room分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RoomService实现分页查询Room
        PageInfo<Room> pageInfo = roomService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param room
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Room>> findList(@RequestBody(required = false) Room room){
        //调用RoomService实现条件查询Room
        List<Room> list = roomService.findList(room);
        return new Result<List<Room>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用RoomService实现根据主键删除
        roomService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Room数据
     * @param room
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Room room, @PathVariable Integer id){
        //设置主键值
        room.setRoomId(id);
        //调用RoomService实现修改Room
        roomService.update(room);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Room数据
     * @param room
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Room room){
        //调用RoomService实现添加Room
        roomService.add(room);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Room数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Room> findById(@PathVariable Integer id){
        //调用RoomService实现根据主键查询Room
        Room room = roomService.findById(id);
        return new Result<Room>(true,StatusCode.OK,"查询成功",room);
    }

    /***
     * 查询Room全部数据
     * @return
     */
    @GetMapping("/findAll")
    public Result<List<Room>> findAll(){
        //调用RoomService实现查询所有Room
        List<Room> list = roomService.findAll();
        return new Result<List<Room>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
