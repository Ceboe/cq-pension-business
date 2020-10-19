package com.cqp.service.api;

import com.cqp.model.RolePerm;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:RolePerm业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface RolePermService {

    /***
     * RolePerm多条件分页查询
     * @param rolePerm
     * @param page
     * @param size
     * @return
     */
    PageInfo<RolePerm> findPage(RolePerm rolePerm, int page, int size);

    /***
     * RolePerm分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<RolePerm> findPage(int page, int size);

    /***
     * RolePerm多条件搜索方法
     * @param rolePerm
     * @return
     */
    List<RolePerm> findList(RolePerm rolePerm);

    /***
     * 删除RolePerm
     * @param id
     */
    int delete(Integer id);

    /***
     * 修改RolePerm数据
     * @param rolePerm
     */
    int update(RolePerm rolePerm);

    /***
     * 新增RolePerm
     * @param rolePerm
     */
    int add(RolePerm rolePerm);

    /**
     * 根据ID查询RolePerm
     * @param id
     * @return
     */
     RolePerm findById(Integer id);

    /***
     * 查询所有RolePerm
     * @return
     */
    List<RolePerm> findAll();
}
