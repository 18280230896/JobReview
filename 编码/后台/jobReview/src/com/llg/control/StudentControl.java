package com.llg.control;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llg.bean.Class;
import com.llg.bean.ClassTask;
import com.llg.bean.Group;
import com.llg.bean.Student;
import com.llg.bean.Subject;
import com.llg.bean.SubjectStudent;
import com.llg.bean.Task;
import com.llg.bean.User;
import com.llg.bean.Work;
import com.llg.service.ClassService;
import com.llg.service.ClassTaskService;
import com.llg.service.GroupService;
import com.llg.service.StudentService;
import com.llg.service.SubjectService;
import com.llg.service.SubjectStudentService;
import com.llg.service.TaskService;
import com.llg.service.WorkService;
import com.llg.util.FileUtil;

@Controller
public class StudentControl {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private ClassTaskService classTaskService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private SubjectStudentService divisionService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private WorkService workService;
	
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
	public Map<String, Object> studentGetClassTaskInfo(Integer ctid,HttpSession session ){
		Map<String, Object> result = new HashMap<>();
		ClassTask classTask = classTaskService.getClassTaskInfo(ctid);
		Task task = taskService.getTaskInfo(classTask.getTask().getId());
		User user = (User) session.getAttribute("user");
		result.put("msg", 1);
		result.put("classTask", classTask);
		result.put("task", task);
		result.put("student", user);
		return result;
	}
	
	
	/**
	 * 获取指定题目的分工成员列表
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:39:57
	 * @param sid
	 * @param session
	 * @return
	 */
	@RequestMapping(value="studentGetDivision.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentGetDivision(Integer sid,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		User user = (User)session.getAttribute("user");
		Student student = studentService.getStudentById(user.getId());
		List<SubjectStudent> divisionList = divisionService.getDivisionList(sid, student.getGroup().getId());
		List<Student> students = groupService.getGroupInfo(student.getGroup().getId()).getMember();
		for (SubjectStudent subjectStudent : divisionList) {
			for (Student student2 : students) {
				if(subjectStudent.getStudent().getId() == student2.getId()){
					students.remove(student2);
					break;
				}
			}
		}
		result.put("msg", 1);
		result.put("division", divisionList);
		result.put("students", students);
		return result;
	}
	
	
	/**
	 * 删除分工信息
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:54:46
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="studentDelDivision.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentDelDivision(@RequestParam(value = "ids[]") Integer[] ids){
		Map<String, Object> result = new HashMap<>();
		divisionService.deleteBatchDivision(ids);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 添加分工
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午10:59:13
	 * @param studentIds
	 * @param subjectId
	 * @return
	 */
	@RequestMapping(value="studentAddDivision.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentAddDivision(@RequestParam(value = "studentIds[]") Integer[] studentIds,Integer subjectId){
		Map<String, Object> result = new HashMap<>();
		List<SubjectStudent> subjectStudents = new ArrayList<>();
		for (Integer id : studentIds) {
			SubjectStudent subjectStudent = new SubjectStudent();
			Student student = new Student();
			student.setId(id);
			Subject subject = new Subject();
			subject.setId(subjectId);
			subjectStudent.setStudent(student);
			subjectStudent.setSubject(subject);
			subjectStudents.add(subjectStudent);
		}
		divisionService.addBatchDivision(subjectStudents);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 判断学生是否是组长
	 * @author 罗龙贵
	 * @date 2019年4月17日 上午11:21:43
	 * @param session
	 * @return
	 */
	@RequestMapping(value="studentIsLeader.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentIsLeader(HttpSession session){
		Map<String, Object> result = new HashMap<>();
		User user = (User)session.getAttribute("user");
		Student student = studentService.getStudentById(user.getId());
		Group group = groupService.getGroupById(student.getGroup().getId());
		if(student.getGroup() != null && student.getId() != null && group != null && group.getLeader() != null && group.getLeader().getId() != null && student.getId() == group.getLeader().getId()){
			result.put("msg", true);
		}else{
			result.put("msg", false);
		}
		return result;
	}
	
	
	/**
	 * 判断该题目是不是第一次被提交
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午9:47:05
	 * @param subjectId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="studentIsFirstSubmit.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentIsFirstSubmit(Integer subjectId, HttpSession session){
		Map<String, Object> result = new HashMap<>();
		//获取题目信息
		Subject subject = subjectService.getSubjectById(subjectId);
		//获取任务信息
		Task task = taskService.getTaskById(subject.getTask().getId());
		//获取学生信息
		User user = (User)session.getAttribute("user");
		Student student = studentService.getStudentById(user.getId());
		//获取班级信息
		Class c = classService.getClassById(student.getC().getId());
		//获取班级任务信息
		ClassTask classTask = classTaskService.getClassTaskByTCId(task.getId(), c.getId());
		//判断任务类型
		Work work;
		if(classTask.getType() == 1) work = workService.getWorkBySId(subjectId, student.getId());
		else {
			work = workService.getWorkByGId(subjectId, student.getGroup().getId());
			//判断学生有没有权限提交
			List<SubjectStudent> subjectStudents = divisionService.getDivisionList(subjectId, student.getGroup().getId());
			boolean flag = false;
			for (SubjectStudent subjectStudent : subjectStudents) {
				if(subjectStudent.getStudent().getId() == student.getId()){
					flag = true;
					break;
				}
			}
			if(!flag) {
				result.put("msg", "0");
				return result;
			}
		}
		if(work == null) result.put("msg", true);
		else result.put("msg", false);
		return result;
	}
	
	
	
	/**
	 * 学生提交作业
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午9:15:07
	 * @param subjectId
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping(value="studentSubmitJavaWork.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentSubmitJavaWork(Integer subjectId,String code,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		//获取题目信息
		Subject subject = subjectService.getSubjectById(subjectId);
		//获取任务信息
		Task task = taskService.getTaskById(subject.getTask().getId());
		if(task.getType() == 2){
			result.put("msg", "oracle任务提交到了java");
			return result;
		}
		//获取学生信息
		User user = (User)session.getAttribute("user");
		Student student = studentService.getStudentById(user.getId());
		//获取班级信息
		Class c = classService.getClassById(student.getC().getId());
		//获取班级任务信息
		ClassTask classTask = classTaskService.getClassTaskByTCId(task.getId(), c.getId());
		//判断任务类型
		Work work;
		if(classTask.getType() == 1) work = workService.getWorkBySId(subjectId, student.getId());
		else {
			work = workService.getWorkByGId(subjectId, student.getGroup().getId());
			//判断学生有没有权限提交
			List<SubjectStudent> subjectStudents = divisionService.getDivisionList(subjectId, student.getGroup().getId());
			boolean flag = false;
			for (SubjectStudent subjectStudent : subjectStudents) {
				if(subjectStudent.getStudent().getId() == student.getId()){
					flag = true;
					break;
				}
			}
			if(!flag) {
				result.put("msg", "该学生没有权限提交！");
				return result;
			}
		}
		//判断任务是否是第一次提交
		if(work == null){
			work = new Work();
			work.setSubject(subject);
			if(classTask.getType() == 1) work.setStudent(student);
			else {
				Group group = new Group();
				group.setId(student.getGroup().getId());
				work.setGroup(group);
			}
			//创建文件
			String fileName = FileUtil.createFileName()+".java";
			File file = FileUtil.createFile(FileUtil.LOCAL_JOB_PATH+fileName);
			//将代码写入文件
			FileUtil.write(file, code);
			work.setName(fileName);
			work.setCodePath(FileUtil.LOCAL_JOB_PATH+fileName);
			workService.addWork(work);
		}else{
			//将代码覆盖
			if(work.getCodePath() != null && !work.getCodePath().equals(""))
				FileUtil.write(new File(work.getCodePath()), code);
		}
		result.put("msg", 1);
		return result;
	}
	
	
	
	
	/**
	 * 获取作业信息
	 * @author 罗龙贵
	 * @date 2019年4月17日 下午7:59:37
	 * @param subjectId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="studentGetWork.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentGetWork(Integer subjectId,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		//获取题目信息
		Subject subject = subjectService.getSubjectById(subjectId);
		//获取任务信息
		Task task = taskService.getTaskById(subject.getTask().getId());
		//获取学生信息
		User user = (User)session.getAttribute("user");
		Student student = studentService.getStudentById(user.getId());
		//获取班级信息
		Class c = classService.getClassById(student.getC().getId());
		//获取班级任务信息
		ClassTask classTask = classTaskService.getClassTaskByTCId(task.getId(), c.getId());
		//判断任务类型
		Work work;
		if(classTask.getType() == 1) work = workService.getWorkBySId(subjectId, student.getId());
		else work = workService.getWorkByGId(subjectId, student.getGroup().getId());
		if(work == null) result.put("msg", 0);
		else{
			result.put("msg", 1);
			result.put("work", work);
			if(task.getType() == 1){
				result.put("code",FileUtil.getFileContent(new File(work.getCodePath())));
			}
		}
		return result;
	}
}
