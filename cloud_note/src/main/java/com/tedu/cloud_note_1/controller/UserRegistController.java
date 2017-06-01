package com.tedu.cloud_note_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloud_note_1.entity.User;
import com.tedu.cloud_note_1.service.UserService;
import com.tedu.cloud_note_1.util.NoteResult;
@Controller
@RequestMapping("/user")
public class UserRegistController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public NoteResult<User> execute(String userName,String nickName,String password){
		NoteResult<User> result  = userService.insert(userName, nickName, password);
		return result;
		
	}
}
