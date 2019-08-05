package com.zegobird.oauth2.server;

import com.zegobird.oauth2.domain.TbPermission;
import com.zegobird.oauth2.domain.TbUser;
import com.zegobird.oauth2.service.TbPermissionService;
import com.zegobird.oauth2.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author huanfion
 * @version 1.0
 * @date 2019/8/5 15:38
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TbUserService tbUserService;
    @Autowired
    private TbPermissionService tbPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.getByUsername(username);
        List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());
        List<GrantedAuthority> grantedAuthorities= Lists.newArrayList();
        if(tbUser!=null){
            tbPermissions.forEach(tbPermission -> {
                GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(tbPermission.getEnname());
                grantedAuthorities.add(grantedAuthority);
            });
        }
        return  new User(tbUser.getUsername(),tbUser.getPassword(),grantedAuthorities);
    }
}
