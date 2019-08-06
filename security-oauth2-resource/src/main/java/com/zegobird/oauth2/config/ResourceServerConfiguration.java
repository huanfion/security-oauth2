package com.zegobird.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 创建资源服务器，资源授权访问
 * @author huanfion
 * @version 1.0
 * @date 2019/8/5 18:51
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class ResourceServerConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/").hasAuthority("SystemContent")
                .antMatchers("/view/**").hasAuthority("SystemContentView")
                .antMatchers("/insert/**").hasAuthority("SystemContentInsert")
                .antMatchers("/update/**").hasAuthority("SystemContentUpdate")
                .antMatchers("/delete/**").hasAuthority("SystemContentDelete")
                ;//.anyRequest().authenticated();
    }
}
