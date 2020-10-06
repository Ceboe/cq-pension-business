package com.cqp.service.api;

import com.cqp.model.UseRecord;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:UseRecord业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface UseRecordService {

    /***
     * UseRecord多条件分页查询
     * @param useRecord
     * @param page
     * @param size
     * @return
     */
    PageInfo<UseRecord> findPage(UseRecord useRecord, int page, int size);

    /***
     * UseRecord分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UseRecord> findPage(int page, int size);

    /***
     * UseRecord多条件搜索方法
     * @param useRecord
     * @return
     */
    List<UseRecord> findList(UseRecord useRecord);

    /***
     * 删除UseRecord
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改UseRecord数据
     * @param useRecord
     */
    void update(UseRecord useRecord);

    /***
     * 新增UseRecord
     * @param useRecord
     */
    void add(UseRecord useRecord);

    /**
     * 根据ID查询UseRecord
     * @param id
     * @return
     */
     UseRecord findById(Integer id);

    /***
     * 查询所有UseRecord
     * @return
     */
    List<UseRecord> findAll();
}
