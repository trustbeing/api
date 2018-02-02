package com.waipan.api.util;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 15:33 2018/1/25
 * @Modified By:
 */
public class Tool {

	public static String generatePassword(int length,boolean isSample){
		if (length <= 0)
			length = 10;
		if (length > 32)
			length = 32;
		String chars = "23456789abcdefghijkmnpqrstuvwxyz@#$%&*";
		if (isSample)
		{
			chars = "23456789abcdefghijkmnpqrstuvwxyz";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++)
		{
			char c = chars.charAt((int)(Math.random() * chars.length()));
			sb.append(c);
		}
		return sb.toString();
	}
}
