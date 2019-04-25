package com.llg.mapper;

import com.llg.bean.JobStatus;

public interface JobStatusMapper {

	/**
	 * 添加一条状态
	 * @author 罗龙贵
	 * @date 2019年4月24日 上午10:16:49
	 * @param jobStatus
	 */
	public void addJobStatus(JobStatus jobStatus);
	
	/**
	 * 删除一条状态
	 * @author 罗龙贵
	 * @date 2019年4月24日 上午10:17:48
	 * @param id
	 */
	public void deleteJobStatus(Integer id);
	
	
	/**
	 * 更新一条状态
	 * @author 罗龙贵
	 * @date 2019年4月24日 上午10:18:24
	 * @param jobStatus
	 */
	public void updateJobStatus(JobStatus jobStatus);
	
	
	/**
	 * 通过id获取任务状态
	 * @author 罗龙贵
	 * @date 2019年4月24日 上午10:19:03
	 * @param id
	 * @return
	 */
	public JobStatus getStatusById(Integer id);
	
	
	/**
	 * 通过学生id和班级任务id查找任务状态
	 * @author 罗龙贵
	 * @date 2019年4月24日 上午10:25:25
	 * @param ctid
	 * @param student_id
	 * @return
	 */
	public JobStatus getStatusByCTSId(Integer ctid,Integer student_id);
	
	/**
	 * 通过小组id和任务id查找任务状态
	 * @author 罗龙贵
	 * @date 2019年4月24日 上午10:48:35
	 * @param ctid
	 * @param groupId
	 * @return
	 */
	public JobStatus getstatusByCTGId(Integer ctid,Integer groupId);
}
