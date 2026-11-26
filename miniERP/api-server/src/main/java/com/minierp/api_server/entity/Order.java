package com.minierp.api_server.entity;

import com.minierp.api_server.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {
    private Long orderId;
    private Long userId;
    private OrderStatus orderStatus;
}
