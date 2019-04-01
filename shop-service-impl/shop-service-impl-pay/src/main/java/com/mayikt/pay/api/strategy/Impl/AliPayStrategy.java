package com.mayikt.pay.api.strategy.Impl;

import java.math.BigDecimal;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.mayikt.pay.api.mapper.entity.PaymentChannelEntity;
import com.mayikt.pay.api.strategy.PayStrategy;
import com.pay.output.dto.PayMentTransacDTO;

public class AliPayStrategy implements PayStrategy{

	@Override
	public String toPayHtml(PaymentChannelEntity paymentChannelEntity, PayMentTransacDTO payMentTransacDTO) {
		AlipayClient alipayClient=new DefaultAlipayClient(
				"https://openapi.alipaydev.com/gateway.do", 
				"2016092500589521", 
				"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCSIozGYkLRN47ycZbCA8rvovn/ZCurNe6ZsrOdYODY9Zl5bI0W4nT9+WNwhBiTggSu+MQOZi4SXZVmuC2ckAGYAJKHcRxSKiEOxX5USHB2Zvz3zq+GIm1nowWng2bwf0Q2YuHQmKMJvbjnVjDjnjYZGvt6oxmbrn7wHP5nwFAJk7WW/pcExmoVPXDNh2pWV6xrSH7cKiLCpmAeJ39bGPbB2QCH339S1UhQ4E7NKxaLQgYtsTsK4/Du80glPH/W7hnHajyAvUHpaatdM4nQaWDTAiBmzMO0fl3z0yp0O27OAjNpJ3fFlG1OTFhbu3w37+bI84V/6Zaic5rvk0U68J8bAgMBAAECggEBAJG1hWxhmYIGxa+T9uAo6/YZKPCvrqMeOXRjLJjlegyahpb914hT8Jc0TSRpch/Sal0UilhZJeMGEOvFBSWwqQYou/H0pGqAu0mBPj9Ho2tLsTxdh8JVHYVSlVa7vK5cF2WrHsHhD9+snmt8E29B12sc7lcPvX7vdH5ySnCk3qlMbsPJ3Yfurchv2bTsr1MhkaHApcQT+6GjhS+xXqXffVRKK0IYzUSyWh0U4T1apUIx7rDeEBOqeUd4il1tF/pYZEvlI+Rs+9kUEKlV5HmEA51PuIpGZ9PYRflc4q4PvL+Vg2VB8PijEFVC2I07AZfgsqTBElOY/Npa+u+FG6B42SECgYEAx3tkK67h6ZWaxOHM7vlvGZnn3+9WOolvR+hD/Br2n2MOJw92iBX9K3w6HvbzRE9tKWuaQzViTpSclydo44V3iv9fyC0XCx3KzNcamHvDA69AjyX0+bJA18rWTOiO5la8InVjQd7EPeQOBAZcRXS6H46feOt//eodcWnBxn/B2EkCgYEAu4nZnOrk4RAwUujj++qAxQNPZqBRX6I33/buOt0qwGj46BsBlSSKdGIyP3eVs0wHsZlB6MKXC0xIcJQNpf0zpntYGCmuMHDXlOAJI8qxfEOH0InRAN61DQ13lJSSuH+Z/EGiqsb6hd4VH/BouP772baYkFmKlsGJKBQ/KPn05EMCgYBI7sMz+W+dcFYyr3+2y7mj+ZI+XIoBQuhNuQzKKq2KnrO48j1bCfcTJAs38QAGNKfroey3r9fudQU/emgt70lCp5XEYT/wj4brF6Ygo/cr7LJE5BLKDDMK8p0hZ1F/w6xrSNHublz/Z9b7/7tSpZe7G/EQS8Hy+tqi8ZCoW2NrCQKBgGwSoZQ7DRDh6mctDIzU88YVBUHH63zoF7j6LQlBAO0G0UG4pm3TM/Kjz/8hI+TCUMC45/GBideZ6zjtKPxZ8NTkybyK8HW74ZBKlxnIKgXJSNAVS5tru/w8oYe/ItottohXLq2pox9X/uZ7/W12i55ICp1M7H+6Ihc1q7wqZ0TPAoGAYx4zk+SxkTMdkNi7ZP15I6a+WaB1TB+kusOjq5Fdsb/y0gb+q58num/FAHJmYelQlyxtAZQpg8M8JkuH0bapNJMEq0T8xm9GwadBhZqrBfE0e0iNGILZPnlscpsIi297ZuurNCJz+/CXU7XFa07bhPKXKluW/UdhIBFhvzdqKVY=", 
				"json", 
				"UTF-8", 
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtn6ePkaLoTNDd5dqLNiGKtWF5nBbH89mJ87FQMNbRLOyNLJLKy3ln+degC7MT/bJ7Hwm+/7cqg2GaLzmpl25sD8kfxim94PBiJ+zEIKKzyVUScc7h0EzmdkymFRyCu3BOf6Xn7E0keCaw+aDCXH9s0eALOwKkA0+F0Z+mvgjBAwoNMK/IU620c4Df2OlqhCJzp1UvNzklgiwW3HqelKed0s9NTh4GjjT5sUYT9qsiKzdDw8CMmkf9E3uSq9ktONuokHEZhTFoxPL9b3MRwTQ1SPs+LwJuk8AQt9nBTV8xdT0n+M9ekfDUg5JL047TJhCRZjvmG/HFXJq0KOO6BPpHwIDAQAB", 
				"RSA2");
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
		 alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
		 alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
		// 商户订单号，商户网站订单系统中唯一订单号，必填
			String outTradeNo = payMentTransacDTO.getPaymentId();
			// 付款金额，必填
			String totalAmount = changeF2Y(payMentTransacDTO.getPayAmount() + "");
			// 订单名称，必填
			String subject = "每特教育微服务电商项目";
			// 商品描述，可空
			String body = "每特教育微服务电商项目";

			alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\"," + "\"total_amount\":\"" + totalAmount
					+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		    try {
		    	 String  form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
		    	 return form;
		    } catch (AlipayApiException e) {
		        e.printStackTrace();
		        return null;
		    }
		
	}
	
	/** 金额为分的格式 */
	public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";

	/**
	 * 将分为单位的转换为元 （除100）
	 * 
	 * @param amount
	 * @return
	 * @throws Exception
	 */
	public static String changeF2Y(String amount) {
		if (!amount.matches(CURRENCY_FEN_REGEX)) {
			return null;
		}
		return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();
	}

}
