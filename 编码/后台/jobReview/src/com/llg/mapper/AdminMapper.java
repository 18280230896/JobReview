package com.llg.mapper;

import com.llg.bean.Admin;
import com.llg.bean.User;

/**
 * 
 * @author 罗龙贵
 * @Data 2019年4月9日 下午7:27:54
 */
public interface AdminMapper {
	
	/**
	 * 通过id查找管理员
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午7:28:25
	 * @return
	 */
	public Admin getAdminById(Integer id);
	
	/**
	 * 修改管理员信息
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午8:31:33
	 * @param user
	 */
	public void updateInfo(User user);
}
