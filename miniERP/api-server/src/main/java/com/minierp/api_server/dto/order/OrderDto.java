package com.minierp.api_server.dto.order;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderDto {
    private Long userId;
    private List<OrderProductDto> orderProducts; // 1 : N Mapping
}
