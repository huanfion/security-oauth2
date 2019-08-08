package com.zegobird.oauth2server.controller;

import com.zegobird.oauth2server.domain.TbUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanfion
 * @version 1.0
 * @date 2019/8/7 10:21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<TbUser> query(){

        List<TbUser> users  = new ArrayList<>();
        users.add(new TbUser());
        users.add(new TbUser());
        users.add(new TbUser());
//        throw new UserNotExistException("user not found");

        return users;
    }
    @GetMapping("/info")
    public Object getCurrentUser(Authentication authentication){
        return  authentication;
    }
}
