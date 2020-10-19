package com.cqp.service.api;

import com.cqp.model.BedRepl;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:BedRepl业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface BedReplService {

    /***
     * BedRepl多条件分页查询
     * @param bedRepl
     * @param page
     * @param size
     * @return
     */
    PageInfo<BedRepl> findPage(BedRepl bedRepl, int page, int size);

    /***
     * BedRepl分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<BedRepl> findPage(int page, int size);

    /***
     * BedRepl多条件搜索方法
     * @param bedRepl
     * @return
     */
    List<BedRepl> findList(BedRepl bedRepl);

    /***
     * 删除BedRepl
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改BedRepl数据
     * @param bedRepl
     */
    int update(BedRepl bedRepl);

    /***
     * 新增BedRepl
     * @param bedRepl
     */
    int add(BedRepl bedRepl);

    /**
     * 根据ID查询BedRepl
     * @param id
     * @return
     */
     BedRepl findById(Integer id);

    /***
     * 查询所有BedRepl
     * @return
     */
    List<BedRepl> findAll();
}
