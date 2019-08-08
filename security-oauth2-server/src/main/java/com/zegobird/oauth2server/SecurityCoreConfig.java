package com.zegobird.oauth2server;

import com.zegobird.oauth2server.properties.SecurityPorperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 使 SecurityPorperties 配置器生效
 * @author huanfion
 * @version 1.0
 * @date 2019/8/7 15:37
 */
@Configuration
@EnableConfigurationProperties(SecurityPorperties.class)
public class SecurityCoreConfig {
}
