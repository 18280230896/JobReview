package com.llg.service;

import java.util.List;

import com.llg.bean.Student;

public interface StudentService {
	
	/**
	 * 添加学生
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午10:54:38
	 * @param student
	 */
	public int addStudent(Student student);
	
	
	/**
	 * 删除一个学生
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午10:55:08
	 * @param id
	 */
	public void deleteStudent(Integer id);
	
	
	/**
	 * 修改学生信息
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午10:55:38
	 * @param student
	 */
	public void updateStudent(Student student);
	
	
	/**
	 * 获取班级的学生数量
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午10:56:19
	 * @param cid 班级id
	 * @return
	 */
	public int getStudentTotal(Integer cid);
	
	
	/**
	 * 获取学生列表
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午10:57:31
	 * @param cid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Student> getStudentList(Integer cid,Integer startNum,Integer pageSize);
	
	
	/**
	 * 批量添加学生
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午9:27:48
	 * @param students
	 * @param cid
	 * @return
	 */
	public int batchAddStudent(List<Student> students,Integer cid);
	
	
	/**
	 * 获取没有分组的学生列表
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午4:26:16
	 * @param cid
	 * @return
	 */
	public List<Student> getNotGroupStudent(Integer cid);


	/**
	 * 通过id获取学生
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午4:43:19
	 * @param studentId
	 * @return
	 */
	public Student getStudentById(Integer studentId);
	
	
	/**
	 * 将学生从小组中移除
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午4:59:16
	 * @param studentId
	 * @param groupId
	 */
	public void removeGroupStudent(Integer studentId,Integer groupId);
	
	
	/**
	 * 获取学生详细信息
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午10:53:05
	 * @param studentId
	 * @return
	 */
	public Student getStudentInfo(Integer studentId);
	
	
	/**
	 * 通过学号查找学生
	 * @author 罗龙贵
	 * @date 2019年4月25日 下午8:05:37
	 * @param num
	 * @return
	 */
	public boolean getStudentByNum(String num);
	
	
	/**
	 * 获取班级所有的学生
	 * @author 罗龙贵
	 * @date 2019年4月25日 下午9:47:19
	 * @param cid
	 * @return
	 */
	public List<Student> getStudentAll(Integer cid);
}
