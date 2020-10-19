package com.cqp.service.provider;

import com.cqp.mapper.UseRecordMapper;
import com.cqp.model.UseRecord;
import com.cqp.service.api.UseRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:UseRecord业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class UseRecordServiceImpl implements UseRecordService {

    @Autowired
    private UseRecordMapper useRecordMapper;


    /**
     * UseRecord条件+分页查询
     * @param useRecord 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UseRecord> findPage(UseRecord useRecord, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(useRecord);
        //执行搜索
        return new PageInfo<UseRecord>(useRecordMapper.selectByExample(example));
    }

    /**
     * UseRecord分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UseRecord> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UseRecord>(useRecordMapper.selectAll());
    }

    /**
     * UseRecord条件查询
     * @param useRecord
     * @return
     */
    @Override
    public List<UseRecord> findList(UseRecord useRecord){
        //构建查询条件
        Example example = createExample(useRecord);
        //根据构建的条件查询数据
        return useRecordMapper.selectByExample(example);
    }


    /**
     * UseRecord构建查询对象
     * @param useRecord
     * @return
     */
    public Example createExample(UseRecord useRecord){
        Example example=new Example(UseRecord.class);
        Example.Criteria criteria = example.createCriteria();
        if(useRecord!=null){
            // 记录编号
            if(!StringUtils.isEmpty(useRecord.getUrId())){
                    criteria.andEqualTo("urId",useRecord.getUrId());
            }
            // 物资编号
            if(!StringUtils.isEmpty(useRecord.getMId())){
                    criteria.andEqualTo("mId",useRecord.getMId());
            }
            // 申请人
            if(!StringUtils.isEmpty(useRecord.getApplicant())){
                    criteria.andEqualTo("applicant",useRecord.getApplicant());
            }
            // 领用时间
            if(!StringUtils.isEmpty(useRecord.getUseTime())){
                    criteria.andEqualTo("useTime",useRecord.getUseTime());
            }
            // 领用数量
            if(!StringUtils.isEmpty(useRecord.getUseNum())){
                    criteria.andEqualTo("useNum",useRecord.getUseNum());
            }
            // 归还时间
            if(!StringUtils.isEmpty(useRecord.getReTime())){
                    criteria.andEqualTo("reTime",useRecord.getReTime());
            }
            // 是否损坏
            if(!StringUtils.isEmpty(useRecord.getIsDem())){
                    criteria.andEqualTo("isDem",useRecord.getIsDem());
            }
            // 使用详情
            if(!StringUtils.isEmpty(useRecord.getUseDes())){
                    criteria.andEqualTo("useDes",useRecord.getUseDes());
            }
            // 记录员
            if(!StringUtils.isEmpty(useRecord.getNoteTaker())){
                    criteria.andEqualTo("noteTaker",useRecord.getNoteTaker());
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
        return useRecordMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UseRecord
     * @param useRecord
     */
    @Override
    public int update(UseRecord useRecord){
        return useRecordMapper.updateByPrimaryKey(useRecord);
    }

    /**
     * 增加UseRecord
     * @param useRecord
     */
    @Override
    public int add(UseRecord useRecord){
        return useRecordMapper.insert(useRecord);
    }

    /**
     * 根据ID查询UseRecord
     * @param id
     * @return
     */
    @Override
    public UseRecord findById(Integer id){
        return  useRecordMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UseRecord全部数据
     * @return
     */
    @Override
    public List<UseRecord> findAll() {
        return useRecordMapper.selectAll();
    }
}
