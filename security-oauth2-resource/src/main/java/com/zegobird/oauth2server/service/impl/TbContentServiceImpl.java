package com.zegobird.oauth2server.service.impl;

import com.zegobird.oauth2server.domain.TbContent;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zegobird.oauth2server.mapper.TbContentMapper;
import com.zegobird.oauth2server.service.TbContentService;

import java.util.List;

/**
 * @version 1.0
 * @author huanfion
 * @date 2019/8/5 17:56
 */
@Service
public class TbContentServiceImpl implements TbContentService{

    @Resource
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> selectAll() {
        return tbContentMapper.selectAll();
    }

    public TbContent getById(Long id) {
        return (TbContent) tbContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(TbContent tbContent) {
        return tbContentMapper.insert(tbContent);
    }

    @Override
    public int update(TbContent tbContent) {
        return tbContentMapper.updateByPrimaryKey(tbContent);
    }

    @Override
    public int delete(Long id) {
        return tbContentMapper.deleteByPrimaryKey(id);
    }
}
