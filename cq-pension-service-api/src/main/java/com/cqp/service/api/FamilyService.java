package com.cqp.service.api;


import com.cqp.model.Family;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Family业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FamilyService {

    /***
     * Family多条件分页查询
     * @param family
     * @param page
     * @param size
     * @return
     */
    PageInfo<Family> findPage(Family family, int page, int size);

    /***
     * Family分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Family> findPage(int page, int size);

    /***
     * Family多条件搜索方法
     * @param family
     * @return
     */
    List<Family> findList(Family family);

    /***
     * 删除Family
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Family数据
     * @param family
     */
    void update(Family family);

    /***
     * 新增Family
     * @param family
     */
    void add(Family family);

    /**
     * 根据ID查询Family
     * @param id
     * @return
     */
     Family findById(Integer id);

    /***
     * 查询所有Family
     * @return
     */
    List<Family> findAll();
}
