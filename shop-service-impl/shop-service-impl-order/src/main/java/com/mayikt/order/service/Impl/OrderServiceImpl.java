package com.mayikt.order.service.Impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayikt.base.BaseApiService;
import com.mayikt.base.BaseResponse;
import com.mayikt.order.entity.OrderEntity;
import com.mayikt.order.service.OrderService;

@RestController
public class OrderServiceImpl extends BaseApiService<OrderEntity> implements OrderService{

	@Override
	@GetMapping("/getOrder")
	public BaseResponse<OrderEntity> getOrder() {
		return setResult(200,"success", new OrderEntity("XXX","XXX"));
	}

}
