package com.minierp.api_server.controller;

import com.minierp.api_server.dto.ProductDto;
import com.minierp.api_server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService =  productService;
    }

    // 등록
    @PostMapping("/api/v1/product")
    public ResponseEntity<Void> add(@RequestBody ProductDto dto){
        productService.add(dto);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/api/v1/products")
    public ResponseEntity<List<ProductDto>> getAll(){
        var result = productService.findAll();

        return  ResponseEntity.ok(result);
    }
}
