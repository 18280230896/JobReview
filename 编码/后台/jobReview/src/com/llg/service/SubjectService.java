package com.llg.service;

import com.llg.bean.Subject;

public interface SubjectService {

	/**
	 * 添加一个题目
	 * @author 罗龙贵
	 * @date 2019年4月15日 下午6:56:09
	 * @param subject
	 */
	public void addSubject(Subject subject);
	
	
	/**
	 * 删除一个题目
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午9:11:52
	 * @param id
	 */
	public void deleteSubject(Integer id);
	
	
	/**
	 * 修改题目
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午9:12:32
	 * @param subject
	 */
	public void updateSubject(Subject subject);
	
	
	/**
	 * 通过id查找题目
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午9:13:26
	 * @param id
	 * @return
	 */
	public Subject getSubjectById(Integer id);
	
}
