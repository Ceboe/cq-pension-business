package com.cqp.service.api;

import com.cqp.model.SocialWorkerAct;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:SocialWorkerAct业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SocialWorkerActService {

    /***
     * SocialWorkerAct多条件分页查询
     * @param socialWorkerAct
     * @param page
     * @param size
     * @return
     */
    PageInfo<SocialWorkerAct> findPage(SocialWorkerAct socialWorkerAct, int page, int size);

    /***
     * SocialWorkerAct分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SocialWorkerAct> findPage(int page, int size);

    /***
     * SocialWorkerAct多条件搜索方法
     * @param socialWorkerAct
     * @return
     */
    List<SocialWorkerAct> findList(SocialWorkerAct socialWorkerAct);

    /***
     * 删除SocialWorkerAct
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改SocialWorkerAct数据
     * @param socialWorkerAct
     */
    void update(SocialWorkerAct socialWorkerAct);

    /***
     * 新增SocialWorkerAct
     * @param socialWorkerAct
     */
    void add(SocialWorkerAct socialWorkerAct);

    /**
     * 根据ID查询SocialWorkerAct
     * @param id
     * @return
     */
     SocialWorkerAct findById(Integer id);

    /***
     * 查询所有SocialWorkerAct
     * @return
     */
    List<SocialWorkerAct> findAll();
}
