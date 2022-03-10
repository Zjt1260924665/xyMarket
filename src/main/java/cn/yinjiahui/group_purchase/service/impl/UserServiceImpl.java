package cn.yinjiahui.group_purchase.service.impl;


import cn.yinjiahui.group_purchase.mapper.UserMapper;
import cn.yinjiahui.group_purchase.po.UserInfo;
import cn.yinjiahui.group_purchase.security.util.JwtTokenUtil;
import cn.yinjiahui.group_purchase.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    UserMapper userMapper;
    private String avatarPath = "";

    private UserDetails loadUserByPhone(String phone) throws UsernameNotFoundException {
        UserInfo user = getUserByPhone(phone);
        if (user == null) {
            throw new UsernameNotFoundException("");
        }
        return new User(user.getPhone(), user.getPassword(), new LinkedList<>());
    }


    @Override
    public String login(String phone, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByPhone(phone);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserInfo user = getUserByPhone(phone);
            token = jwtTokenUtil.generateToken(user.getId());
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public Integer getCurrentUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return Integer.valueOf(auth.getName());
    }

    @Override
    public UserInfo getUserByPhone(String phone) {
        List<UserInfo> users = userMapper.selectByMap(new HashMap<>() {
            {
                put("phone", phone);
            }
        });
        if (users == null || users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public UserInfo getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void updateAvatar(MultipartFile file) throws IOException {
//        String fileName = file.getOriginalFilename();
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        String trueName = UUID.randomUUID() + suffixName;
//        File dest = new File(avatarPath + trueName);
//        file.transferTo(dest);
//        userMapper.updateAvatar(trueName, getCurrentUserId());
    }


}
