package com.cqp.service.api;

import com.cqp.model.PriceEat;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:PriceEat业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PriceEatService {

    /***
     * PriceEat多条件分页查询
     * @param priceEat
     * @param page
     * @param size
     * @return
     */
    PageInfo<PriceEat> findPage(PriceEat priceEat, int page, int size);

    /***
     * PriceEat分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PriceEat> findPage(int page, int size);

    /***
     * PriceEat多条件搜索方法
     * @param priceEat
     * @return
     */
    List<PriceEat> findList(PriceEat priceEat);

    /***
     * 删除PriceEat
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改PriceEat数据
     * @param priceEat
     */
    int update(PriceEat priceEat);

    /***
     * 新增PriceEat
     * @param priceEat
     */
    int add(PriceEat priceEat);

    /**
     * 根据ID查询PriceEat
     * @param id
     * @return
     */
     PriceEat findById(Integer id);

    /***
     * 查询所有PriceEat
     * @return
     */
    List<PriceEat> findAll();
}
