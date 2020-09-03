package com.green.springboot.controller;

import com.green.springboot.bean.Department;
import com.green.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    DepartmentMapper departmentMapper;


    @RequestMapping("/dep/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departmentMapper.selectById(id);
    }

    @RequestMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }



}
