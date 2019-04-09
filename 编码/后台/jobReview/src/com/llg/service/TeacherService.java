package com.llg.service;

import java.util.List;

import com.llg.bean.Teacher;

/**
 * 
 * @author 罗龙贵
 * @Date 2019年4月9日 下午9:24:55
 */
public interface TeacherService {

	/**
	 * 返回教师总数
	 * @author 罗龙贵
	 * @date 2019年4月9日 下午9:27:37
	 * @return
	 */
	public int getTeacherNum();
	
	/**
	 * 返回指定范围内的教师列表
	 * @author 罗龙贵
	 * @date 2019年4月9日 下午9:27:48
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Teacher> getTeacherList(Integer startNum,Integer pageSize);
}
