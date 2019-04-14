package com.llg.mapper;

import java.util.List;

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
	
	
	/**
	 * ���һ��ѧ��
	 * @author ������
	 * @date 2019��4��13�� ����10:43:53
	 * @param student
	 */
	public void addStudent(Student student);
	
	
	/**
	 * ɾ��һ��ѧ��
	 * @author ������
	 * @date 2019��4��13�� ����10:44:19
	 * @param id
	 */
	public void deleteStudent(Integer id);
	
	
	/**
	 * ��ȡ�༶ѧ������
	 * @author ������
	 * @date 2019��4��13�� ����10:45:01
	 * @param cid
	 * @return
	 */
	public int getStudentTotal(Integer cid);
	
	
	/**
	 * ��ȡ�༶ѧ���б�
	 * @author ������
	 * @date 2019��4��13�� ����10:46:16
	 * @param cid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Student> getStudentList(Integer cid,Integer startNum,Integer pageSize);
}
