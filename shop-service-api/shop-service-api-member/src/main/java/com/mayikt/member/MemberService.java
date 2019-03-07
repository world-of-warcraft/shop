package com.mayikt.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mayikt.base.BaseResponse;
import com.member.output.dto.UserOutDTO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

public interface MemberService {
		
	 /**
		 * 根据手机号码查询是否已经存在,如果存在返回当前用户信息
		 * 
		 * @param mobile
		 * @return
		 */
		@ApiOperation(value = "根据手机号码查询是否已经存在")
		@ApiImplicitParams({
				@ApiImplicitParam(paramType = "query", name = "mobile", dataType = "String", required = true, value = "用户手机号码"), })
		@PostMapping("/existMobile")
		BaseResponse<UserOutDTO> existMobile(@RequestParam("mobile") String mobile);
		
		/**
		 * 根据token查询用户信息
		 * 
		 * @param userEntity
		 * @return
		 */
		@GetMapping("/getUserInfo")
		@ApiOperation(value = "/getUserInfo")
		BaseResponse<UserOutDTO> getInfo(@RequestParam("token") String token);
	
}
