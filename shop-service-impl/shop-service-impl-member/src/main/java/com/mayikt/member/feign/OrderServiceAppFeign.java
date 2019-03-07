package com.mayikt.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.order.service.OrderService;

@FeignClient(name = "app-mayikt-order")
public interface OrderServiceAppFeign extends OrderService{


}
