package com.macro.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SaTokenApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaTokenApiApplication.class, args);
    }

}
