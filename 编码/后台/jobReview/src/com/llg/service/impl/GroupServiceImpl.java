package com.llg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.Group;
import com.llg.mapper.GroupMapper;
import com.llg.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupMapper groupMapper;
	
	@Override
	public void addGroup(Group group) {
		groupMapper.addGroup(group);
	}

	@Override
	public void deleteGroup(Integer id) {
		groupMapper.deleteGroup(id);
	}

	@Override
	public void updateGroup(Group group) {
		//获取小组信息
		Group group2 = groupMapper.getGroupById(group.getId());
		if(group.getNum() != null && !group.getNum().equals("")) group2.setNum(group.getNum());
		if(group.getName() != null && !group.getName().equals("")) group2.setName(group.getName());
		if(group.getLeader() != null && group.getLeader().getId() != null) group2.setLeader(group.getLeader());
		groupMapper.updateGroup(group2);
	}

	@Override
	public Group getGroupById(Integer id) {
		return groupMapper.getGroupById(id);
	}

	@Override
	public int getGroupTotal(Integer cid) {
		return groupMapper.getGroupTotal(cid);
	}

	@Override
	public List<Group> getGroupList(Integer cid, Integer startNum, Integer pageSize) {
		return groupMapper.getGroupList(cid, startNum, pageSize);
	}

	@Override
	public Group getGroupInfo(Integer id) {
		return groupMapper.getGroupInfo(id);
	}

}
