package com.zegobird.oauth2server.controller;

import com.zegobird.oauth2server.dto.ResponseResult;
import com.zegobird.oauth2server.properties.SecurityPorperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huanfion
 * @version 1.0
 * @date 2019/8/7 15:05
 */
@RestController
public class AuthenticationController {
    private Logger logger= LoggerFactory.getLogger(getClass());
    private RequestCache requestCache=new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
    @Autowired
    private SecurityPorperties securityPorperties;
    /**
     * 当需要身份认证时，跳转到这里
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code= HttpStatus.UNAUTHORIZED)
    public ResponseResult<String> requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if(savedRequest!=null){
            String targetUrl=savedRequest.getRedirectUrl();
            logger.info("引发跳转的url是："+targetUrl);
            //if(StringUtils.endsWithIgnoreCase(targetUrl,".html")){
                redirectStrategy.sendRedirect(request,response,securityPorperties.getBrowser().getLoginPage());
            //}
        }
        return new ResponseResult<String>(HttpStatus.UNAUTHORIZED.value(),"访问的服务需要身份认证，请引导用户到登录页",null);
    }
}
