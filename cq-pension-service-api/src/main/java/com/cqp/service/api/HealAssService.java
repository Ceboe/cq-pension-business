package com.cqp.service.api;


import com.cqp.model.HealAss;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:HealAss业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface HealAssService {

    /***
     * HealAss多条件分页查询
     * @param healAss
     * @param page
     * @param size
     * @return
     */
    PageInfo<HealAss> findPage(HealAss healAss, int page, int size);

    /***
     * HealAss分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<HealAss> findPage(int page, int size);

    /***
     * HealAss多条件搜索方法
     * @param healAss
     * @return
     */
    List<HealAss> findList(HealAss healAss);

    /***
     * 删除HealAss
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改HealAss数据
     * @param healAss
     */
    void update(HealAss healAss);

    /***
     * 新增HealAss
     * @param healAss
     */
    void add(HealAss healAss);

    /**
     * 根据ID查询HealAss
     * @param id
     * @return
     */
     HealAss findById(Integer id);

    /***
     * 查询所有HealAss
     * @return
     */
    List<HealAss> findAll();
}
