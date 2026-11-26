package com.minierp.api_server.dto.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ProductDto {
    private Long id;
    private String name;
    private Integer price;
    private Integer stockQuantity;
}
