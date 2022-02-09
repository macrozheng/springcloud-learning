package com.macro.cloud.service;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.macro.cloud.domain.CommonResult;
import com.macro.cloud.domain.User;
import com.macro.cloud.service.impl.UserFallbackService;
import retrofit2.http.*;

/**
 * 定义Http接口，用于调用远程的User服务
 * Created by macro on 2019/9/5.
 */
@RetrofitClient(serviceId = "nacos-user-service", fallback = UserFallbackService.class)
public interface UserService {
    @POST("/user/create")
    CommonResult create(@Body User user);

    @GET("/user/{id}")
    CommonResult<User> getUser(@Path("id") Long id);

    @GET("/user/getByUsername")
    CommonResult<User> getByUsername(@Query("username") String username);

    @POST("/user/update")
    CommonResult update(@Body User user);

    @POST("/user/delete/{id}")
    CommonResult delete(@Path("id") Long id);
}
