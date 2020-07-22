package com.macro.cloud.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * Created by macro on 2019/8/29.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Order {
    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("商品ID")
    private Long productId;
    @ApiModelProperty("商品数量")
    private Integer count;
    @ApiModelProperty("商品单价")
    private BigDecimal money;
    @ApiModelProperty("订单状态")
    private Integer status;
}
