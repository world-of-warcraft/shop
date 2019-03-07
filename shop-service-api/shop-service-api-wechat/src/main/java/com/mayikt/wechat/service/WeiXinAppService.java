package com.mayikt.wechat.service;

import org.springframework.web.bind.annotation.GetMapping;

import com.mayikt.base.BaseResponse;
import com.mayikt.wachat.entity.AppEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 
 * @description:微信服务接口
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */
@Api(tags = "微信服务接口")
public interface WeiXinAppService {

	/**
	 * 功能说明： 应用服务接口
	 */
	@ApiOperation(value = "微信应用服务接口")
	@GetMapping("/getApp")
	public BaseResponse<AppEntity> getApp();

}
