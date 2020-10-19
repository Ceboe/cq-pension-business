package com.cqp.service.provider;

import com.cqp.mapper.OutMapper;
import com.cqp.model.Out;
import com.cqp.service.api.OutService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Out业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class OutServiceImpl implements OutService {

    @Autowired
    private OutMapper outMapper;


    /**
     * Out条件+分页查询
     * @param out 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Out> findPage(Out out, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(out);
        //执行搜索
        return new PageInfo<Out>(outMapper.selectByExample(example));
    }

    /**
     * Out分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Out> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Out>(outMapper.selectAll());
    }

    /**
     * Out条件查询
     * @param out
     * @return
     */
    @Override
    public List<Out> findList(Out out){
        //构建查询条件
        Example example = createExample(out);
        //根据构建的条件查询数据
        return outMapper.selectByExample(example);
    }


    /**
     * Out构建查询对象
     * @param out
     * @return
     */
    public Example createExample(Out out){
        Example example=new Example(Out.class);
        Example.Criteria criteria = example.createCriteria();
        if(out!=null){
            // 编号
            if(!StringUtils.isEmpty(out.getOutId())){
                    criteria.andEqualTo("outId",out.getOutId());
            }
            // 老人编号
            if(!StringUtils.isEmpty(out.getOpId())){
                    criteria.andEqualTo("opId",out.getOpId());
            }
            // 外出时间
            if(!StringUtils.isEmpty(out.getOutTime())){
                    criteria.andEqualTo("outTime",out.getOutTime());
            }
            // 预计回来时间
            if(!StringUtils.isEmpty(out.getPredictTime())){
                    criteria.andEqualTo("predictTime",out.getPredictTime());
            }
            // 实际回来时间
            if(!StringUtils.isEmpty(out.getRealTime())){
                    criteria.andEqualTo("realTime",out.getRealTime());
            }
            // 外出原因
            if(!StringUtils.isEmpty(out.getOutReason())){
                    criteria.andEqualTo("outReason",out.getOutReason());
            }
            // 同意家属名
            if(!StringUtils.isEmpty(out.getOutfmName())){
                    criteria.andEqualTo("outfmName",out.getOutfmName());
            }
            // 记录人
            if(!StringUtils.isEmpty(out.getOutRecord())){
                    criteria.andEqualTo("outRecord",out.getOutRecord());
            }
            // 审批人
            if(!StringUtils.isEmpty(out.getOutEaa())){
                    criteria.andEqualTo("outEaa",out.getOutEaa());
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
        return outMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Out
     * @param out
     */
    @Override
    public int update(Out out){
        return outMapper.updateByPrimaryKey(out);
    }

    /**
     * 增加Out
     * @param out
     */
    @Override
    public int add(Out out){
        return outMapper.insert(out);
    }

    /**
     * 根据ID查询Out
     * @param id
     * @return
     */
    @Override
    public Out findById(Integer id){
        return  outMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Out全部数据
     * @return
     */
    @Override
    public List<Out> findAll() {
        return outMapper.selectAll();
    }
}
