package com.llg.service;

import com.llg.bean.User;
/**
 * 
 * @author 罗龙贵
 * @Data 2019年4月9日 下午4:55:09
 */
public interface UserService {

	/**
	 * 登录验证
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午4:58:04
	 * @param username 用户名
	 * @param password 密码
	 * @return 
	 */
	public User login(String username,String password);
	
	/**
	 * 获取用户信息
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午7:15:00
	 * @param user
	 * @return
	 */
	public User getUserInfo(User user);
	
	/**
	 * 修改指定用户密码
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午8:21:30
	 * @param user
	 * @param newPassword
	 * @param oldPassword
	 * @return status=1表示修改成功，0表示旧密码错误
	 */
	public int updatePwd(User user,String newPassword,String oldPassword);
}
