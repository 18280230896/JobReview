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
/**
 * 
 * @author 罗龙贵
 * @Data 2019年4月9日 下午6:46:23
 */
@Controller
public class UserControl {
	@Autowired
	private UserService userService;
	
	/**
	 * 跳转到登录界面
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午6:46:37
	 * @return
	 */
	@RequestMapping(value="toLogin.action",method=RequestMethod.GET)
	public String toLogin(){
		
		return "login";
	}
	
	/**
	 * ajax登录验证
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午6:46:58
	 * @param username 用户名
	 * @param password 密码
	 * @param session
	 * @return
	 */
	@RequestMapping(value="login.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(String username,String password,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		User user = userService.login(username, password);
		if(user == null){
			result.put("status", 0);
			return result;
		}
		session.setAttribute("user", user);
		result.put("status", user.getRole());
		return result;
	}
	
	/**
	 * 跳转到管理员首页
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午7:04:34
	 * @return
	 */
	@RequestMapping(value="adminIndex.action",method=RequestMethod.GET)
	public String toAdminIndex(){
		return "adminIndex";
	}
	
	/**
	 * ajax返回当前登录用户的信息
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午7:06:15
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getUserInfo.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getUserInfo(HttpSession session){
		Map<String, Object> result = new HashMap<>();
		User user = userService.getUserInfo((User)session.getAttribute("user"));
		result.put("user", user);
		return result;
	}
	
	/**
	 * 注销当前用户，并跳转到登录界面
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午7:49:26
	 * @param session
	 * @return
	 */
	@RequestMapping(value="logout.action",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:toLogin.action";
	}
	
	/**
	 * 修改当前用户密码
	 * @author 罗龙贵
	 * @data 2019年4月9日 下午8:50:37
	 * @param newPassword
	 * @param oldPassword
	 * @param session
	 * @return status=0表示旧密码错误，1表示修改成功
	 */
	@RequestMapping(value="changePwd.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> changePwd(String newPassword,String oldPassword,HttpSession session){
		Map<String, Object> result = new HashMap<>();
		User user = (User)session.getAttribute("user");
		result.put("status", userService.updatePwd(user, newPassword, oldPassword));
		return result;
	}
	
	
	/**
	 * ajax请求验证用户名是否存在
	 * @author 罗龙贵
	 * @date 2019年4月10日 上午8:29:12
	 * @param username
	 * @return
	 */
	@RequestMapping(value="usernameIsExist.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> usernameIsExist(String username){
		Map<String, Object> result = new HashMap<>();
		result.put("msg", userService.usernameIsExist(username)? 0 : 1);
		return result;
	}
}
