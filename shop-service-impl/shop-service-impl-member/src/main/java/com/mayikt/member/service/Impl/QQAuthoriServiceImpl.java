package com.mayikt.member.service.Impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.base.BaseApiService;
import com.mayikt.base.BaseResponse;
import com.mayikt.constants.Constants;
import com.mayikt.core.token.GenerateToken;
import com.mayikt.member.QQAuthoriService;
import com.mayikt.member.mapper.UserMapper;
import com.mayikt.member.mapper.entity.UserDo;

@RestController
public class QQAuthoriServiceImpl extends BaseApiService<JSONObject> implements QQAuthoriService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private GenerateToken generateToken;

	@Override
	public BaseResponse<JSONObject> findByOpenId(String qqOpenId) {
		if (StringUtils.isEmpty(qqOpenId)) {
			return setResultError("qqOpenId不能为空!");
		}
		// 1.根据openid查询用户信息
		UserDo userDo = userMapper.findByOpenId(qqOpenId);
		if (userDo == null) {
			return setResultError(Constants.HTTP_RES_CODE_NOTUSER_203, "根据qqOpenId没有查询到用户信息");
		}
		// 2.如果能够查询到用户信息,则直接生成对应的用户令牌
		String keyPrefix = Constants.MEMBER_TOKEN_KEYPREFIX + Constants.HTTP_RES_CODE_QQ_LOGINTYPE;
		Long userId = userDo.getUserId();
		String userToken = generateToken.createToken(keyPrefix, userId + "");
		JSONObject data = new JSONObject();
		data.put("token", userToken);
		return setResultSuccess(data);
	}

}
