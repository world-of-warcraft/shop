package com.mayikt.member.service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmayi.member.entity.UserEntity;
import com.mayikt.base.BaseApiService;
import com.mayikt.base.BaseResponse;
import com.mayikt.constants.Constants;
import com.mayikt.member.MemberService;
import com.mayikt.member.feign.OrderServiceAppFeign;
import com.mayikt.member.mapper.UserMapper;
import com.mayikt.order.entity.OrderEntity;

@RestController
public class MemberServiceImpl extends BaseApiService<UserEntity> implements MemberService{
	
	@Autowired
	OrderServiceAppFeign orderServiceAppFeign;
	
	@Autowired
	UserMapper userMapper;

	@Override
	@GetMapping("/MemberInvokeOrder")
	public  BaseResponse<OrderEntity> memberInvokeOrder() {
		return orderServiceAppFeign.getOrder();
	}

	@Override
	@PostMapping("/existMobile")
	public BaseResponse<UserEntity> existMobile(String mobile) {
		if(StringUtils.isBlank(mobile)) {
			return setResultError("手机号码未填写");
		}
		UserEntity user=userMapper.existMobile(mobile);
		if(user==null) {
			return setResultError(Constants.HTTP_RES_CODE_EXISTMOBILE_404, "该用户不存在");
		}
		return setResultSuccess(user);
	}

}
