package com.zegobird.oauth2.controller;

import com.zegobird.oauth2.domain.TbContent;
import com.zegobird.oauth2.dto.ResponseResult;
import com.zegobird.oauth2.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huanfion
 * @version 1.0
 * @date 2019/8/5 17:58
 */
@RestController
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    /**
     * 获取全部资源
     * @return
     */
    @GetMapping("/")
    public ResponseResult<List<TbContent>> list(){
        return new ResponseResult<List<TbContent>>(HttpStatus.OK.value(),HttpStatus.OK.toString(),tbContentService.selectAll());
    }

    @GetMapping("/view/{id}")
    public ResponseResult<TbContent> getById(@PathVariable long id){
        return new ResponseResult<TbContent>(HttpStatus.OK.value(), HttpStatus.OK.toString(), tbContentService.getById(id));
    }
    @PostMapping("/insert")
    public ResponseResult<Integer> insert(@RequestBody TbContent tbContent){
        int count=tbContentService.insert(tbContent);
        if(count>0){
            return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()),HttpStatus.OK.toString(),count);
        }
        else{
            return new ResponseResult<>(Integer.valueOf(HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST.toString(),count);
        }
    }
    @PutMapping("/put")
    public ResponseResult<Integer> update(@RequestBody TbContent tbContent){
        int count=tbContentService.update(tbContent);
        if(count>0){
            return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()),HttpStatus.OK.toString(),count);
        }
        else{
            return new ResponseResult<>(Integer.valueOf(HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST.toString(),count);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseResult<Integer> delete(@PathVariable Long id){
        int count=tbContentService.delete(id);
        if(count>0){
            return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()),HttpStatus.OK.toString(),count);
        }
        else{
            return new ResponseResult<>(Integer.valueOf(HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST.toString(),count);
        }
    }
}
