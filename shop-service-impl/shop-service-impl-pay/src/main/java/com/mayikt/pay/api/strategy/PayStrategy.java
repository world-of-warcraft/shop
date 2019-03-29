package com.mayikt.pay.api.strategy;

import com.mayikt.pay.api.mapper.entity.PaymentChannelEntity;
import com.pay.output.dto.PayMentTransacDTO;

public interface PayStrategy {

	/**
	 * 
	 * @param paymentChannelEntity
	 * @param payMentTransacDTO
	 * @return
	 */
	String toPayHtml(PaymentChannelEntity paymentChannelEntity,PayMentTransacDTO payMentTransacDTO );
}
