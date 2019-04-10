package com.llg.service;

import java.util.List;

import com.llg.bean.Teacher;

/**
 * 
 * @author ������
 * @Date 2019��4��9�� ����9:24:55
 */
public interface TeacherService {

	/**
	 * ���ؽ�ʦ����
	 * @author ������
	 * @date 2019��4��9�� ����9:27:37
	 * @return
	 */
	public int getTeacherNum();
	
	/**
	 * ����ָ����Χ�ڵĽ�ʦ�б�
	 * @author ������
	 * @date 2019��4��9�� ����9:27:48
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Teacher> getTeacherList(Integer startNum,Integer pageSize);
	
	
	/**
	 * ��ӽ�ʦ
	 * @author ������
	 * @date 2019��4��10�� ����8:36:50
	 * @param teacher
	 * @return����1�ɹ�����������ʧ�ܣ��û����Ѵ���
	 */
	public int addTeacher(Teacher teacher);
	
	
	/**
	 * ɾ��ָ����ʦ
	 * @author ������
	 * @date 2019��4��10�� ����9:08:51
	 * @param id  Ҫɾ����ʦ��id
	 */
	public void deleteTeacher(Integer id);
	
	
	/**
	 * �޸�ָ����ʦ�Ļ�����Ϣ
	 * @author ������
	 * @date 2019��4��10�� ����9:09:34
	 * @param teacher Ҫ�޸ĵĽ�ʦ
	 */
	public void updateTeacher(Teacher teacher);
}
