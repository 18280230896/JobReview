package com.llg.mapper;

import java.util.List;

import com.llg.bean.Task;

/**
 * @author ������
 * @Date 2019��4��12�� ����4:53:56
 */
public interface TaskMapper {

	/**
	 * �������
	 * @author ������
	 * @date 2019��4��12�� ����5:11:28
	 * @param task
	 */
	public void addTask(Task task);
	
	
	/**
	 * ɾ������
	 * @author ������
	 * @date 2019��4��12�� ����5:12:15
	 * @param id Ҫɾ��������id
	 */
	public void deleteTask(Integer id);
	
	/**
	 * �޸�������Ϣ
	 * @author ������
	 * @date 2019��4��12�� ����5:14:18
	 * @param task Ҫ�޸ĵ�����
	 */
	public void updateTask(Task task);
	
	
	/**
	 * ��������id����������
	 * @author ������
	 * @date 2019��4��12�� ����5:15:43
	 * @param id
	 * @return
	 */
	public Task getTaskById(Integer id);
	
	
	/**
	 * ����ָ����ʦ����������������
	 * @author ������
	 * @date 2019��4��12�� ����5:16:18
	 * @param tid ��ʦid
	 * @return
	 */
	public int getTaskTotal(Integer tid);
	
	
	/**
	 * ��ҳ���������б�
	 * @author ������
	 * @date 2019��4��12�� ����5:18:42
	 * @param tid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Task> getTaskList(Integer tid,Integer startNum,Integer pageSize);
	
	
	/**
	 * ��ȡ���е������б�
	 * @author ������
	 * @date 2019��4��13�� ����11:46:52
	 * @param tid
	 * @return
	 */
	public List<Task> getTaskListAll(Integer tid);
	
	
	/**
	 * ��ȡ������ϸ��Ϣ
	 * @author ������
	 * @date 2019��4��15�� ����2:37:54
	 * @param id
	 * @return
	 */
	public Task getTaskInfo(Integer id);
	
	
}
