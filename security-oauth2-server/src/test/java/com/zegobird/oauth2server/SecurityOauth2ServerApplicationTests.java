package com.zegobird.oauth2server;

import com.zegobird.oauth2server.properties.SecurityPorperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityOauth2ServerApplicationTests {

    @Autowired
    private Environment env;
    @Autowired
    private SecurityPorperties securityPorperties;
    @Test
    public void contextLoads() {
        System.out.println(securityPorperties.getBrowser().getLoginType());
        System.out.println(env.getProperty("zegobird.security.browser.loginType"));
    }

}
