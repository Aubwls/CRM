package com.briup.demo.service;

import org.springframework.data.domain.Page;

import com.briup.demo.bean.Chance;
import com.briup.demo.bean.User;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年4月1日 下午7:14:08 
* 类说明 
*/
public interface IChanceService {
	Page<Chance> findAllChances(User user);
	//查询指定页面上的数据
	Page<Chance> findAllChances(Integer pageIndex,User user);
	
	void deleteById(Integer id);
	
	void saveAndUpdate(Chance chance);

	Chance findChanceById(Integer id);
	
	Page<Chance> findChanceByNameAndAdress(User user,String customer,String address,Integer pagesIndex);
}
