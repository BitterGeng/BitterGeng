package com.tedu.cloud_note_1.dao;

import com.tedu.cloud_note_1.entity.User;

public interface UserDao {
	//��¼����
	public User findByName(String name);
	
	//ע�Ṧ��
	public void regist(User user);
	
	//�޸�����
	public int changePassword(String new_password,String userName);
}
