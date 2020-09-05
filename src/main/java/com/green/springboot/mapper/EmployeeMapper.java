package com.green.springboot.mapper;

import com.green.springboot.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

//    public Employee selectEmpById(Integer id);

    public void insertEmp(Employee employee);

    public List<Map<String, Object>> selectAll();

    List<Map<String, Object>> selectById(Integer id);
}
