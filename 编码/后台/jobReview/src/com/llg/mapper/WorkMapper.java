package com.llg.mapper;

import com.llg.bean.Work;

public interface WorkMapper {

	/**
	 * 添加一个work
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午6:57:08
	 * @param work
	 */
	public void addWork(Work work);
	
	
	/**
	 * 删除一个work
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午6:57:34
	 * @param id
	 */
	public void deleteWork(Integer id);
	
	
	/**
	 * 修改作业
	 * @author 罗龙贵
	 * @date 2019年4月21日 下午3:23:49
	 * @param work
	 */
	public void updateWork(Work work);
	
	
	/**
	 * 通过学生id和题目id查找作业
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午6:59:58
	 * @param subjectId
	 * @param studentId
	 * @return
	 */
	public Work getWorkBySId(Integer subjectId,Integer studentId);
	
	
	/**
	 * 通过小组id和题目id查找作业
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午7:00:55
	 * @param subjectId
	 * @param groupId
	 * @return
	 */
	public Work getWorkByGId(Integer subjectId,Integer groupId);
	
	
	/**
	 * 通过id查找作业
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午7:01:39
	 * @param id
	 * @return
	 */
	public Work getWorkById(Integer id);
}
