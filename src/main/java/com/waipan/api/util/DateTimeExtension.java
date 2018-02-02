package com.waipan.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 19:34 2018/1/26
 * @Modified By:
 */
public class DateTimeExtension {

	public  static String format(Date time){
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return timeFormat.format(time);
	}
}
