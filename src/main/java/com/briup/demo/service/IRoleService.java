package com.briup.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.briup.demo.bean.Role;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年3月27日 下午2:34:38 
* 类说明 
*/
public interface IRoleService {
	
	Page<Role> findAllRoles();
	
	//查询指定页面上的数据
	Page<Role> findAllRoles(Integer pagesIndex);
	
	//add
	void saveRole(Role role);
	
	//update
	void updateRole(Role role);
	
	//delete
	void deleteRole(Integer id);
	
	//通过id找role
	Optional<Role> findRoleById(Integer id);
	
	List<Role> findAllRoleId();
}
