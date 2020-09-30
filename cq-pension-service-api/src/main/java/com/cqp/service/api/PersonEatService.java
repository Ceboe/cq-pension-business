package com.cqp.service.api;


import com.cqp.model.PersonEat;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:PersonEat业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PersonEatService {

    /***
     * PersonEat多条件分页查询
     * @param personEat
     * @param page
     * @param size
     * @return
     */
    PageInfo<PersonEat> findPage(PersonEat personEat, int page, int size);

    /***
     * PersonEat分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PersonEat> findPage(int page, int size);

    /***
     * PersonEat多条件搜索方法
     * @param personEat
     * @return
     */
    List<PersonEat> findList(PersonEat personEat);

    /***
     * 删除PersonEat
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改PersonEat数据
     * @param personEat
     */
    void update(PersonEat personEat);

    /***
     * 新增PersonEat
     * @param personEat
     */
    void add(PersonEat personEat);

    /**
     * 根据ID查询PersonEat
     * @param id
     * @return
     */
     PersonEat findById(Integer id);

    /***
     * 查询所有PersonEat
     * @return
     */
    List<PersonEat> findAll();
}
