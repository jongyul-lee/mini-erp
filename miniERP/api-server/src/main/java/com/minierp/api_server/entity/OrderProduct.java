package com.minierp.api_server.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderProduct {
    private Long orderProductId;
    private Long orderId;
    private Long productId;
    private Integer quantity;
}
