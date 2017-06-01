package com.tedu.cloud_note_1.service;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.cloud_note_1.dao.UserDao;
import com.tedu.cloud_note_1.entity.User;
import com.tedu.cloud_note_1.util.NoteResult;
import com.tedu.cloud_note_1.util.Util;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserDao userDao;
	
	public NoteResult<User> checkLogin(String name, String password) {
		//����¼
		User user = userDao.findByName(name);
		NoteResult<User> result = new NoteResult<User>();
		if(user == null){
			result.setStatus(1);
			result.setMsg("�û���������");
			logger.warn("�û���������");
			return result;
		}
		
		//���벻��
		if(!password.equals(user.getCn_user_password())){
			result.setStatus(2);
			result.setMsg("�������");
			logger.warn("�������");
			return result;
		}
		
		//��¼�ɹ�
		result.setStatus(0);
		result.setMsg("��¼�ɹ�");
		result.setData(user);
		logger.info("��¼�ɹ�");
		return result;
	}

	public NoteResult<User> insert(String name,String nickname,String password) {
		//�Ȳ��û����Ƿ����
		User user = userDao.findByName(name);
		NoteResult<User> result = new NoteResult<User>();
		if(user != null){
			result.setStatus(1);
			result.setMsg("�û����Ѿ�����");
			logger.warn("�û����Ѿ�������");
			return result;
		}
		
		user = new User();
		user.setCn_user_name(name);
		user.setCn_user_nick(nickname);
		user.setCn_user_password(password);
		String id = Util.createId();
		user.setCn_user_id(id);
		userDao.regist(user);
		result.setStatus(0);
		result.setMsg("ע��ɹ�");
		result.setData(user);
		logger.info("ע��ɹ�");
		return result;
	}

	
	//�޸�����
	public NoteResult<Object> changePassword(String last_password,
			String new_password, String userName) {
		User user=userDao.findByName(userName);
		String password=user.getCn_user_password();
		NoteResult<Object> res = new NoteResult<Object>();
		if(password.equals(last_password)){
			int rows=userDao.changePassword(new_password, userName);
			if(rows == 1){
				res.setStatus(0);
				res.setMsg("�޸ĳɹ�");
				logger.info("�޸�����ɹ�");
			}else{
				res.setStatus(1);
				res.setData("�޸�����ʧ��");
				logger.warn("�޸�����ʧ��");
			}
		}else{
			res.setStatus(1);
			res.setData("�޸�����ʧ��");
			logger.warn("�޸�����ʧ��");
		}
		return res;
	}


	
}
