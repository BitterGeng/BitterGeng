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
		//检测登录
		User user = userDao.findByName(name);
		NoteResult<User> result = new NoteResult<User>();
		if(user == null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			logger.warn("用户名不存在");
			return result;
		}
		
		//密码不对
		if(!password.equals(user.getCn_user_password())){
			result.setStatus(2);
			result.setMsg("密码错误");
			logger.warn("密码错误");
			return result;
		}
		
		//登录成功
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		logger.info("登录成功");
		return result;
	}

	public NoteResult<User> insert(String name,String nickname,String password) {
		//先查用户名是否存在
		User user = userDao.findByName(name);
		NoteResult<User> result = new NoteResult<User>();
		if(user != null){
			result.setStatus(1);
			result.setMsg("用户名已经存在");
			logger.warn("用户名已经存在了");
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
		result.setMsg("注册成功");
		result.setData(user);
		logger.info("注册成功");
		return result;
	}

	
	//修改密码
	public NoteResult<Object> changePassword(String last_password,
			String new_password, String userName) {
		User user=userDao.findByName(userName);
		String password=user.getCn_user_password();
		NoteResult<Object> res = new NoteResult<Object>();
		if(password.equals(last_password)){
			int rows=userDao.changePassword(new_password, userName);
			if(rows == 1){
				res.setStatus(0);
				res.setMsg("修改成功");
				logger.info("修改密码成功");
			}else{
				res.setStatus(1);
				res.setData("修改密码失败");
				logger.warn("修改密码失败");
			}
		}else{
			res.setStatus(1);
			res.setData("修改密码失败");
			logger.warn("修改密码失败");
		}
		return res;
	}


	
}
