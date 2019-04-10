package com.llg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.QueryVo;
import com.llg.bean.Teacher;
import com.llg.mapper.TeacherMapper;
import com.llg.mapper.UserMapper;
import com.llg.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private UserMapper userMapper;
	
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

	@Override
	public int addTeacher(Teacher teacher) {
		//判断用户名是否存在
		if(userMapper.getUserByUserName(teacher.getUsername()) != null) return 0;
		//添加
		teacherMapper.addTeacher(teacher);
		return 1;
	}

	@Override
	public void deleteTeacher(Integer id) {
		teacherMapper.deleteTeacher(id);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		//获取教师信息
		Teacher teacher2 = teacherMapper.getTeacherById(teacher.getId());
		if(!"".equals(teacher.getName())) teacher2.setName(teacher.getName());
		if(!"".equals(teacher.getPassword())) teacher2.setPassword(teacher.getPassword());
		teacherMapper.updateInfo(teacher2);
	}

}
