package com.zegobird.oauth2.service;

import com.zegobird.oauth2.domain.TbPermission;

import java.util.List;

/**
 * @author huanfion
 * @version 1.0
 * @date 2019/8/5 15:13
 */
public interface TbPermissionService {
    List<TbPermission> selectByUserId(Long userId);

}
