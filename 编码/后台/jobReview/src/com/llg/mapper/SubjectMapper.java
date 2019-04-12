package com.llg.mapper;

import java.util.List;

import com.llg.bean.Subject;

public interface SubjectMapper {

	/**
	 * ���һ����Ŀ
	 * @author ������
	 * @date 2019��4��12�� ����6:07:23
	 * @param subject
	 */
	public void addSubject(Subject subject);
	
	
	/**
	 * ɾ��ָ����Ŀ
	 * @author ������
	 * @date 2019��4��12�� ����6:07:53
	 * @param id
	 */
	public void deleteSubject(Integer id);
	
	
	/**
	 * �޸���Ŀ
	 * @author ������
	 * @date 2019��4��12�� ����6:09:01
	 * @param subject
	 */
	public void updateSubject(Subject subject);
	
	
	/**
	 * ͨ��id������Ŀ
	 * @author ������
	 * @date 2019��4��12�� ����6:09:44
	 * @param id
	 * @return
	 */
	public Subject getSubjectById(Integer id);
	
	
	/**
	 * �����������Ŀ�б�
	 * @author ������
	 * @date 2019��4��12�� ����6:10:35
	 * @param tid
	 * @return
	 */
	public List<Subject> getSubjectLsit(Integer tid);
}
