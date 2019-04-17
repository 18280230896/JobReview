package com.llg.mapper;

import java.util.List;

import com.llg.bean.SubjectStudent;

public interface SubjectStudentMapper {

	/**
	 * ���һ��С��ֹ�
	 * @author ������
	 * @date 2019��4��17�� ����9:58:33
	 * @param subjectStudent
	 */
	public void addDivision(SubjectStudent subjectStudent);
	

	/**
	 * ɾ��һ��С��ֹ�
	 * @author ������
	 * @date 2019��4��17�� ����10:01:37
	 * @param id
	 */
	public void deleteDivision(Integer id);
	
	
	/**
	 * ͨ��id��ȡ�ֹ���Ϣ
	 * @author ������
	 * @date 2019��4��17�� ����10:05:05
	 * @param id
	 * @return
	 */
	public SubjectStudent getById(Integer id);
	
	
	/**
	 * ��ȡĳ����Ŀ�ķֹ�ѧ���б�
	 * @author ������
	 * @date 2019��4��17�� ����10:06:00
	 * @param sid
	 * @param gid
	 * @return
	 */
	public List<SubjectStudent> getDivivionList(Integer sid,Integer gid);
	
	
	/**
	 * ͨ����Ŀid��ѧ��id���ҷֹ���Ϣ
	 * @author ������
	 * @date 2019��4��17�� ����10:30:57
	 * @param subjectId
	 * @param studentId
	 * @return
	 */
	public SubjectStudent getSubjectStudentById(Integer subjectId,Integer studentId);
	
}
