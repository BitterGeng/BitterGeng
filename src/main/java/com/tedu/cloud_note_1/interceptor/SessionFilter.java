package com.tedu.cloud_note_1.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {

		Logger logger = LoggerFactory.getLogger(SessionFilter.class);
		HttpServletRequest req = (HttpServletRequest) servletrequest;
		HttpServletResponse res = (HttpServletResponse) servletresponse;
		HttpSession session = req.getSession();
		String name = (String) session.getAttribute("name");
		System.out.println(name);
		String url = req.getRequestURI();
		if(url.equals("/cloud_note_1/user/login.do") || 
				url.equals("/cloud_note_1/user//regist.do") ||
				url.equals("/cloud_note_1/user/logout.do") ||
				url.equals("/cloud_note_1/log_in.html")){
			logger.info("放行的请求路径");
			filterchain.doFilter(servletrequest, servletresponse);
		}else{
			if (name == null) {
				String str = "<script language='javascript'>alert('会话过期,请重新登录');"
						+ "window.location.href=log_in.html;" + "</script>";
				res.setContentType("text/html;charset=UTF-8");
				PrintWriter pw = res.getWriter();
				pw.println(str);
				pw.flush();
				pw.close();
				logger.warn("Session 过期失效");
			} else {
				if(req.getHeader("x-requested-with") != null && req.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
					res.addHeader("sessionstatus", "timeOut");
				}
				logger.info("Session获取正常");
				filterchain.doFilter(servletrequest, servletresponse);
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
