package com.marspie.modules.sys.services;

import com.marspie.modules.sys.entity.UserEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;

/**
 * 自定义身份认证组件
 * @author alex.yao
 * @version 1.0.0
 * @create 2018-01-10 13:36
 **/
public class WebAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebAuthenticationProvider(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // 认证逻辑
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        if(null != userDetails){
            String encodePassword = DigestUtils.md5DigestAsHex((password).getBytes());
            if(userDetails.getPassword().equals(encodePassword)){
                // 这里设置权限和角色
                ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add( new SimpleGrantedAuthority("ROLE_ADMIN") );
                // 生成令牌
                Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
                return auth;
            }else {
                throw new BadCredentialsException("密码错误~");
            }
        }else {
            throw new UsernameNotFoundException("用户不存在~");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
