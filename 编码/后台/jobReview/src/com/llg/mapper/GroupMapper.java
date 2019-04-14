package com.llg.mapper;

import java.util.List;

import com.llg.bean.Group;

public interface GroupMapper {

	/**
	 * 添加小组
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:03:48
	 * @param group
	 */
	public void addGroup(Group group);
	
	
	/**
	 * 删除小组
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:04:19
	 * @param id
	 */
	public void deleteGroup(Integer id);
	
	
	/**
	 * 修改小组
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:04:45
	 * @param group
	 */
	public void updateGroup(Group group);
	
	
	/**
	 * 通过id查找小组
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:05:25
	 * @param id
	 * @return
	 */
	public Group getGroupById(Integer id);
	
	
	/**
	 * 查找班级小组数量
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:05:56
	 * @param cid
	 * @return
	 */
	public int getGroupTotal(Integer cid);
	
	
	/**
	 * 查找指定范围内的小组
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:06:46
	 * @param cid
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	public List<Group> getGroupList(Integer cid,Integer startNum,Integer pageSize);
	
	
	/**
	 * 获取小组详情
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午11:44:26
	 * @param id
	 * @return
	 */
	public Group getGroupInfo(Integer id);
}
