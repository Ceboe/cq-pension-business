package com.cqp.service.api;

import com.cqp.model.EatCons;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:EatCons业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface EatConsService {

    /***
     * EatCons多条件分页查询
     * @param eatCons
     * @param page
     * @param size
     * @return
     */
    PageInfo<EatCons> findPage(EatCons eatCons, int page, int size);

    /***
     * EatCons分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<EatCons> findPage(int page, int size);

    /***
     * EatCons多条件搜索方法
     * @param eatCons
     * @return
     */
    List<EatCons> findList(EatCons eatCons);

    /***
     * 删除EatCons
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改EatCons数据
     * @param eatCons
     */
    void update(EatCons eatCons);

    /***
     * 新增EatCons
     * @param eatCons
     */
    void add(EatCons eatCons);

    /**
     * 根据ID查询EatCons
     * @param id
     * @return
     */
     EatCons findById(Integer id);

    /***
     * 查询所有EatCons
     * @return
     */
    List<EatCons> findAll();
}
