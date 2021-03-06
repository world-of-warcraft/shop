package com.mayikt.unionpay.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mayikt.unionpay.acp.sdk.SDKConfig;


/**
 * 
 * 
 * 银联支付项目初始化
 */
@Component
public class InitUnionPayProject implements ApplicationRunner {

	// springboot 项目启动的时候 执行该方法
	@Override
	public void run(ApplicationArguments args) throws Exception {
		SDKConfig.getConfig().loadPropertiesFromSrc();
	}
}
