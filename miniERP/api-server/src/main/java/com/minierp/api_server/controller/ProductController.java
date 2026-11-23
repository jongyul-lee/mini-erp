package com.minierp.api_server.controller;

import com.minierp.api_server.dto.ProductDto;
import com.minierp.api_server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService =  productService;
    }

    @PostMapping("/api/v1/product")
    public ResponseEntity<Void> add(@RequestBody ProductDto dto){
        productService.add(dto);

        return ResponseEntity.status(201).build();
    }
}
