package com.cqp.mapper;

import com.cqp.model.Employee;
import com.cqp.model.Employeemanage;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Employee的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface EmployeeMapper extends Mapper<Employee> {
    /***
     * 根据Employeemanage查询Employee
     * @param employeemanage
     * @return
     */
    List<Employee> selectByEmpAndEmm(Employeemanage employeemanage);
}
