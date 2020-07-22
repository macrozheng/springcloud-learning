package com.macro.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.macro.cloud.domain.Order;
import com.macro.cloud.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by macro on 2019/8/29.
 */
@Service
public class OrderServiceImpl implements OrderService {
    private List<Order> orderList;

    @Override
    public void create(Order order) {
        orderList.add(order);
    }

    @Override
    public Order getOrder(Long id) {
        List<Order> findUserList = orderList.stream().filter(orderItem -> orderItem.getId().equals(id)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        }
        return null;
    }

    @Override
    public void update(Order order) {
        orderList.stream().filter(orderItem -> orderItem.getId().equals(order.getId())).forEach(orderItem -> {
            BeanUtil.copyProperties(order,orderItem);
        });
    }

    @Override
    public void delete(Long id) {
        Order order = getOrder(id);
        if (order != null) {
            orderList.remove(order);
        }
    }

    @PostConstruct
    public void initData() {
        orderList = new ArrayList<>();
        orderList.add(Order.builder()
                .id(1L)
                .userId(1L)
                .productId(1L)
                .money(new BigDecimal(100))
                .count(1)
                .status(0)
                .build());
        orderList.add(Order.builder()
                .id(2L)
                .userId(1L)
                .productId(2L)
                .money(new BigDecimal(200))
                .count(2)
                .status(0)
                .build());
    }
}
