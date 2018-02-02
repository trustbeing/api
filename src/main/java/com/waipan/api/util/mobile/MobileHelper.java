package com.waipan.api.util.mobile;

import com.waipan.api.util.StringExtension;
import com.waipan.api.util.Tool;

import java.util.Random;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:34 2018/1/25
 * @Modified By:
 */
public class MobileHelper {

	public static String setCode(String mobile, int length) {
		if(StringExtension.isEmpty(mobile)) return "";
		Random r = new Random();
		String code =String.valueOf(1000 + (int)(Math.random() *9000));
		if (length != 4)
		{
			code = Tool.generatePassword(length,true);
		}
		return code;
	}

	public static String hide(String mobile) {
		if(StringExtension.isEmpty(mobile) || mobile.length()!=11) return "";
		return mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
	}
}
