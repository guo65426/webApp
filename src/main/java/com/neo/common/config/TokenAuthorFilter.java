package com.neo.common.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns = { "/*" }, filterName = "tokenAuthorFilter")
public class TokenAuthorFilter implements Filter {
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;

		// 设置允许跨域的配置
		// 这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
		rep.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的访问方法
		rep.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
		// Access-Control-Max-Age 用于 CORS 相关配置的缓存
		rep.setHeader("Access-Control-Max-Age", "86400");
		rep.setHeader("Access-Control-Allow-Headers", "token,Origin, X-Requested-With, Content-Type, Accept");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		chain.doFilter(request, response);
		return;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}