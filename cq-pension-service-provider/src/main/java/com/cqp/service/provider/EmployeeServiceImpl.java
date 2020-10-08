package com.cqp.service.provider;

import com.cqp.mapper.EmployeeMapper;
import com.cqp.model.Employee;
import com.cqp.service.api.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Employee业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    /**
     * Employee条件+分页查询
     * @param employee 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Employee> findPage(Employee employee, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(employee);
        //执行搜索
        return new PageInfo<Employee>(employeeMapper.selectByExample(example));
    }

    /**
     * Employee分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Employee> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Employee>(employeeMapper.selectAll());
    }

    /**
     * Employee条件查询
     * @param employee
     * @return
     */
    @Override
    public List<Employee> findList(Employee employee){
        //构建查询条件
        Example example = createExample(employee);
        //根据构建的条件查询数据
        return employeeMapper.selectByExample(example);
    }


    /**
     * Employee构建查询对象
     * @param employee
     * @return
     */
    public Example createExample(Employee employee){
        Example example=new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        if(employee!=null){
            // 员工编号
            if(!StringUtils.isEmpty(employee.getEmpId())){
                    criteria.andEqualTo("empId",employee.getEmpId());
            }
            // 姓名
            if(!StringUtils.isEmpty(employee.getEmpName())){
                    criteria.andEqualTo("empName",employee.getEmpName());
            }
            // 性别
            if(!StringUtils.isEmpty(employee.getEmpSex())){
                    criteria.andEqualTo("empSex",employee.getEmpSex());
            }
            // 年龄
            if(!StringUtils.isEmpty(employee.getEmpBirthday())){
                    criteria.andEqualTo("empBirthday",employee.getEmpBirthday());
            }
            // 电话
            if(!StringUtils.isEmpty(employee.getEmpPhone())){
                    criteria.andEqualTo("empPhone",employee.getEmpPhone());
            }
            // 电子邮件
            if(!StringUtils.isEmpty(employee.getEmpEmail())){
                    criteria.andEqualTo("empEmail",employee.getEmpEmail());
            }
            // 地址
            if(!StringUtils.isEmpty(employee.getEmpAdd())){
                    criteria.andEqualTo("empAdd",employee.getEmpAdd());
            }
            // 照片
            if(!StringUtils.isEmpty(employee.getEmpPhoto())){
                    criteria.andEqualTo("empPhoto",employee.getEmpPhoto());
            }
            // 籍贯
            if(!StringUtils.isEmpty(employee.getEmpNative())){
                    criteria.andEqualTo("empNative",employee.getEmpNative());
            }
            // 是否婚配
            if(!StringUtils.isEmpty(employee.getEmpMarry())){
                    criteria.andEqualTo("empMarry",employee.getEmpMarry());
            }
            // 专业
            if(!StringUtils.isEmpty(employee.getEmpMajor())){
                    criteria.andEqualTo("empMajor",employee.getEmpMajor());
            }
            // 身份证号
            if(!StringUtils.isEmpty(employee.getEmpCard())){
                    criteria.andEqualTo("empCard",employee.getEmpCard());
            }
            //
            if(!StringUtils.isEmpty(employee.getEmpEdu())){
                    criteria.andEqualTo("emp",employee.getEmpEdu());
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
        employeeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Employee
     * @param employee
     */
    @Override
    public void update(Employee employee){
        employeeMapper.updateByPrimaryKey(employee);
    }

    /**
     * 增加Employee
     * @param employee
     */
    @Override
    public void add(Employee employee){
        employeeMapper.insert(employee);
    }

    /**
     * 根据ID查询Employee
     * @param id
     * @return
     */
    @Override
    public Employee findById(Integer id){
        return  employeeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Employee全部数据
     * @return
     */
    @Override
    public List<Employee> findAll() {
        return employeeMapper.selectAll();
    }
}
