package com.minierp.api_server.mapper;

import com.minierp.api_server.entity.OrderProduct;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderProductMapper {
    void insert(OrderProduct entity);
}
