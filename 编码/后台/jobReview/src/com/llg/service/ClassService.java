package com.llg.service;

import java.util.List;

import com.llg.bean.Class;

/**
 * ���ڴ���԰༶���crud����
 * @author ������
 * @Date 2019��4��12�� ����2:59:39
 */
public interface ClassService {

	/**
	 * ��ѯ������ָ����ʦ�����İ༶����
	 * @author ������
	 * @date 2019��4��12�� ����3:00:43
	 * @param tid ��ʦid
	 * @return
	 */
	public int getClassTotal(Integer tid);
	
	/**
	 * ��ѯ������ָ����ʦָ����Χ�İ༶�б�
	 * @author ������
	 * @date 2019��4��12�� ����3:02:58
	 * @param tid  ��ʦid
	 * @param startNum ��startNum��ʼ
	 * @param pageSize  ��ѯpageSize������
	 * @return
	 */
	public List<Class> getClassList(Integer tid,Integer startNum,Integer pageSize);
	
	/**
	 * ���һ��ָ����ʦ�İ༶
	 * @author ������
	 * @date 2019��4��12�� ����3:05:15
	 * @param tid ��ʦid
	 */
	public void addClass(Class c);
	
	/**
	 * ɾ��ָ���༶
	 * @author ������
	 * @date 2019��4��12�� ����3:06:08
	 * @param cid Ҫɾ���İ༶id
	 */
	public void deleteClass(Integer cid);
	
	/**
	 * �޸�ָ���༶��Ϣ
	 * @author ������
	 * @date 2019��4��12�� ����3:06:52
	 * @param c ����Ҫ�޸ĵİ༶id���޸ĺ�ĸ�������
	 */
	public void updateClass(Class c);
	


	/**
	 * ͨ��id���Ұ༶
	 * @author ������
	 * @date 2019��4��12�� ����3:07:58
	 * @param cid  �༶id
	 * @return
	 */
	public Class getClassById(Integer cid);
}
