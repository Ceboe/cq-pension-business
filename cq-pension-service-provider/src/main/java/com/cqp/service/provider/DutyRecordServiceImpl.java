package com.cqp.service.provider;

import com.cqp.mapper.DutyRecordMapper;
import com.cqp.model.DutyRecord;
import com.cqp.service.api.DutyRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:DutyRecord业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class DutyRecordServiceImpl implements DutyRecordService {

    @Autowired
    private DutyRecordMapper dutyRecordMapper;


    /**
     * DutyRecord条件+分页查询
     * @param dutyRecord 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<DutyRecord> findPage(DutyRecord dutyRecord, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(dutyRecord);
        //执行搜索
        return new PageInfo<DutyRecord>(dutyRecordMapper.selectByExample(example));
    }

    /**
     * DutyRecord分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<DutyRecord> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<DutyRecord>(dutyRecordMapper.selectAll());
    }

    /**
     * DutyRecord条件查询
     * @param dutyRecord
     * @return
     */
    @Override
    public List<DutyRecord> findList(DutyRecord dutyRecord){
        //构建查询条件
        Example example = createExample(dutyRecord);
        //根据构建的条件查询数据
        return dutyRecordMapper.selectByExample(example);
    }


    /**
     * DutyRecord构建查询对象
     * @param dutyRecord
     * @return
     */
    public Example createExample(DutyRecord dutyRecord){
        Example example=new Example(DutyRecord.class);
        Example.Criteria criteria = example.createCriteria();
        if(dutyRecord!=null){
            // id
            if(!StringUtils.isEmpty(dutyRecord.getDrId())){
                    criteria.andEqualTo("drId",dutyRecord.getDrId());
            }
            // 值班员工编号
            if(!StringUtils.isEmpty(dutyRecord.getEmpId())){
                    criteria.andEqualTo("empId",dutyRecord.getEmpId());
            }
            // 值班时间
            if(!StringUtils.isEmpty(dutyRecord.getDrTime())){
                    criteria.andEqualTo("drTime",dutyRecord.getDrTime());
            }
            // 换班时间
            if(!StringUtils.isEmpty(dutyRecord.getDrCtime())){
                    criteria.andEqualTo("drCtime",dutyRecord.getDrCtime());
            }
            // 值班安排
            if(!StringUtils.isEmpty(dutyRecord.getDrArrange())){
                    criteria.andEqualTo("drArrange",dutyRecord.getDrArrange());
            }
            // 备注
            if(!StringUtils.isEmpty(dutyRecord.getDrRem())){
                    criteria.andEqualTo("drRem",dutyRecord.getDrRem());
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
        return dutyRecordMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改DutyRecord
     * @param dutyRecord
     */
    @Override
    public int update(DutyRecord dutyRecord){
        return dutyRecordMapper.updateByPrimaryKey(dutyRecord);
    }

    /**
     * 增加DutyRecord
     * @param dutyRecord
     */
    @Override
    public int add(DutyRecord dutyRecord){
        return dutyRecordMapper.insert(dutyRecord);
    }

    /**
     * 根据ID查询DutyRecord
     * @param id
     * @return
     */
    @Override
    public DutyRecord findById(Integer id){
        return  dutyRecordMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询DutyRecord全部数据
     * @return
     */
    @Override
    public List<DutyRecord> findAll() {
        return dutyRecordMapper.selectAll();
    }
}
