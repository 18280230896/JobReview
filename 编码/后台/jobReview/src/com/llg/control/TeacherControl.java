package com.llg.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.llg.bean.Class;
import com.llg.bean.ClassTask;
import com.llg.bean.Group;
import com.llg.bean.JobStatus;
import com.llg.bean.Student;
import com.llg.bean.Subject;
import com.llg.bean.SubjectStudent;
import com.llg.bean.Task;
import com.llg.bean.Teacher;
import com.llg.bean.User;
import com.llg.bean.Work;
import com.llg.service.ClassService;
import com.llg.service.ClassTaskService;
import com.llg.service.GroupService;
import com.llg.service.JobStatusService;
import com.llg.service.StudentService;
import com.llg.service.SubjectService;
import com.llg.service.SubjectStudentService;
import com.llg.service.TaskService;
import com.llg.service.WorkService;
import com.llg.util.FileUtil;

@Controller
public class TeacherControl {

	@Autowired
	private ClassService classService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ClassTaskService classTaskService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private JobStatusService jobService;
	@Autowired
	private SubjectStudentService divisionService;
	@Autowired
	private WorkService workService;
	
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
	@RequestMapping(value="teacherToClassInfo.action",method=RequestMethod.GET)
	public String teacherToClassInfo(Integer classId,HttpServletRequest request,HttpSession session){
		Class c = classService.getClassById(classId);
		if(c == null) return "redirect:teacherToClassManage.action";
		User user = (User) session.getAttribute("user");
		if(!c.getTeacher().getId().equals(user.getId())) return "redirect:teacherToClassManage.action";
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
		Class c = classService.getClassById(classId);
		int count = classTaskService.getClassTaskTotal(c);
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
	
	
	/**
	 * 获取班级学生数量
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午11:05:42
	 * @param classId
	 * @return
	 */
	@RequestMapping(value="teacherGetStudentCount.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetStudentCount(Integer classId){
		Map<String, Object> result = new HashMap<>();
		int count = studentService.getStudentTotal(classId);
		result.put("msg", 1);
		result.put("count", count);
		return result;
	}
	
	
	/**
	 * 分页获取班级学生列表
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午11:07:21
	 * @param classId
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="teacherGetStudentList.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetStudentList(Integer classId,Integer startNum,Integer pageSize){
		Map<String, Object> result = new HashMap<>();
		List<Student> students = studentService.getStudentList(classId, startNum, pageSize);
		result.put("msg", 1);
		result.put("students", students);
		return result;
	}
	
	/**
	 * 判断学号是否存在
	 * @author 罗龙贵
	 * @date 2019年4月25日 下午8:08:45
	 * @param num
	 * @return
	 */
	@RequestMapping(value="teacherGetNumIsEmpty.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetNumIsEmpty(String num){
		Map<String, Object> result = new HashMap<>();
		result.put("msg", studentService.getStudentByNum(num));
		return result;
	}
	
	
	/**
	 * 添加学生
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午11:12:30
	 * @param classId
	 * @param student
	 * @return
	 */
	@RequestMapping(value="teacherAddStudent.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherAddStudent(Integer classId,Student student){
		Map<String, Object> result = new HashMap<>();
		Class c = new Class();
		c.setId(classId);
		student.setC(c);
		result.put("msg", studentService.addStudent(student));
		return result;
	}
	
	
	/**
	 * 修改学生信息
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午11:13:38
	 * @param student
	 * @return
	 */
	@RequestMapping(value="teacherUpdateStudent.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherUpdateStudent(Student student){
		Map<String, Object> result = new HashMap<>();
		studentService.updateStudent(student);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 删除学生
	 * @author 罗龙贵
	 * @date 2019年4月13日 下午11:16:08
	 * @param studentId
	 * @return
	 */
	@RequestMapping(value="teacherDeleteStudent.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherDeleteStudent(Integer studentId){
		Map<String, Object> result = new HashMap<>();
		studentService.deleteStudent(studentId);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 批量添加学生
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午9:35:19
	 * @param file
	 * @param cid
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="teacherBatchAddStudent.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherBatchAddStudent(MultipartFile file,Integer cid) throws IOException{
		Map<String, Object> result = new HashMap<>();
		//判断文件是否为空
		if(file.isEmpty()){
			//1、表示正确，2、表示文件为空 ，3、表示文件格式不符合要求
			result.put("msg", "2");
			return result;
		}
		//获取文件名
		String fileName = file.getOriginalFilename();
		//获取文件后缀名
		String ext = FilenameUtils.getExtension(fileName);
		if(ext.equals("xlsx") || ext.equals("xls")){
			Workbook workbook;
			if(ext.equals("xls")){
				workbook = new HSSFWorkbook(file.getInputStream());
			}else{
				workbook = new XSSFWorkbook(file.getInputStream());
			}
			List<Student> students = new ArrayList<>();
			int count=0;//有效行
			int success=0;//成功
			int fail=0;//失败
			//遍历sheet
			for(int sheetNum=0;sheetNum<workbook.getNumberOfSheets();sheetNum++){
				//遍历每行
				for(int rowNum=0;rowNum <= workbook.getSheetAt(sheetNum).getLastRowNum();rowNum++){
					if(workbook.getSheetAt(sheetNum).getRow(rowNum) == null)
						continue;
					Cell numCell = workbook.getSheetAt(sheetNum).getRow(rowNum).getCell(0);
					Cell nameCell = workbook.getSheetAt(sheetNum).getRow(rowNum).getCell(1);
					Cell usernameCell = workbook.getSheetAt(sheetNum).getRow(rowNum).getCell(2);
					Cell passwordCell = workbook.getSheetAt(sheetNum).getRow(rowNum).getCell(3);
					String num = null,name = null,username = null,password = null;
					if(numCell != null &&nameCell != null && usernameCell != null && passwordCell != null){
						num = numCell.toString().split("\\.")[0];
						name = nameCell.toString().split("\\.")[0];
						username = usernameCell.toString().split("\\.")[0];
						password = passwordCell.toString().split("\\.")[0];
						String regExp = "^[0-9a-zA-Z]{6,20}$";
						if((!Pattern.matches("^[0-9]{6}$", username)) || (!Pattern.matches(regExp, password))){
							continue;
						}
						if((name.toCharArray()).length<2 || (name.toCharArray()).length>11){
							continue;
						}
						if((!Pattern.matches(regExp, username)) || (!Pattern.matches(regExp, password))){
							continue;
						}
						count++;
						Student student = new Student();
						student.setNum(num);
						student.setName(name);
						student.setUsername(username);
						student.setPassword(password);
						students.add(student);
					}else{
						continue;
					}
				}
			}
			success = studentService.batchAddStudent(students, cid);
			workbook.close();
			result.put("msg", "1");
			result.put("count", count);
			result.put("success", success);
			result.put("fail", fail);
		}else{
			result.put("msg", "3");
		}
		return result;
	}
	
	/**
	 * 获取班级小组数量
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:40:16
	 * @param classId
	 * @return
	 */
	@RequestMapping(value="teacherGetGroupTotal.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetGroupTotal(Integer classId){
		Map<String, Object> result = new HashMap<>();
		int count = groupService.getGroupTotal(classId);
		result.put("msg", 1);
		result.put("count", count);
		return result;
	}
	
	
	/**
	 * 分页获取小组列表
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:44:17
	 * @param classId
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="teacherGetGroupList.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetGroupList(Integer classId,Integer startNum,Integer pageSize){
		Map<String, Object> result = new HashMap<>();
		List<Group> groupList = groupService.getGroupList(classId, startNum, pageSize);
		result.put("msg", 1);
		result.put("groups", groupList);
		return result;
	}
	
	/**
	 * 添加小组
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:49:40
	 * @param classId
	 * @param group
	 * @return
	 */
	@RequestMapping(value="teacherAddGroup.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherAddGroup(Integer classId,Group group){
		Map<String, Object> result = new HashMap<>();
		Class c = new Class();
		c.setId(classId);
		group.setC(c);
		groupService.addGroup(group);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 删除小组
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午10:51:07
	 * @param groupId
	 * @return
	 */
	@RequestMapping(value="teacherDeleteGroup.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherDeleteGroup(Integer groupId){
		Map<String, Object> result = new HashMap<>();
		groupService.deleteGroup(groupId);
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 跳转到小组详情界面
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午11:09:01
	 * @param groupId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="teacherToGroupInfo.action",method=RequestMethod.GET)
	public String teacherToGroupInfo(Integer groupId,HttpServletRequest request,HttpSession session){
		Group group = groupService.getGroupById(groupId);
		if(group == null) return "redirect:teacherToClassManage.action";
		User user = (User) session.getAttribute("user");
		Class c = classService.getClassById(group.getC().getId());
		if(!user.getId().equals(c.getTeacher().getId())) return "redirect:teacherToClassManage.action";
		request.setAttribute("group", group);
		return "groupInfo.jsp";
	}
	
	
	/**
	 * 获取小组详情
	 * @author 罗龙贵
	 * @date 2019年4月14日 上午11:47:28
	 * @param groupId
	 * @return
	 */
	@RequestMapping(value="teacherGetGroupInfo.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetGroupInfo(Integer groupId){
		Map<String, Object> result = new HashMap<>();
		Group group = groupService.getGroupInfo(groupId);
		result.put("msg", 1);
		result.put("group", group);
		return result;
	}
	

	/**
	 * 获取没有分组的学生
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午4:27:43
	 * @param classId
	 * @return
	 */
	@RequestMapping(value="teacherGetNotStudentList.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetNotStudentList(Integer classId){
		Map<String, Object> result = new HashMap<>();
		List<Student> students = studentService.getNotGroupStudent(classId);
		result.put("msg", 1);
		result.put("students", students);
		return result;
	}
	
	
	/**
	 * 将学生添加到小组
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午4:32:27
	 * @param groupId
	 * @param studentId
	 * @return
	 */
	@RequestMapping(value="teacherAddStudentToGroup.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherAddStudentToGroup(Integer groupId,Integer studentId){
		Map<String, Object> result = new HashMap<>();
		Student student = studentService.getStudentById(studentId);
		if(student.getGroup() != null && student.getGroup().getId() != null){
			result.put("msg", 0);
			return result;
		}
		Group group = new Group();
		group.setId(groupId);
		student.setId(studentId);
		student.setGroup(group);
		studentService.updateStudent(student);
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 将学生从小组中移除
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午5:00:26
	 * @param studentId
	 * @param groupId
	 * @return
	 */
	@RequestMapping(value="teacherRemoveStudentToGroup.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherRemoveStudentToGroup(Integer studentId,Integer groupId){
		Map<String, Object> result = new HashMap<>();
		studentService.removeGroupStudent(studentId, groupId);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 将学生任命为组长
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午5:06:19
	 * @param studentId
	 * @param groupId
	 * @return
	 */
	@RequestMapping(value="teacherAddLeader.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherAddLeader(Integer studentId,Integer groupId){
		Map<String, Object> result = new HashMap<>();
		Student student = new Student();
		student.setId(studentId);
		Group group = new Group();
		group.setId(groupId);
		group.setLeader(student);
		groupService.updateGroup(group);
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 修改小组信息
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午5:59:12
	 * @param group
	 * @return
	 */
	@RequestMapping(value="teacherUpdateGroupInfo.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherUpdateGroupInfo(Group group){
		Map<String, Object> result = new HashMap<>();
		groupService.updateGroup(group);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 跳转到任务详情界面
	 * @author 罗龙贵
	 * @date 2019年4月14日 下午6:45:06
	 * @param taskId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="teacherToTaskInfo.action",method=RequestMethod.GET)
	public String teacherToTaskInfo(Integer taskId,HttpServletRequest request,HttpSession session){
		Task task = taskService.getTaskById(taskId);
		if(task == null) return "redirect:teacherToClassManage.action";
		User user = (User)session.getAttribute("user");
		if(!user.getId().equals(task.getTeacher().getId())) return "redirect:teacherToClassManage.action";
		request.setAttribute("task", task);
		return "taskInfo.jsp";
	}
	
	
	/**
	 * 获取任务详细信息
	 * @author 罗龙贵
	 * @date 2019年4月15日 下午2:39:39
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value="teacherGetTaskInfo.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetTaskInfo(Integer taskId){
		Map<String, Object> result = new HashMap<>();
		Task task = taskService.getTaskInfo(taskId);
		result.put("msg", 1);
		result.put("task", task);
		return result;
	}
	
	/**
	 * 获取执行指定任务的班级数量
	 * @author 罗龙贵
	 * @date 2019年4月15日 下午3:07:06
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value="teacherGetExeTaskClassTotal.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetExeTaskClassTotal(Integer taskId){
		Map<String, Object> result = new HashMap<>();
		int count = classTaskService.getTaskClassTotal(taskId);
		result.put("msg", 1);
		result.put("count", count);
		return result;
	}
	
	/**
	 * 分页获取执行指定任务的班级列表
	 * @author 罗龙贵
	 * @date 2019年4月15日 下午3:07:28
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value="teacherGetExeTaskClassList.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetExeTaskClassList(Integer taskId,Integer startNum,Integer pageSize){
		Map<String, Object> result = new HashMap<>();
		List<ClassTask> classTasks = classTaskService.getTaskClassList(taskId, startNum, pageSize);
		result.put("msg", 1);
		result.put("classTasks", classTasks);
		return result;
	}
	
	
	/**
	 * 修改任务信息
	 * @author 罗龙贵
	 * @date 2019年4月15日 下午5:02:09
	 * @param task
	 * @return
	 */
	@RequestMapping(value="teacherUpdateTaskInfo.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherUpdateTaskInfo(Task task){
		Map<String, Object> result = new HashMap<>();
		taskService.updateTask(task);
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 添加一个题目
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午9:17:16
	 * @param subject
	 * @param tid
	 * @return
	 */
	@RequestMapping(value="teacheraddSubject.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacheraddSubject(Subject subject,Integer tid){
		Map<String, Object> result = new HashMap<>();
		Task task = new Task();
		task.setId(tid);
		subject.setTask(task);
		subjectService.addSubject(subject);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 删除一个题目
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午9:17:58
	 * @param id
	 * @return
	 */
	@RequestMapping(value="teacherDelSubject.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherDelSubject(Integer id){
		Map<String, Object> result = new HashMap<>();
		subjectService.deleteSubject(id);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 修改题目信息
	 * @author 罗龙贵
	 * @date 2019年4月16日 上午9:19:38
	 * @param subject
	 * @return
	 */
	@RequestMapping(value="teacherUpdateSubject.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherUpdateSubject(Subject subject){
		Map<String, Object> result = new HashMap<>();
		subjectService.updateSubject(subject);
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 教师跳转到作业提交情况界面
	 * @author 罗龙贵
	 * @date 2019年4月22日 上午10:30:18
	 * @param ctid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="teacher2JobStatus.action",method=RequestMethod.GET)
	public String teacher2ReviewJob(Integer ctid,HttpServletRequest request){
		//获取班级任务信息
		ClassTask classTask = classTaskService.getClassTaskById(ctid);
		if(classTask == null) return "redirect:teacherToClassManage.action";
		//获取任务信息
		Task task = taskService.getTaskById(classTask.getTask().getId());
		request.setAttribute("classTask", classTask);
		request.setAttribute("task", task);
		return "jobStatus.jsp";
	}
	
	
	/**
	 * 分页获取获取任务状态信息
	 * @author 罗龙贵
	 * @date 2019年4月24日 下午3:28:40
	 * @param ctid
	 * @param startNum
	 * @param pageSize
	 * @param session
	 * @return
	 */
	@RequestMapping(value="teacherGetTaskSubmitStatus.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetTaskSubmitStatus(Integer ctid,Integer startNum,Integer pageSize,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		//获取班级任务
		ClassTask classTask = classTaskService.getClassTaskById(ctid);
		//判断任务类型
		if(classTask.getType() == 1){
			//个人任务
			//获取学生列表
			List<Student> students = studentService.getStudentList(classTask.getC().getId(), startNum, pageSize);
			//获取任务状态信息
			List<JobStatus> jobStatus = new ArrayList<>();
			for (Student student : students) {
				JobStatus job = jobService.getJobStatusByCTSId(ctid, student.getId());
				jobStatus.add(job);
			}
			result.put("data", students);
			result.put("jobStatus", jobStatus);
		}else{
			//小组任务
			//获取小组列表
			List<Group> groups = groupService.getGroupList(classTask.getC().getId(), startNum, pageSize);
			//获取任务状态信息
			List<JobStatus> jobStatus = new ArrayList<>();
			for (Group group : groups) {
				JobStatus job = jobService.getJobStatusByCTGId(ctid, group.getId());
				jobStatus.add(job);
			}
			result.put("data", groups);
			result.put("jobStatus", jobStatus);
		}
		result.put("status", 1);
		return result;
	}
	
	/**
	 * 跳转到批改作业界面
	 * @author 罗龙贵
	 * @date 2019年4月24日 下午4:54:06
	 * @param action 小组任务传2，个人任务传1
	 * @param id 学生或小组id
	 * @param ctid 班级任务id
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="teacher2ReviewJob.action",method=RequestMethod.GET)
	public String teacher2ReviewJavaJob(Integer id,Integer ctid,HttpSession session,HttpServletRequest request){
		//获取班级任务信息
		ClassTask classTask = classTaskService.getClassTaskById(ctid);
		if(classTask == null ) return "redirect:teacherIndex.action";
		//获取任务信息 
		Task task = taskService.getTaskById(classTask.getTask().getId());
		request.setAttribute("classTask", classTask);
		request.setAttribute("task", task);
		//获取当前登录的教师信息
		User user = (User) session.getAttribute("user");
		if(classTask.getType() == 1){
			//获取学生信息
			Student student = studentService.getStudentById(id);
			if(student == null ) return "redirect:teacherIndex.action";
			//获取该学生班级信息
			Class c = classService.getClassById(student.getC().getId());
			if(!c.getTeacher().getId().equals(user.getId())) return "redirect:teacherIndex.action";
			if(!c.getId().equals(classTask.getC().getId())) return "redirect:teacherIndex.action";
			request.setAttribute("data", student);
		}else if(classTask.getType() == 2){
			//获取小组信息
			Group group = groupService.getGroupById(id);
			if(group == null ) return "redirect:teacherIndex.action";
			//获取班级信息
			Class c = classService.getClassById(group.getC().getId());
			if(!c.getTeacher().getId().equals(user.getId())) return "redirect:teacherIndex.action";
			if(!c.getId().equals(classTask.getC().getId())) return "redirect:teacherIndex.action";
			request.setAttribute("data", group);
		}
		if(task.getType() == 1) return "reviewJavaJob.jsp";
		return "reviewOracleJob.jsp";
	}
	
	/**
	 * 获取学生或小组某个任务的分数
	 * @author 罗龙贵
	 * @date 2019年4月25日 上午11:09:39
	 * @param id
	 * @param ctid
	 * @return
	 */
	@RequestMapping(value="teacherGetScore.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetScore(Integer id,Integer ctid){
		Map<String, Object> result = new HashMap<>();
		//获取班级任务
		ClassTask classTask = classTaskService.getClassTaskById(ctid);
		JobStatus jobStatus;
		if(classTask.getType() == 1) jobStatus = jobService.getJobStatusByCTSId(ctid, id);
		else jobStatus = jobService.getJobStatusByCTGId(ctid, id);
		result.put("jobStatus", jobStatus);
		result.put("status", 1);
		return result;
	}
	
	
	/**
	 * 获取班级任务信息
	 * @author 罗龙贵
	 * @date 2019年4月25日 下午12:18:51
	 * @param ctid
	 * @return
	 */
	@RequestMapping(value="teacherGetClassTask.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetClassTask(Integer ctid,Integer id){
		Map<String, Object> result = new HashMap<>();
		//获取班级任务
		ClassTask classTask = classTaskService.getClassTaskById(ctid);
		Task task = taskService.getTaskInfo(classTask.getTask().getId());
		JobStatus jobStatus;
		if(classTask.getType() == 1) jobStatus = jobService.getJobStatusByCTSId(ctid, id);
		else jobStatus = jobService.getJobStatusByCTGId(ctid, id);
		result.put("classTask", classTask);
		result.put("jobStatus", jobStatus);
		result.put("task", task);
		result.put("status", 1);
		return result;
	}
	
	
	/**
	 * 获取某个小组某个题目的分工
	 * @author 罗龙贵
	 * @date 2019年4月25日 下午2:25:11
	 * @param gid
	 * @param sid
	 * @param session
	 * @return
	 */
	@RequestMapping(value="teacherGetDivision.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentGetDivision(Integer gid,Integer sid,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		List<SubjectStudent> divisionList = divisionService.getDivisionList(sid,gid);
		result.put("msg", 1);
		result.put("division", divisionList);
		return result;
	}
	
	
	/**
	 * 获取提交的作业信息
	 * @author 罗龙贵
	 * @date 2019年4月25日 下午2:41:49
	 * @param ctid
	 * @param subjectId
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="teacherGetWork.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetWork(Integer ctid,Integer subjectId,Integer id,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		//获取班级任务信息
		ClassTask classTask = classTaskService.getClassTaskById(ctid);
		//获取任务信息
		Task task = taskService.getTaskById(classTask.getTask().getId());
		//判断任务类型
		Work work;
		if(classTask.getType() == 1) work = workService.getWorkBySId(subjectId, id);
		else work = workService.getWorkByGId(subjectId, id);
		if(work == null) result.put("status", 0);
		else{
			result.put("status", 1);
			result.put("work", work);
			if(task.getType() == 1){
				result.put("code",FileUtil.getFileContent(new File(work.getCodePath())));
			}
		}
		return result;
	}
	
	
	/**
	 * 给任务打分
	 * @author 罗龙贵
	 * @date 2019年4月25日 下午3:40:43
	 * @param score
	 * @param id
	 * @param ctid
	 * @param session
	 * @return
	 */
	@RequestMapping(value="teacherSubmitScore.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherSubmitScore(Integer score,Integer id,Integer ctid,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		//获取班级任务信息
		ClassTask classTask = classTaskService.getClassTaskById(ctid);
		//判断任务类型
		JobStatus jobStatus;
		if(classTask.getType() == 1) jobStatus = jobService.getJobStatusByCTSId(ctid, id);
		else jobStatus = jobService.getJobStatusByCTGId(ctid, id);
		if(jobStatus == null){
			jobStatus = new JobStatus();
			jobStatus.setClassTask(classTask);
			if(classTask.getType() == 1) jobStatus.setStudent(studentService.getStudentById(id));
			else jobStatus.setGroup(groupService.getGroupById(id));
			jobStatus.setScore(score);
			jobService.addJobStatus(jobStatus);
		}else{
			jobStatus.setScore(score);
			jobService.updateJobStatus(jobStatus);
		}
		result.put("status", 1);
		return result;
	}
	
	
	/**
	 * 获取期末成绩信息
	 * @author 罗龙贵
	 * @date 2019年4月25日 下午10:43:40
	 * @param classId 班级id
	 * @param type 任务类型
	 * @return
	 */
	@RequestMapping(value="teacherGetFinalExam.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teacherGetFinalExam(Integer type,Integer classId){
		Map<String, Object> result = new HashMap<>();
		//获取班级信息
		Class c = classService.getClassById(classId);
		//获取班级任务列表
		List<ClassTask> classTasks = classTaskService.getClassTaskByType(classId, type ,c.getSemester());
		//获取所有学生列表
		List<Student> students = studentService.getStudentAll(classId);
		//个人任务次数
		int studentTask = 0;
		//小组任务次数
		int groupTask = 0;
		int row = students.size()+1;
		int colunm = classTasks.size()+4;
		String[][] data = new String[row][colunm];
		for(int m = 0;m < row;m++){
			if(m == 0){
				data[m][0] = "编号";
				data[m][1] = "学号";
				data[m][2] = "姓名";
				int i = 0;
				for(;i<classTasks.size();i++){
					String typeStr;
					if(classTasks.get(i).getType() == 1){
						typeStr = "个人";
						studentTask++;
					}else{
						typeStr = "小组";
						groupTask++;
					}
					data[m][i+3] = classTasks.get(i).getTask().getName()+"("+typeStr+")("+classTasks.get(i).getProportion()+"%)";
				}
				data[m][i+3] = "成绩";
				continue;
			}
			data[m][0] = (m)+"";
			data[m][1] = students.get(m-1).getNum();
			data[m][2] = students.get(m-1).getName();
			double finalScore = 0;
			for(int n = 3;n < colunm - 1;n++){
				//获取该学生该任务的分数
				JobStatus jobStatus;
				if(classTasks.get(n-3).getType() == 1) jobStatus = jobService.getJobStatusByCTSId(classTasks.get(n-3).getId(), students.get(m-1).getId());
				else {
					if(students.get(m-1).getGroup() == null || students.get(m-1).getGroup().getId() == null) jobStatus = null;
					else jobStatus = jobService.getJobStatusByCTGId(classTasks.get(n-3).getId(), students.get(m-1).getGroup().getId());
				}
				int score = (jobStatus == null || jobStatus.getScore() == null) ? 0 : jobStatus.getScore();
				finalScore += score * classTasks.get(n-3).getProportion() * 0.01;
				data[m][n] = ""+score;
			}
			data[m][colunm - 1] = (int)Math.round(finalScore)+"";
		}
		result.put("status", 1);
		result.put("c", c);
		result.put("studentTask", studentTask);
		result.put("groupTask", groupTask);
		result.put("data", data);
		return result;
	}
	
	/**
	 * 导出成绩单
	 * @author 罗龙贵
	 * @date 2019年4月26日 下午7:11:19
	 * @param type
	 * @param classId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="teacherDownLoadReportCard.action",method=RequestMethod.GET)
	public ResponseEntity<byte[]> teacherDownLoadReportCard(Integer type,Integer classId) throws IOException{
		Map<String, Object> map = teacherGetFinalExam(type,classId);
		//获取班级信息
		Class c = (Class)map.get("c");
		String[][] data = (String[][]) map.get("data");
		String typeStr = type == 1 ? "Java" : "Oracle";
		String DownLoadFileName = c.getName()+getSemester(c.getSemester())+typeStr+"课程成绩单.xlsx";
		//创建成绩单文件
		File file = FileUtil.createFile(FileUtil.LOCAL_TEMP_PATH+FileUtil.createFileName()+".xlsx");
		FileOutputStream outputStream = new FileOutputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		for(int i=0;i<data.length;i++){
			Row row = sheet.createRow(i);
			if(i == 0){
				for(int j = 0;j<data[0].length;j++){
					Cell cell = row.createCell(j);
					cell.setCellValue(data[i][j]);
				}
				continue;
			}
			for(int j = 0;j<data[0].length;j++){
				Cell cell = row.createCell(j);
				if(j == 0 || j > 2) cell.setCellValue(Integer.parseInt(data[i][j]));
				else cell.setCellValue(data[i][j]);
			}
		}
		wb.write(outputStream);
		wb.close();
		outputStream.close();
		//通知浏览器下载
		HttpHeaders headers = new HttpHeaders();
		DownLoadFileName = new String(DownLoadFileName.getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment", DownLoadFileName); 
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED);
	}
	
	public String getSemester(int semester){
		String semesterStr = "";
		switch(semester){
			case 1 : semesterStr = "大一上期";break;
			case 2 : semesterStr = "大一下期";break;
			case 3 : semesterStr = "大二上期";break;
			case 4 : semesterStr = "大二下期";break;
			case 5 : semesterStr = "大三上期";break;
			case 6 : semesterStr = "大三下期";break;
			case 7 : semesterStr = "大四上期";break;
			case 8 : semesterStr = "大四下期";break;
		}
		return semesterStr;
	}
}
