package com.minierp.api_server.mapper;

import com.minierp.api_server.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper {

    void add(ProductDto dto);
    Optional<ProductDto> findByName(String name);
    List<ProductDto> getAll();
}
