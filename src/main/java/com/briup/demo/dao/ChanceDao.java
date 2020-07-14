package com.briup.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.briup.demo.bean.Chance;
import com.briup.demo.bean.User;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年4月1日 下午7:11:09 
* 类说明 
*/
public interface ChanceDao extends JpaRepository<Chance, Integer> {
	
	@Query(value = "select * from chance where creator_id = ?1 and address = ?2 and customer = ?3", nativeQuery=true)
	Page<Chance> findChanceByNameAndAdress(Integer creatorId,String Address,String customer,Pageable pageable);
	@Query(value = "select * from chance where creator_id = ?1 and address = ?2", nativeQuery=true)
	Page<Chance> findByAddress(Integer creatorId,String address,Pageable pageable);
	@Query(value = "select * from chance where creator_id = ?1 and customer = ?2", nativeQuery=true)
	Page<Chance> findByCustomer(Integer creatorId,String customer,Pageable pageable);
	
	Page<Chance> findByCreator(User creator,Pageable pageable);
}
