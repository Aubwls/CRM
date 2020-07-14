package com.briup.demo.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.demo.bean.Role;
import com.briup.demo.bean.User;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年3月26日 下午4:47:46 
* 类说明 
*/
public interface IUserService {
	
	//查询刚进入角色管理页面的所有角色
	Page<User> findAllUsers();
	
	//查询指定页面上的数据
	Page<User> findAllUsers(Integer pageIndex);
	
	//add
	void saveUser(User user);
	
	void deteleUserById(Integer id);
	
	User findByName(String name);
	
	Page<User> findAllUserByRole(Role role);
	
	Page<User> findAllUserByRole(Role role,Integer pagesIndex);
	
	List<User> findAll();
	
	List<User> findByRole(Role role);
}
