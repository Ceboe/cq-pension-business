package com.cqp.service.provider;

import com.cqp.mapper.LogMapper;
import com.cqp.model.Log;
import com.cqp.service.api.LogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Log业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;


    /**
     * Log条件+分页查询
     * @param log 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Log> findPage(Log log, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(log);
        //执行搜索
        return new PageInfo<Log>(logMapper.selectByExample(example));
    }

    /**
     * Log分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Log> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Log>(logMapper.selectAll());
    }

    /**
     * Log条件查询
     * @param log
     * @return
     */
    @Override
    public List<Log> findList(Log log){
        //构建查询条件
        Example example = createExample(log);
        //根据构建的条件查询数据
        return logMapper.selectByExample(example);
    }


    /**
     * Log构建查询对象
     * @param log
     * @return
     */
    public Example createExample(Log log){
        Example example=new Example(Log.class);
        Example.Criteria criteria = example.createCriteria();
        if(log!=null){
            // ID
            if(!StringUtils.isEmpty(log.getLogId())){
                    criteria.andEqualTo("logId",log.getLogId());
            }
            // 操作类型
            if(!StringUtils.isEmpty(log.getLogType())){
                    criteria.andEqualTo("logType",log.getLogType());
            }
            // 具体操作
            if(!StringUtils.isEmpty(log.getLogCon())){
                    criteria.andEqualTo("logCon",log.getLogCon());
            }
            // 操作人
            if(!StringUtils.isEmpty(log.getLogName())){
                    criteria.andEqualTo("logName",log.getLogName());
            }
            // 日期
            if(!StringUtils.isEmpty(log.getLogDate())){
                    criteria.andEqualTo("logDate",log.getLogDate());
            }
            // 时间
            if(!StringUtils.isEmpty(log.getLogTime())){
                    criteria.andEqualTo("logTime",log.getLogTime());
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
        logMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Log
     * @param log
     */
    @Override
    public void update(Log log){
        logMapper.updateByPrimaryKey(log);
    }

    /**
     * 增加Log
     * @param log
     */
    @Override
    public void add(Log log){
        logMapper.insert(log);
    }

    /**
     * 根据ID查询Log
     * @param id
     * @return
     */
    @Override
    public Log findById(Integer id){
        return  logMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Log全部数据
     * @return
     */
    @Override
    public List<Log> findAll() {
        return logMapper.selectAll();
    }
}
