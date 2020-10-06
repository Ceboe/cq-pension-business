package com.cqp.service.api;

import com.cqp.model.RepContent;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:RepContent业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface RepContentService {

    /***
     * RepContent多条件分页查询
     * @param repContent
     * @param page
     * @param size
     * @return
     */
    PageInfo<RepContent> findPage(RepContent repContent, int page, int size);

    /***
     * RepContent分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<RepContent> findPage(int page, int size);

    /***
     * RepContent多条件搜索方法
     * @param repContent
     * @return
     */
    List<RepContent> findList(RepContent repContent);

    /***
     * 删除RepContent
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改RepContent数据
     * @param repContent
     */
    void update(RepContent repContent);

    /***
     * 新增RepContent
     * @param repContent
     */
    void add(RepContent repContent);

    /**
     * 根据ID查询RepContent
     * @param id
     * @return
     */
     RepContent findById(Integer id);

    /***
     * 查询所有RepContent
     * @return
     */
    List<RepContent> findAll();
}
