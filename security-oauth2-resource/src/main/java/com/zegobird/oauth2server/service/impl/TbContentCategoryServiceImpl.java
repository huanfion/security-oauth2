package com.zegobird.oauth2server.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zegobird.oauth2server.mapper.TbContentCategoryMapper;
import com.zegobird.oauth2server.service.TbContentCategoryService;
/**
 * @version 1.0
 * @author huanfion
 * @date 2019/8/5 17:56
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService{

    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

}
