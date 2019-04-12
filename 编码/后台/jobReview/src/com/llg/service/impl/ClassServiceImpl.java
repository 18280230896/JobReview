package com.llg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.Class;
import com.llg.mapper.ClassMapper;
import com.llg.service.ClassService;
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassMapper classMaper;
	@Override
	public int getClassTotal(Integer tid) {
		return classMaper.getClassTotal(tid);
	}

	@Override
	public List<Class> getClassList(Integer tid, Integer startNum, Integer pageSize) {
		return classMaper.getClassList(tid, startNum, pageSize);
	}

	@Override
	public void addClass(Class c) {
		classMaper.addClass(c);
	}

	@Override
	public void deleteClass(Integer cid) {
		classMaper.deleteClass(cid);
	}

	@Override
	public void updateClass(Class c) {
		classMaper.updateClass(c);
	}

	@Override
	public Class getClassById(Integer cid) {
		return classMaper.getClassById(cid);
	}

}
