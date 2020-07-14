package com.briup.demo.dao;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.demo.bean.Role;
import com.briup.demo.bean.User;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年3月26日 下午4:55:48 
* 类说明 :user对象在数据库中的操作
*/
public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByName(String name);
	Page<User> findByRole(Role role,Pageable pageable);
	List<User> findByRole(Role role);
}
