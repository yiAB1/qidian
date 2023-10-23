package com.userservice.controller;


import com.commonService.comnon.Result;
import com.commonService.filter.JwtClaimsConstant;
import com.commonService.filter.JwtUtil;
import com.userservice.poji.DTO.EmployeeDTO;
import com.userservice.poji.Employee;
import com.userservice.poji.VO.EmployeeLoginVo;
import com.userservice.properties.JwtProperties;
import com.userservice.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/emps")
@Slf4j
@Api(tags = "用户登录")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;
    @Resource
    private JwtProperties jwtProperties;
    @PostMapping
    @ApiOperation("新增用户")
    public Result userInsert(@RequestBody Employee employee) {
        log.info("新增用户 : {}",employee);
        employeeService.save(employee);
        return Result.success();
    }

    @PostMapping("/login")
    @ApiOperation("员工登录")
    public Result<EmployeeLoginVo> login(@RequestBody EmployeeDTO employeeDTO) {
        log.info("员工登录 ： {}",employeeDTO);
        Employee employee = employeeService.login(employeeDTO);

        //登录成功后生成JWT
        Map<String,Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID,employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims
        );
        EmployeeLoginVo employeeLoginVo = EmployeeLoginVo.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .token(token)
                .build();

        return Result.success(employeeLoginVo);
    }


    @PostMapping("/logout")
    @ApiOperation("员工退出")
    public Result<String> logout() {
        return Result.success();
    }
}
