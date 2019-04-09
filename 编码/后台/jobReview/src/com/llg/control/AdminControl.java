package com.llg.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llg.bean.Teacher;
import com.llg.service.TeacherService;

/**
 * 处理管理员请求
 * @author 罗龙贵
 * @Data 2019年4月9日 下午9:15:15
 */
@Controller
public class AdminControl {

	@Autowired
	private TeacherService teacherService;
	
	/**
	 * ajax返回教师总数
	 * @author 罗龙贵
	 * @date 2019年4月9日 下午9:46:17
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
	
	@RequestMapping(value="adminGetTeacherList.action" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> adminGetTeacherList(Integer startNum,Integer pageSize){
		Map<String, Object> result = new HashMap<>();
		result.put("msg", 1);
		result.put("teachers", teacherService.getTeacherList(startNum, pageSize));
		return result;
	}
	
}
