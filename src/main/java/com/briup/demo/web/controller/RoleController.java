package com.briup.demo.web.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.demo.bean.Role;
import com.briup.demo.service.IRoleService;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年3月27日 上午11:50:45 
* 类说明 :角色管理模块
* 
*/
@Controller
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("toRole")
	public String toRole(HttpSession session) {
		Page<Role> roles = roleService.findAllRoles();
		session.setAttribute("roles", roles);
		return "pages/role";
	}
	
	@RequestMapping("role/add")
	@ResponseBody
	public String AddRole(String username,String description,String flag) {
		if ("".equals(username)) {
			return "名字不能为空！保存失败！";
		}
		if ("".equals(description)) {
			return "描述不能为空！保存失败！";
		}
		Role role = new Role(username,description,Integer.parseInt(flag));
		roleService.saveRole(role);
		return "保存成功！";
	}
	
	@RequestMapping("role/delete")
	@ResponseBody
	public String DeleteRole(String id) {
		roleService.deleteRole(Integer.parseInt(id));
		return "删除成功！";
	}
	
	@RequestMapping("role/update")
	@ResponseBody
	public String Update(Role role) {
		roleService.saveRole(role);
		return "更新成功！";
	}
	
	@RequestMapping("changeRolePage")
	public String changeRolePage(Integer pageIndex,HttpSession session) {
		Page<Role> roles = roleService.findAllRoles(pageIndex);
		session.setAttribute("roles", roles);
		return "pages/role";
	}
}
