package com.cqp.service.api;

import com.cqp.model.NursPlan;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:NursPlan业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface NursPlanService {

    /***
     * NursPlan多条件分页查询
     * @param nursPlan
     * @param page
     * @param size
     * @return
     */
    PageInfo<NursPlan> findPage(NursPlan nursPlan, int page, int size);

    /***
     * NursPlan分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<NursPlan> findPage(int page, int size);

    /***
     * NursPlan多条件搜索方法
     * @param nursPlan
     * @return
     */
    List<NursPlan> findList(NursPlan nursPlan);

    /***
     * 删除NursPlan
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改NursPlan数据
     * @param nursPlan
     */
    void update(NursPlan nursPlan);

    /***
     * 新增NursPlan
     * @param nursPlan
     */
    void add(NursPlan nursPlan);

    /**
     * 根据ID查询NursPlan
     * @param id
     * @return
     */
     NursPlan findById(Integer id);

    /***
     * 查询所有NursPlan
     * @return
     */
    List<NursPlan> findAll();
}
