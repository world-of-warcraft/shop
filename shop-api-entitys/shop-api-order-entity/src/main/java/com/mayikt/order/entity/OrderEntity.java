package com.mayikt.order.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "订单")
public class OrderEntity {
	@ApiModelProperty(value = "订单id")
	private String orderId;
	@ApiModelProperty(value = "订单名")
	private String orderName;

	public OrderEntity(String orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public OrderEntity() {
	}
	
	
}
