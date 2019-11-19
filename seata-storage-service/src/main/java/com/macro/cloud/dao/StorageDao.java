package com.macro.cloud.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageDao {

    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
