package com.cqp.service.provider;

import com.cqp.mapper.MaterialMapper;
import com.cqp.model.Material;
import com.cqp.service.api.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Material业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;


    /**
     * Material条件+分页查询
     * @param material 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Material> findPage(Material material, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(material);
        //执行搜索
        return new PageInfo<Material>(materialMapper.selectByExample(example));
    }

    /**
     * Material分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Material> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Material>(materialMapper.selectAll());
    }

    /**
     * Material条件查询
     * @param material
     * @return
     */
    @Override
    public List<Material> findList(Material material){
        //构建查询条件
        Example example = createExample(material);
        //根据构建的条件查询数据
        return materialMapper.selectByExample(example);
    }


    /**
     * Material构建查询对象
     * @param material
     * @return
     */
    public Example createExample(Material material){
        Example example=new Example(Material.class);
        Example.Criteria criteria = example.createCriteria();
        if(material!=null){
            // 物资编号
            if(!StringUtils.isEmpty(material.getMId())){
                    criteria.andEqualTo("mId",material.getMId());
            }
            // 物资号
            if(!StringUtils.isEmpty(material.getMName())){
                    criteria.andEqualTo("mName",material.getMName());
            }
            // 说明
            if(!StringUtils.isEmpty(material.getMDescrip())){
                    criteria.andEqualTo("mDescrip",material.getMDescrip());
            }
            // 价格
            if(!StringUtils.isEmpty(material.getMPrice())){
                    criteria.andEqualTo("mPrice",material.getMPrice());
            }
            // 折旧率
            if(!StringUtils.isEmpty(material.getDeprRate())){
                    criteria.andEqualTo("deprRate",material.getDeprRate());
            }
            // 物品类型
            if(!StringUtils.isEmpty(material.getItemType())){
                    criteria.andEqualTo("itemType",material.getItemType());
            }
            // 现存数量
            if(!StringUtils.isEmpty(material.getStockNum())){
                    criteria.andEqualTo("stockNum",material.getStockNum());
            }
            // 负责人
            if(!StringUtils.isEmpty(material.getCharge())){
                    criteria.andEqualTo("charge",material.getCharge());
            }
            // 记录人
            if(!StringUtils.isEmpty(material.getNoteTaker())){
                    criteria.andEqualTo("noteTaker",material.getNoteTaker());
            }
            // 备注
            if(!StringUtils.isEmpty(material.getRemark())){
                    criteria.andEqualTo("remark",material.getRemark());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        materialMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Material
     * @param material
     */
    @Override
    public void update(Material material){
        materialMapper.updateByPrimaryKey(material);
    }

    /**
     * 增加Material
     * @param material
     */
    @Override
    public void add(Material material){
        materialMapper.insert(material);
    }

    /**
     * 根据ID查询Material
     * @param id
     * @return
     */
    @Override
    public Material findById(Integer id){
        return  materialMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Material全部数据
     * @return
     */
    @Override
    public List<Material> findAll() {
        return materialMapper.selectAll();
    }
}
