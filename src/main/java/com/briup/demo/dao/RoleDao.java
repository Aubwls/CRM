package com.briup.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.demo.bean.Role;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年3月27日 上午11:51:01 
* 类说明 
*/
public interface RoleDao extends JpaRepository<Role, Integer>{
	
}
