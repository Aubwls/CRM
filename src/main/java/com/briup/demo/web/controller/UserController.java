package com.briup.demo.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.demo.bean.Role;
import com.briup.demo.bean.User;
import com.briup.demo.service.IRoleService;
import com.briup.demo.service.IUserService;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年3月26日 下午4:32:26 
* 类说明 
*/
@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	
	private boolean flag = false;
	private Integer roleId;
	//获取前台输入的用户名密码，进行校验
	@RequestMapping("user/login")
	@ResponseBody
	public String loginCheck(String username,String password,HttpSession session) {
		User user = userService.findByName(username);
		if (user == null) {
			return "当前用户不存在！";
		}else {
			if (!user.getPassword().equals(password)) {
				return "密码错误！";
			}else if(user.getFlag() != 1) {
				return "该用户已被注销！";
			}
		}
		session.setAttribute("user", user);
		return "OK";
	}
	
	@RequestMapping("user/select")
	@ResponseBody
	public String userSelect(String roleId,HttpSession session) {
		System.out.println("-------------"+roleId);
		if("".equals(roleId) || roleId ==null) {
			return "请选择正确的查询角色！";
		}else {
			this.roleId = Integer.parseInt(roleId);
			Role role = roleService.findRoleById(Integer.parseInt(roleId)).get();
			Page<User> Users = userService.findAllUserByRole(role);
			flag = true;
			session.setAttribute("Users", Users);
			return "查询成功！";
		}
		
	}
	
	@RequestMapping("user/add")
	@ResponseBody
	public String addUser(String username,String password,String flag,String roleId) {
		Role role = roleService.findRoleById(Integer.parseInt(roleId)).get();
		User user = new User(username,password,Integer.parseInt(flag),role);
		userService.saveUser(user);
		return "OK";
	}
	
	@RequestMapping("user/delete")
	@ResponseBody
	public String deleteUser(String id) {
		userService.deteleUserById(Integer.parseInt(id));
		return "删除成功！";
	}
	
	@RequestMapping("user/update")
	@ResponseBody
	public String updateUser(String id,String username,String password,String roleId,String flag) {
		Role role = roleService.findRoleById(Integer.parseInt(roleId)).get();
		User user = new User(Integer.parseInt(id),username,password,Integer.parseInt(flag), role);
		userService.saveUser(user);
		return "更改成功！";
	}
	
	@RequestMapping("user/reset")
	@ResponseBody
	public String resetUser() {
		flag = false;
		return "重置成功！";
	}
	
	@RequestMapping("toUser")
	public String toUser(HttpSession session) {
		Page<User> Users = userService.findAllUsers();
		List<Role> roleId = roleService.findAllRoleId();
		if(!flag) {
			session.setAttribute("Users", Users);
		}
		session.setAttribute("roleId", roleId);
		return "pages/user";
	}
	
	@RequestMapping("changeUserPage")
	public String changeUserPage(Integer pageIndex,HttpSession session) {
		Page<User> Users;
		if(!flag) {
			Users = userService.findAllUsers(pageIndex);
			session.setAttribute("Users", Users);
		}else {
			Role role = roleService.findRoleById(roleId).get();
			Users = userService.findAllUserByRole(role, pageIndex);
			session.setAttribute("Users", Users);
		}
		return "pages/user";
	}
	
}
