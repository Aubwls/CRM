package com.briup.demo.dao;
/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年4月3日 上午10:48:04 
* 类说明 
*/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.demo.bean.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	List<Customer> findByRegion(String region);
	
	List<Customer> findByLevel(String level);
	
}
