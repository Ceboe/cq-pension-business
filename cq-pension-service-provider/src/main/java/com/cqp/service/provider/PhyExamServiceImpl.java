package com.cqp.service.provider;

import com.cqp.mapper.PhyExamMapper;
import com.cqp.model.PhyExam;
import com.cqp.service.api.PhyExamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:PhyExam业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PhyExamServiceImpl implements PhyExamService {

    @Autowired
    private PhyExamMapper phyExamMapper;


    /**
     * PhyExam条件+分页查询
     * @param phyExam 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PhyExam> findPage(PhyExam phyExam, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(phyExam);
        //执行搜索
        return new PageInfo<PhyExam>(phyExamMapper.selectByExample(example));
    }

    /**
     * PhyExam分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PhyExam> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PhyExam>(phyExamMapper.selectAll());
    }

    /**
     * PhyExam条件查询
     * @param phyExam
     * @return
     */
    @Override
    public List<PhyExam> findList(PhyExam phyExam){
        //构建查询条件
        Example example = createExample(phyExam);
        //根据构建的条件查询数据
        return phyExamMapper.selectByExample(example);
    }


    /**
     * PhyExam构建查询对象
     * @param phyExam
     * @return
     */
    public Example createExample(PhyExam phyExam){
        Example example=new Example(PhyExam.class);
        Example.Criteria criteria = example.createCriteria();
        if(phyExam!=null){
            // 记录编号
            if(!StringUtils.isEmpty(phyExam.getPeId())){
                    criteria.andEqualTo("peId",phyExam.getPeId());
            }
            // 老人ID
            if(!StringUtils.isEmpty(phyExam.getOpId())){
                    criteria.andEqualTo("opId",phyExam.getOpId());
            }
            // 体检单
            if(!StringUtils.isEmpty(phyExam.getPeForm())){
                    criteria.andEqualTo("peForm",phyExam.getPeForm());
            }
            // 体检医院
            if(!StringUtils.isEmpty(phyExam.getPeHos())){
                    criteria.andEqualTo("peHos",phyExam.getPeHos());
            }
            // 体检类型
            if(!StringUtils.isEmpty(phyExam.getPeType())){
                    criteria.andEqualTo("peType",phyExam.getPeType());
            }
            // 体检时间
            if(!StringUtils.isEmpty(phyExam.getPeTime())){
                    criteria.andEqualTo("peTime",phyExam.getPeTime());
            }
            // 体检负责人
            if(!StringUtils.isEmpty(phyExam.getPeCharge())){
                    criteria.andEqualTo("peCharge",phyExam.getPeCharge());
            }
            // 记录人
            if(!StringUtils.isEmpty(phyExam.getPeRec())){
                    criteria.andEqualTo("peRec",phyExam.getPeRec());
            }
            // 备注
            if(!StringUtils.isEmpty(phyExam.getPeRem())){
                    criteria.andEqualTo("peRem",phyExam.getPeRem());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public int delete(Integer id){
        return phyExamMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PhyExam
     * @param phyExam
     */
    @Override
    public int update(PhyExam phyExam){
        return phyExamMapper.updateByPrimaryKey(phyExam);
    }

    /**
     * 增加PhyExam
     * @param phyExam
     */
    @Override
    public int add(PhyExam phyExam){
        return phyExamMapper.insert(phyExam);
    }

    /**
     * 根据ID查询PhyExam
     * @param id
     * @return
     */
    @Override
    public PhyExam findById(Integer id){
        return  phyExamMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PhyExam全部数据
     * @return
     */
    @Override
    public List<PhyExam> findAll() {
        return phyExamMapper.selectAll();
    }
}
