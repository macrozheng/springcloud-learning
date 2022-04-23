# springcloud-learning

<p>
    <a href="#公众号"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%85%AC%E4%BC%97%E5%8F%B7-macrozheng-blue.svg" alt="公众号"></a>
    <a href="#公众号"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E4%BA%A4%E6%B5%81-%E5%BE%AE%E4%BF%A1%E7%BE%A4-2BA245.svg" alt="交流"></a>
    <a href="https://github.com/macrozheng/mall-swarm"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/Cloud%E7%89%88%E6%9C%AC-mall--swarm-brightgreen.svg" alt="SpringCloud版本"></a>
    <a href="https://github.com/macrozheng/mall"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%90%8E%E5%8F%B0%E9%A1%B9%E7%9B%AE-mall-blue.svg" alt="后台项目"></a>
    <a href="https://github.com/macrozheng/mall-admin-web"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%89%8D%E7%AB%AF%E9%A1%B9%E7%9B%AE-mall--admin--web-green.svg" alt="前端项目"></a>
</p>

## 简介

一套涵盖大部分核心组件使用的Spring Cloud教程，包括Spring Cloud Alibaba及分布式事务Seata，基于Spring Cloud Greenwich及SpringBoot 2.1.7。24篇文章，篇篇精华，34个Demo，涵盖大部分应用场景。

## 目录

### 概述

- [Spring Cloud 整体架构概览](https://www.macrozheng.com/cloud/springcloud.html)

### Spring Cloud 组件

- [Spring Cloud Eureka：服务注册与发现](https://www.macrozheng.com/cloud/eureka.html)
- [Spring Cloud Ribbon：负载均衡的服务调用](https://www.macrozheng.com/cloud/ribbon.html)
- [Spring Cloud Hystrix：服务容错保护](https://www.macrozheng.com/cloud/hystrix.html)
- [Hystrix Dashboard：断路器执行监控](https://www.macrozheng.com/cloud/hystrix_dashboard.html)
- [Spring Cloud OpenFeign：基于Ribbon和Hystrix的声明式服务调用](https://www.macrozheng.com/cloud/feign.html)
- [Spring Cloud Zuul：API网关服务](https://www.macrozheng.com/cloud/zuul.html)
- [Spring Cloud Config：外部集中化配置管理](https://www.macrozheng.com/cloud/config.html)
- [Spring Cloud Bus：消息总线](https://www.macrozheng.com/cloud/bus.html)
- [Spring Cloud Sleuth：分布式请求链路跟踪](https://www.macrozheng.com/cloud/sleuth.html)
- [Spring Cloud Consul：服务治理与配置中心](https://www.macrozheng.com/cloud/consul.html)
- [Spring Cloud Gateway：新一代API网关服务](https://www.macrozheng.com/cloud/gateway.html)

### Spring Cloud Alibaba

- [Spring Cloud Alibaba：Nacos 作为注册中心和配置中心使用](https://www.macrozheng.com/cloud/nacos.html)
- [Spring Cloud Alibaba：Sentinel实现熔断与限流](https://www.macrozheng.com/cloud/sentinel.html)
- [使用Seata彻底解决Spring Cloud中的分布式事务问题](https://www.macrozheng.com/cloud/seata.html)

### Spring Cloud Oauth2

- [Spring Cloud Security：Oauth2使用入门](https://www.macrozheng.com/cloud/oauth2.html)
- [Spring Cloud Security：Oauth2结合JWT使用](https://www.macrozheng.com/cloud/oauth2_jwt.html)
- [Spring Cloud Security：Oauth2实现单点登录](https://www.macrozheng.com/cloud/oauth2_sso.html)

### 微服务监控

- [Spring Boot Admin：微服务应用监控](https://www.macrozheng.com/cloud/admin.html)

### 微服务解决方案

- [微服务权限终极解决方案，Spring Cloud Gateway + Oauth2 实现统一认证和鉴权！](https://www.macrozheng.com/cloud/gateway_oauth2.html)
- [微服务聚合Swagger文档，这波操作是真的香！](https://www.macrozheng.com/cloud/knife4j_cloud.html)
- [我扒了半天源码，终于找到了Oauth2自定义处理结果的最佳方案！](https://www.macrozheng.com/cloud/oauth2_custom.html)
- [开箱即用！看看人家的微服务权限解决方案，那叫一个优雅！](https://www.macrozheng.com/cloud/sa_token_cloud_start.html)
- [再见Feign！推荐一款微服务间调用神器，跟SpringCloud绝配！](https://www.macrozheng.com/cloud/retrofit_cloud.html)


## 项目结构

``` lua
springcloud-learning
├── eureka-server -- eureka注册中心
├── eureka-security-server -- 带登录认证的eureka注册中心
├── eureka-client -- eureka客户端
├── user-service -- 提供User对象CRUD接口的服务
├── ribbon-service -- ribbon服务调用测试服务
├── hystrix-service -- hystrix服务调用测试服务
├── turbine-service -- 聚合收集hystrix实例监控信息的服务
├── hystrix-dashboard -- 展示hystrix实例监控信息的仪表盘
├── feign-service -- feign服务调用测试服务
├── zuul-proxy -- zuul作为网关的测试服务
├── config-server -- 配置中心服务
├── config-security-server -- 带安全认证的配置中心服务
├── config-client -- 获取配置的客户端服务
├── consul-config-client -- 用于演示consul作为配置中心的consul客户端
├── consul-user-service -- 注册到consul的提供User对象CRUD接口的服务
├── consul-service -- 注册到consul的ribbon服务调用测试服务
├── api-gateway -- gateway作为网关的测试服务
├── admin-server -- admin监控中心服务
├── admin-client -- admin监控中心监控的应用服务
├── admin-security-server -- 带登录认证的admin监控中心服务
├── oauth2-server -- oauth2认证测试服务
├── oauth2-jwt-server -- 使用jwt的oauth2认证测试服务
├── oauth2-client -- 单点登录的oauth2客户端服务
├── nacos-config-client -- 用于演示nacos作为配置中心的nacos客户端
├── nacos-user-service -- 注册到nacos的提供User对象CRUD接口的服务
├── nacos-ribbon-service -- 注册到nacos的ribbon服务调用测试服务
├── sentinel-service -- sentinel功能测试服务
├── seata-order-service -- 整合了seata的订单服务
├── seata-storage-service -- 整合了seata的库存服务
├── seata-account-service -- 整合了seata的账户服务
├── micro-oauth2 -- Gateway + Oauth2 实现统一认证和鉴权
└── micro-knife4j -- Gateway + Knife4j聚合API文档
```

## 公众号

学习不走弯路，关注公众号「**macrozheng**」，回复「**学习路线**」，获取mall项目专属学习路线！

加微信群交流，公众号后台回复「**加群**」即可。

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)
