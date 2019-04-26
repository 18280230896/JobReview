package com.llg.mapper;

import java.util.List;

import com.llg.bean.Student;
import com.llg.bean.User;

/**
 * 
 * @author 罗龙贵
 * @Data 2019年4月9日 下午7:30:57
 */
public interface StudentMapper {

	/**
	 * 通过id查找学生
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午7:31:42
	 * @param id
	 * @return
	 */
	public Student getStudentById(Integer id);
	
	
	/**
	 * 修改学生信息
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午8:36:11
	 * @param user
	 */
	public void updateInfo(User user);
	
	
	/**
	 * 添加一个学生
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午10:43:53
	 * @param student
	 */
	public void addStudent(Student student);
	
	
	/**
	 * 删除一个学生
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午10:44:19
	 * @param id
	 */
	public void deleteStudent(Integer id);
	
	
	/**
	 * 获取班级学生数量
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午10:45:01
	 * @param cid
	 * @return
	 */
	public int getStudentTotal(Integer cid);
	
	
	/**
	 * 获取班级学生列表
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午10:46:16
	 * @param cid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Student> getStudentList(Integer cid,Integer startNum,Integer pageSize);
	
	
	/**
	 * 获取班级中所有没分组的学生
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午4:23:37
	 * @param cid
	 * @return
	 */
	public List<Student> getNotGroupStudent(Integer cid);
	
	
	/**
	 * 修改学生信息
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午4:58:05
	 * @param student
	 */
	public void updateStudent(Student student);
	
	/**
	 * 获取学生的详细信息
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午10:50:06
	 * @param id
	 * @return
	 */
	public Student getStudentInfo(Integer id);
	
	/**
	 * 通过学号查找学生
	 * @author 罗龙贵
	 * @date 2019年4月25日 下午8:02:21
	 * @param num
	 * @return
	 */
	public Student getStudentByNum(String num);
	
	
	/**
	 * 获取班级所有学生
	 * @author 罗龙贵
	 * @date 2019年4月25日 下午9:45:44
	 * @param cid
	 * @return
	 */
	public List<Student> getStudentAll(Integer cid);
}
