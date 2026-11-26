package com.minierp.api_server.mapper;

import com.minierp.api_server.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void  insert(Order entity);
}
