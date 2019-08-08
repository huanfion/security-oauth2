package com.zegobird.oauth2server.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * 认证服务器配置
 * @author huanfion
 * @version 1.0
 * @date 2019/8/5 10:43
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    /**
     * 用户自定义信息
     * @return
     */
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return  new UserDetailsServiceImpl();
//    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()");//允许check_token访问
        security.checkTokenAccess("isAuthenticated()");
        security.allowFormAuthenticationForClients();//允许表单认证
    }

    /**
     * 主要配置 Client客户端信息（clientid,secret,scope,authorizedGrantTypes,authorities）
     * scope:权限范围，可选项
     * authorizedGrantTypes（四种：authorization_code，implicit，Client Credentials,Resource Owner Password Credentials）
     * authorities: 授予client的权限
     * 具体实现方式有很多：inMemory,JdbcClientDetailsService,jwt
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("clientid")
//                .secret(passwordEncoder.encode("secret"))
//                .authorizedGrantTypes("authorization_code")
//                .scopes("user_info")
//                .redirectUris("http://www.baidu.com");
        //读取客户端配置
        clients.withClientDetails(jdbcClientDetails());
    }

    /**
     * 认证服务器端口配置
     * AuthorizationServerEndpointsConfigurer 中AuthorizationServerTokenServices tokenServices
     * Token 存储方式
     * （1）InMemoryTokenStore 存在内存中，不会持久化。AuthorizationServerTokenServices接口实现有多种，DefaultTokenServices是其默认实现，它使用了默认的InMemoryTokenStore
     * （2）JdbcTokenStore 存放在数据库中
     * （3）JwkTokenStore 这个暂时不知道是啥
     * （4）jwt(Json Web Token):JwtTokenStore
     * （5）RedisTokenStore 存储在Redis内存数据库中
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //设置令牌
        endpoints.tokenStore(jdbcTokenStore());
        //endpoints.authenticationManager(authenticationManager()).allowedTokenEndpointRequestMethods(HttpMethod.POST, HttpMethod.GET);
    }


    @Bean
    public TokenStore jdbcTokenStore() {
        //基于jdbc实现存储令牌到数据库
        return new JdbcTokenStore(dataSource());
    }

    /*
    //redis 链接工厂
    @Autowired
    private RedisConnectionFactory connectionFactory;
    @Bean
    public TokenStore redisTokenStore(){
        return  new RedisTokenStore(connectionFactory);
    }
    */
    @Bean
    @Primary //spring boot 默认有个配置，使用了@Bean，又配置了，所以这里要使用Primary 指定这个是主配置。
    @ConfigurationProperties(prefix = "spring.datasource")//指定数据源，否则会有冲突
    public DataSource dataSource() {
        //配置数据源
        return DataSourceBuilder.create().build();
    }

    @Bean
    public ClientDetailsService jdbcClientDetails() {
        //基于jdbc实现，需要事先在数据库配置客户端信息
        return new JdbcClientDetailsService(dataSource());
    }
}
