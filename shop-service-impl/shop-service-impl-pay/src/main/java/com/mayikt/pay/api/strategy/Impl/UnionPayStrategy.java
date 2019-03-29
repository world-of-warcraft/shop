package com.mayikt.pay.api.strategy.Impl;

import org.springframework.stereotype.Component;

import com.mayikt.pay.api.mapper.entity.PaymentChannelEntity;
import com.mayikt.pay.api.strategy.PayStrategy;
import com.pay.output.dto.PayMentTransacDTO;

@Component
public class UnionPayStrategy implements PayStrategy {

	@Override
	public String toPayHtml(PaymentChannelEntity paymentChannelEntity, PayMentTransacDTO payMentTransacDTO) {
		return "银联支付成功";
	}

}
