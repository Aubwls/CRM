package com.briup.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.CustomerConstitute;
import com.briup.demo.dao.CustomerDao;
import com.briup.demo.service.ICustomerConstituteService;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年4月3日 上午10:47:33 
* 类说明 
*/
@Service
public class ICustomerConstituteServiceImple implements ICustomerConstituteService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<CustomerConstitute> regionAnalyze() {
		//从数据库将所有的客户信息查出来
		float regionNum = customerDao.findAll().size();
		String[] regions= {"华中","华南","华东","华北"};
		List<CustomerConstitute> ccList = new ArrayList();
		//根据地区进行筛选，然后封装成List自定义对象
		for (String region : regions) {
			float num = customerDao.findByRegion(region).size();
			float y = num/regionNum * 100;
			CustomerConstitute cc = new CustomerConstitute(region,y,region);
			ccList.add(cc);
		}
		return ccList;
	}

	@Override
	public List<CustomerConstitute> levelAnalyze() {
		float Nums = customerDao.findAll().size();
		String[] levels= {"普通客户","重点开发客户","大客户","合作伙伴","战略合作伙伴"};
		List<CustomerConstitute> ccList = new ArrayList<CustomerConstitute>();
		//根据地区进行筛选，然后封装成List自定义对象
		for (String level : levels) {
			float num = customerDao.findByLevel(level).size();
			float y = num/Nums * 100;
			CustomerConstitute cc = new CustomerConstitute(level,y,level);
			ccList.add(cc);
		}
		return ccList;
	}

}
