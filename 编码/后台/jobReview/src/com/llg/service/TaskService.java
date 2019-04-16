package com.llg.service;

import java.util.List;

import com.llg.bean.Task;

public interface TaskService {

	/**
	 * �������
	 * @author ������
	 * @date 2019��4��12�� ����6:20:52
	 * @param task
	 */
	public void addTask(Task task);
	
	
	/**
	 * ɾ������
	 * @author ������
	 * @date 2019��4��12�� ����6:21:37
	 * @param id
	 */
	public void deleteTask(Integer id);
	
	/**
	 * �޸�����
	 * @author ������
	 * @date 2019��4��12�� ����6:22:04
	 * @param task
	 */
	public void updateTask(Task task);
	
	
	/**
	 * ��ȡ��������
	 * @author ������
	 * @date 2019��4��12�� ����6:23:03
	 * @param id
	 * @return
	 */
	public Task getTaskInfo(Integer id);
	
	
	/**
	 * ��ȡ��ʦ��������������
	 * @author ������
	 * @date 2019��4��12�� ����6:24:15
	 * @param tid ��ʦid
	 * @return
	 */
	public int getTaskTotal(Integer tid);
	
	
	/**
	 * ��ҳ��ȡ�����б�
	 * @author ������
	 * @date 2019��4��12�� ����6:25:28
	 * @param tid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Task> getTaskList(Integer tid,Integer startNum,Integer pageSize);
	
	
	/**
	 * ͨ��id��ȡ������Ϣ
	 * @author ������
	 * @date 2019��4��14�� ����6:42:48
	 * @param id
	 * @return
	 */
	public Task getTaskById(Integer id);
	
	
}
