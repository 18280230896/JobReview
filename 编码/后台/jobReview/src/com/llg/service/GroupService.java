package com.llg.service;

import java.util.List;

import com.llg.bean.Group;

public interface GroupService {

	/**
	 * 添加小组
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:29:26
	 * @param group
	 */
	public void addGroup(Group group);
	
	
	/**
	 * 删除小组
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:30:01
	 * @param id
	 */
	public void deleteGroup(Integer id);
	
	
	/**
	 * 修改小组信息
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:30:52
	 * @param group
	 */
	public void updateGroup(Group group);
	
	
	/**
	 * 通过id查找班级
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:31:26
	 * @param id
	 */
	public Group getGroupById(Integer id);
	
	
	/**
	 * 查询班级的小组数量
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:32:11
	 * @param cid
	 * @return
	 */
	public int getGroupTotal(Integer cid);
	
	
	/**
	 * 获取小组列表
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:33:00
	 * @param cid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Group> getGroupList(Integer cid,Integer startNum,Integer pageSize);
	
	
	/**
	 * 获取小组详情
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午11:46:20
	 * @param id
	 * @return
	 */
	public Group getGroupInfo(Integer id);
}
