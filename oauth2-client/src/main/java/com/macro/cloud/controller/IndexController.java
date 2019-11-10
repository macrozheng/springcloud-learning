package com.macro.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by macro on 2019/10/11.
 */
@RestController
public class IndexController {
    @Autowired
    private UserController userController;

    @GetMapping("/")
    public Object index(Authentication authentication) {
        return userController.getCurrentUser(authentication);
    }
}
