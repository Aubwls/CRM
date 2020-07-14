package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Role;
import com.briup.demo.bean.User;
import com.briup.demo.dao.UserDao;
import com.briup.demo.service.IUserService;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年3月26日 下午4:51:05 
* 类说明 
*/
@Service
public class IUserServiceImpl implements IUserService{

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public User findByName(String name) {
		return userDao.findByName(name);
	}
	@Override
	public Page<User> findAllUsers() {
		return findAllUsers(0);
	}
	@Override
	public Page<User> findAllUsers(Integer pageIndex) {
		PageRequest of = PageRequest.of(pageIndex, 3);
		Page<User> page = userDao.findAll(of);
		return page;
	}
	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}
	@Override
	public Page<User> findAllUserByRole(Role role) {
		Page<User> user = findAllUserByRole(role,0);
		return user;
	}
	
	@Override
	public Page<User> findAllUserByRole(Role role,Integer pagesIndex) {
		PageRequest pageable = PageRequest.of(pagesIndex, 1);
		Page<User> user = userDao.findByRole(role, pageable);
		return user;
	}
	@Override
	public void deteleUserById(Integer id) {
		userDao.deleteById(id);
	}
	@Override
	public List<User> findAll() {
		List<User> list = userDao.findAll();
		return list;
	}
	@Override
	public List<User> findByRole(Role role) {
		List<User> list = userDao.findByRole(role);
		return list;
	}

}
