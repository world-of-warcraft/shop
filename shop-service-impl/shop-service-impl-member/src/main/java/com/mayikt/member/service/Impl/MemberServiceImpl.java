package com.mayikt.member.service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayikt.base.BaseApiService;
import com.mayikt.base.BaseResponse;
import com.mayikt.constants.Constants;
import com.mayikt.core.bean.BeanUtil;
import com.mayikt.core.token.GenerateToken;
import com.mayikt.core.type.TypeCastHelper;
import com.mayikt.member.MemberService;
import com.mayikt.member.feign.OrderServiceAppFeign;
import com.mayikt.member.mapper.UserMapper;
import com.mayikt.member.mapper.entity.UserDo;
import com.member.output.dto.UserOutDTO;

@RestController
public class MemberServiceImpl extends BaseApiService<UserOutDTO> implements MemberService{
	
	@Autowired
	OrderServiceAppFeign orderServiceAppFeign;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	private GenerateToken generateToken;

	@Override
	@PostMapping("/existMobile")
	public BaseResponse<UserOutDTO> existMobile(String mobile) {
		if(StringUtils.isBlank(mobile)) {
			return setResultError("手机号码未填写");
		}
		UserDo userDo=userMapper.existMobile(mobile);
		if(userDo==null) {
			return setResultError(Constants.HTTP_RES_CODE_NOTUSER_203, "该用户不存在");
		}
		return setResultSuccess(BeanUtil.doToDto(userDo, UserOutDTO.class));
	}

	@Override
	public BaseResponse<UserOutDTO> getInfo(String token) {
		// 1.验证token参数
		if (StringUtils.isEmpty(token)) {
			return setResultError("token不能为空!");
		}
		// 2.使用token查询redis 中的userId
		String redisUserId = generateToken.getToken(token);
		if (StringUtils.isEmpty(redisUserId)) {
			return setResultError("token已经失效或者token错误!");
		}
		// 3.使用userID查询 数据库用户信息
		Long userId = TypeCastHelper.toLong(redisUserId);
		UserDo userDo = userMapper.findByUserId(userId);
		if (userDo == null) {
			return setResultError("用户不存在!");
		}
		// 下节课将 转换代码放入在BaseApiService
		return setResultSuccess(BeanUtil.doToDto(userDo, UserOutDTO.class));
	}
	// token存放在PC端 cookie token 存放在安卓 或者IOS端 存放在本地文件中
	// 当前存在那些问题？ 用户如果退出或者修改密码、忘记密码的情况 对token状态进行标识
	// token 如何防止伪造 真正其实很难防御伪造 尽量实现在安全体系 xss 只能在一些某些业务模块上加上必须验证本人操作

}
