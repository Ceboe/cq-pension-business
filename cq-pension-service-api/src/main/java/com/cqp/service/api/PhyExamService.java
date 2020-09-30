package com.cqp.service.api;


import com.cqp.model.PhyExam;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:PhyExam业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PhyExamService {

    /***
     * PhyExam多条件分页查询
     * @param phyExam
     * @param page
     * @param size
     * @return
     */
    PageInfo<PhyExam> findPage(PhyExam phyExam, int page, int size);

    /***
     * PhyExam分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PhyExam> findPage(int page, int size);

    /***
     * PhyExam多条件搜索方法
     * @param phyExam
     * @return
     */
    List<PhyExam> findList(PhyExam phyExam);

    /***
     * 删除PhyExam
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改PhyExam数据
     * @param phyExam
     */
    void update(PhyExam phyExam);

    /***
     * 新增PhyExam
     * @param phyExam
     */
    void add(PhyExam phyExam);

    /**
     * 根据ID查询PhyExam
     * @param id
     * @return
     */
     PhyExam findById(Integer id);

    /***
     * 查询所有PhyExam
     * @return
     */
    List<PhyExam> findAll();
}
