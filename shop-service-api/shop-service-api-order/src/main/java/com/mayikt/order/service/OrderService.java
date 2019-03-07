package com.mayikt.order.service;

import org.springframework.web.bind.annotation.GetMapping;

import com.mayikt.base.BaseResponse;
import com.mayikt.order.entity.OrderEntity;

public interface OrderService {
	@GetMapping("/getOrder")
	public BaseResponse<OrderEntity> getOrder();

}
