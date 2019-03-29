package com.mayikt.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.member.service.QQAuthoriService;


@FeignClient("app-mayikt-member")
public interface QQAuthoriFeign extends QQAuthoriService {

}
