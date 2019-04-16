package com.llg.service;

import com.llg.bean.Subject;

public interface SubjectService {

	/**
	 * ���һ����Ŀ
	 * @author ������
	 * @date 2019��4��15�� ����6:56:09
	 * @param subject
	 */
	public void addSubject(Subject subject);
	
	
	/**
	 * ɾ��һ����Ŀ
	 * @author ������
	 * @date 2019��4��16�� ����9:11:52
	 * @param id
	 */
	public void deleteSubject(Integer id);
	
	
	/**
	 * �޸���Ŀ
	 * @author ������
	 * @date 2019��4��16�� ����9:12:32
	 * @param subject
	 */
	public void updateSubject(Subject subject);
	
	
	/**
	 * ͨ��id������Ŀ
	 * @author ������
	 * @date 2019��4��16�� ����9:13:26
	 * @param id
	 * @return
	 */
	public Subject getSubjectById(Integer id);
	
}
