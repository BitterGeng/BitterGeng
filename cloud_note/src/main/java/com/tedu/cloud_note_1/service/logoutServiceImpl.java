package com.tedu.cloud_note_1.service;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class logoutServiceImpl implements LogoutService{
	private static Logger logger = LoggerFactory.getLogger(logoutServiceImpl.class);

	public void logoutService(HttpSession session) {
		session.invalidate();
		logger.info("É¾³ýsession³É¹¦");
	}

}
