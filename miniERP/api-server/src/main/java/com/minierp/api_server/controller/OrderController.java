package com.minierp.api_server.controller;

import com.minierp.api_server.dto.order.OrderDto;
import com.minierp.api_server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/order")
    public ResponseEntity<Void> add(@RequestBody OrderDto request) {
        orderService.insert(request);

        return ResponseEntity.status(201).build();
    }


}
