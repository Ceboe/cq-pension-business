package com.cqp.service.api;

import com.cqp.model.VisitRecord;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:VisitRecord业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface VisitRecordService {

    /***
     * VisitRecord多条件分页查询
     * @param visitRecord
     * @param page
     * @param size
     * @return
     */
    PageInfo<VisitRecord> findPage(VisitRecord visitRecord, int page, int size);

    /***
     * VisitRecord分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<VisitRecord> findPage(int page, int size);

    /***
     * VisitRecord多条件搜索方法
     * @param visitRecord
     * @return
     */
    List<VisitRecord> findList(VisitRecord visitRecord);

    /***
     * 删除VisitRecord
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改VisitRecord数据
     * @param visitRecord
     */
    int update(VisitRecord visitRecord);

    /***
     * 新增VisitRecord
     * @param visitRecord
     */
    int add(VisitRecord visitRecord);

    /**
     * 根据ID查询VisitRecord
     * @param id
     * @return
     */
     VisitRecord findById(Integer id);

    /***
     * 查询所有VisitRecord
     * @return
     */
    List<VisitRecord> findAll();
}
