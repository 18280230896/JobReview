package com.llg.mapper;

import com.llg.bean.Admin;
import com.llg.bean.User;

/**
 * 
 * @author ������
 * @Data 2019��4��9�� ����7:27:54
 */
public interface AdminMapper {
	
	/**
	 * ͨ��id���ҹ���Ա
	 * @author ������
	 * @data 2019��4��9�� ����7:28:25
	 * @return
	 */
	public Admin getAdminById(Integer id);
	
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @author ������
	 * @data 2019��4��9�� ����8:31:33
	 * @param user
	 */
	public void updateInfo(User user);
}
