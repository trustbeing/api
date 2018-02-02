package com.waipan.api.util;

import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 15:23 2018/1/26
 * @Modified By:
 */
public class RequestHelper {

	public static Long getCurrentLoginId(HttpServletRequest request) {
		return (Long)request.getAttribute(Constants.CURRENT_LOGIN_ID);
	}

	public static Integer getCurrentLoginType(HttpServletRequest request) {
		return (Integer) request.getAttribute(Constants.CURRENT_LOGIN_TYPE);
	}
}
