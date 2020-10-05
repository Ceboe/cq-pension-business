package com.cqp.service.provider;

import com.cqp.mapper.HealAssMapper;
import com.cqp.model.HealAss;
import com.cqp.service.api.HealAssService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:HealAss业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class HealAssServiceImpl implements HealAssService {

    @Autowired
    private HealAssMapper healAssMapper;


    /**
     * HealAss条件+分页查询
     * @param healAss 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<HealAss> findPage(HealAss healAss, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(healAss);
        //执行搜索
        return new PageInfo<HealAss>(healAssMapper.selectByExample(example));
    }

    /**
     * HealAss分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<HealAss> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<HealAss>(healAssMapper.selectAll());
    }

    /**
     * HealAss条件查询
     * @param healAss
     * @return
     */
    @Override
    public List<HealAss> findList(HealAss healAss){
        //构建查询条件
        Example example = createExample(healAss);
        //根据构建的条件查询数据
        return healAssMapper.selectByExample(example);
    }


    /**
     * HealAss构建查询对象
     * @param healAss
     * @return
     */
    public Example createExample(HealAss healAss){
        Example example=new Example(HealAss.class);
        Example.Criteria criteria = example.createCriteria();
        if(healAss!=null){
            // id
            if(!StringUtils.isEmpty(healAss.getHaId())){
                    criteria.andEqualTo("ha-id",healAss.getHaId());
            }
            // 老人id
            if(!StringUtils.isEmpty(healAss.getOpId())){
                    criteria.andEqualTo("opId",healAss.getOpId());
            }
            // 评估单号
            if(!StringUtils.isEmpty(healAss.getHaNum())){
                    criteria.andEqualTo("haNum",healAss.getHaNum());
            }
            // 评估类型
            if(!StringUtils.isEmpty(healAss.getHaType())){
                    criteria.andEqualTo("haType",healAss.getHaType());
            }
            // 评估时间
            if(!StringUtils.isEmpty(healAss.getHaTime())){
                    criteria.andEqualTo("haTime",healAss.getHaTime());
            }
            // 建议护理级别
            if(!StringUtils.isEmpty(healAss.getHaLevel())){
                    criteria.andEqualTo("haLevel",healAss.getHaLevel());
            }
            // 入住评估
            if(!StringUtils.isEmpty(healAss.getLiveAss())){
                    criteria.andEqualTo("liveAss",healAss.getLiveAss());
            }
            // 评估人
            if(!StringUtils.isEmpty(healAss.getHaPerson())){
                    criteria.andEqualTo("haPerson",healAss.getHaPerson());
            }
            // 视力障碍
            if(!StringUtils.isEmpty(healAss.getHaEye())){
                    criteria.andEqualTo("haEye",healAss.getHaEye());
            }
            // 听力障碍
            if(!StringUtils.isEmpty(healAss.getHaEar())){
                    criteria.andEqualTo("haEar",healAss.getHaEar());
            }
            // 精神状态
            if(!StringUtils.isEmpty(healAss.getHaMood())){
                    criteria.andEqualTo("haMood",healAss.getHaMood());
            }
            // 行动能力
            if(!StringUtils.isEmpty(healAss.getHaMove())){
                    criteria.andEqualTo("haMove",healAss.getHaMove());
            }
            // 交流能力
            if(!StringUtils.isEmpty(healAss.getHaTalk())){
                    criteria.andEqualTo("haTalk",healAss.getHaTalk());
            }
            // 肢体能力
            if(!StringUtils.isEmpty(healAss.getHaLimbs())){
                    criteria.andEqualTo("haLimbs",healAss.getHaLimbs());
            }
            // 日常生活能力
            if(!StringUtils.isEmpty(healAss.getHaDaily())){
                    criteria.andEqualTo("haDaily",healAss.getHaDaily());
            }
            // 饮食障碍
            if(!StringUtils.isEmpty(healAss.getHaEat())){
                    criteria.andEqualTo("haEat",healAss.getHaEat());
            }
            // 药物过敏
            if(!StringUtils.isEmpty(healAss.getHaMed())){
                    criteria.andEqualTo("haMed",healAss.getHaMed());
            }
            // 记录人
            if(!StringUtils.isEmpty(healAss.getHaRec())){
                    criteria.andEqualTo("haRec",healAss.getHaRec());
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
        healAssMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改HealAss
     * @param healAss
     */
    @Override
    public void update(HealAss healAss){
        healAssMapper.updateByPrimaryKey(healAss);
    }

    /**
     * 增加HealAss
     * @param healAss
     */
    @Override
    public void add(HealAss healAss){
        healAssMapper.insert(healAss);
    }

    /**
     * 根据ID查询HealAss
     * @param id
     * @return
     */
    @Override
    public HealAss findById(Integer id){
        return  healAssMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询HealAss全部数据
     * @return
     */
    @Override
    public List<HealAss> findAll() {
        return healAssMapper.selectAll();
    }
}
