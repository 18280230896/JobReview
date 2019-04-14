package com.llg.service;

import java.util.List;

import com.llg.bean.Student;

public interface StudentService {
	
	/**
	 * ���ѧ��
	 * @author ������
	 * @date 2019��4��13�� ����10:54:38
	 * @param student
	 */
	public int addStudent(Student student);
	
	
	/**
	 * ɾ��һ��ѧ��
	 * @author ������
	 * @date 2019��4��13�� ����10:55:08
	 * @param id
	 */
	public void deleteStudent(Integer id);
	
	
	/**
	 * �޸�ѧ����Ϣ
	 * @author ������
	 * @date 2019��4��13�� ����10:55:38
	 * @param student
	 */
	public void updateStudent(Student student);
	
	
	/**
	 * ��ȡ�༶��ѧ������
	 * @author ������
	 * @date 2019��4��13�� ����10:56:19
	 * @param cid �༶id
	 * @return
	 */
	public int getStudentTotal(Integer cid);
	
	
	/**
	 * ��ȡѧ���б�
	 * @author ������
	 * @date 2019��4��13�� ����10:57:31
	 * @param cid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Student> getStudentList(Integer cid,Integer startNum,Integer pageSize);
	
	
	/**
	 * �������ѧ��
	 * @author ������
	 * @date 2019��4��14�� ����9:27:48
	 * @param students
	 * @param cid
	 * @return
	 */
	public int batchAddStudent(List<Student> students,Integer cid);
}
