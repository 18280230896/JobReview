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
	
	
	/**
	 * ��ȡû�з����ѧ���б�
	 * @author ������
	 * @date 2019��4��14�� ����4:26:16
	 * @param cid
	 * @return
	 */
	public List<Student> getNotGroupStudent(Integer cid);


	/**
	 * ͨ��id��ȡѧ��
	 * @author ������
	 * @date 2019��4��14�� ����4:43:19
	 * @param studentId
	 * @return
	 */
	public Student getStudentById(Integer studentId);
	
	
	/**
	 * ��ѧ����С�����Ƴ�
	 * @author ������
	 * @date 2019��4��14�� ����4:59:16
	 * @param studentId
	 * @param groupId
	 */
	public void removeGroupStudent(Integer studentId,Integer groupId);
	
	
	/**
	 * ��ȡѧ����ϸ��Ϣ
	 * @author ������
	 * @date 2019��4��16�� ����10:53:05
	 * @param studentId
	 * @return
	 */
	public Student getStudentInfo(Integer studentId);
	
	
	/**
	 * ͨ��ѧ�Ų���ѧ��
	 * @author ������
	 * @date 2019��4��25�� ����8:05:37
	 * @param num
	 * @return
	 */
	public boolean getStudentByNum(String num);
	
	
	/**
	 * ��ȡ�༶���е�ѧ��
	 * @author ������
	 * @date 2019��4��25�� ����9:47:19
	 * @param cid
	 * @return
	 */
	public List<Student> getStudentAll(Integer cid);
}
