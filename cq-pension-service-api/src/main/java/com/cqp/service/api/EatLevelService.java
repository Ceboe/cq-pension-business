package com.cqp.service.api;

import com.cqp.model.EatLevel;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:EatLevel业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface EatLevelService {

    /***
     * EatLevel多条件分页查询
     * @param eatLevel
     * @param page
     * @param size
     * @return
     */
    PageInfo<EatLevel> findPage(EatLevel eatLevel, int page, int size);

    /***
     * EatLevel分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<EatLevel> findPage(int page, int size);

    /***
     * EatLevel多条件搜索方法
     * @param eatLevel
     * @return
     */
    List<EatLevel> findList(EatLevel eatLevel);

    /***
     * 删除EatLevel
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改EatLevel数据
     * @param eatLevel
     */
    int update(EatLevel eatLevel);

    /***
     * 新增EatLevel
     * @param eatLevel
     */
    int add(EatLevel eatLevel);

    /**
     * 根据ID查询EatLevel
     * @param id
     * @return
     */
     EatLevel findById(Integer id);

    /***
     * 查询所有EatLevel
     * @return
     */
    List<EatLevel> findAll();
}
