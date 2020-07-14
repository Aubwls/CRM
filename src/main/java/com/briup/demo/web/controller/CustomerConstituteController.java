package com.briup.demo.web.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.demo.bean.CustomerConstitute;
import com.briup.demo.service.ICustomerConstituteService;


/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年4月3日 上午10:42:18 
* 类说明 
*/
@Controller
public class CustomerConstituteController {
	
	@Autowired
	private ICustomerConstituteService  service;

	@RequestMapping("toCustomerConstitute")
	public String toCustomerConstitute(HttpSession session) {
		
		return "pages/customerConstitute";
	}
	
	@RequestMapping("regionAnalyze")
	@ResponseBody
	public List<CustomerConstitute> toRegionAnalyze(){
		List<CustomerConstitute> regionAnalyze = service.regionAnalyze();
		return regionAnalyze;
	}
	@RequestMapping("levelAnalyze")
	@ResponseBody
	public List<CustomerConstitute> toLevelAnalyze(){
		List<CustomerConstitute> levelAnalyze = service.levelAnalyze();
		return levelAnalyze;
	}
}
