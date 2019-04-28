package com.llg.service;

import java.util.List;

import com.llg.bean.Class;
import com.llg.bean.ClassTask;
import com.llg.bean.Task;

public interface ClassTaskService {

	/**
	 * 添加班级任务
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:42:48
	 * @param classTask
	 */
	public void addClassTask(ClassTask classTask);
	
	
	/**
	 * 删除指定班级任务
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:45:10
	 * @param id
	 */
	public void deleteClassTask(Integer id);
	
	
	/**
	 * 修改指定班级任务
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:45:37
	 * @param classTask
	 */
	public void updateClassTask(ClassTask classTask);
	
	
	/**
	 * 通过id查找指定的班级任务
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:46:19
	 * @param id
	 */
	public ClassTask getClassTaskById(Integer id);
	
	
	/**
	 * 查找指定班级所执行的任务总数
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:47:00
	 * @param cid 班级id
	 * @return
	 */
	public int getClassTaskTotal(Class c);
	
	
	/**
	 * 查找指定范围内的班级任务列表
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:48:18
	 * @param cid 班级id
	 * @param startNum 从startNum开始
	 * @param pageSize 查找pageSize条数据
	 * @return
	 */
	public List<ClassTask> getClassTaskList(Integer cid,Integer startNum,Integer pageSize);


	/**
	 * 获取班级不执行的任务列表
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午11:43:38
	 * @param classId
	 * @return
	 */
	public List<Task> getNotTaskList(Integer tid,Integer classId);
	
	
	/**
	 * 获取执行指定任务的班级数量
	 * @author 罗龙贵
	 * @date 2019年4月15日 下午3:03:56
	 * @param tid
	 * @return
	 */
	public int getTaskClassTotal(Integer tid);
	
	
	/**
	 * 分页获取执行指定任务的班级列表
	 * @author 罗龙贵
	 * @date 2019年4月15日 下午3:04:56
	 * @param tid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<ClassTask> getTaskClassList(Integer tid,Integer startNum,Integer pageSize);
	
	
	/**
	 * 获取班级任务详情
	 * @author 罗龙贵
	 * @date 2019年4月16日 下午10:06:40
	 * @param ctid
	 * @return
	 */
	public ClassTask getClassTaskInfo(Integer ctid);
	
	
	/**
	 * 通过班级和任务id获取班级任务
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午7:31:59
	 * @param taskId
	 * @param classId
	 * @return
	 */
	public ClassTask getClassTaskByTCId(Integer taskId,Integer classId);
	
	
	/**
	 * 获取班级所有的任务列表
	 * @author 罗龙贵
	 * @date 2019年4月25日 下午9:40:23
	 * @param classId
	 * @return
	 */
	public List<ClassTask> getClassTaskAll(Integer classId);
	
	
	/**
	 * 查找班级指定任务类型的所有任务
	 * @author 罗龙贵
	 * @date 2019年4月26日 下午2:56:45
	 * @param classId
	 * @param type
	 * @return
	 */
	public List<ClassTask> getClassTaskByType(Integer classId,Integer type);
}
