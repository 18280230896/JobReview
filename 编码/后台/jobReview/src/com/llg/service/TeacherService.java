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
	
	
	/**
	 * 添加教师
	 * @author 罗龙贵
	 * @date 2019年4月10日 上午8:36:50
	 * @param teacher
	 * @return返回1成功，返回其他失败，用户名已存在
	 */
	public int addTeacher(Teacher teacher);
	
	
	/**
	 * 删除指定教师
	 * @author 罗龙贵
	 * @date 2019年4月10日 上午9:08:51
	 * @param id  要删除教师的id
	 */
	public void deleteTeacher(Integer id);
	
	
	/**
	 * 修改指定教师的基本信息
	 * @author 罗龙贵
	 * @date 2019年4月10日 上午9:09:34
	 * @param teacher 要修改的教师
	 */
	public void updateTeacher(Teacher teacher);
}
