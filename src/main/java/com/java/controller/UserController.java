package com.java.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dao.UserDao;
import com.java.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 * 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model,HttpServletRequest request) {
		
		User user=(User)request.getAttribute("user");
		
		if(user==null) {
			System.out.println(user);
			User usero=new User("##erroors##","1234");
			model.addAttribute("user",usero);
		}
		return "bm";
	}
	
	
	/**
	 * 打开登录界面
	 * @return
	 */
	@RequestMapping("/oplogin")
	public String oplogin() {
		
		return "login";
	}
	
	
	/**
	 * 登录控制层
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Map<String, Object> map) {
		
		//获取用户名和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//根据用户名查询，判断用户是否存在
		User user=userDao.findByUsername(username);
		
		//如果在
		if(user!=null) {
			if(password.equals(user.getPassword())){
				//如果密码正确
				//将用户信息存放到会话中。。。
				request.setAttribute("user", user);
				
				return "bm";
			}else {
				//如果密码错误
				System.out.println("密码错误");
				//return "ferror";
				map.put("msg", "密码错误！");
				return "login";
			}
		}else {
			//如果不存在
			System.out.println("用户不存在！");
			//return "ferror";
			map.put("msg", "用户不存在！");
			return "login";
		}
	}
	
	/**
	 * 打开注册界面
	 * @return
	 */
	@RequestMapping("/resgi")
	public String resgi() {
		
		return "resgi";
	}
	
	
	/**
	 * 注册控制层
	 * @param request
	 * @return
	 */
	@RequestMapping("/rege")
	public String resgi(HttpServletRequest request,Map<String, Object> map) {
		
		//获取用户和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//查询用户是否存在
		User user=userDao.findByUsername(username);
		
		//若存在
		if(user!=null) {
			//username重复
			//return "ferror2";
			map.put("msg", "用户名已存在！");
			return "resgi";
		}
		
		//若不存在
		User newUser=new User(username,password);
		//注册
		userDao.save(newUser);
		
		//将信息设置session作用域
		request.setAttribute("user", newUser);
		
		return "login";
	}
	
	
	
}
