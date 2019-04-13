package com.llg.control;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llg.bean.Class;
import com.llg.bean.ClassTask;
import com.llg.bean.Task;
import com.llg.bean.Teacher;
import com.llg.bean.User;
import com.llg.service.ClassService;
import com.llg.service.ClassTaskService;
import com.llg.service.TaskService;

@Controller
public class TeacherControl {

	@Autowired
	private ClassService classService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ClassTaskService classTaskService;
	
	/**
	 * 跳转到教师首页
	 * @author 罗龙贵
	 * @date 2019年4月11日 上午9:57:37
	 * @return
	 */
	@RequestMapping(value="teacherIndex.action",method=RequestMethod.GET)
	public String teacherIndex(){
		return "teacherIndex.html";
	}
	
	/**
	 * 跳转到班级管理界面
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午2:48:36
	 * @return
	 */
	@RequestMapping(value="teacherToClassManage.action",method=RequestMethod.GET)
	public String teacherToClassManage(){
		return "classManager.html";
	}
	
	/**
	 * 获取当前登录教师所创建的所有班级数量
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午3:27:31
	 * @param session
	 * @return
	 */
	@RequestMapping(value="teacherGetClassTotal.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetClassTotal(HttpSession session){
		Map<String, Object> result = new HashMap<>();
		int total = classService.getClassTotal(((User)session.getAttribute("user")).getId());
		result.put("msg", 1);
		result.put("count", total);
		return result;
	}
	
