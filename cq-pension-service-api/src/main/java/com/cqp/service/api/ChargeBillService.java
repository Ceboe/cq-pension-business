package com.cqp.service.api;

import com.cqp.model.ChargeBill;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:ChargeBill业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ChargeBillService {

    /***
     * ChargeBill多条件分页查询
     * @param chargeBill
     * @param page
     * @param size
     * @return
     */
    PageInfo<ChargeBill> findPage(ChargeBill chargeBill, int page, int size);

    /***
     * ChargeBill分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ChargeBill> findPage(int page, int size);

    /***
     * ChargeBill多条件搜索方法
     * @param chargeBill
     * @return
     */
    List<ChargeBill> findList(ChargeBill chargeBill);

    /***
     * 删除ChargeBill
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改ChargeBill数据
     * @param chargeBill
     */
    int update(ChargeBill chargeBill);

    /***
     * 新增ChargeBill
     * @param chargeBill
     */
    int add(ChargeBill chargeBill);

    /**
     * 根据ID查询ChargeBill
     * @param id
     * @return
     */
     ChargeBill findById(Integer id);

    /***
     * 查询所有ChargeBill
     * @return
     */
    List<ChargeBill> findAll();
}
