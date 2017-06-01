package com.tedu.cloud_note_1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloud_note_1.service.LogoutService;
import com.tedu.cloud_note_1.util.NoteResult;

@Controller
@RequestMapping("/user")
public class LogoutController {

	@Autowired
	LogoutService logoutService;
	
	@ResponseBody
	@RequestMapping("/logout.do")
	public NoteResult<Object> ogOut(HttpSession session){
		logoutService.logoutService(session);
		NoteResult<Object> res = new NoteResult<Object>();
		res.setStatus(0);
		res.setMsg("×¢Ïú³É¹¦");
		return res;
	}
}
