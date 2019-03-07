package com.mayikt.wachat.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @description: App实体类层
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */
@Data
@ApiModel(value = "公众号")
public class AppEntity {

	/**
	 * appid
	 */ 
	@ApiModelProperty(value = "公众号id")
	private String appId;
	/**
	 * 应用名称
	 */
	@ApiModelProperty(value = "公众号名称")
	private String appName;

	public AppEntity() {

	}

	public AppEntity(String appId, String appName) {
		super();
		this.appId = appId;
		this.appName = appName;
	}

}
