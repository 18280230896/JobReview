package com.llg.control;

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

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.llg.bean.Class;
import com.llg.bean.ClassTask;
import com.llg.bean.Group;
import com.llg.bean.Student;
import com.llg.bean.Subject;
import com.llg.bean.Task;
import com.llg.bean.Teacher;
import com.llg.bean.User;
import com.llg.service.ClassService;
import com.llg.service.ClassTaskService;
import com.llg.service.GroupService;
import com.llg.service.StudentService;
import com.llg.service.SubjectService;
import com.llg.service.TaskService;

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
					Cell nameCell = workbook.getSheetAt(sheetNum).getRow(rowNum).getCell(0);
					Cell usernameCell = workbook.getSheetAt(sheetNum).getRow(rowNum).getCell(1);
					Cell passwordCell = workbook.getSheetAt(sheetNum).getRow(rowNum).getCell(2);
					String name = null,username = null,password = null;
					if(nameCell != null && usernameCell != null && passwordCell != null){
						name = nameCell.toString().split("\\.")[0];
						username = usernameCell.toString().split("\\.")[0];
						password = passwordCell.toString().split("\\.")[0];
						String regExp = "^[0-9a-zA-Z]{6,20}$";
						if((name.toCharArray()).length<2 || (name.toCharArray()).length>11){
							continue;
						}
						if((!Pattern.matches(regExp, username)) || (!Pattern.matches(regExp, password))){
							continue;
						}
						count++;
						Student student = new Student();
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
	@RequestMapping(value="teacherToGroupInfo.action",method=RequestMethod.POST)
	public String teacherToGroupInfo(Integer groupId,HttpServletRequest request){
		Group group = groupService.getGroupById(groupId);
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
	@RequestMapping(value="teacherToTaskInfo.action",method=RequestMethod.POST)
	public String teacherToTaskInfo(Integer taskId,HttpServletRequest request){
		Task task = taskService.getTaskById(taskId);
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
	
}
