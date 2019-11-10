package com.macro.cloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 在接口上配置权限时使用
 * Created by macro on 2019/10/11.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(101)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
}
