package com.cqp.service.provider;

import com.cqp.mapper.EmployeemanageMapper;
import com.cqp.model.Employeemanage;
import com.cqp.service.api.EmployeemanageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Employeemanage业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class EmployeemanageServiceImpl implements EmployeemanageService {

    @Autowired
    private EmployeemanageMapper employeemanageMapper;


    /**
     * Employeemanage条件+分页查询
     * @param employeemanage 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Employeemanage> findPage(Employeemanage employeemanage, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(employeemanage);
        //执行搜索
        return new PageInfo<Employeemanage>(employeemanageMapper.selectByExample(example));
    }

    /**
     * Employeemanage分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Employeemanage> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Employeemanage>(employeemanageMapper.selectAll());
    }

    /**
     * Employeemanage条件查询
     * @param employeemanage
     * @return
     */
    @Override
    public List<Employeemanage> findList(Employeemanage employeemanage){
        //构建查询条件
        Example example = createExample(employeemanage);
        //根据构建的条件查询数据
        return employeemanageMapper.selectByExample(example);
    }


    /**
     * Employeemanage构建查询对象
     * @param employeemanage
     * @return
     */
    public Example createExample(Employeemanage employeemanage){
        Example example=new Example(Employeemanage.class);
        Example.Criteria criteria = example.createCriteria();
        if(employeemanage!=null){
            // 就职编号
            if(!StringUtils.isEmpty(employeemanage.getEmmId())){
                    criteria.andEqualTo("emmId",employeemanage.getEmmId());
            }
            // 员工编号
            if(!StringUtils.isEmpty(employeemanage.getEmpId())){
                    criteria.andEqualTo("empId",employeemanage.getEmpId());
            }
            // 职位
            if(!StringUtils.isEmpty(employeemanage.getEmmJob())){
                    criteria.andEqualTo("emmJob",employeemanage.getEmmJob());
            }
            // 是否在职
            if(!StringUtils.isEmpty(employeemanage.getEmmInc())){
                    criteria.andEqualTo("emmInc",employeemanage.getEmmInc());
            }
            // 资薪
            if(!StringUtils.isEmpty(employeemanage.getEmmSalary())){
                    criteria.andEqualTo("emmSalary",employeemanage.getEmmSalary());
            }
            // 入职时间
            if(!StringUtils.isEmpty(employeemanage.getEmmEtime())){
                    criteria.andEqualTo("emmEtime",employeemanage.getEmmEtime());
            }
            // 离职时间
            if(!StringUtils.isEmpty(employeemanage.getEmmDtime())){
                    criteria.andEqualTo("emmDtime",employeemanage.getEmmDtime());
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
        return employeemanageMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Employeemanage
     * @param employeemanage
     */
    @Override
    public int update(Employeemanage employeemanage){
        return employeemanageMapper.updateByPrimaryKey(employeemanage);
    }

    /**
     * 增加Employeemanage
     * @param employeemanage
     */
    @Override
    public int add(Employeemanage employeemanage){
        return employeemanageMapper.insert(employeemanage);
    }

    /**
     * 根据ID查询Employeemanage
     * @param id
     * @return
     */
    @Override
    public Employeemanage findById(Integer id){
        return  employeemanageMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Employeemanage全部数据
     * @return
     */
    @Override
    public List<Employeemanage> findAll() {
        return employeemanageMapper.selectAll();
    }
}
