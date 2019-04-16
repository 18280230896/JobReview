package com.llg.service;

import java.util.List;

import com.llg.bean.Task;

public interface TaskService {

	/**
	 * 添加任务
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:20:52
	 * @param task
	 */
	public void addTask(Task task);
	
	
	/**
	 * 删除任务
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:21:37
	 * @param id
	 */
	public void deleteTask(Integer id);
	
	/**
	 * 修改任务
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:22:04
	 * @param task
	 */
	public void updateTask(Task task);
	
	
	/**
	 * 获取任务详情
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:23:03
	 * @param id
	 * @return
	 */
	public Task getTaskInfo(Integer id);
	
	
	/**
	 * 获取教师创建的任务数量
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:24:15
	 * @param tid 教师id
	 * @return
	 */
	public int getTaskTotal(Integer tid);
	
	
	/**
	 * 分页获取任务列表
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:25:28
	 * @param tid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Task> getTaskList(Integer tid,Integer startNum,Integer pageSize);
	
	
	/**
	 * 通过id获取任务信息
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午6:42:48
	 * @param id
	 * @return
	 */
	public Task getTaskById(Integer id);
	
	
}
