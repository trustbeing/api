package com.waipan.api.util.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class XssFilter implements Filter {

	FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
	}

	public void destroy() {
		this.filterConfig = null;
	}
}
