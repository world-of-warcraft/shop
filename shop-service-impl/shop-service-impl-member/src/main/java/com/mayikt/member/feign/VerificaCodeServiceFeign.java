package com.mayikt.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.wechat.service.VerificaCodeService;

@FeignClient(name="app-mayikt-wechat")
public interface VerificaCodeServiceFeign extends VerificaCodeService{

}
