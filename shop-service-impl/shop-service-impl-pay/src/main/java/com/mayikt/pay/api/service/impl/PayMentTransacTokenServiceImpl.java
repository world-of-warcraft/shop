package com.mayikt.pay.api.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.base.BaseApiService;
import com.mayikt.base.BaseResponse;
import com.mayikt.core.token.GenerateToken;
import com.mayikt.pay.api.mapper.PaymentTransactionMapper;
import com.mayikt.pay.api.mapper.entity.PaymentTransactionEntity;
import com.mayikt.pay.api.service.PayMentTransacTokenService;
import com.mayikt.twitter.SnowflakeIdUtils;
import com.pay.input.dto.PayCratePayTokenDto;

@RestController
public class PayMentTransacTokenServiceImpl extends BaseApiService<JSONObject> implements PayMentTransacTokenService {
	
	@Autowired
	private PaymentTransactionMapper paymentTransactionMapper;

	@Autowired
	private GenerateToken generateToken;

	@Override
	public BaseResponse<JSONObject> cratePayToken(PayCratePayTokenDto payCratePayTokenDto) {
		String orderId=payCratePayTokenDto.getOrderId();
		if(StringUtils.isBlank(orderId)) {
			return setResultError("订单不能为空");
		}
		Long payAmount=payCratePayTokenDto.getPayAmount();
		if(null==payAmount) {
			return setResultError("支付金额不能为空");
		}
		Long userId=payCratePayTokenDto.getUserId();
		if(null==userId) {
			return setResultError("userId不能为空");
		}
		PaymentTransactionEntity paymentTransactionEntity=new PaymentTransactionEntity();
		paymentTransactionEntity.setOrderId(orderId);
		paymentTransactionEntity.setPayAmount(payAmount);
		paymentTransactionEntity.setUserId(userId);
		paymentTransactionEntity.setPaymentId(SnowflakeIdUtils.nextId());
		int result=paymentTransactionMapper.insertPaymentTransaction(paymentTransactionEntity);
		if(!toDaoResult(result)) {
			return setResultError("系统错误");
		}
		// 获取主键id
		Long payId = paymentTransactionEntity.getId();
		if (payId == null) {
			return setResultError("系统错误!");
		}
		String token = generateToken.createToken("pay_", payId + "");
		JSONObject dataResult = new JSONObject();
		dataResult.put("token", token);
		return setResultSuccess(dataResult);
	}

}
