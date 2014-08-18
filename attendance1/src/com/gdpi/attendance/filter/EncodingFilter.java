package com.gdpi.attendance.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 设置字符编码的过滤器，解决页面乱码的问题
 * @author think
 *
 */
public class EncodingFilter implements Filter {
	private static final String DEFALUT_ENCODING = "gb2312";
	private String encoding;

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// 设计编码
		request.setCharacterEncoding(encoding);
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//获得编码
		encoding = filterConfig.getInitParameter("encoding");
		if (encoding == null || "".equals(encoding)) {
			//获取不了，就用默认
			encoding = DEFALUT_ENCODING;
		}
	}

}
