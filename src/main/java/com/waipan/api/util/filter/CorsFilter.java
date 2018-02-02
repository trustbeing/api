package com.waipan.api.util.filter;

import com.waipan.api.util.CollectionExtension;
import com.waipan.api.util.StringExtension;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:跨域访问处理(跨域资源共享),解决前后端分离架构中的跨域问
 * @Date: Created in 14:50 2018/1/24
 * @Modified By:
 */
public class CorsFilter implements Filter {

	private static final Logger logger = Logger.getLogger(CorsFilter.class);


	private String allowOrigin;
	private String allowMethods;
	private String allowCredentials;
	private String allowHeaders;

	public void init(FilterConfig filterConfig) throws ServletException {
		allowOrigin = filterConfig.getInitParameter("allowOrigin");
		allowMethods = filterConfig.getInitParameter("allowMethods");
		allowCredentials = filterConfig.getInitParameter("allowCredentials");
		allowHeaders = filterConfig.getInitParameter("allowHeaders");
	}

	/** 
	 * @Description: 通过CORS技术实现AJAX跨域访问,只要将CORS响应头写入response对象中即可
	 * @Author:WangChenGang
	 * @Date:2018/1/24 14:52
	 * @param:
	 * @return:
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setHeader("Access-Control-Allow-Origin", allowOrigin);

		
		response.setHeader("Access-Control-Allow-Credentials", allowCredentials);
		response.setHeader("Access-Control-Allow-Methods", allowMethods);
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", allowHeaders);

		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {

	}
}
