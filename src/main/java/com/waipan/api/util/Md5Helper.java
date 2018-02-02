package com.waipan.api.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:23 2018/1/24
 * @Modified By:
 */
public class Md5Helper {

	public static String getMd5(String str){
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");

			md5.update(str.getBytes("gb2312"));
			byte[] hash =md5.digest();
			StringBuilder builder=  new StringBuilder();
			for(byte a : hash)
			{
				int b = a;
				if(b<0){
					b=b+256;
				}
				if (b < 16) {
					if (b < 10) builder.append(b);
					else builder.append(b - 10);
					builder.append(Integer.toHexString(b).toLowerCase());
				}
				else builder.append(Integer.toHexString(b).toLowerCase());
			}
			return builder.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
}
