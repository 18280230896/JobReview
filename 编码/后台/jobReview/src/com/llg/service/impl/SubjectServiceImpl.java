package com.llg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.Subject;
import com.llg.mapper.SubjectMapper;
import com.llg.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectMapper subjectMapper;
	
	@Override
	public void addSubject(Subject subject) {
		subjectMapper.addSubject(subject);
	}

	@Override
	public void deleteSubject(Integer id) {
		subjectMapper.deleteSubject(id);
	}

	@Override
	public void updateSubject(Subject subject) {
		Subject subject2 = subjectMapper.getSubjectById(subject.getId());
		if(subject.getName() != null && !subject.getName().equals("")) subject2.setName(subject.getName());
		subjectMapper.updateSubject(subject2);
	}

	@Override
	public Subject getSubjectById(Integer id) {
		return subjectMapper.getSubjectById(id);
	}

}
