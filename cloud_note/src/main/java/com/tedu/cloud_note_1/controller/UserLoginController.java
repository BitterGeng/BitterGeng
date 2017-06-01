package com.tedu.cloud_note_1.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloud_note_1.entity.User;
import com.tedu.cloud_note_1.service.UserService;
import com.tedu.cloud_note_1.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserLoginController {

	private static Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult<User> execute(String name,String password,
			HttpSession session){
		NoteResult<User> result = new NoteResult<User>();
		System.out.println(name);
		System.out.println(password);
		result = userService.checkLogin(name, password);
		if(result.getStatus()==0){
			session.setAttribute("name", name);
			session.setAttribute("password", password);
			session.setMaxInactiveInterval((int) (0.5*60));
		}
		logger.info("这是登录界面的controller日志输出");
		return result;
		
	}
	
}
