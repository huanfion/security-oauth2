package com.zegobird.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author huanfion
 * @version 1.0
 * @date 2019/8/5 17:51
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zegobird.oauth2.mapper")
public class OAuth2ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ResourceApplication.class,args);
    }
}
