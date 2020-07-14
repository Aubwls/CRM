package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.CustomerConstitute;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年4月3日 上午10:47:04 
* 类说明 
*/
public interface ICustomerConstituteService {
	//地区分类
	List<CustomerConstitute> regionAnalyze();
	
	//等级分类
	List<CustomerConstitute> levelAnalyze();
}
