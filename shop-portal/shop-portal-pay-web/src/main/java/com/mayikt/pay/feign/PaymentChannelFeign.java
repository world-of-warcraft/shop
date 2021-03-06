package com.mayikt.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.pay.api.service.PaymentChannelService;


@FeignClient("app-mayikt-pay")
public interface PaymentChannelFeign extends PaymentChannelService {

}
