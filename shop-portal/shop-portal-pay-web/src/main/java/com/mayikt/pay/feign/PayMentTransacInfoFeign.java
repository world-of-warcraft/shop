package com.mayikt.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.pay.api.service.PayMentTransacInfoService;


@FeignClient("app-mayikt-pay")
public interface PayMentTransacInfoFeign extends PayMentTransacInfoService {

}
