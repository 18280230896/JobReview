package com.llg.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.llg.bean.Admin;
import com.llg.bean.Student;
import com.llg.bean.Teacher;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//获取请求uri
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		if(uri.indexOf("teacher") >= 0){
			//判断老师是否登录
			Teacher teacher = (Teacher) session.getAttribute("teacher");
			if(teacher != null) return true;
		}else if(uri.indexOf("student") >= 0){
			//判断学生是否登录
			Student student = (Student) session.getAttribute("student");
			if(student != null) return true;
		}else if(uri.indexOf("admin") >= 0){
			//判断管理员是否登录
			Admin admin = (Admin) session.getAttribute("admin");
			if(admin != null) return true;
		}else{
			return true;
		}
		//没有登录，跳转到登录界面
		response.sendRedirect("tologin.action");
		return false;
	}

}
