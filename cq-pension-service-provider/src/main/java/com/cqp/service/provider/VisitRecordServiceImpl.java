package com.cqp.service.provider;

import com.cqp.mapper.VisitRecordMapper;
import com.cqp.model.VisitRecord;
import com.cqp.service.api.VisitRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:VisitRecord业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    @Autowired
    private VisitRecordMapper visitRecordMapper;


    /**
     * VisitRecord条件+分页查询
     * @param visitRecord 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<VisitRecord> findPage(VisitRecord visitRecord, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(visitRecord);
        //执行搜索
        return new PageInfo<VisitRecord>(visitRecordMapper.selectByExample(example));
    }

    /**
     * VisitRecord分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<VisitRecord> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<VisitRecord>(visitRecordMapper.selectAll());
    }

    /**
     * VisitRecord条件查询
     * @param visitRecord
     * @return
     */
    @Override
    public List<VisitRecord> findList(VisitRecord visitRecord){
        //构建查询条件
        Example example = createExample(visitRecord);
        //根据构建的条件查询数据
        return visitRecordMapper.selectByExample(example);
    }


    /**
     * VisitRecord构建查询对象
     * @param visitRecord
     * @return
     */
    public Example createExample(VisitRecord visitRecord){
        Example example=new Example(VisitRecord.class);
        Example.Criteria criteria = example.createCriteria();
        if(visitRecord!=null){
            // 记录编号
            if(!StringUtils.isEmpty(visitRecord.getVrId())){
                    criteria.andEqualTo("vrId",visitRecord.getVrId());
            }
            // 到访时间
            if(!StringUtils.isEmpty(visitRecord.getVrTtime())){
                    criteria.andEqualTo("vrTtime",visitRecord.getVrTtime());
            }
            // 离开时间
            if(!StringUtils.isEmpty(visitRecord.getVrLtime())){
                    criteria.andEqualTo("vrLtime",visitRecord.getVrLtime());
            }
            // 姓名
            if(!StringUtils.isEmpty(visitRecord.getVrName())){
                    criteria.andEqualTo("vrName",visitRecord.getVrName());
            }
            // 联系电话
            if(!StringUtils.isEmpty(visitRecord.getVrPhone())){
                    criteria.andEqualTo("vrPhone",visitRecord.getVrPhone());
            }
            // 到访目的
            if(!StringUtils.isEmpty(visitRecord.getVrPurpsoe())){
                    criteria.andEqualTo("vrPurpsoe",visitRecord.getVrPurpsoe());
            }
            // 备注
            if(!StringUtils.isEmpty(visitRecord.getVrRem())){
                    criteria.andEqualTo("vrRem",visitRecord.getVrRem());
            }
            // 值班人员
            if(!StringUtils.isEmpty(visitRecord.getVrDutyname())){
                    criteria.andLike("vrDutyname","%"+visitRecord.getVrDutyname()+"%");
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
        return visitRecordMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改VisitRecord
     * @param visitRecord
     */
    @Override
    public int update(VisitRecord visitRecord){
        return visitRecordMapper.updateByPrimaryKey(visitRecord);
    }

    /**
     * 增加VisitRecord
     * @param visitRecord
     */
    @Override
    public int add(VisitRecord visitRecord){
        return visitRecordMapper.insert(visitRecord);
    }

    /**
     * 根据ID查询VisitRecord
     * @param id
     * @return
     */
    @Override
    public VisitRecord findById(Integer id){
        return  visitRecordMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询VisitRecord全部数据
     * @return
     */
    @Override
    public List<VisitRecord> findAll() {
        return visitRecordMapper.selectAll();
    }
}
