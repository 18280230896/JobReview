package com.llg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.Subject;
import com.llg.bean.Task;
import com.llg.mapper.SubjectMapper;
import com.llg.mapper.TaskMapper;
import com.llg.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private SubjectMapper subjectMapper;
	
	@Override
	public void addTask(Task task) {
		//添加任务
		taskMapper.addTask(task);
		for (Subject subject : task.getSubjects()) {
			if(subject != null && subject.getName() != null && !subject.getName().equals("")){
				//添加题目
				subject.setTask(task);
				subjectMapper.addSubject(subject);
			}
		}
		
	}

	@Override
	public void deleteTask(Integer id) {
		taskMapper.deleteTask(id);
	}

	@Override
	public void updateTask(Task task) {
		//获取任务信息
		Task task2 = taskMapper.getTaskById(task.getId());
		if(task2 == null) return;
		if(task.getName() != null && !task.getName().equals("")) task2.setName(task.getName());
		if(task.getType() != 0) task2.setType(task.getType());
		taskMapper.updateTask(task2);
	}

	@Override
	public Task getTaskInfo(Integer id) {
		return taskMapper.getTaskInfo(id);
	}

	@Override
	public int getTaskTotal(Integer tid) {
		return taskMapper.getTaskTotal(tid);
	}

	@Override
	public List<Task> getTaskList(Integer tid, Integer startNum, Integer pageSize) {
		return taskMapper.getTaskList(tid, startNum, pageSize);
	}

	@Override
	public Task getTaskById(Integer id) {
		return taskMapper.getTaskById(id);
	}

}
