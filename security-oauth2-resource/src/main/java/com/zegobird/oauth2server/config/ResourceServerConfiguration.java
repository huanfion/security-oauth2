package com.zegobird.oauth2server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

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

    @Primary
    @Bean
    public RemoteTokenServices tokenServices(){
        final RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl("http://localhost:9090/oauth/check_token");
        tokenService.setClientId("clientid");
        tokenService.setClientSecret("secret");
        return  tokenService;
    }
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
