package com.waipan.api.util.filter;

import com.waipan.api.model.dto.TokenModel;
import com.waipan.api.service.TokenManagerService;
import com.waipan.api.util.Constants;
import com.waipan.api.util.IpHelper;
import com.waipan.api.util.RequestHelper;
import com.waipan.api.util.annotation.Authorization;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:38 2018/1/26
 * @Modified By:
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private TokenManagerService tokenManagerService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//如果不是映射到方法直接通过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		//如果验证token失败，并且方法注明了Authorization，返回401错误
		if (method.getAnnotation(Authorization.class) != null) {

			//从header中得到token
			String authorization = request.getHeader(Constants.AUTHORIZATION);
			authorization = authorization.substring(7);
			//验证token
			TokenModel model = tokenManagerService.getToken(authorization);
			if (tokenManagerService.checkToken(model, IpHelper.getRequestIp(request))) {
				//如果token验证成功，将token对应的用户id存在request中，便于之后注入
				request.setAttribute(Constants.CURRENT_LOGIN_ID, model.getId());
				request.setAttribute(Constants.CURRENT_LOGIN_TYPE, model.getType());
				return true;
			}
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}

		return true;
	}
}
