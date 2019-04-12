package com.llg.mapper;

import java.util.List;

import com.llg.bean.Class;

public interface ClassMapper {

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
	 * ���һ���༶
	 * @author ������
	 * @date 2019��4��12�� ����3:34:39
	 * @param c 
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
