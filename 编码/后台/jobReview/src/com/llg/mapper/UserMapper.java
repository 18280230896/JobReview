package com.llg.mapper;

import com.llg.bean.User;

/**
 * 
 * @author ������
 * @Data 2019��4��9�� ����5:01:31
 */
public interface UserMapper {

	/**
	 * ��ѯ���ݿ��û����������Ƿ���ȷ
	 * @author ������
	 * @data 2019��4��9�� ����5:02:39
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	
	/**
	 * ͨ���û�����ȡ�û���Ϣ
	 * @author ������
	 * @date 2019��4��10�� ����8:25:06
	 * @param username
	 * @return
	 */
	public User getUserByUserName(String username);
	
}
