package com.cqp.service.api;

import com.cqp.model.NursProj;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:NursProj业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface NursProjService {

    /***
     * NursProj多条件分页查询
     * @param nursProj
     * @param page
     * @param size
     * @return
     */
    PageInfo<NursProj> findPage(NursProj nursProj, int page, int size);

    /***
     * NursProj分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<NursProj> findPage(int page, int size);

    /***
     * NursProj多条件搜索方法
     * @param nursProj
     * @return
     */
    List<NursProj> findList(NursProj nursProj);

    /***
     * 删除NursProj
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改NursProj数据
     * @param nursProj
     */
    int update(NursProj nursProj);

    /***
     * 新增NursProj
     * @param nursProj
     */
    int add(NursProj nursProj);

    /**
     * 根据ID查询NursProj
     * @param id
     * @return
     */
     NursProj findById(Integer id);

    /***
     * 查询所有NursProj
     * @return
     */
    List<NursProj> findAll();
}
