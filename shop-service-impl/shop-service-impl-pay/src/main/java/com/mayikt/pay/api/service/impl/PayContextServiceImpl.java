package com.mayikt.pay.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.base.BaseApiService;
import com.mayikt.base.BaseResponse;
import com.mayikt.pay.api.factory.StrategyFactory;
import com.mayikt.pay.api.mapper.PaymentChannelMapper;
import com.mayikt.pay.api.mapper.entity.PaymentChannelEntity;
import com.mayikt.pay.api.service.PayContextService;
import com.mayikt.pay.api.service.PayMentTransacInfoService;
import com.mayikt.pay.api.strategy.PayStrategy;
import com.pay.output.dto.PayMentTransacDTO;

@RestController
public class PayContextServiceImpl extends BaseApiService<JSONObject> implements PayContextService {
	@Autowired
	private PaymentChannelMapper paymentChannelMapper;
	@Autowired
	private PayMentTransacInfoService payMentTransacInfoService;
	@Override
	public BaseResponse<JSONObject> toPayHtml(String channelId, String payToken) {
		// 1.使用渠道id获取渠道信息 classAddres
		PaymentChannelEntity paymentChannelEntity=paymentChannelMapper.getEntity(channelId);
		if(paymentChannelEntity==null) {
			return setResultError("没有查询到渠道信息");
		}
		// 2.使用payToken获取支付参数
		BaseResponse<PayMentTransacDTO> tokenByPayMentTransac=payMentTransacInfoService.tokenByPayMentTransac(payToken);
		if(!isSuccess(tokenByPayMentTransac)) {
			return setResultError(tokenByPayMentTransac.getMsg());
		}
		PayMentTransacDTO payMentTransacDTO = tokenByPayMentTransac.getData();
		// 3.执行具体的支付渠道的算法获取html表单数据 策略设计模式 使用java反射机制 执行具体方法
		String classAddress=paymentChannelEntity.getClassAddres();
		PayStrategy payStrategy = StrategyFactory.getPayStrategy(classAddress);
		// 4.直接返回html
		String payhtml=payStrategy.toPayHtml(paymentChannelEntity, payMentTransacDTO);
		JSONObject data=new JSONObject(); 
		data.put("payhtml",payhtml);
		return setResultSuccess(data);
	}

}
