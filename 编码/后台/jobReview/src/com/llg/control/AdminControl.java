package com.llg.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llg.bean.Teacher;
import com.llg.service.TeacherService;

/**
 * �������Ա����
 * @author ������
 * @Data 2019��4��9�� ����9:15:15
 */
@Controller
public class AdminControl {

	@Autowired
	private TeacherService teacherService;
	
	/**
	 * ajax���ؽ�ʦ����
	 * @author ������
	 * @date 2019��4��9�� ����9:46:17
	 * @return
	 */
	@RequestMapping(value="adminGetTeacherNum.action" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> adminGetTeacherNum(){
		Map<String, Object> result = new HashMap<>();
		result.put("msg", 1);
		result.put("count", teacherService.getTeacherNum());
		return result;
	}
	
	/**
	 * ajax����ָ����Χ�Ľ�ʦ�б�
	 * @author ������
	 * @date 2019��4��10�� ����8:12:56
	 * @param startNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="adminGetTeacherList.action" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> adminGetTeacherList(Integer startNum,Integer pageSize){
		Map<String, Object> result = new HashMap<>();
		result.put("msg", 1);
		result.put("teachers", teacherService.getTeacherList(startNum, pageSize));
		return result;
	}
	
	
	
	/**
	 * ��ӽ�ʦ
	 * @author ������
	 * @date 2019��4��10�� ����9:03:33
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value="adminAddTeacher.action" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> adminAddTeacher(Teacher teacher){
		Map<String, Object> result = new HashMap<>();
		result.put("msg", teacherService.addTeacher(teacher));
		return result;
	}
	
	/**
	 * ɾ��ָ����ʦ
	 * @author ������
	 * @date 2019��4��10�� ����9:21:46
	 * @param id Ҫɾ���Ľ�ʦid
	 * @return
	 */
	@RequestMapping(value="adminDelTeacher.action" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> adminDelTeacher(Integer id){
		Map<String, Object> result = new HashMap<>();
		teacherService.deleteTeacher(id);
		result.put("msg", 1);
		return result;
	}
	
	@RequestMapping(value="adminUpdateTeacher.action" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> adminUpdateTeacher(Teacher teacher){
		Map<String, Object> result = new HashMap<>();
		teacherService.updateTeacher(teacher);
		result.put("msg", 1);
		return result;
	}
	
}
