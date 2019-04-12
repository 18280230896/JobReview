package com.llg.service;

import java.util.List;

import com.llg.bean.Class;

/**
 * 用于处理对班级表的crud操作
 * @author 罗龙贵
 * @Date 2019年4月12日 下午2:59:39
 */
public interface ClassService {

	/**
	 * 查询并返回指定教师所创的班级数量
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午3:00:43
	 * @param tid 教师id
	 * @return
	 */
	public int getClassTotal(Integer tid);
	
	/**
	 * 查询并返回指定教师指定范围的班级列表
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午3:02:58
	 * @param tid  教师id
	 * @param startNum 从startNum开始
	 * @param pageSize  查询pageSize条数据
	 * @return
	 */
	public List<Class> getClassList(Integer tid,Integer startNum,Integer pageSize);
	
	/**
	 * 添加一个指定教师的班级
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午3:05:15
	 * @param tid 教师id
	 */
	public void addClass(Class c);
	
	/**
	 * 删除指定班级
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午3:06:08
	 * @param cid 要删除的班级id
	 */
	public void deleteClass(Integer cid);
	
	/**
	 * 修改指定班级信息
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午3:06:52
	 * @param c 包含要修改的班级id和修改后的各项属性
	 */
	public void updateClass(Class c);
	


	/**
	 * 通过id查找班级
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午3:07:58
	 * @param cid  班级id
	 * @return
	 */
	public Class getClassById(Integer cid);
}
