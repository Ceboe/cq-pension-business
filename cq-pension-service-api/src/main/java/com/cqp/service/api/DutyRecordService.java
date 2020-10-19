package com.cqp.service.api;

import com.cqp.model.DutyRecord;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:DutyRecord业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface DutyRecordService {

    /***
     * DutyRecord多条件分页查询
     * @param dutyRecord
     * @param page
     * @param size
     * @return
     */
    PageInfo<DutyRecord> findPage(DutyRecord dutyRecord, int page, int size);

    /***
     * DutyRecord分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<DutyRecord> findPage(int page, int size);

    /***
     * DutyRecord多条件搜索方法
     * @param dutyRecord
     * @return
     */
    List<DutyRecord> findList(DutyRecord dutyRecord);

    /***
     * 删除DutyRecord
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改DutyRecord数据
     * @param dutyRecord
     */
    int update(DutyRecord dutyRecord);

    /***
     * 新增DutyRecord
     * @param dutyRecord
     */
    int add(DutyRecord dutyRecord);

    /**
     * 根据ID查询DutyRecord
     * @param id
     * @return
     */
     DutyRecord findById(Integer id);

    /***
     * 查询所有DutyRecord
     * @return
     */
    List<DutyRecord> findAll();
}
