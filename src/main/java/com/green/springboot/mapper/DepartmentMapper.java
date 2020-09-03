package com.green.springboot.mapper;

import com.green.springboot.bean.Department;
import org.apache.ibatis.annotations.*;
/*
用来实现mapper映射文件的增删改查需求
 */
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department selectById(Integer id);

    @Delete("delete from department where id =#{id} ")
    public int deleteById(Integer id);

    /*
    参考注解 Options 中的方式方法
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department (departmentName ) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set deptName = #{deptName} where id = #{id} ")
    public int updateById(Department department);
}
