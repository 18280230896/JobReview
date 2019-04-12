package com.llg.control;

import java.io.ByteArrayOutputStream;
import java.io.File;
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
import com.llg.util.CompilerUtil;
import com.llg.util.FileUtil;
import com.llg.util.MyRunnable;
/**
 * 
 * @author 罗龙贵
 * @Data 2019年4月9日 下午6:46:23
 */
@Controller
public class UserControl {
	@Autowired
	private UserService userService;
	
	private static final String LOCAL_PATH = "D:\\jobReview\\";
	private static final String LOCAL_JOB_PATH = LOCAL_PATH+"job\\";
	private static final String LOCAL_TEMP_PATH = LOCAL_PATH+"temp\\";
	private static final String VIRTUAL_PATH = "file/";
	private static final String VIRTUAL_JOB_PATH = VIRTUAL_PATH+"job/";
	private static final String VIRTUAL_TEMP_PATH = VIRTUAL_PATH+"temp/";
	
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
	
	/**
	 * 编译运行传入的代码
	 * @author 罗龙贵
	 * @date 2019年4月12日 下午2:20:42
	 * @param code 要编译运行的代码
	 * @return
	 */
	@RequestMapping(value="run.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> run(String code){
		Map<String, Object> result = new HashMap<>();
		String fileName = FileUtil.createFileName();
		File file = FileUtil.createFile(LOCAL_TEMP_PATH+fileName+".java");
		code = "package com.llg.test;\npublic class "+fileName+" {\n"+code+"}";
		String className = FileUtil.parseClassName(code);
		//将代码写入文件
		if(!FileUtil.write(file, code)){
			//写入文件错误
			result.put("status", 2);
			result.put("msg", "写入文件错误!");
			return result;
		}
		//编译
		Map<String, Object> res = CompilerUtil.compiler(new File[]{file});
		if(!(boolean) res.get("success")){
			//编译错误
			result.put("status", 3);
			result.put("msg", res.get("msg").toString());
			return result;
		}
		//运行
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ByteArrayOutputStream berr = new ByteArrayOutputStream(); 
		MyRunnable runnable = new MyRunnable(bout, berr);
		runnable.run(className, FileUtil.createFile(LOCAL_TEMP_PATH+fileName+".class"));
		result.put("status", 1);
		result.put("out", new String(bout.toByteArray()));
		result.put("err", new String(berr.toByteArray()));
		return result;
	}
	
}
