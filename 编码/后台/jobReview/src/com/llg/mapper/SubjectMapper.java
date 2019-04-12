package com.llg.mapper;

import java.util.List;

import com.llg.bean.Subject;

public interface SubjectMapper {

	/**
	 * 添加一个题目
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:07:23
	 * @param subject
	 */
	public void addSubject(Subject subject);
	
	
	/**
	 * 删除指定题目
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:07:53
	 * @param id
	 */
	public void deleteSubject(Integer id);
	
	
	/**
	 * 修改题目
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:09:01
	 * @param subject
	 */
	public void updateSubject(Subject subject);
	
	
	/**
	 * 通过id查找题目
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:09:44
	 * @param id
	 * @return
	 */
	public Subject getSubjectById(Integer id);
	
	
	/**
	 * 查找任务的题目列表
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:10:35
	 * @param tid
	 * @return
	 */
	public List<Subject> getSubjectLsit(Integer tid);
}
