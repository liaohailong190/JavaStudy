package org.liaohailong.weba;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
  *  来源过滤器
 * 
 * @author Administrator
 *
 */
public class RefererFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String referer = httpRequest.getHeader("referer");
		String serverName = httpRequest.getServerName();
		System.out.println("referer = " + referer + "  serverName = " + serverName);
		if (StringUtils.isEmpty(referer) || !referer.contains(serverName)) {
			httpRequest.getRequestDispatcher("/static/error.png").forward(httpRequest, httpResponse);
			return;
		}
		// 放行请求
		chain.doFilter(httpRequest, httpResponse);
	}

	public void destroy() {

	}

}
