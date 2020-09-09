package com.green.springboot.controller;

import com.green.springboot.bean.Department;
import com.green.springboot.bean.Employee;
import com.green.springboot.mapper.DepartmentMapper;
import com.green.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
/**
 *
 * @description: TODO 使用mybatis方式访问数据库
 * @function:
 *mybatis访问数据库的两种方式：
 *     第一：注解方式
 *     第二：mapper映射文件方法
 * @author: zero
 * @date: 2020/9/9
 * @version: 1.0
 */
@RestController
public class HelloController {

    @Autowired
    public DepartmentMapper departmentMapper;

    @Autowired
    public EmployeeMapper employeeMapper;

    @RequestMapping(value="/dep/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departmentMapper.selectById(id);
    }

    @RequestMapping(value="/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @RequestMapping(value="/empl")
    public Object[] selectAllEmp(){
        System.out.println("查询employee数据库中的信息");
        List<Map<String, Object>> maps = employeeMapper.selectAll();
        System.out.println("查询企业员工信息1，，，，，"+maps.toString());

        return maps.toArray();
    }
    @RequestMapping(value="/emp")
    public Employee insertEmp(Employee employee){
        System.out.println("新增企业员工信息，，，，，"+employee.toString());
        employeeMapper.insertEmp(employee);
        return employee;
    }

    @RequestMapping(value="/empl/{id}")
    public Object[] selectEmpById(@PathVariable("id") Integer id){
        System.out.println("查询employee数据库中的信息");
        List<Map<String, Object>> maps = employeeMapper.selectById(id);
        System.out.println("查询企业员工信息2，，，，，"+maps.toString());
        return maps.toArray();
    }
    @RequestMapping("/user/del/{id}")
    public String delById(@PathVariable("id") Integer id){
        return "success";
    }

}
