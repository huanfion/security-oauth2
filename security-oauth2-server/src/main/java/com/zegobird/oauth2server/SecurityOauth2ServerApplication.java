package com.zegobird.oauth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.zegobird.oauth2server.mapper")
public class SecurityOauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOauth2ServerApplication.class, args);
    }

}
