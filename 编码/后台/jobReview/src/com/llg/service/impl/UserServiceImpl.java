package com.llg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.User;
import com.llg.mapper.AdminMapper;
import com.llg.mapper.StudentMapper;
import com.llg.mapper.TeacherMapper;
import com.llg.mapper.UserMapper;
import com.llg.service.UserService;

/**
 * 
 * @author 罗龙贵
 * @Data 2019年4月9日 下午4:58:52
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper usermaper;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public User login(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return usermaper.login(user);
	}

	@Override
	public User getUserInfo(User user) {
		if(user == null || user.getId() == null) return null;
		if(user.getRole() == 1) return adminMapper.getAdminById(user.getId());
		if(user.getRole() == 2) return teacherMapper.getTeacherById(user.getId());
		if(user.getRole() == 3) return studentMapper.getStudentById(user.getId());
		return null;
	}

	@Override
	public int updatePwd(User user, String newPassword, String oldPassword) {
		//获取用户信息
		User user2 = null;
		if(user.getRole() == 1) user2 = adminMapper.getAdminById(user.getId());
		if(user.getRole() == 2) user2 = teacherMapper.getTeacherById(user.getId());
		if(user.getRole() == 3) user2 = studentMapper.getStudentById(user.getId());
		//判断旧密码是否正确
		if(user != null && user.getUsername().equals(oldPassword)){
			//修改密码
			user2.setPassword(newPassword);
			if(user.getRole() == 1) adminMapper.updateInfo(user2);
			if(user.getRole() == 2) teacherMapper.updateInfo(user2);
			if(user.getRole() == 3) studentMapper.updateInfo(user2);
			return 1;
		}
		return 0;
	}

}
