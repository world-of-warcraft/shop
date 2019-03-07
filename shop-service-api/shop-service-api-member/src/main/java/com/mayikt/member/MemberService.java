package com.mayikt.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itmayi.member.entity.UserEntity;
import com.mayikt.base.BaseResponse;
import com.mayikt.order.entity.OrderEntity;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

public interface MemberService {
		
		@PostMapping("/memberInvokeOrder")
	 	BaseResponse<OrderEntity> memberInvokeOrder();
	 
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
		BaseResponse<UserEntity> existMobile(@RequestParam("mobile") String mobile);
	
}
