package com.macro.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * Created by macro on 2020/6/19.
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World.";
    }

}
