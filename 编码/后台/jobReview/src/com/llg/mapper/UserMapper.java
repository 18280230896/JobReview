package com.llg.mapper;

import com.llg.bean.User;

/**
 * 
 * @author 罗龙贵
 * @Data 2019年4月9日 下午5:01:31
 */
public interface UserMapper {

	/**
	 * 查询数据库用户名或密码是否正确
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午5:02:39
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	
	/**
	 * 通过用户名获取用户信息
	 * @author 罗龙贵
	 * @date 2019年4月10日 上午8:25:06
	 * @param username
	 * @return
	 */
	public User getUserByUserName(String username);
	
}
