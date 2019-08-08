package com.zegobird.oauth2server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 登录相关Controller
 *
 * @author huanfion
 * @version 1.0
 * @date 2019/8/6 12:20
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String hello() {
        return "login";
    }

    @GetMapping("/success")
    public String success(){
        return "success";
    }

    //失败页面
    @GetMapping("/failure")
    public String failurePage(){
        return "failure";
    }
}
