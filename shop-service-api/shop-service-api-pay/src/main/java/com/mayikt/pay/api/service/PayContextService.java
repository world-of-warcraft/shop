package com.mayikt.pay.api.service;

import org.springframework.web.bind.annotation.GetMapping;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.base.BaseResponse;

public interface PayContextService {
	@GetMapping("/toPayHtml")
	public BaseResponse<JSONObject> toPayHtml(String channelId, String payToken);
}
