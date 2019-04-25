package com.llg.mapper;

import com.llg.bean.JobStatus;

public interface JobStatusMapper {

	/**
	 * ���һ��״̬
	 * @author ������
	 * @date 2019��4��24�� ����10:16:49
	 * @param jobStatus
	 */
	public void addJobStatus(JobStatus jobStatus);
	
	/**
	 * ɾ��һ��״̬
	 * @author ������
	 * @date 2019��4��24�� ����10:17:48
	 * @param id
	 */
	public void deleteJobStatus(Integer id);
	
	
	/**
	 * ����һ��״̬
	 * @author ������
	 * @date 2019��4��24�� ����10:18:24
	 * @param jobStatus
	 */
	public void updateJobStatus(JobStatus jobStatus);
	
	
	/**
	 * ͨ��id��ȡ����״̬
	 * @author ������
	 * @date 2019��4��24�� ����10:19:03
	 * @param id
	 * @return
	 */
	public JobStatus getStatusById(Integer id);
	
	
	/**
	 * ͨ��ѧ��id�Ͱ༶����id��������״̬
	 * @author ������
	 * @date 2019��4��24�� ����10:25:25
	 * @param ctid
	 * @param student_id
	 * @return
	 */
	public JobStatus getStatusByCTSId(Integer ctid,Integer student_id);
	
	/**
	 * ͨ��С��id������id��������״̬
	 * @author ������
	 * @date 2019��4��24�� ����10:48:35
	 * @param ctid
	 * @param groupId
	 * @return
	 */
	public JobStatus getstatusByCTGId(Integer ctid,Integer groupId);
}
