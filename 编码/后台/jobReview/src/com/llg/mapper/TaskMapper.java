package com.llg.mapper;

import java.util.List;

import com.llg.bean.Task;

/**
 * @author 罗龙贵
 * @Date 2019年4月12日 下午4:53:56
 */
public interface TaskMapper {

	/**
	 * 添加任务
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午5:11:28
	 * @param task
	 */
	public void addTask(Task task);
	
	
	/**
	 * 删除任务
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午5:12:15
	 * @param id 要删除的任务id
	 */
	public void deleteTask(Integer id);
	
	/**
	 * 修改任务信息
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午5:14:18
	 * @param task 要修改的任务
	 */
	public void updateTask(Task task);
	
	
	/**
	 * 根据任务id，查找任务
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午5:15:43
	 * @param id
	 * @return
	 */
	public Task getTaskById(Integer id);
	
	
	/**
	 * 查找指定教师所创建的任务数量
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午5:16:18
	 * @param tid 教师id
	 * @return
	 */
	public int getTaskTotal(Integer tid);
	
	
	/**
	 * 分页查找任务列表
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午5:18:42
	 * @param tid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Task> getTaskList(Integer tid,Integer startNum,Integer pageSize);
	
	
	/**
	 * 获取所有的任务列表
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午11:46:52
	 * @param tid
	 * @return
	 */
	public List<Task> getTaskListAll(Integer tid);
	
	
	/**
	 * 获取任务详细信息
	 * @author 罗龙贵
	 * @date 2019年4月15日 下午2:37:54
	 * @param id
	 * @return
	 */
	public Task getTaskInfo(Integer id);
	
	
}
