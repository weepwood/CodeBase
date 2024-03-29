package com.halo.autologin.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.halo.autologin.entity.Users;
import com.halo.autologin.mapper.UsersMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Halo
 * @date Created in 2021/04/15 5:10 PM
 * @description
 */

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 调用usersMapper方法，根据用户名查询数据库
        QueryWrapper<Users> wrapper = new QueryWrapper();
        // where username=?
        wrapper.eq("username", username);
        Users users = usersMapper.selectOne(wrapper);
        // 判断,数据库是否存在用户名，认证失败
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admins");
        // 从查询数据库返回users对象，得到用户名和密码，返回
        return new User(users.getUsername(), new BCryptPasswordEncoder().encode(users.getPassword()), auths);
    }
}
