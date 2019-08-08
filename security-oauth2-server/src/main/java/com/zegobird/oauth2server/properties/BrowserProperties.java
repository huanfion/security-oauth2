package com.zegobird.oauth2server.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huanfion
 * @version 1.0
 * @date 2019/8/7 15:33
 */
@Data
public class BrowserProperties {
    private  String loginPage="/login.html";
    private LoginType loginType=LoginType.JSON;
}
