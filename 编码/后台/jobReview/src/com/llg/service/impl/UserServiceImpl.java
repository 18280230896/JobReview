package com.llg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.User;
import com.llg.mapper.UserMapper;
import com.llg.service.UserService;

/**
 * 
 * @author ������
 * @Data 2019��4��9�� ����4:58:52
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper usermaper;
	
	@Override
	public User login(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return usermaper.login(user);
	}

}
