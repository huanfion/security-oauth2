package com.zegobird.oauth2.service.impl;

import com.zegobird.oauth2.domain.TbPermission;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zegobird.oauth2.mapper.TbPermissionMapper;
import com.zegobird.oauth2.service.TbPermissionService;

import java.util.List;

/**
 * @version 1.0
 * @author huanfion
 * @date 2019/8/5 15:13
 */
@Service
public class TbPermissionServiceImpl implements TbPermissionService{

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectByUserId(Long userId) {
        return tbPermissionMapper.selectByUserId(userId);
    }
}
