package com.llg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.Work;
import com.llg.mapper.WorkMapper;
import com.llg.service.WorkService;
@Service
public class WorkServiceImpl implements WorkService {
	@Autowired
	private WorkMapper workMapper;

	@Override
	public void addWork(Work work) {
		workMapper.addWork(work);
	}

	@Override
	public Work getWorkBySId(Integer subjectId, Integer studentId) {
		return workMapper.getWorkBySId(subjectId, studentId);
	}

	@Override
	public Work getWorkByGId(Integer subjectId, Integer groupId) {
		return workMapper.getWorkByGId(subjectId, groupId);
	}

	@Override
	public Work getWorkById(Integer id) {
		return workMapper.getWorkById(id);
	}

	@Override
	public void updateWork(Work work) {
		Work work2 = workMapper.getWorkById(work.getId());
		if(work.getName() != null && !work.getName().equals("")) work2.setName(work.getName());;
		if(work.getCodePath() != null && !work.getCodePath().equals("")) work2.setCodePath(work.getCodePath());
		if(work.getPicPath() != null && !work.getPicPath().equals("")) work2.setPicPath(work.getPicPath());
		workMapper.updateWork(work2);
	}
}
