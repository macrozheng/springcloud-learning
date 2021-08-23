package com.macro.cloud.service;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import com.macro.cloud.domain.UserDTO;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class UserServiceImpl{

    private List<UserDTO> userList;

    @PostConstruct
    public void initData() {
        String password = SaSecureUtil.md5("123456");
        userList = new ArrayList<>();
        userList.add(UserDTO.builder()
                .id(1L)
                .username("admin")
                .password(SaSecureUtil.md5("123456"))
                .permissionList(CollUtil.toList("api:user:info","api:test:hello"))
                .build());
        userList.add(UserDTO.builder()
                .id(1L)
                .username("macro")
                .password(SaSecureUtil.md5("123456"))
                .permissionList(CollUtil.toList("api:user:info"))
                .build());
    }

    public UserDTO loadUserByUsername(String username) {
        List<UserDTO> findUserList = userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        if (CollUtil.isEmpty(findUserList)) {
            return null;
        }
        return findUserList.get(0);
    }

    public SaTokenInfo login(String username, String password) {
        SaTokenInfo saTokenInfo = null;
        UserDTO userDTO = loadUserByUsername(username);
        if (userDTO == null) {
            return null;
        }
        if (!SaSecureUtil.md5(password).equals(userDTO.getPassword())) {
            return null;
        }
        // 密码校验成功后登录，一行代码实现登录
        StpUtil.login(userDTO.getId());
        // 将用户信息存储到Session中
        StpUtil.getSession().set("userInfo",userDTO);
        // 获取当前登录用户Token信息
        saTokenInfo = StpUtil.getTokenInfo();
        return saTokenInfo;
    }
}
