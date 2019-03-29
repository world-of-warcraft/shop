package com.mayikt.pay.api.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mayikt.pay.api.strategy.PayStrategy;


public class StrategyFactory {
	private static Map<String, PayStrategy> strategyBean = new ConcurrentHashMap<String, PayStrategy>();

	public static PayStrategy getPayStrategy(String classAddress) {
		try {
			if(classAddress==null) {
				return null;
			}
			PayStrategy beanPayStrategy = strategyBean.get(classAddress);
			if (beanPayStrategy != null) {
				return beanPayStrategy;
			}
			Class<?> className=Class.forName(classAddress);
			PayStrategy payStrategy=(PayStrategy) className.newInstance();
			strategyBean.put(classAddress, payStrategy);
			return payStrategy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
