package com.llg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.Class;
import com.llg.bean.Group;
import com.llg.bean.Student;
import com.llg.mapper.GroupMapper;
import com.llg.mapper.StudentMapper;
import com.llg.mapper.UserMapper;
import com.llg.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private GroupMapper groupMapper;
	
	@Override
	public int addStudent(Student student) {
		if(userMapper.getUserByUserName(student.getUsername()) != null) return 2;
		if(studentMapper.getStudentByNum(student.getNum()) != null) return 3;
		studentMapper.addStudent(student);
		return 1;
	}

	@Override
	public void deleteStudent(Integer id) {
		studentMapper.deleteStudent(id);
	}

	@Override
	public void updateStudent(Student student) {
		//获取学生信息
		Student student2 = studentMapper.getStudentById(student.getId());
		if(student.getNum() != null && student.getNum().equals("")) student2.setNum(student.getNum());
		if(student.getName() != null && !"".equals(student.getName())) student2.setName(student.getName());
		if(student.getUsername() != null && !"".equals(student.getUsername())) student2.setUsername(student.getUsername());
		if(student.getPassword() != null && !"".equals(student.getPassword())) student2.setPassword(student.getPassword());
		if(student.getGroup() != null) student2.setGroup(student.getGroup());
		studentMapper.updateStudent(student2);
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
			if(userMapper.getUserByUserName(student.getUsername()) == null && studentMapper.getStudentByNum(student.getNum()) == null){
				Class c = new Class();
				c.setId(cid);
				student.setC(c);
				studentMapper.addStudent(student);
				success ++;
			}
		}
		return success;
	}

	@Override
	public List<Student> getNotGroupStudent(Integer cid) {
		return studentMapper.getNotGroupStudent(cid);
	}

	@Override
	public Student getStudentById(Integer studentId) {
		return studentMapper.getStudentById(studentId);
	}

	@Override
	public void removeGroupStudent(Integer studentId, Integer groupId) {
		//获取小组信息
		Group group = groupMapper.getGroupById(groupId);
		//判断是否是组长
		if(group.getLeader() != null && studentId == group.getLeader().getId()){
			Student student = new Student();
			student.setId(null);
			group.setLeader(student);
			groupMapper.updateGroup(group);
		}
		Student student = studentMapper.getStudentById(studentId);
		student.setGroup(new Group());
		studentMapper.updateStudent(student);
	}

	@Override
	public Student getStudentInfo(Integer studentId) {
		return studentMapper.getStudentInfo(studentId);
	}

	@Override
	public boolean getStudentByNum(String num) {
		Student student = studentMapper.getStudentByNum(num);
		return student == null;
	}

	@Override
	public List<Student> getStudentAll(Integer cid) {
		return studentMapper.getStudentAll(cid);
	}
	
}
