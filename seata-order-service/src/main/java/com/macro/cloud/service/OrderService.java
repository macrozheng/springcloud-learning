package com.macro.cloud.service;


import com.macro.cloud.domain.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
