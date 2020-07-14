package com.briup.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Chance;
import com.briup.demo.bean.User;
import com.briup.demo.dao.ChanceDao;
import com.briup.demo.service.IChanceService;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年4月1日 下午7:15:33 
* 类说明 
*/
@Service
public class IChanceServiceImpl implements IChanceService {
	
	@Autowired
	private ChanceDao chanceDao;
	
	@Override
	public Page<Chance> findAllChances(User user) {
		return findAllChances(0,user);
	}

	@Override
	public Page<Chance> findAllChances(Integer pageIndex,User user) {
		PageRequest of = PageRequest.of(pageIndex, 3);
		return chanceDao.findByCreator(user, of);
	}

	@Override
	public void deleteById(Integer id) {
		chanceDao.deleteById(id);
	}

	@Override
	public void saveAndUpdate(Chance chance) {
		chanceDao.save(chance);
	}

	@Override
	public Chance findChanceById(Integer id) {
		return chanceDao.findById(id).get();
	}

	@Override
	public Page<Chance> findChanceByNameAndAdress(User user,String customer,String address,Integer pagesIndex) {
		PageRequest of = PageRequest.of(pagesIndex, 1);
		Page<Chance> page = null;
		boolean flag1 = (customer == null && address!=null);
		boolean flag2 = (customer != null && address == null);
		boolean flag3 = (customer != null && address !=null);
		System.out.println(flag1+"-----"+flag2+"--------"+flag3);
		System.out.println(customer+"------------"+address);
		if (customer == null && address!=null) {
			page = chanceDao.findByAddress(user.getId(),address, of);
			System.out.println("111111111111");
		}
		if (customer != null && address == null) {
			page = chanceDao.findByCustomer(user.getId(),customer, of);
			System.out.println("22222222222222");
		}
		if (customer != null && address !=null) {
			page = chanceDao.findChanceByNameAndAdress(user.getId(),address,customer, of);
		}
		return page;
	}

}
