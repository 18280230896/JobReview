package com.llg.mapper;

import java.util.List;

import com.llg.bean.Class;
import com.llg.bean.ClassTask;

public interface ClassTaskMapper {

	/**
	 * 添加一个班级任务
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:18:56
	 * @param classTask
	 */
	public void addClassTask(ClassTask classTask);
	
	
	/**
	 * 删除一个班级任务
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:19:34
	 * @param ctid
	 */
	public void deleteClassTask(Integer ctid);
	
	
	/**
	 * 修改一个班级任务
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:20:07
	 * @param classTask
	 */
	public void updateClassTask(ClassTask classTask);
	
	
	/**
	 * 通过id查找班级任务
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:20:46
	 * @param ctid
	 * @return
	 */
	public ClassTask geClassTaskById(Integer ctid);
	
	
	/**
	 * 获取指定班级的任务总数
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:22:03
	 * @param cid
	 * @return
	 */
	public int  getClassTaskTotal(Class c);
	
	
	/**
	 * 获取指定范围的任务列表
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:23:05
	 * @param cid
	 * @param startNum 从startNum开始
	 * @param pageSize 查询pageSize条数据
	 * @return
	 */
	public List<ClassTask> getClassTaskList(Integer cid,Integer semester,Integer startNum,Integer pageSize);
	
	
	/**
	 * 
	 * 获取班级所有的任务列表
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午5:01:39
	 * @param cid
	 * @return
	 */
	public List<ClassTask> getClassTaskAll(Integer cid);
	
	
	/**
	 * 获取指定执行指定任务的班级总数
	 * @author 罗龙贵
	 * @date 2019年4月15日 下午2:58:26
	 * @param tid
	 * @return
	 */
	public int getTaskClassTotal(Integer tid);
	
	
	/**
	 * 分页获取执行执行任务的班级列表
	 * @author 罗龙贵
	 * @date 2019年4月15日 下午3:01:44
	 * @param tid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<ClassTask> getTaskClassList(Integer tid,Integer startNum,Integer pageSize);
	
	
	/**
	 * 获取班级任务详情
	 * @author 罗龙贵
	 * @date 2019年4月16日 下午10:04:58
	 * @param ctid
	 * @return
	 */
	public ClassTask getClassTaskInfo(Integer ctid);
}
