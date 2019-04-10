package com.llg.mapper;

import java.util.List;

import com.llg.bean.QueryVo;
import com.llg.bean.Teacher;
import com.llg.bean.User;

/**
 * 
 * @author 罗龙贵
 * @Data 2019年4月9日 下午7:33:33
 */
public interface TeacherMapper {

	/**
	 * 通过教师id查找教师
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午7:33:59
	 * @param id
	 * @return
	 */
	public Teacher getTeacherById(Integer id);
	
	/**
	 * 修改教师信息
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午8:43:26
	 * @param user
	 */
	public void updateInfo(User user);
	
	/**
	 * 获取教师总数
	 * @author 罗龙贵
	 * @date 2019年4月9日 下午9:38:35
	 * @return
	 */
	public int getTeacherNum();
	
	
	/**
	 * 获取指定范围内的教师列表
	 * @author 罗龙贵
	 * @date 2019年4月9日 下午9:38:38
	 * @param vo
	 * @return
	 */
	public List<Teacher> getTeacherList(QueryVo vo);
	
	/**
	 * 添加教师
	 * @author 罗龙贵
	 * @date 2019年4月10日 上午9:11:43
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher);
	
	/**
	 * 删除指定教师
	 * @author 罗龙贵
	 * @date 2019年4月10日 上午9:19:40
	 * @param id 要删除的教师的id
	 */
	public void deleteTeacher(Integer id);
}
