package com.cqp.service.provider;

import com.cqp.mapper.NursRecordMapper;
import com.cqp.model.NursRecord;
import com.cqp.service.api.NursRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:NursRecord业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class NursRecordServiceImpl implements NursRecordService {

    @Autowired
    private NursRecordMapper nursRecordMapper;


    /**
     * NursRecord条件+分页查询
     * @param nursRecord 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<NursRecord> findPage(NursRecord nursRecord, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(nursRecord);
        //执行搜索
        return new PageInfo<NursRecord>(nursRecordMapper.selectByExample(example));
    }

    /**
     * NursRecord分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<NursRecord> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<NursRecord>(nursRecordMapper.selectAll());
    }

    /**
     * NursRecord条件查询
     * @param nursRecord
     * @return
     */
    @Override
    public List<NursRecord> findList(NursRecord nursRecord){
        //构建查询条件
        Example example = createExample(nursRecord);
        //根据构建的条件查询数据
        return nursRecordMapper.selectByExample(example);
    }


    /**
     * NursRecord构建查询对象
     * @param nursRecord
     * @return
     */
    public Example createExample(NursRecord nursRecord){
        Example example=new Example(NursRecord.class);
        Example.Criteria criteria = example.createCriteria();
        if(nursRecord!=null){
            // 记录编号
            if(!StringUtils.isEmpty(nursRecord.getNId())){
                    criteria.andEqualTo("nId",nursRecord.getNId());
            }
            // 老人编号
            if(!StringUtils.isEmpty(nursRecord.getOpId())){
                    criteria.andEqualTo("opId",nursRecord.getOpId());
            }
            // 开始时间
            if(!StringUtils.isEmpty(nursRecord.getStartTime())){
                    criteria.andEqualTo("startTime",nursRecord.getStartTime());
            }
            // 结束时间
            if(!StringUtils.isEmpty(nursRecord.getEndTime())){
                    criteria.andEqualTo("endTime",nursRecord.getEndTime());
            }
            // 护理项编号
            if(!StringUtils.isEmpty(nursRecord.getNpId())){
                    criteria.andEqualTo("npId",nursRecord.getNpId());
            }
            // 详细描述
            if(!StringUtils.isEmpty(nursRecord.getNnDes())){
                    criteria.andEqualTo("nnDes",nursRecord.getNnDes());
            }
            // 护理结果
            if(!StringUtils.isEmpty(nursRecord.getResult())){
                    criteria.andEqualTo("result",nursRecord.getResult());
            }
            // 执行护工
            if(!StringUtils.isEmpty(nursRecord.getNurse())){
                    criteria.andEqualTo("nurse",nursRecord.getNurse());
            }
            // 记录人
            if(!StringUtils.isEmpty(nursRecord.getNoteTaker())){
                    criteria.andEqualTo("noteTaker",nursRecord.getNoteTaker());
            }
            // 备注
            if(!StringUtils.isEmpty(nursRecord.getRemark())){
                    criteria.andEqualTo("remark",nursRecord.getRemark());
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
        nursRecordMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改NursRecord
     * @param nursRecord
     */
    @Override
    public void update(NursRecord nursRecord){
        nursRecordMapper.updateByPrimaryKey(nursRecord);
    }

    /**
     * 增加NursRecord
     * @param nursRecord
     */
    @Override
    public void add(NursRecord nursRecord){
        nursRecordMapper.insert(nursRecord);
    }

    /**
     * 根据ID查询NursRecord
     * @param id
     * @return
     */
    @Override
    public NursRecord findById(Integer id){
        return  nursRecordMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询NursRecord全部数据
     * @return
     */
    @Override
    public List<NursRecord> findAll() {
        return nursRecordMapper.selectAll();
    }
}
