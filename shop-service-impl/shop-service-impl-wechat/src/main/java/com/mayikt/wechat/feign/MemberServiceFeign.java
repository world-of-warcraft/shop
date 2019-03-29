package com.mayikt.wechat.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.member.service.MemberService;

@FeignClient(name="app-mayikt-member")
public interface MemberServiceFeign extends MemberService {

}
