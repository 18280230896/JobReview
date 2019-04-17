package com.llg.control;

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
import com.llg.bean.Student;
import com.llg.bean.Task;
import com.llg.bean.User;
import com.llg.service.ClassService;
import com.llg.service.ClassTaskService;
import com.llg.service.StudentService;
import com.llg.service.TaskService;

@Controller
public class StudentControl {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;
	@Autowired
	private ClassTaskService classTaskService;
	@Autowired
	private TaskService taskService;
	
	/**
	 * 跳转到学生首页
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午10:47:47
	 * @return
	 */
	@RequestMapping(value="studentIndex.action",method=RequestMethod.GET)
	public String studentIndex(){
		return "studentIndex.html";
	}
	
	
	/**
	 * 获取学生详细信息
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午10:55:24
	 * @param session
	 * @return
	 */
	@RequestMapping(value="studentGetStudentInfo.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getStudentInfo(HttpSession session){
		Map<String, Object> result = new HashMap<>();
		User user = (User)session.getAttribute("user");
		Student student = studentService.getStudentInfo(user.getId());
		result.put("msg", 1);
		result.put("student", student);
		return result;
	}
	
	
	/**
	 * 获取学生任务数量
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午11:22:05
	 * @param session
	 * @return
	 */
	@RequestMapping(value="studentGetTaskTotal.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentGetTaskTotal(HttpSession session){
		Map<String, Object> result = new HashMap<>();
		User user = (User)session.getAttribute("user");
		Student student = studentService.getStudentById(user.getId());
		Class c = classService.getClassById(student.getC().getId());
		int count = classTaskService.getClassTaskTotal(c);
		result.put("count", count);
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 分页获取学生任务列表
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午11:25:01
	 * @param startNum
	 * @param pageSize
	 * @param session
	 * @return
	 */
	@RequestMapping(value="studentGetTaskList.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentGetTaskList(Integer startNum,Integer pageSize,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		User user = (User)session.getAttribute("user");
		Student student = studentService.getStudentById(user.getId());
		List<ClassTask> classTasks = classTaskService.getClassTaskList(student.getC().getId(), startNum, pageSize);
		result.put("msg", 1);
		result.put("classTasks", classTasks);
		return result;
	}
	
	/**
	 * 学生跳转到任务提交界面
	 * @author 罗龙贵
	 * @date 2019年4月16日 下午9:20:38
	 * @param ctid
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="student2TaskInfo.action",method=RequestMethod.GET)
	public String student2TaskInfo(Integer ctid,HttpSession session,HttpServletRequest request){
		//获取任务详情
		ClassTask classTask = classTaskService.getClassTaskById(ctid);
		//获取学生信息
		User user = (User)session.getAttribute("user");
		Student student = studentService.getStudentById(user.getId());
		//判断此任务是否是该学生要执行的任务
		if(classTask == null || classTask.getC().getId() != student.getC().getId()) return "redirect:studentIndex.action";
		//获取任务信息
		Task task = taskService.getTaskById(classTask.getC().getId());
		if(task.getType() == 1){
			//java任务
			request.setAttribute("classTask", classTask);
			request.setAttribute("task", task);
			return "reportJavaJob.jsp";
		}
		return "";
	}
	
	
	/**
	 * 获取班级任务的详细信息
	 * @author 罗龙贵
	 * @date 2019年4月16日 下午10:08:35
	 * @param ctid
	 * @return
	 */
	@RequestMapping(value="studentGetClassTaskInfo.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentGetClassTaskInfo(Integer ctid){
		Map<String, Object> result = new HashMap<>();
		ClassTask classTask = classTaskService.getClassTaskInfo(ctid);
		Task task = taskService.getTaskInfo(classTask.getTask().getId());
		result.put("msg", 1);
		result.put("classTask", classTask);
		result.put("task", task);
		return result;
	}
	
}
