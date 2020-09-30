package com.cqp.service.provider;

import com.cqp.mapper.ChargeBillMapper;
import com.cqp.model.ChargeBill;
import com.cqp.service.api.ChargeBillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:ChargeBill业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ChargeBillServiceImpl implements ChargeBillService {

    @Autowired
    private ChargeBillMapper chargeBillMapper;


    /**
     * ChargeBill条件+分页查询
     * @param chargeBill 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ChargeBill> findPage(ChargeBill chargeBill, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(chargeBill);
        //执行搜索
        return new PageInfo<ChargeBill>(chargeBillMapper.selectByExample(example));
    }

    /**
     * ChargeBill分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ChargeBill> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ChargeBill>(chargeBillMapper.selectAll());
    }

    /**
     * ChargeBill条件查询
     * @param chargeBill
     * @return
     */
    @Override
    public List<ChargeBill> findList(ChargeBill chargeBill){
        //构建查询条件
        Example example = createExample(chargeBill);
        //根据构建的条件查询数据
        return chargeBillMapper.selectByExample(example);
    }


    /**
     * ChargeBill构建查询对象
     * @param chargeBill
     * @return
     */
    public Example createExample(ChargeBill chargeBill){
        Example example=new Example(ChargeBill.class);
        Example.Criteria criteria = example.createCriteria();
        if(chargeBill!=null){
            // 收费单号
            if(!StringUtils.isEmpty(chargeBill.getCbId())){
                    criteria.andEqualTo("cbId",chargeBill.getCbId());
            }
            // 老人编号
            if(!StringUtils.isEmpty(chargeBill.getOpId())){
                    criteria.andEqualTo("opId",chargeBill.getOpId());
            }
            // 收费时间
            if(!StringUtils.isEmpty(chargeBill.getCbTime())){
                    criteria.andEqualTo("cbTime",chargeBill.getCbTime());
            }
            // 预计收费
            if(!StringUtils.isEmpty(chargeBill.getChargEsti())){
                    criteria.andEqualTo("chargEsti",chargeBill.getChargEsti());
            }
            // 待付金额
            if(!StringUtils.isEmpty(chargeBill.getChargAct())){
                    criteria.andEqualTo("chargAct",chargeBill.getChargAct());
            }
            // 支付方式
            if(!StringUtils.isEmpty(chargeBill.getPayMethod())){
                    criteria.andEqualTo("payMethod",chargeBill.getPayMethod());
            }
            // 记录员
            if(!StringUtils.isEmpty(chargeBill.getNoteTaker())){
                    criteria.andEqualTo("noteTaker",chargeBill.getNoteTaker());
            }
            // 备注
            if(!StringUtils.isEmpty(chargeBill.getCbRem())){
                    criteria.andEqualTo("cbRem",chargeBill.getCbRem());
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
        chargeBillMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ChargeBill
     * @param chargeBill
     */
    @Override
    public void update(ChargeBill chargeBill){
        chargeBillMapper.updateByPrimaryKey(chargeBill);
    }

    /**
     * 增加ChargeBill
     * @param chargeBill
     */
    @Override
    public void add(ChargeBill chargeBill){
        chargeBillMapper.insert(chargeBill);
    }

    /**
     * 根据ID查询ChargeBill
     * @param id
     * @return
     */
    @Override
    public ChargeBill findById(Integer id){
        return  chargeBillMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ChargeBill全部数据
     * @return
     */
    @Override
    public List<ChargeBill> findAll() {
        return chargeBillMapper.selectAll();
    }
}
