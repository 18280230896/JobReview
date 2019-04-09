package com.llg.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.llg.bean.User;
/**
 * 用于登录拦截
 * @author 罗龙贵
 * @Data 2019年4月9日 下午9:15:29
 */
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
		User user = (User)session.getAttribute("user");
		if(uri.indexOf("ogin") > 0 || uri.indexOf("logout") > 0 || uri.equals("/jobReview/")) return true;
		if(uri.indexOf("admin") >= 0){
			//判断管理员是否登录
			if(user != null && user.getRole() == 1) return true;
		}else if(uri.indexOf("teacher") >= 0){
			//判断老师是否登录
			if(user != null && user.getRole() == 2) return true;
		}else if(uri.indexOf("student") >= 0){
			//判断学生是否登录
			if(user != null && user.getRole() == 3) return true;
		}else{
			if(user != null) return true;
		}
		//没有登录，跳转到登录界面
		response.sendRedirect("toLogin.action");
		return false;
	}

}
