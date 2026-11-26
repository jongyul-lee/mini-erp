package com.minierp.api_server.controller;

import com.minierp.api_server.dto.product.ProductDto;
import com.minierp.api_server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService =  productService;
    }

    // 등록
    @PostMapping("/api/v1/product")
    public ResponseEntity<Void> add(@RequestBody ProductDto request){
        productService.add(request);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/api/v1/product/{name}")
    public ResponseEntity<Optional<ProductDto>> getByName(@PathVariable String name){
        var result = productService.findByName(name);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/api/v1/products")
    public ResponseEntity<List<ProductDto>> getAll(){
        var result = productService.findAll();

        return  ResponseEntity.ok(result);
    }
}
