package com.llg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.QueryVo;
import com.llg.bean.Teacher;
import com.llg.mapper.TeacherMapper;
import com.llg.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	
	@Override
	public int getTeacherNum() {
		return teacherMapper.getTeacherNum();
	}

	@Override
	public List<Teacher> getTeacherList(Integer startNum, Integer pageSize) {
		QueryVo vo = new QueryVo();
		vo.setStartNum(startNum);
		vo.setPageSize(pageSize);
		return teacherMapper.getTeacherList(vo);
	}

}
