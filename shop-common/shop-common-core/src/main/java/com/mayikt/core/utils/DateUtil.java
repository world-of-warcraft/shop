package com.mayikt.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 获取现在时间
	 * @return返回字符串格式yyyyMMddHHmmss
	 */
	public static String getStringDate() {
		Date nowDate=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString =formatter.format(nowDate);
		return dateString;
	}
}
