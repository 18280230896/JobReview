package com.llg.mapper;

import java.util.List;

import com.llg.bean.SubjectStudent;

public interface SubjectStudentMapper {

	/**
	 * 添加一个小组分工
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午9:58:33
	 * @param subjectStudent
	 */
	public void addDivision(SubjectStudent subjectStudent);
	

	/**
	 * 删除一个小组分工
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:01:37
	 * @param id
	 */
	public void deleteDivision(Integer id);
	
	
	/**
	 * 通过id获取分工信息
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:05:05
	 * @param id
	 * @return
	 */
	public SubjectStudent getById(Integer id);
	
	
	/**
	 * 获取某个题目的分工学生列表
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:06:00
	 * @param sid
	 * @param gid
	 * @return
	 */
	public List<SubjectStudent> getDivivionList(Integer sid,Integer gid);
	
	
	/**
	 * 通过题目id和学生id查找分工信息
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:30:57
	 * @param subjectId
	 * @param studentId
	 * @return
	 */
	public SubjectStudent getSubjectStudentById(Integer subjectId,Integer studentId);
	
}
