package com.userservice.mapper;


import com.userservice.poji.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {
    @Insert("insert into yuan_01.employee(username, password) " +
            "VALUES (#{username},#{password})")
    void saveInsert(Employee employee);

    @Select("select * from yuan_01.employee where username = #{username}")
    Employee getByUserName(String username);
}
