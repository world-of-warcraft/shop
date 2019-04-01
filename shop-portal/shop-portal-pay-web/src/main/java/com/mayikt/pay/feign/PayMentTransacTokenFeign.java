package com.mayikt.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.pay.api.service.PayMentTransacTokenService;

@FeignClient("app-mayikt-pay")
public interface PayMentTransacTokenFeign extends PayMentTransacTokenService{

}
