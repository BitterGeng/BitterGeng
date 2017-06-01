package com.tedu.cloud_note_1.service;

import org.springframework.stereotype.Service;

import com.tedu.cloud_note_1.entity.User;
import com.tedu.cloud_note_1.util.NoteResult;
@Service
public interface UserService {
	public NoteResult<User> checkLogin(String name,String password);
	
	public NoteResult<User> insert(String name,String nickname,String password);

	public NoteResult<Object> changePassword(String last_password,String new_password,
			String userName);
}
