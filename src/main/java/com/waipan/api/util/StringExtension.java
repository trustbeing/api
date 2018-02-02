package com.waipan.api.util;

import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:字符串工具类
 * @Date: Created in 13:27 2018/1/24
 * @Modified By:
 */
public class StringExtension {

	/**
	 * @Description: 判断字符串是否为空或空字符串
	 * @Author:WangChenGang
	 * @Date:2018/1/24 13:38
	 * @param:
	 * @return:
	 */
	public static boolean isNotEmpty(String str){
		return str != null && str.length() != 0;
	}

	/** 
	 * @Description: 判断字符串是否为空或空串
	 * @Author:WangChenGang
	 * @Date:2018/1/24 13:41
	 * @param:
	 * @return:
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0 ||str.trim().length()==0;
	}

	public static String getEmpty(){
		return "";
	}


	public static <T> String join(String join,List<T> strAry){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<strAry.size();i++){
			if(i==(strAry.size()-1)){
				sb.append(strAry.get(i));
			}else{
				sb.append(strAry.get(i)).append(join);
			}
		}

		return new String(sb);
	}


}
