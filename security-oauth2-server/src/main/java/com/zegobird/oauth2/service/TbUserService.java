package com.zegobird.oauth2.service;

import com.zegobird.oauth2.domain.TbUser;

/**
 * @version 1.0
 * @author huanfion
 * @date 2019/8/5 15:00
 */
public interface TbUserService{

    TbUser getByUsername(String username);

}
