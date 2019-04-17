package com.llg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.SubjectStudent;
import com.llg.mapper.SubjectStudentMapper;
import com.llg.service.SubjectStudentService;
@Service
public class SubjectStudentServiceImpl implements SubjectStudentService {

	@Autowired
	private SubjectStudentMapper mapper;
	
	@Override
	public void addDivision(SubjectStudent subjectStudent) {
		//判断是否已经添加过
		SubjectStudent subjectStudent2 = mapper.getSubjectStudentById(subjectStudent.getSubject().getId(), subjectStudent.getStudent().getId());
		if(subjectStudent2 != null) return;
		mapper.addDivision(subjectStudent);
	}

	@Override
	public void addBatchDivision(List<SubjectStudent> subjectStudents) {
		for (SubjectStudent subjectStudent : subjectStudents) {
			addDivision(subjectStudent);
		}
	}

	@Override
	public void deleteDivision(Integer id) {
		mapper.deleteDivision(id);
	}

	@Override
	public void deleteBatchDivision(Integer[] ids) {
		for (Integer id : ids) {
			mapper.deleteDivision(id);
		}
	}

	@Override
	public List<SubjectStudent> getDivisionList(Integer sid, Integer gid) {
		return mapper.getDivivionList(sid, gid);
	}

	
}
