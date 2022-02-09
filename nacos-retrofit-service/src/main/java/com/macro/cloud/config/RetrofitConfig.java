package com.macro.cloud.config;

import com.github.lianjiatech.retrofit.spring.boot.core.ServiceInstanceChooser;
import com.github.lianjiatech.retrofit.spring.boot.core.SpringCloudServiceInstanceChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Retrofit相关配置
 * Created by macro on 2022/1/26.
 */
@Configuration
public class RetrofitConfig {

    @Bean
    @Autowired
    public ServiceInstanceChooser serviceInstanceChooser(LoadBalancerClient loadBalancerClient) {
        return new SpringCloudServiceInstanceChooser(loadBalancerClient);
    }
}
