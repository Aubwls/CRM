package com.briup.demo.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.demo.bean.User;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年3月26日 下午3:29:50 
* 类说明 :用来映射thymeleaf页面的Controller类
*/
@Controller
public class ViewController {
	
	@RequestMapping("login")
	public String toLoginPage(HttpSession session) {
		if (session.getAttribute("user")!=null) {
			return "index";
		}
		return "login";
	}
	
	@RequestMapping("index")
	public String toIndexPage(HttpSession session) {
		User user = (User)session.getAttribute("user");
		if (user==null) {
			return "login";
		}else {
			return "index";
		}
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
}
