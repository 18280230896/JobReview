package com.llg.mapper;

import com.llg.bean.Student;
import com.llg.bean.User;

/**
 * 
 * @author ������
 * @Data 2019��4��9�� ����7:30:57
 */
public interface StudentMapper {

	/**
	 * ͨ��id����ѧ��
	 * @author ������
	 * @data 2019��4��9�� ����7:31:42
	 * @param id
	 * @return
	 */
	public Student getStudentById(Integer id);
	
	
	/**
	 * �޸�ѧ����Ϣ
	 * @author ������
	 * @data 2019��4��9�� ����8:36:11
	 * @param user
	 */
	public void updateInfo(User user);
}