	/**
	 * 分页查询班级列表
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午3:31:36
	 * @param session
	 * @param startNum 从startNum开始
	 * @param pageSize 查询pageSize条数据
	 * @return
	 */
	@RequestMapping(value="teacherGetClassList.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetClassList(HttpSession session,Integer startNum,Integer pageSize){
		Map<String, Object> result = new HashMap<>();
		Integer tid = ((User)session.getAttribute("user")).getId();
		List<Class> classList = classService.getClassList(tid, startNum, pageSize);
		result.put("msg", 1);
		result.put("classList", classList);
		return result;
	}
	
	
	/**
	 * 添加班级
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午4:00:52
	 * @param session
	 * @param c
	 * @return
	 */
	@RequestMapping(value="teacherAddClass.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherAddClass(HttpSession session,Class c){
		Map<String, Object> result = new HashMap<>();
		Teacher teacher = new Teacher();
		teacher.setId(((User)session.getAttribute("user")).getId());
		c.setTeacher(teacher);
		classService.addClass(c);
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 删除班级
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午4:01:40
	 * @param id
	 * @return
	 */
	@RequestMapping(value="teacherDeleteClass.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherDeleteClass(Integer id){
		Map<String, Object> result = new HashMap<>();
		classService.deleteClass(id);
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 修改班级信息
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午4:46:05
	 * @param c
	 * @return
	 */
	@RequestMapping(value="teacherUpdateClass.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherUpdateClass(Class c){
		Map<String, Object> result = new HashMap<>();
		classService.updateClass(c);
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 跳转到任务管理界面
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午4:53:11
	 * @return
	 */
	@RequestMapping(value="teacherToTaskManage.action",method=RequestMethod.GET)
	public String teacherToTaskManage(){
		return "taskManager.html";
	}
	
	/**
	 * 获取指定教师创建的任务总数
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午6:34:07
	 * @param session
	 * @return
	 */
	@RequestMapping(value="teacherGetTaskCount.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetTaskCount(HttpSession session){
		Map<String, Object> result = new HashMap<>();
		int count = taskService.getTaskTotal(((User)session.getAttribute("user")).getId());
		result.put("msg", 1);
		result.put("count", count);
		return result;
	}
	
	/**
	 * 分页获取任务列表
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午9:08:11
	 * @param session
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="teacherGetTaskList.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetTaskList(HttpSession session,Integer startNum,Integer pageSize){
		Map<String, Object> result = new HashMap<>();
		int tid = ((User)session.getAttribute("user")).getId();
		List<Task> taskList = taskService.getTaskList(tid, startNum, pageSize);
		result.put("msg", 1);
		result.put("tasks", taskList);
		return result;
	}
	
	
	/**
	 * 添加任务
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午9:57:03
	 * @param session
	 * @param task
	 * @return
	 */
	@RequestMapping(value="teacherAddTask.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherAddList(HttpSession session,Task task){
		Map<String, Object> result = new HashMap<>();
		int tid = ((User)session.getAttribute("user")).getId();
		Teacher teacher = new Teacher();
		teacher.setId(tid);
		task.setTeacher(teacher);
		taskService.addTask(task);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 删除任务
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午9:58:37
	 * @param id
	 * @return
	 */
	@RequestMapping(value="teacherDeleteTask.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherDeleteTask(Integer id){
		Map<String, Object> result = new HashMap<>();
		taskService.deleteTask(id);
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 跳转到班级详情界面
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:17:36
	 * @param classId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="teacherToClassInfo.action",method=RequestMethod.POST)
	public String teacherToClassInfo(Integer classId,HttpServletRequest request){
		Class c = classService.getClassById(classId);
		request.setAttribute("c", c);
		return "classInfo.jsp";
	}
	
	
	/**
	 * 获取班级的任务总数
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:53:13
	 * @param classId
	 * @return
	 */
	@RequestMapping(value="teacherGetClassTaskTotal.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetClassTaskTotal(Integer classId){
		Map<String, Object> result = new HashMap<>();
		int count = classTaskService.getClassTaskTotal(classId);
		result.put("msg", 1);
		result.put("count", count);
		return result;
	}
	
	/**
	 * 分页获取班级任务列表
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午10:55:07
	 * @param classId 班级id
	 * @param startNum  从startNum开始
	 * @param pageSize 查询pageSize条数据
	 * @return
	 */
	@RequestMapping(value="teacherGetClassTaskList.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetClassTaskList(Integer classId,Integer startNum,Integer pageSize){
		Map<String, Object> result = new HashMap<>();
		List<ClassTask> classTasks = classTaskService.getClassTaskList(classId, startNum, pageSize);
		result.put("msg", 1);
		result.put("classTasks", classTasks);
		return result;
	}
	
	
	/**
	 * 给班级分配一个任务
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午11:11:20
	 * @param classTask
	 * @return
	 */
	@RequestMapping(value="teacherAddClassTask.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherAddClassTask(ClassTask classTask,Integer classId,Integer taskId){
		Map<String, Object> result = new HashMap<>();
		Class c = new Class();
		c.setId(classId);
		Task task = new Task();
		task.setId(taskId);
		classTask.setC(c);
		classTask.setTask(task);
		classTaskService.addClassTask(classTask);
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 删除班级的任务
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午11:12:29
	 * @param ctId
	 * @return
	 */
	@RequestMapping(value="teacherDeleteClassTask.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherDeleteClassTask(Integer ctId){
		Map<String, Object> result = new HashMap<>();
		classTaskService.deleteClassTask(ctId);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 修改班级任务信息
	 * @author 罗龙贵
	 * @date 2019年4月13日 上午11:40:34
	 * @param classTask
	 * @return
	 */
	@RequestMapping(value="teacherUpdateClassTask.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherUpdateClassTask(ClassTask classTask){
		Map<String, Object> result = new HashMap<>();
		long now = new Date().getTime();
		if(now < classTask.getStartTime().getTime()) classTask.setStatus(1);
		else if(now > classTask.getEndTime().getTime()) classTask.setStatus(3);
		else classTask.setStatus(2);
		classTaskService.updateClassTask(classTask);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 获取班级没有的任务列表
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午5:05:06
	 * @param classId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="teacherGetNotTaskList.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetNotTaskList(Integer classId,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		int tid = ((User)session.getAttribute("user")).getId();
		List<Task> tasks = classTaskService.getNotTaskList(tid,classId);
		result.put("msg", 1);
		result.put("tasks", tasks);
		return result;
	}


	/**
	 * 立即截至任务
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午8:00:37
	 * @param classTask
	 * @return
	 */
	@RequestMapping(value="teacherEndClassTask.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherEndClassTask(ClassTask classTask){
		Map<String, Object> result = new HashMap<>();
		Timestamp endTime = new Timestamp(new Date().getTime());
		classTask.setEndTime(endTime);
		classTask.setStatus(3);
		classTaskService.updateClassTask(classTask);
		result.put("msg", 1);
		return result;
	}
	
}
