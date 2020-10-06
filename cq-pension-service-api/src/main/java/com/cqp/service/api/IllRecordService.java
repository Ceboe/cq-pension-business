package com.cqp.service.api;

import com.cqp.model.IllRecord;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:IllRecord业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface IllRecordService {

    /***
     * IllRecord多条件分页查询
     * @param illRecord
     * @param page
     * @param size
     * @return
     */
    PageInfo<IllRecord> findPage(IllRecord illRecord, int page, int size);

    /***
     * IllRecord分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<IllRecord> findPage(int page, int size);

    /***
     * IllRecord多条件搜索方法
     * @param illRecord
     * @return
     */
    List<IllRecord> findList(IllRecord illRecord);

    /***
     * 删除IllRecord
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改IllRecord数据
     * @param illRecord
     */
    void update(IllRecord illRecord);

    /***
     * 新增IllRecord
     * @param illRecord
     */
    void add(IllRecord illRecord);

    /**
     * 根据ID查询IllRecord
     * @param id
     * @return
     */
     IllRecord findById(Integer id);

    /***
     * 查询所有IllRecord
     * @return
     */
    List<IllRecord> findAll();
}
