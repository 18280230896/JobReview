package com.llg.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherControl {

	/**
	 * 跳转到教师首页
	 * @author 罗龙贵
	 * @date 2019年4月11日 上午9:57:37
	 * @return
	 */
	@RequestMapping(value="teacherIndex.action",method=RequestMethod.GET)
	public String teacherIndex(){
		return "teacherIndex";
	}
}
