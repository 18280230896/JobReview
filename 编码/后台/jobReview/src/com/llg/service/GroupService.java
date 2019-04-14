package com.llg.service;

import java.util.List;

import com.llg.bean.Group;

public interface GroupService {

	/**
	 * ���С��
	 * @author ������
	 * @date 2019��4��14�� ����10:29:26
	 * @param group
	 */
	public void addGroup(Group group);
	
	
	/**
	 * ɾ��С��
	 * @author ������
	 * @date 2019��4��14�� ����10:30:01
	 * @param id
	 */
	public void deleteGroup(Integer id);
	
	
	/**
	 * �޸�С����Ϣ
	 * @author ������
	 * @date 2019��4��14�� ����10:30:52
	 * @param group
	 */
	public void updateGroup(Group group);
	
	
	/**
	 * ͨ��id���Ұ༶
	 * @author ������
	 * @date 2019��4��14�� ����10:31:26
	 * @param id
	 */
	public Group getGroupById(Integer id);
	
	
	/**
	 * ��ѯ�༶��С������
	 * @author ������
	 * @date 2019��4��14�� ����10:32:11
	 * @param cid
	 * @return
	 */
	public int getGroupTotal(Integer cid);
	
	
	/**
	 * ��ȡС���б�
	 * @author ������
	 * @date 2019��4��14�� ����10:33:00
	 * @param cid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Group> getGroupList(Integer cid,Integer startNum,Integer pageSize);
	
	
	/**
	 * ��ȡС������
	 * @author ������
	 * @date 2019��4��14�� ����11:46:20
	 * @param id
	 * @return
	 */
	public Group getGroupInfo(Integer id);
}
