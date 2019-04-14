package com.llg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.Class;
import com.llg.bean.Student;
import com.llg.mapper.StudentMapper;
import com.llg.mapper.UserMapper;
import com.llg.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int addStudent(Student student) {
		if(userMapper.getUserByUserName(student.getUsername())== null){
			studentMapper.addStudent(student);
			return 1;
		}
		return 0;
	}

	@Override
	public void deleteStudent(Integer id) {
		studentMapper.deleteStudent(id);
	}

	@Override
	public void updateStudent(Student student) {
		//获取学生信息
		Student student2 = studentMapper.getStudentById(student.getId());
		if(student.getName() != null && !"".equals(student.getName())) student2.setName(student.getName());
		if(student.getUsername() != null && !"".equals(student.getUsername())) student2.setUsername(student.getUsername());
		if(student.getPassword() != null && !"".equals(student.getPassword())) student2.setPassword(student.getPassword());
		studentMapper.updateInfo(student2);
	}

	@Override
	public int getStudentTotal(Integer cid) {
		return studentMapper.getStudentTotal(cid);
	}

	@Override
	public List<Student> getStudentList(Integer cid, Integer startNum, Integer pageSize) {
		return studentMapper.getStudentList(cid, startNum, pageSize);
	}

	@Override
	public int batchAddStudent(List<Student> students, Integer cid) {
		int success = 0;
		for (Student student : students) {
			if(userMapper.getUserByUserName(student.getUsername()) == null){
				Class c = new Class();
				c.setId(cid);
				student.setC(c);
				studentMapper.addStudent(student);
				success ++;
			}
		}
		return success;
	}
	
}
