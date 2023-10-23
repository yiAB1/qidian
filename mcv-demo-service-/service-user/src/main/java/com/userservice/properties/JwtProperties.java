package com.userservice.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "demo.jwt")
public class JwtProperties {
    /*
    管理员工生成JWT相关配置
     */
    private String adminSecretKey;
    private Long adminTtl;
    private String adminTokenName;
}
