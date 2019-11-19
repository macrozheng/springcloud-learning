package com.macro.cloud.dao;

import com.macro.cloud.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDao {

    /**
     * 创建订单
     */
    void create(Order order);

    /**
     * 修改订单金额
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
