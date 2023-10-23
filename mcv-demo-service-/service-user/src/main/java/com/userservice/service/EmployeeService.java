package com.userservice.service;


import com.userservice.poji.DTO.EmployeeDTO;
import com.userservice.poji.Employee;

public interface EmployeeService {
    //新增
    void save(Employee employee);

    //员工登录
    Employee login(EmployeeDTO employeeDTO);
}
