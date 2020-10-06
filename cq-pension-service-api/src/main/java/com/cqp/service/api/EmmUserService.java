package com.cqp.service.api;

import com.cqp.model.EmmUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:EmmUser业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface EmmUserService {

    /***
     * EmmUser多条件分页查询
     * @param emmUser
     * @param page
     * @param size
     * @return
     */
    PageInfo<EmmUser> findPage(EmmUser emmUser, int page, int size);

    /***
     * EmmUser分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<EmmUser> findPage(int page, int size);

    /***
     * EmmUser多条件搜索方法
     * @param emmUser
     * @return
     */
    List<EmmUser> findList(EmmUser emmUser);

    /***
     * 删除EmmUser
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改EmmUser数据
     * @param emmUser
     */
    void update(EmmUser emmUser);

    /***
     * 新增EmmUser
     * @param emmUser
     */
    void add(EmmUser emmUser);

    /**
     * 根据ID查询EmmUser
     * @param id
     * @return
     */
     EmmUser findById(Integer id);

    /***
     * 查询所有EmmUser
     * @return
     */
    List<EmmUser> findAll();
}
