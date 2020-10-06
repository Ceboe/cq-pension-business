package com.cqp.service.api;

import com.cqp.model.NursRecord;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:NursRecord业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface NursRecordService {

    /***
     * NursRecord多条件分页查询
     * @param nursRecord
     * @param page
     * @param size
     * @return
     */
    PageInfo<NursRecord> findPage(NursRecord nursRecord, int page, int size);

    /***
     * NursRecord分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<NursRecord> findPage(int page, int size);

    /***
     * NursRecord多条件搜索方法
     * @param nursRecord
     * @return
     */
    List<NursRecord> findList(NursRecord nursRecord);

    /***
     * 删除NursRecord
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改NursRecord数据
     * @param nursRecord
     */
    void update(NursRecord nursRecord);

    /***
     * 新增NursRecord
     * @param nursRecord
     */
    void add(NursRecord nursRecord);

    /**
     * 根据ID查询NursRecord
     * @param id
     * @return
     */
     NursRecord findById(Integer id);

    /***
     * 查询所有NursRecord
     * @return
     */
    List<NursRecord> findAll();
}
