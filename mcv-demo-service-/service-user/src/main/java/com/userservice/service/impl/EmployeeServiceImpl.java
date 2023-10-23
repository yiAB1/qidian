package com.userservice.service.impl;


import com.commonService.comnon.MessageConstant;
import com.commonService.execption.AccountNotFoundException;
import com.commonService.execption.PasswordErrorException;
import com.userservice.mapper.EmployeeMapper;
import com.userservice.poji.DTO.EmployeeDTO;
import com.userservice.poji.Employee;
import com.userservice.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;
    //新增员工
    @Override
    public void save(Employee employee) {
        employeeMapper.saveInsert(employee);
    }

    @Override
    public Employee login(EmployeeDTO employeeDTO) {
        String username = employeeDTO.getUsername();
        String password = employeeDTO.getPassword();

        //根据用户名查询用户中的数据
        Employee employee = employeeMapper.getByUserName(username);
        //处理各种异常
        if (employee == null) {
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //加密
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(employee.getPassword())) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        return employee;
    }
}
