package com.tedu.cloud_note_1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
//		Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
//		String url=request.getRequestURI();
		return true;
		
//		if(url.equals("/cloud_note_1/user/login.do") || 
//				url.equals("/cloud_note_1/user//regist.do") ||
//				url.equals("/cloud_note_1/user/logout.do")){
//			return true;
//		}else{
//			HttpSession session = request.getSession();
//			String name = (String) session.getAttribute("name");
//			if(name != null){
//				logger.info("µÇÂ¼¼ì²âÍ¨¹ý");
//				return true;
//			}else{
//				logger.warn("µÇÂ¼³¬Ê±");
//				response.sendRedirect("https://www.baidu.com");
//				return false;
//			}
//		}
//		
	}

	
}
