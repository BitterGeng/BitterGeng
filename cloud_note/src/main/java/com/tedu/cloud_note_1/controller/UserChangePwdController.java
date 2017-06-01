package com.tedu.cloud_note_1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloud_note_1.service.UserService;
import com.tedu.cloud_note_1.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserChangePwdController {

	@Autowired
	UserService userService;

	@ResponseBody
	@RequestMapping("/changePassword.do")
	public NoteResult<Object> execute(String last_password,
			String new_password, String userName,HttpSession session) {
		NoteResult<Object> res = userService.changePassword(last_password,
				new_password, userName);
		if(res.getStatus()==0){
			session.setAttribute("password", new_password);
		}
		return res;

	}
}
