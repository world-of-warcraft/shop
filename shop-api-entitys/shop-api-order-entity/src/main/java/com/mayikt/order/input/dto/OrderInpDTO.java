package com.mayikt.order.input.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "订单")
public class OrderInpDTO {
	@ApiModelProperty(value = "订单id")
	private String orderId;
	@ApiModelProperty(value = "订单名")
	private String orderName;

	
	
}
