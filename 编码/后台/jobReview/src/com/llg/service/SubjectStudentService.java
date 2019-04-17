package com.llg.service;

import java.util.List;

import com.llg.bean.SubjectStudent;

public interface SubjectStudentService {

	/**
	 * 添加一个分工信息
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:13:37
	 * @param student
	 */
	public void addDivision(SubjectStudent student);
	
	
	/**
	 * 批量添加分工信息
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:15:03
	 * @param subjectStudents
	 */
	public void addBatchDivision(List<SubjectStudent> subjectStudents);
	
	
	/**
	 * 删除一个分工信息
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:15:39
	 * @param id
	 */
	public void deleteDivision(Integer id);
	
	
	/**
	 * 删除多个分工信息
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:16:15
	 * @param ids
	 */
	public void deleteBatchDivision(Integer[] ids);
	
	
	/**
	 * 获取某个题目的分工列表
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:17:12
	 * @param sid 题目id
	 * @param gid 小组id
	 */
	public List<SubjectStudent> getDivisionList(Integer sid,Integer gid);
	
}
