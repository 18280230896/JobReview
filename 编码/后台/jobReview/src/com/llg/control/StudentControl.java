package com.llg.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llg.bean.Class;
import com.llg.bean.ClassTask;
import com.llg.bean.Student;
import com.llg.bean.User;
import com.llg.service.ClassService;
import com.llg.service.ClassTaskService;
import com.llg.service.StudentService;

@Controller
public class StudentControl {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;
	@Autowired
	private ClassTaskService classTaskService;
	
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
	
}
