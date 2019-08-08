package com.zegobird.oauth2server.service.impl;

import com.zegobird.oauth2server.domain.TbUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zegobird.oauth2server.mapper.TbUserMapper;
import com.zegobird.oauth2server.service.TbUserService;
import tk.mybatis.mapper.entity.Example;

/**
 * @version 1.0
 * @author huanfion
 * @date 2019/8/5 15:00
 */
@Service
public class TbUserServiceImpl implements TbUserService{

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUsername(String username) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username",username);
        return tbUserMapper.selectOneByExample(example);

    }
}
