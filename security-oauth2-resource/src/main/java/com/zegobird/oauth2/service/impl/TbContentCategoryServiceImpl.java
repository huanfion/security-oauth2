package com.zegobird.oauth2.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zegobird.oauth2.mapper.TbContentCategoryMapper;
import com.zegobird.oauth2.service.TbContentCategoryService;
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
