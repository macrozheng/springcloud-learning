package com.macro.cloud.service.impl;

import com.macro.cloud.dao.OrderDao;
import com.macro.cloud.domain.Order;
import com.macro.cloud.service.AccountService;
import com.macro.cloud.service.OrderService;
import com.macro.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单业务实现类
 * Created by macro on 2019/11/11.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        LOGGER.info("------->下单开始");
        //本应用创建订单
        orderDao.create(order);

        //远程调用库存服务扣减库存
        LOGGER.info("------->order-service中扣减库存开始");
        storageService.decrease(order.getProductId(),order.getCount());
        LOGGER.info("------->order-service中扣减库存结束");

        //远程调用账户服务扣减余额
        LOGGER.info("------->order-service中扣减余额开始");
        accountService.decrease(order.getUserId(),order.getMoney());
        LOGGER.info("------->order-service中扣减余额结束");

        //修改订单状态为已完成
        LOGGER.info("------->order-service中修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        LOGGER.info("------->order-service中修改订单状态结束");

        LOGGER.info("------->下单结束");
    }
}
