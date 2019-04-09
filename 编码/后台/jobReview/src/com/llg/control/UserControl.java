package com.llg.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llg.bean.User;
import com.llg.service.UserService;

@Controller
public class UserControl {
	@Autowired
	private UserService userService;
	//跳转到登录界面
	@RequestMapping(value="toLogin.action",method=RequestMethod.GET)
	public String toLogin(){
		
		return "login";
	}
	
	//登录验证
	@RequestMapping(value="login.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(String username,String password,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		User user = userService.login(username, password);
		if(user == null){
			result.put("status", 0);
			return result;
		}
		if(user.getRole() == 1){
			session.setAttribute("admin", user);
		}else if(user.getRole() == 2){
			session.setAttribute("teacher", user);
		}else if(user.getRole() == 3){
			session.setAttribute("student", user);
		}
		result.put("status", user.getRole());
		return result;
	}
}
