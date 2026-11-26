package com.minierp.api_server.service;

import com.minierp.api_server.dto.order.OrderDto;
import com.minierp.api_server.entity.Order;
import com.minierp.api_server.dto.order.OrderProductDto;
import com.minierp.api_server.entity.OrderProduct;
import com.minierp.api_server.enums.OrderStatus;
import com.minierp.api_server.mapper.OrderMapper;
import com.minierp.api_server.mapper.OrderProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderProductMapper orderProductMapper;

    @Autowired
    public OrderService(OrderMapper orderMapper, OrderProductMapper orderProductMapper) {
        this.orderMapper = orderMapper;
        this.orderProductMapper = orderProductMapper;
    }

    @Transactional
    public void insert(OrderDto request) {

        // 주문 데이터 검증
        if (request.getUserId() == null || request.getOrderProducts() == null || request.getOrderProducts().isEmpty()) {
            throw new IllegalArgumentException("주문 정보가 올바르지 않습니다.");
        }

        // 주문 생성
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setOrderStatus(OrderStatus.PENDING);

        orderMapper.insert(order);

        // 생성된 주문 ID
        Long orderId = order.getOrderId();

        // 주문_상품 등록
        for (OrderProductDto item : request.getOrderProducts()) {

            if (item == null || item.getProductId() == null || item.getQuantity() == null || item.getQuantity() <= 0) {
                throw new IllegalArgumentException("주문 상품 정보가 올바르지 않습니다.");
            }

            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrderId(orderId);
            orderProduct.setProductId(item.getProductId());
            orderProduct.setQuantity(item.getQuantity());

            orderProductMapper.insert(orderProduct);
        }
    }
}
