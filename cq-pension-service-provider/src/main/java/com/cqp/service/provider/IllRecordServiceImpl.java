package com.cqp.service.provider;

import com.cqp.mapper.IllRecordMapper;
import com.cqp.model.IllRecord;
import com.cqp.service.api.IllRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:IllRecord业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class IllRecordServiceImpl implements IllRecordService {

    @Autowired
    private IllRecordMapper illRecordMapper;


    /**
     * IllRecord条件+分页查询
     * @param illRecord 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<IllRecord> findPage(IllRecord illRecord, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(illRecord);
        //执行搜索
        return new PageInfo<IllRecord>(illRecordMapper.selectByExample(example));
    }

    /**
     * IllRecord分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<IllRecord> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<IllRecord>(illRecordMapper.selectAll());
    }

    /**
     * IllRecord条件查询
     * @param illRecord
     * @return
     */
    @Override
    public List<IllRecord> findList(IllRecord illRecord){
        //构建查询条件
        Example example = createExample(illRecord);
        //根据构建的条件查询数据
        return illRecordMapper.selectByExample(example);
    }


    /**
     * IllRecord构建查询对象
     * @param illRecord
     * @return
     */
    public Example createExample(IllRecord illRecord){
        Example example=new Example(IllRecord.class);
        Example.Criteria criteria = example.createCriteria();
        if(illRecord!=null){
            // id
            if(!StringUtils.isEmpty(illRecord.getIllId())){
                    criteria.andEqualTo("illId",illRecord.getIllId());
            }
            // 老人id
            if(!StringUtils.isEmpty(illRecord.getOpId())){
                    criteria.andEqualTo("opId",illRecord.getOpId());
            }
            // 疾病
            if(!StringUtils.isEmpty(illRecord.getIllDis())){
                    criteria.andEqualTo("illDis",illRecord.getIllDis());
            }
            // 生病时间
            if(!StringUtils.isEmpty(illRecord.getIllTime())){
                    criteria.andEqualTo("illTime",illRecord.getIllTime());
            }
            // 就诊机构
            if(!StringUtils.isEmpty(illRecord.getMedMech())){
                    criteria.andEqualTo("medMech",illRecord.getMedMech());
            }
            // 痊愈时间
            if(!StringUtils.isEmpty(illRecord.getRecoTime())){
                    criteria.andEqualTo("recoTime",illRecord.getRecoTime());
            }
            // 注意事项
            if(!StringUtils.isEmpty(illRecord.getIllAttention())){
                    criteria.andEqualTo("illAttention",illRecord.getIllAttention());
            }
            // 记录人
            if(!StringUtils.isEmpty(illRecord.getIllRec())){
                    criteria.andEqualTo("illRec",illRecord.getIllRec());
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
        return illRecordMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改IllRecord
     * @param illRecord
     */
    @Override
    public int update(IllRecord illRecord){
        return illRecordMapper.updateByPrimaryKey(illRecord);
    }

    /**
     * 增加IllRecord
     * @param illRecord
     */
    @Override
    public int add(IllRecord illRecord){
        return illRecordMapper.insert(illRecord);
    }

    /**
     * 根据ID查询IllRecord
     * @param id
     * @return
     */
    @Override
    public IllRecord findById(Integer id){
        return  illRecordMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询IllRecord全部数据
     * @return
     */
    @Override
    public List<IllRecord> findAll() {
        return illRecordMapper.selectAll();
    }
}
