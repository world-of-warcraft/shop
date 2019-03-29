package com.mayikt.pay.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mayikt.base.BaseApiService;
import com.mayikt.mapper.MapperUtils;
import com.mayikt.pay.api.mapper.PaymentChannelMapper;
import com.mayikt.pay.api.mapper.entity.PaymentChannelEntity;
import com.mayikt.pay.api.service.PaymentChannelService;
import com.pay.output.dto.PaymentChannelDTO;

@RestController
public class PaymentChannelServiceImpl extends BaseApiService<List<PaymentChannelDTO>> implements PaymentChannelService {
	@Autowired
	private PaymentChannelMapper paymentChannelMapper;
	@Override
	public List<PaymentChannelDTO> selectAll() {
		List<PaymentChannelEntity> paymentChanneList = paymentChannelMapper.selectAll();
		return MapperUtils.mapAsList(paymentChanneList, PaymentChannelDTO.class);
	}

}
