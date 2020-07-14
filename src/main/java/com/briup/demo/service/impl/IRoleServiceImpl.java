package com.briup.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Role;
import com.briup.demo.dao.RoleDao;
import com.briup.demo.service.IRoleService;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年3月27日 下午2:42:54 
* 类说明 
*/
@Service
public class IRoleServiceImpl implements IRoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Page<Role> findAllRoles() {
		return findAllRoles(0);
	}

	@Override
	public Page<Role> findAllRoles(Integer pagesIndex) {
		PageRequest pageable = PageRequest.of(pagesIndex, 2);
		Page<Role> page = roleDao.findAll(pageable);
		return page;
	}
	
/*	@Override
	public Page<Role> findAllRoles(Integer pageIndex) {
		List<Role> list = roleDao.findAll();
		int i = (list.size()+1)/5;
		PageRequest pageable = PageRequest.of(pageIndex, 5);
		Page<Role> page = roleDao.findAll(pageable);
		return page;
	}*/
	

	@Override
	public void saveRole(Role role) {
		roleDao.save(role);
	}

	@Override
	public void updateRole(Role role) {
		roleDao.save(role);
	}

	@Override
	public void deleteRole(Integer id) {
		roleDao.deleteById(id);
	}

	@Override
	public Optional<Role> findRoleById(Integer id) {
		Optional<Role> optional = roleDao.findById(id);
		return optional;
	}
	
	@Override
	public List<Role> findAllRoleId(){
		List<Role> all = roleDao.findAll();
		return all;
	}
}
