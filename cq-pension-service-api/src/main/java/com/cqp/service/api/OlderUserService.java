package com.cqp.service.api;

import com.cqp.model.OlderUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:OlderUser业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface OlderUserService {

    /***
     * OlderUser多条件分页查询
     * @param olderUser
     * @param page
     * @param size
     * @return
     */
    PageInfo<OlderUser> findPage(OlderUser olderUser, int page, int size);

    /***
     * OlderUser分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OlderUser> findPage(int page, int size);

    /***
     * OlderUser多条件搜索方法
     * @param olderUser
     * @return
     */
    List<OlderUser> findList(OlderUser olderUser);

    /***
     * 删除OlderUser
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改OlderUser数据
     * @param olderUser
     */
    void update(OlderUser olderUser);

    /***
     * 新增OlderUser
     * @param olderUser
     */
    void add(OlderUser olderUser);

    /**
     * 根据ID查询OlderUser
     * @param id
     * @return
     */
     OlderUser findById(Integer id);

    /***
     * 查询所有OlderUser
     * @return
     */
    List<OlderUser> findAll();
}
