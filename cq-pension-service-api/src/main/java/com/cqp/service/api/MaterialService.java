package com.cqp.service.api;

import com.cqp.model.Material;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Material业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface MaterialService {

    /***
     * Material多条件分页查询
     * @param material
     * @param page
     * @param size
     * @return
     */
    PageInfo<Material> findPage(Material material, int page, int size);

    /***
     * Material分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Material> findPage(int page, int size);

    /***
     * Material多条件搜索方法
     * @param material
     * @return
     */
    List<Material> findList(Material material);

    /***
     * 删除Material
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Material数据
     * @param material
     */
    void update(Material material);

    /***
     * 新增Material
     * @param material
     */
    void add(Material material);

    /**
     * 根据ID查询Material
     * @param id
     * @return
     */
     Material findById(Integer id);

    /***
     * 查询所有Material
     * @return
     */
    List<Material> findAll();
}
