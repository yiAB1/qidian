package com.userservice.poji.DTO;

import lombok.Data;

import java.io.Serializable;

//DTO属性
@Data
public class EmployeeDTO implements Serializable {
    private Long id;//  '主键',
    private String username;//  '用户名',
    private String password;// '密码',
}
