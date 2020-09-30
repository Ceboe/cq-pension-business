package com.cqp.service.provider;

import com.cqp.mapper.ReportMapper;
import com.cqp.model.Report;
import com.cqp.service.api.ReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Report业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;


    /**
     * Report条件+分页查询
     * @param report 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Report> findPage(Report report, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(report);
        //执行搜索
        return new PageInfo<Report>(reportMapper.selectByExample(example));
    }

    /**
     * Report分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Report> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Report>(reportMapper.selectAll());
    }

    /**
     * Report条件查询
     * @param report
     * @return
     */
    @Override
    public List<Report> findList(Report report){
        //构建查询条件
        Example example = createExample(report);
        //根据构建的条件查询数据
        return reportMapper.selectByExample(example);
    }


    /**
     * Report构建查询对象
     * @param report
     * @return
     */
    public Example createExample(Report report){
        Example example=new Example(Report.class);
        Example.Criteria criteria = example.createCriteria();
        if(report!=null){
            // 报表ID
            if(!StringUtils.isEmpty(report.getRepId())){
                    criteria.andEqualTo("repId",report.getRepId());
            }
            // 报表名称
            if(!StringUtils.isEmpty(report.getRepName())){
                    criteria.andEqualTo("repName",report.getRepName());
            }
            // 描述
            if(!StringUtils.isEmpty(report.getRepDes())){
                    criteria.andEqualTo("repDes",report.getRepDes());
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
        reportMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Report
     * @param report
     */
    @Override
    public void update(Report report){
        reportMapper.updateByPrimaryKey(report);
    }

    /**
     * 增加Report
     * @param report
     */
    @Override
    public void add(Report report){
        reportMapper.insert(report);
    }

    /**
     * 根据ID查询Report
     * @param id
     * @return
     */
    @Override
    public Report findById(Integer id){
        return  reportMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Report全部数据
     * @return
     */
    @Override
    public List<Report> findAll() {
        return reportMapper.selectAll();
    }
}
