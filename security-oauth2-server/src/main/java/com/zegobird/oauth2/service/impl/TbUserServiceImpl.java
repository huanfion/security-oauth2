package com.zegobird.oauth2.service.impl;

import com.zegobird.oauth2.domain.TbUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zegobird.oauth2.mapper.TbUserMapper;
import com.zegobird.oauth2.service.TbUserService;
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
