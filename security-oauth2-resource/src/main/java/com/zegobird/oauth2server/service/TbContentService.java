package com.zegobird.oauth2server.service;

import com.zegobird.oauth2server.domain.TbContent;

import java.util.List;

/**
 * @version 1.0
 * @author huanfion
 * @date 2019/8/5 17:56
 */
public interface TbContentService{

    default List<TbContent> selectAll(){
        return null;
    }
    default TbContent getById(Long id){
        return  null;
    }
    default int insert(TbContent tbContent){
        return 0;
    }
    default int update(TbContent tbContent){
        return 0;
    }
    default int delete(Long id){
        return 0;
    }
}
