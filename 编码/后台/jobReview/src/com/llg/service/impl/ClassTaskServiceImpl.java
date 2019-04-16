package com.llg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llg.bean.Class;
import com.llg.bean.ClassTask;
import com.llg.bean.Task;
import com.llg.mapper.ClassMapper;
import com.llg.mapper.ClassTaskMapper;
import com.llg.mapper.TaskMapper;
import com.llg.service.ClassTaskService;

@Service
public class ClassTaskServiceImpl implements ClassTaskService {

	@Autowired
	private ClassTaskMapper classTaskMapper;
	@Autowired
	private ClassMapper classMapper;
	@Autowired
	private TaskMapper taskMapper;
	
	@Override
	public void addClassTask(ClassTask classTask) {
		//获取班级信息
		Class c = classMapper.getClassById(classTask.getC().getId());
		classTask.setC(c);
		classTaskMapper.addClassTask(classTask);
	}

	@Override
	public void deleteClassTask(Integer id) {
		classTaskMapper.deleteClassTask(id);
	}

	@Override
	public void updateClassTask(ClassTask classTask) {
		//获取班级任务详情
		ClassTask classTask2 = classTaskMapper.geClassTaskById(classTask.getId());
		if(classTask.getStartTime() != null) classTask2.setStartTime(classTask.getStartTime());
		if(classTask.getEndTime() != null) classTask2.setEndTime(classTask.getEndTime());
		if(classTask.getStatus() != 0) classTask2.setStatus(classTask.getStatus());
		if(classTask.getProportion() != 0) classTask2.setProportion(classTask.getProportion());
		classTaskMapper.updateClassTask(classTask2);
	}

	@Override
	public void getClassTaskById(Integer id) {
		classTaskMapper.geClassTaskById(id);
	}

	@Override
	public int getClassTaskTotal(Integer cid) {
		return classTaskMapper.getClassTaskTotal(cid);
	}

	@Override
	public List<ClassTask> getClassTaskList(Integer cid, Integer startNum, Integer pageSize) {
		//获取班级信息
		Class c = classMapper.getClassById(cid);
		return classTaskMapper.getClassTaskList(cid, c.getSemester() , startNum, pageSize);
	}

	@Override
	public List<Task> getNotTaskList(Integer tid,Integer classId) {
		//获取所有的任务列表
		List<Task> tasks = taskMapper.getTaskListAll(tid);
		//获取班级已经有的任务列表
		List<ClassTask> classTasks = classTaskMapper.getClassTaskAll(classId);
		//获取班级没有的任务列表
		for (ClassTask classTask : classTasks) {
			for (Task task : tasks) {
				if(task.getId() == classTask.getTask().getId()){
					tasks.remove(task);
					break;
				}
			}	
		}
		return tasks;
	}

	@Override
	public int getTaskClassTotal(Integer tid) {
		return classTaskMapper.getTaskClassTotal(tid);
	}

	@Override
	public List<ClassTask> getTaskClassList(Integer tid, Integer startNum, Integer pageSize) {
		return classTaskMapper.getTaskClassList(tid, startNum, pageSize);
	}

}
