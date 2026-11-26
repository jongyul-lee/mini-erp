package com.minierp.api_server.service;

import com.minierp.api_server.dto.ProductDto;
import com.minierp.api_server.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Transactional
    public void add(ProductDto dto) {

        // 상품이름 조회 후, 같은 이름의 상품이 있다면 throw
        if(productMapper.findByName(dto.getName()).isPresent()){
            throw new IllegalArgumentException("이미 존재하는 상품입니다.");
        }

        productMapper.insert(dto);
    }


    public List<ProductDto> findAll() {

        return productMapper.findAll();
    }

    public Optional<ProductDto> findByName(String name) {
        return productMapper.findByName(name);
    }
}
