package com.llg.service;

import com.llg.bean.Work;

public interface WorkService {

	
	/**
	 * 添加一个作业
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午7:17:54
	 * @param work
	 */
	public void addWork(Work work);
	
	
	/**
	 * 修改作业
	 * @author 罗龙贵
	 * @date 2019年4月21日 下午3:22:52
	 * @param work
	 */
	public void updateWork(Work work);
	
	
	/**
	 * 通过学生id和题目id获取作业
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午7:19:54
	 * @param subjectId
	 * @param studentId
	 * @return
	 */
	public Work getWorkBySId(Integer subjectId,Integer studentId);
	
	
	/**
	 * 通过小组id和题目id获取作业
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午7:20:46
	 * @param subjectId
	 * @param group_id
	 * @return
	 */
	public Work getWorkByGId(Integer subjectId,Integer groupId);
	
	
	/**
	 * 通过id获取作业
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午7:21:42
	 * @param id
	 * @return
	 */
	public Work getWorkById(Integer id);

}
