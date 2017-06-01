package com.tedu.cloud_note_1.dao;

import com.tedu.cloud_note_1.entity.User;

public interface UserDao {
	//登录功能
	public User findByName(String name);
	
	//注册功能
	public void regist(User user);
	
	//修改密码
	public int changePassword(String new_password,String userName);
}
