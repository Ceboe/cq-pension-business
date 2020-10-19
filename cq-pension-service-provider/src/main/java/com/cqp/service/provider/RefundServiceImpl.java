package com.cqp.service.provider;

import com.cqp.mapper.RefundMapper;
import com.cqp.model.Refund;
import com.cqp.service.api.RefundService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Refund业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    private RefundMapper refundMapper;


    /**
     * Refund条件+分页查询
     * @param refund 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Refund> findPage(Refund refund, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(refund);
        //执行搜索
        return new PageInfo<Refund>(refundMapper.selectByExample(example));
    }

    /**
     * Refund分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Refund> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Refund>(refundMapper.selectAll());
    }

    /**
     * Refund条件查询
     * @param refund
     * @return
     */
    @Override
    public List<Refund> findList(Refund refund){
        //构建查询条件
        Example example = createExample(refund);
        //根据构建的条件查询数据
        return refundMapper.selectByExample(example);
    }


    /**
     * Refund构建查询对象
     * @param refund
     * @return
     */
    public Example createExample(Refund refund){
        Example example=new Example(Refund.class);
        Example.Criteria criteria = example.createCriteria();
        if(refund!=null){
            // 退费编号
            if(!StringUtils.isEmpty(refund.getReId())){
                    criteria.andEqualTo("reId",refund.getReId());
            }
            // 老人编号
            if(!StringUtils.isEmpty(refund.getOpId())){
                    criteria.andEqualTo("opId",refund.getOpId());
            }
            // 退费状态
            if(!StringUtils.isEmpty(refund.getReStatus())){
                    criteria.andEqualTo("reStatus",refund.getReStatus());
            }
            // 退费时间
            if(!StringUtils.isEmpty(refund.getReTime())){
                    criteria.andEqualTo("reTime",refund.getReTime());
            }
            // 退费金额
            if(!StringUtils.isEmpty(refund.getReMoney())){
                    criteria.andEqualTo("reMoney",refund.getReMoney());
            }
            // 退费方式
            if(!StringUtils.isEmpty(refund.getReMethod())){
                    criteria.andEqualTo("reMethod",refund.getReMethod());
            }
            // 记录员
            if(!StringUtils.isEmpty(refund.getNoteTaker())){
                    criteria.andEqualTo("noteTaker",refund.getNoteTaker());
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
        return refundMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Refund
     * @param refund
     */
    @Override
    public int update(Refund refund){
        return refundMapper.updateByPrimaryKey(refund);
    }

    /**
     * 增加Refund
     * @param refund
     */
    @Override
    public int add(Refund refund){
        return refundMapper.insert(refund);
    }

    /**
     * 根据ID查询Refund
     * @param id
     * @return
     */
    @Override
    public Refund findById(Integer id){
        return  refundMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Refund全部数据
     * @return
     */
    @Override
    public List<Refund> findAll() {
        return refundMapper.selectAll();
    }
}
